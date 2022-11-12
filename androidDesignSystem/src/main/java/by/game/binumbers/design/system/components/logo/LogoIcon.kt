package by.game.binumbers.design.system.components.logo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun LogoIcon(modifier: Modifier) {
    Icon(
        makeLogoFromPath(),
        contentDescription = "Logo icon",
        tint = Color.Unspecified,
        modifier = modifier,
    )
}

@Suppress("LongMethod", "MagicNumber")
@Composable
internal fun makeLogoFromPath(
    viewportWidth: Float = 571f,
    viewportHeight: Float = 613f,
): ImageVector {
    val brushLogoNormalShadowColor1 = SolidColor(GameTheme.colors.logoNormalShadowColor.copy(0.21f))
    val brushLogoNormalShadowColor2 = SolidColor(GameTheme.colors.logoNormalShadowColor.copy(0.36f))
    val brushLogoNormalBackgroundColor = SolidColor(GameTheme.colors.logoNormalBackgroundColor)
    val brushLogoNormalRhombusColor = SolidColor(GameTheme.colors.logoNormalRhombusColor)
    val brushLogoNormalTextColor = SolidColor(GameTheme.colors.logoNormalTextColor)
    val brushCrownColor = SolidColor(GameTheme.colors.logoCrownColor)
    val brushCrownDarkColor = SolidColor(GameTheme.colors.logoCrownDarkColor)

    val b = Brush.linearGradient(
        0.0f to GameTheme.colors.logoNormalCellShadowDarkColor,
        0.505208f to GameTheme.colors.logoNormalCellShadowColor,
        1.0f to GameTheme.colors.logoNormalCellShadowDarkColor,
        start = Offset(x = 25.3434f, y = 330.198f),
        end = Offset(x = 544.858f, y = 279.317f)
    )

    return ImageVector.Builder(
        defaultWidth = viewportWidth.dp,
        defaultHeight = viewportHeight.dp,
        viewportWidth = viewportWidth,
        viewportHeight = viewportHeight,
    ).run {
        addPath(
            pathData = addPathNodes("M56.902,578.471a34,249 89.821,1 0,497.998 -1.554a34,249 89.821,1 0,-497.998 1.554z"),
            fill = brushLogoNormalShadowColor1,
        )
        addPath(
            pathData = addPathNodes("M73.893,575.418a25,182 89.821,1 0,363.998 -1.136a25,182 89.821,1 0,-363.998 1.136z"),
            fill = brushLogoNormalShadowColor2,
        )
        addPath(
            pathData = addPathNodes("M12.672,200.817C5.673,129.362 57.926,65.763 129.381,58.765L390.133,33.227C461.588,26.228 525.188,78.481 532.186,149.936L557.529,408.698C564.528,480.153 512.275,543.752 440.82,550.75L180.068,576.289C108.613,583.287 45.013,531.034 38.015,459.579L12.672,200.817Z"),
            fill = b,
        )
        addPath(
            pathData = addPathNodes("M19.68,180.035C12.681,108.58 64.934,44.981 136.389,37.983L388.184,13.322C459.639,6.323 523.238,58.576 530.237,130.031L554.995,382.821C561.993,454.276 509.741,517.876 438.286,524.874L186.491,549.535C115.036,556.533 51.436,504.281 44.438,432.826L19.68,180.035Z"),
            fill = brushLogoNormalBackgroundColor
        )

        listOf(
            "M29.704,282.391L24.232,226.513L55.023,255.442L29.704,282.391Z",
            "M51.721,464.878C48.797,456.88 46.628,448.489 45.306,439.783L61.236,454.75L51.721,464.878Z",
            "M162.257,549.662C138.807,547.595 116.911,539.218 98.481,526.1L116.625,506.789L162.257,549.662Z",
            "M350.902,533.432L278.39,540.534L315.932,500.576L350.902,533.432Z",
            "M550.187,333.728L551.291,344.999L511.89,386.935L464.518,342.427L509.026,295.056L550.187,333.728Z",
            "M528.912,120.269C529.471,123.48 529.914,126.735 530.237,130.031L533.027,158.518L505.677,187.628L458.305,143.12L502.813,95.748L528.912,120.269Z",
            "M415.244,13.475L447.424,43.709L402.917,91.081L355.545,46.573L386.645,13.472L388.184,13.322C397.368,12.422 406.423,12.501 415.244,13.475Z",
            "M173.567,34.341L226.062,29.2L248.117,49.922L203.609,97.294L156.238,52.786L173.567,34.341Z",
            "M151.57,152.682L104.198,108.175L59.691,155.547L107.063,200.054L151.57,152.682Z",
            "M206.958,204.722L254.33,249.229L209.823,296.601L162.451,252.093L206.958,204.722Z",
            "M357.09,345.776L309.719,301.269L265.211,348.641L312.583,393.148L357.09,345.776Z",
            "M459.85,442.323L412.479,397.816L367.971,445.187L415.343,489.695L459.85,442.323Z",
            "M110.411,307.482L157.783,351.989L113.276,399.361L65.904,354.853L110.411,307.482Z",
            "M213.172,404.029L260.543,448.536L216.036,495.908L168.664,451.401L213.172,404.029Z",
            "M303.505,101.962L350.877,146.469L306.37,193.841L258.998,149.333L303.505,101.962Z",
            "M406.266,198.508L453.637,243.016L409.13,290.388L361.758,245.88L406.266,198.508Z",
        ).forEach {
            addPath(
                pathData = addPathNodes(it),
                fill = brushLogoNormalRhombusColor
            )
        }

        addPath(
            pathData = addPathNodes("M22.214,205.912L44.438,432.826C46.053,449.321 50.685,464.793 57.734,478.749L550.862,430.451C555.069,415.393 556.61,399.317 554.995,382.821L532.771,155.907L22.214,205.912Z"),
            fill = SolidColor(Color(0x26000000))
        )

        listOf(
            "M104.151,417.935C101.523,418.192 99.226,417.513 97.259,415.897C95.412,414.269 94.365,412.201 94.12,409.693C93.862,407.066 94.488,404.834 95.996,402.998L141.047,338.54C144.221,334.009 146.582,329.799 148.13,325.91C149.798,322.008 150.468,318.386 150.14,315.042C149.38,307.279 146.741,301.268 142.225,297.008C137.827,292.736 132.165,290.939 125.238,291.618C120.7,292.062 116.697,293.66 113.229,296.411C109.868,299.031 107.306,302.417 105.542,306.569C103.886,310.589 103.286,314.928 103.742,319.586C103.976,321.975 103.285,324.152 101.669,326.119C100.173,328.074 98.111,329.181 95.483,329.438C92.975,329.684 90.738,328.999 88.771,327.383C86.804,325.767 85.704,323.764 85.47,321.376C84.674,313.255 85.818,305.848 88.9,299.156C91.971,292.344 96.49,286.777 102.457,282.455C108.543,278.121 115.587,275.562 123.589,274.778C131.71,273.983 138.926,275.024 145.237,277.903C151.548,280.782 156.625,285.228 160.47,291.242C164.434,297.244 166.842,304.604 167.696,313.322C168.071,317.144 167.615,321.107 166.329,325.212C165.162,329.306 163.5,333.266 161.343,337.095C159.306,340.912 157.173,344.376 154.946,347.488L118.484,398.083L168.644,393.17C171.271,392.913 173.574,393.652 175.553,395.387C177.52,397.003 178.62,399.006 178.854,401.394C179.1,403.902 178.415,406.14 176.799,408.107C175.183,410.073 173.061,411.186 170.434,411.443L104.151,417.935Z",
            "M240.459,404.585C226.844,405.918 215.672,400.803 206.943,389.238C198.322,377.543 192.936,360.708 190.783,338.733C188.62,316.639 190.637,299.078 196.837,286.052C203.156,273.014 213.123,265.828 226.738,264.495C235.815,263.606 243.799,265.718 250.69,270.83C257.689,275.812 263.375,283.394 267.748,293.576C272.11,303.639 274.998,315.895 276.414,330.346C277.829,344.797 277.379,357.441 275.065,368.278C272.738,378.996 268.631,387.537 262.744,393.901C256.964,400.135 249.535,403.696 240.459,404.585ZM238.634,385.954C244.128,385.416 248.45,382.762 251.6,377.992C254.738,373.103 256.823,366.689 257.854,358.751C258.885,350.812 258.921,341.947 257.962,332.153C257.003,322.36 255.247,313.67 252.696,306.083C250.144,298.495 246.854,292.608 242.827,288.421C238.8,284.233 234.039,282.408 228.546,282.947C223.052,283.485 218.736,286.198 215.597,291.087C212.447,295.857 210.357,302.211 209.326,310.15C208.294,318.088 208.264,327.013 209.235,336.926C210.206,346.838 211.967,355.588 214.519,363.176C217.071,370.763 220.354,376.591 224.37,380.659C228.505,384.715 233.26,386.48 238.634,385.954Z",
            "M373.226,391.581C370.838,391.815 368.719,391.118 366.872,389.491C365.025,387.863 363.978,385.795 363.732,383.287L361.522,360.715L301.867,366.558C299.12,366.827 296.889,366.201 295.172,364.681C293.456,363.161 292.373,361.338 291.924,359.212C291.582,356.955 291.98,354.866 293.119,352.946L352.923,256.296C353.761,255.008 354.742,253.947 355.866,253.114C357.11,252.269 358.508,251.77 360.061,251.618C362.569,251.372 364.687,252.069 366.415,253.709C368.143,255.348 369.135,257.481 369.393,260.109L377.464,342.514L388.212,341.462C390.72,341.216 392.928,341.603 394.837,342.622C396.745,343.64 397.851,345.702 398.155,348.808C398.378,351.077 397.675,353.135 396.047,354.982C394.408,356.71 392.334,357.697 389.826,357.943L379.078,358.996L381.288,381.568C381.534,384.076 380.909,386.307 379.412,388.262C377.915,390.218 375.854,391.324 373.226,391.581ZM359.907,344.234L354.1,284.938L314.764,348.655L359.907,344.234Z",
            "M461.404,382.764C453.522,383.536 446.235,382.381 439.542,379.299C432.958,376.085 427.558,371.429 423.344,365.331C419.117,359.113 416.607,351.944 415.811,343.823C415.063,336.179 416.122,329.143 418.989,322.713C421.844,316.163 426.022,310.81 431.523,306.654C427.158,303.947 423.56,300.441 420.727,296.137C417.882,291.713 416.184,286.694 415.635,281.081C414.968,274.274 415.93,268.091 418.52,262.532C421.099,256.853 424.864,252.204 429.815,248.584C434.873,244.833 440.806,242.625 447.613,241.958C454.409,241.172 460.587,242.074 466.146,244.664C471.824,247.243 476.479,251.068 480.11,256.138C483.742,261.208 485.837,267.212 486.396,274.151C486.946,279.764 486.255,285.016 484.322,289.908C482.378,294.68 479.522,298.758 475.754,302.141C481.957,305.151 487.094,309.592 491.166,315.463C495.237,321.334 497.648,328.091 498.396,335.734C499.192,343.856 498.06,351.382 495.001,358.313C492.05,365.113 487.656,370.728 481.82,375.158C475.972,379.468 469.167,382.004 461.404,382.764ZM452.965,296.596C457.981,296.105 461.914,293.791 464.764,289.653C467.734,285.504 469.015,280.736 468.608,275.35C468.201,269.964 466.156,265.703 462.473,262.568C458.79,259.432 454.381,258.115 449.245,258.618C444.229,259.109 440.219,261.25 437.214,265.041C434.209,268.832 432.91,273.421 433.317,278.807C433.724,284.193 435.787,288.633 439.505,292.127C443.343,295.61 447.829,297.099 452.965,296.596ZM459.79,366.283C464.209,365.85 468.033,364.27 471.263,361.542C474.611,358.803 477.108,355.363 478.752,351.223C480.385,346.963 480.961,342.385 480.482,337.489C480.133,332.7 478.763,328.554 476.37,325.05C473.965,321.428 470.866,318.717 467.073,316.918C463.387,314.988 459.275,314.245 454.737,314.69C450.318,315.123 446.428,316.649 443.068,319.269C439.695,321.77 437.181,325.03 435.525,329.051C433.858,332.952 433.258,337.291 433.726,342.068C434.205,346.965 435.599,351.35 437.908,355.223C440.324,358.966 443.441,361.856 447.257,363.893C451.074,365.931 455.252,366.727 459.79,366.283Z",
        ).forEach {
            addPath(
                pathData = addPathNodes(it),
                fill = brushLogoNormalTextColor
            )
        }

        addPath(
            pathData = addPathNodes("M231.134,220.532L277.108,223.148L262.779,76.848L234.16,143.715L190.289,126.657L231.134,220.532Z"),
            fill = brushCrownColor
        )
        addPath(
            pathData = addPathNodes("M321.7,211.662L277.108,223.148L262.779,76.848L303.827,136.892L343.555,111.646L321.7,211.662Z"),
            fill = brushCrownDarkColor
        )
        build()
    }
}

@Preview
@Composable
private fun PreviewLogoIcon() {
    BinumbersTheme(useDynamicColor = false) {
        Column {
            LogoIcon(Modifier.width(20.dp))
        }
    }
}