import dev.icerock.moko.kswift.plugin.context.ClassContext
import dev.icerock.moko.kswift.plugin.feature.BaseConfig
import dev.icerock.moko.kswift.plugin.feature.Filter
import dev.icerock.moko.kswift.plugin.feature.ProcessorContext
import dev.icerock.moko.kswift.plugin.feature.ProcessorFeature
import io.outfoxx.swiftpoet.FileSpec
import io.outfoxx.swiftpoet.TypeAliasSpec
import io.outfoxx.swiftpoet.TypeSpec
import io.outfoxx.swiftpoet.Modifier
import io.outfoxx.swiftpoet.ExtensionSpec
import io.outfoxx.swiftpoet.PropertySpec
import io.outfoxx.swiftpoet.TypeVariableName
import io.outfoxx.swiftpoet.FunctionSpec
import kotlin.reflect.KClass
import kotlin.system.exitProcess

class ConnectedViewSwiftGenerator(
    override val featureContext: KClass<ClassContext>,
    override val filter: Filter<ClassContext>,
) : ProcessorFeature<ClassContext>() {

    @ExperimentalStdlibApi
    override fun doProcess(featureContext: ClassContext, processorContext: ProcessorContext) {

        if ("interactor" !in featureContext.clazz.name.lowercase()) return
        try {

            val fileSpec: FileSpec.Builder = processorContext.fileSpecBuilder
            val classSimpleName = featureContext.clazz.name.substringAfterLast('/')

            val name = classSimpleName.replace("Interactor", "")

            generateDispatchFunction(fileSpec, name)
            generateConnectedViewProtocol(fileSpec, name)
            generateConnectedViewExtension(fileSpec, name)
            generateConnectorStructure(fileSpec, name)



            fileSpec.addImport("SwiftUI")
        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    private fun generateDispatchFunction(fileSpec: FileSpec.Builder, name: String) {
        val dispatchTypealias = TypeAliasSpec
            .builder("Dispatch${name}Function", className("(${name}Action) -> ()"))
            .addModifiers(Modifier.PUBLIC)
            .build()
        fileSpec.addType(dispatchTypealias)
    }

    private fun generateConnectedViewProtocol(fileSpec: FileSpec.Builder, name: String) {
        val connectedViewProtocol = TypeSpec.protocolBuilder("Connected${name}View")
            .addSuperType(className("View"))
            .addAssociatedType(className("Props"))
            .addAssociatedType(className("V: View"))

            .addFunction(
                FunctionSpec.builder("map")
                    .abstract(true)
                    .addParameter("state", className("${name}State"))
                    .addParameter("dispatch",
                        type = TypeVariableName.typeVariable(name = "@escaping Dispatch${name}Function", bounds = emptyList())
                    )

                    .returns(className("Props"))
                    .build()
            )

            .addFunction(
                FunctionSpec.builder("body")
                    .abstract(true)
                    .addParameter("props", className("Props"))
                    .returns(className("V"))
                    .build()
            )
            .addModifiers(Modifier.PUBLIC)
            .build()
        fileSpec.addType(connectedViewProtocol)
    }

    private fun generateConnectedViewExtension(fileSpec: FileSpec.Builder, name: String) {
        val connectedViewExtension = ExtensionSpec.builder(className("Connected${name}View"))
            .addFunction(
                FunctionSpec.builder("render")
                    .addParameter("state", className("${name}State"))
                    .addParameter("dispatch",
                        type = TypeVariableName.typeVariable(name = "@escaping Dispatch${name}Function", bounds = emptyList())
                    )
                    .addCode("let props = map(state: state, dispatch: dispatch)\nreturn body(props: props)\n")
                    .returns(className("V"))
                    .build()
            )
            .addProperty(
                PropertySpec.builder("body",className("${name}InteractorConnector<V> {\n" +
                        "\treturn ${name}InteractorConnector(content: render)\n" +
                        "}"))
                    .mutable(true)
                    .build()
            )
            .addModifiers(Modifier.PUBLIC)
            .build()
        fileSpec.addExtension(connectedViewExtension)
    }

    private fun generateConnectorStructure(fileSpec: FileSpec.Builder, name: String) {
        val connectorStructure = TypeSpec.structBuilder("${name}InteractorConnector")
            .addTypeVariable(className("V: View"))
            .addProperty(
                PropertySpec.builder("${name.toLowerCase()}Interactor", className("Observable${name}Interactor"))
                    .addAttribute("EnvironmentObject")
                    .addModifiers(Modifier.PUBLIC)
                    .mutable(true)
//                    .space(true)
                    .build()
            )

            .addProperty(
                PropertySpec.builder("content", className("(${name}State, @escaping Dispatch${name}Function) -> V"))
//                    .space(true)
                    .build()
            )

            .addProperty(
                PropertySpec.builder("body",className("V {\n\treturn content(${name.toLowerCase()}Interactor.${name.toLowerCase()}State, ${name.toLowerCase()}Interactor.dispatch)\n}"))
                    .addModifiers(Modifier.PUBLIC)
                    .mutable(true)
                    .build()
            )

            .addSuperType(className("View"))

            .addModifiers(Modifier.PUBLIC)

            .build()

        fileSpec.addType(connectorStructure)
    }

    private fun className(className: String) =
        TypeVariableName.typeVariable(name = className, bounds = emptyList())

    class Config : BaseConfig<ClassContext> {
        override var filter: Filter<ClassContext> = Filter.Exclude(emptySet())
    }

    companion object : Factory<ClassContext, ConnectedViewSwiftGenerator, Config> {

        override fun create(block: Config.() -> Unit): ConnectedViewSwiftGenerator {
            val config = Config().apply(block)
            return ConnectedViewSwiftGenerator(featureContext, config.filter)
        }

        override val featureContext: KClass<ClassContext> = ClassContext::class

        @JvmStatic
        override val factory = Companion
    }
}
