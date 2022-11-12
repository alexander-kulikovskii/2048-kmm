import dev.icerock.moko.kswift.plugin.context.ClassContext
import dev.icerock.moko.kswift.plugin.feature.BaseConfig
import dev.icerock.moko.kswift.plugin.feature.Filter
import dev.icerock.moko.kswift.plugin.feature.ProcessorContext
import dev.icerock.moko.kswift.plugin.feature.ProcessorFeature
import io.outfoxx.swiftpoet.*
import io.outfoxx.swiftpoet.FunctionSpec
import kotlin.reflect.KClass
import kotlin.system.exitProcess


class MyKSwiftGenerator(
    override val featureContext: KClass<ClassContext>,
    override val filter: Filter<ClassContext>,
) : ProcessorFeature<ClassContext>() {
    private val defaultValuesForState =
        mapOf("Stand" to "StandState(progress: false, stands: [], selectedStand: nil)",
            "Home" to "HomeState(progress: false, allColors: [], selectedColor: nil)",
            "Splash" to "SplashState(progress: false)",
        )

    @ExperimentalStdlibApi
    override fun doProcess(featureContext: ClassContext, processorContext: ProcessorContext) {

        if ("interactor" !in featureContext.clazz.name.lowercase()) return
        try {

            val fileSpec: FileSpec.Builder = processorContext.fileSpecBuilder

//            val frameworkName: String = processorContext.fileSpecBuilder.name

            val classSimpleName = featureContext.clazz.name.substringAfterLast('/')

            val name = classSimpleName.replace("Interactor", "")
            val platformClassTypeName =
                TypeVariableName.typeVariable(name = "ObservableObject", bounds = emptyList())

            val enumType = TypeSpec.classBuilder("Observable${classSimpleName}")
                .addModifiers(Modifier.PUBLIC)
                .addSuperType(platformClassTypeName)
                .addProperty(
                    PropertySpec.builder("${name.toLowerCase()}State", className("${name}State"))
                        .addAttribute("Published")
                        .addModifiers(Modifier.PUBLIC)
//                        .initializer(CodeBlock.of(defaultValuesForState[name] + "${name}.State.Companion().initial"))
                        .initializer(CodeBlock.of("${name}State.Companion().initial"))
                        .mutable(true)
                        .build()
                )
                .addProperty(
                    PropertySpec.builder("sideEffect",
                        className("${name}SideEffect").makeOptional())
                        .addAttribute("Published")
                        .addModifiers(Modifier.PUBLIC)
                        .mutable(true)
                        .build()
                )
                .addProperty(
                    PropertySpec.builder("navigation",
                        className("BinumbersNavigation").makeOptional())
                        .addAttribute("Published")
//                        .space(true)
                        .addModifiers(Modifier.PUBLIC)
                        .mutable(true)
                        .build()
                )

                .addProperty(
                    PropertySpec.builder("interactor", className(classSimpleName))
//                        .space(true)
                        .initializer(CodeBlock.of("${name}DIHelper().${name.toLowerCase()}Interactor"))
                        .build()
                )

                .addProperty(
                    PropertySpec.builder("stateWatcher", className("Closeable").makeOptional())
                        .mutable(true)
                        .addModifiers(Modifier.PUBLIC)
                        .build()
                )

                .addProperty(
                    PropertySpec.builder("sideEffectWatcher", className("Closeable").makeOptional())
                        .mutable(true)
                        .addModifiers(Modifier.PUBLIC)
                        .build()
                )
                .addProperty(
                    PropertySpec.builder("navigationWatcher", className("Closeable").makeOptional())
                        .mutable(true)
                        .addModifiers(Modifier.PUBLIC)
                        .build()
                )
                .addFunction(
                    FunctionSpec.constructorBuilder()
                        .addModifiers(Modifier.PUBLIC)
//                        .addParameter("interactor", className(classSimpleName))
                        .addCode("stateWatcher = self.interactor.watchState().watch { [weak self] state in\n" +
                                "   self?.${name.toLowerCase()}State = state\n" +
                                "}\n" +
                                "sideEffectWatcher = self.interactor.watchSideEffect().watch { [weak self] state in\n" +
                                "   self?.sideEffect = state\n" +
                                "}\n" +
                                "navigationWatcher = self.interactor.watchNavigation().watch { [weak self] state in\n" +
                                "   self?.navigation = state\n" +
                                "}\n")
                        .build()
                )
                .addFunction(
                    FunctionSpec.builder("dispatch")
                        .addParameter(label = "_","action", className(name + "Action"))
                        .addModifiers(Modifier.PUBLIC)
                        .addCode("interactor.dispatch(action: action)\n")

                        .build()
                )

                .addFunction(FunctionSpec.deinitializerBuilder()
                    .addCode("stateWatcher?.close()\nsideEffectWatcher?.close()\nnavigationWatcher?.close()\n")
                    .build())

                .build()

            fileSpec.addImport("Foundation")
            fileSpec.addType(enumType)

        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    private fun className(className: String) =
        TypeVariableName.typeVariable(name = className, bounds = emptyList())

    class Config : BaseConfig<ClassContext> {
        override var filter: Filter<ClassContext> = Filter.Exclude(emptySet())
    }

    companion object : Factory<ClassContext, MyKSwiftGenerator, Config> {

        override fun create(block: Config.() -> Unit): MyKSwiftGenerator {
            val config = Config().apply(block)
            return MyKSwiftGenerator(featureContext, config.filter)
        }

        override val featureContext: KClass<ClassContext> = ClassContext::class

        @JvmStatic
        override val factory = Companion
    }
}