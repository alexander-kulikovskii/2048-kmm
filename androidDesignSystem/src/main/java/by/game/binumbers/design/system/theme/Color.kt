package by.game.binumbers.design.system.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/*************************************************************
 *
 *          Light theme
 *
 **************************************************************/
internal val lightPrimary = Color(0xFF308C8C)
internal val lightPrimaryVariant = Color(0xFFC4BCAD)
internal val lightOnPrimary = Color(0xFFFFFFFF)
internal val lightPrimaryDisabled = Color(0xFF77AFAF)

internal val lightSecondary = Color(0xFFECC644)
internal val lightSecondaryVariant = Color(0xFFB8A669)
internal val lightOnSecondary = Color(0xFFFFFFFF)
internal val lightSecondaryDisabled = Color(0xFFA8A187)

internal val lightBackground = Color(0xFFDDD3BE)
internal val lightBackgroundVariant = Color(0xFFD7CAB2)
internal val lightOnBackground = Color(0xFFFFFFFF)

internal val lightPrimaryTextColor = Color(0xFFFFFFFF)

internal val lightCellEmptyBackgroundColor = Color(0xFF978E7B)
internal val lightCellEmptyShadowColor = Color(0xFF978E7B)

internal val lightCell2BackgroundColor = Color(0xFF17BABA)
internal val lightCell2ShadowColor = Color(0xFF2D9898)

internal val lightCell4BackgroundColor = Color(0xFF2BB55E)
internal val lightCell4ShadowColor = Color(0xFF189646)

internal val lightCell8BackgroundColor = Color(0xFF9AB034)
internal val lightCell8ShadowColor = Color(0xFF779228)

internal val lightCell16BackgroundColor = Color(0xFFC9C84B)
internal val lightCell16ShadowColor = Color(0xFF9C9B2D)

internal val lightCell32BackgroundColor = Color(0xFFD8A331)
internal val lightCell32ShadowColor = Color(0xFFBE8B1D)

internal val lightCell64BackgroundColor = Color(0xFFDB7036)
internal val lightCell64ShadowColor = Color(0xFFB1531A)

internal val lightCell128BackgroundColor = Color(0xFFD1544E)
internal val lightCell128ShadowColor = Color(0xFFAA3D37)

internal val lightCell256BackgroundColor = Color(0xFFC8628D)
internal val lightCell256ShadowColor = Color(0xFFB74E7A)

internal val lightCell512BackgroundColor = Color(0xFFBA5CB2)
internal val lightCell512ShadowColor = Color(0xFFA14599)

internal val lightCell1024BackgroundColor = Color(0xFF9A6CDD)
internal val lightCell1024ShadowColor = Color(0xFF8455CA)

internal val lightCell2048BackgroundColor = Color(0xFF4B96DB)
internal val lightCell2048ShadowColor = Color(0xFF3572AB)
internal val lightCell2048CenterLineColor = Color(0xFF4084C3)

internal val lightCell4096CenterLineColor = Color(0xFF219F9F)

internal val lightCell8192CenterLineColor = Color(0xFF1F9B4D)
internal val lightCellUnlimitedCenterLineColor = Color(0xFF789421)

internal val lightLogoNormalBackgroundColor = Color(0xFF399393)
internal val lightLogoNormalCellShadowColor = Color(0xFF2C7878)
internal val lightLogoNormalCellShadowDarkColor = Color(0xFF1F5757)
internal val lightLogoNormalRhombusColor = Color(0xFF2A8383)
internal val lightLogoNormalTextColor = Color(0xFFFFFFFF)
internal val lightLogoNormalShadowColor = Color(0xFF8C8578)
internal val lightLogoCrownColor = Color(0xFFF8E774)
internal val lightLogoCrownDarkColor = Color(0xFFECC644)

internal val lightUndoTextBorderColor = Color(0x40E15236)
internal val lightUndoTextBackgroundColor = Color(0xFFe15236)

/*************************************************************
 *
 *          Dark theme
 *
 **************************************************************/
internal val darkPrimary = Color(0xFF28353E)
internal val darkPrimaryVariant = Color(0x7328353E)
internal val darkOnPrimary = Color(0xFFCFD4DB)
internal val darkPrimaryDisabled = Color(0x804A6272)

internal val darkSecondary = Color(0xFFFFFFFF)
internal val darkSecondaryVariant = Color(0x40CFD4DB)
internal val darkOnSecondary = Color(0xFF0E1318)
internal val darkSecondaryDisabled = Color(0xFFFFFFFF)

internal val darkBackground = Color(0xFF12191F)
internal val darkBackgroundVariant = Color(0x26000000)
internal val darkOnBackground = Color(0xFFFFFFFF)

internal val darkPrimaryTextColor = Color(0xFFCFD4DB)

internal val darkCellEmptyBackgroundColor = Color(0xFF151C22)
internal val darkCellEmptyShadowColor = Color(0xFF151C22)

internal val darkCell2BackgroundColor = Color(0xFF17BABA)
internal val darkCell2ShadowColor = Color(0xFF2D9898)

internal val darkCell4BackgroundColor = Color(0xFF2BB55E)
internal val darkCell4ShadowColor = Color(0xFF189646)

internal val darkCell8BackgroundColor = Color(0xFF9AB034)
internal val darkCell8ShadowColor = Color(0xFF779228)

internal val darkCell16BackgroundColor = Color(0xFFC9C84B)
internal val darkCell16ShadowColor = Color(0xFF9C9B2D)

internal val darkCell32BackgroundColor = Color(0xFFD8A331)
internal val darkCell32ShadowColor = Color(0xFFBE8B1D)

internal val darkCell64BackgroundColor = Color(0xFFDB7036)
internal val darkCell64ShadowColor = Color(0xFFB1531A)

internal val darkCell128BackgroundColor = Color(0xFFD1544E)
internal val darkCell128ShadowColor = Color(0xFFAA3D37)

internal val darkCell256BackgroundColor = Color(0xFFC8628D)
internal val darkCell256ShadowColor = Color(0xFFB74E7A)

internal val darkCell512BackgroundColor = Color(0xFFBA5CB2)
internal val darkCell512ShadowColor = Color(0xFFA14599)

internal val darkCell1024BackgroundColor = Color(0xFF9A6CDD)
internal val darkCell1024ShadowColor = Color(0xFF8455CA)

internal val darkCell2048BackgroundColor = Color(0xFF4B96DB)
internal val darkCell2048ShadowColor = Color(0xFF3572AB)
internal val darkCell2048CenterLineColor = Color(0xFF4084C3)

internal val darkCell4096CenterLineColor = Color(0xFF219F9F)

internal val darkCell8192CenterLineColor = Color(0xFF1F9B4D)
internal val darkCellUnlimitedCenterLineColor = Color(0xFF789421)

internal val darkUndoTextBorderColor = Color(0x7328353E)
internal val darkUndoTextBackgroundColor = Color(0xFFF45C4E)

internal val black = Color(0xFF000000)
internal val white = Color(0xFFFFFFFF)
internal val shadowBlack = Color(0x88000000)
internal const val ALPHA_NEAR_OPAQUE = 0.95f
internal const val DIVIDER_ALPHA = 0.12f

@Suppress("LongParameterList")
@Stable
class GameColors(
    primary: Color,
    primaryVariant: Color,
    onPrimary: Color,
    primaryDisabled: Color,

    secondary: Color,
    secondaryVariant: Color,
    onSecondary: Color,
    secondaryDisabled: Color,

    background: Color,
    backgroundVariant: Color,
    onBackground: Color,

    logoNormalBackgroundColor: Color,
    logoNormalCellShadowColor: Color,
    logoNormalCellShadowDarkColor: Color,
    logoNormalRhombusColor: Color,
    logoNormalTextColor: Color,
    logoNormalShadowColor: Color,
    logoCrownColor: Color,
    logoCrownDarkColor: Color,

    cellTextColor: Color,
    cellEmptyBackgroundColor: Color,
    cellEmptyShadowColor: Color,
    cell2BackgroundColor: Color,
    cell2ShadowColor: Color,

    cell4BackgroundColor: Color,
    cell4ShadowColor: Color,

    cell8BackgroundColor: Color,
    cell8ShadowColor: Color,

    cell16BackgroundColor: Color,
    cell16ShadowColor: Color,

    cell32BackgroundColor: Color,
    cell32ShadowColor: Color,

    cell64BackgroundColor: Color,
    cell64ShadowColor: Color,

    cell128BackgroundColor: Color,
    cell128ShadowColor: Color,

    cell256BackgroundColor: Color,
    cell256ShadowColor: Color,

    cell512BackgroundColor: Color,
    cell512ShadowColor: Color,

    cell1024BackgroundColor: Color,
    cell1024ShadowColor: Color,

    cell2048BackgroundColor: Color,
    cell2048ShadowColor: Color,
    cell2048CenterLineColor: Color,

    cell4096CenterLineColor: Color,

    cell8192CenterLineColor: Color,
    cellUnlimitedCenterLineColor: Color,

    undoTextBorderColor: Color,
    undoTextBackgroundColor: Color,

    isDark: Boolean,
) {
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var primaryDisabled by mutableStateOf(primaryDisabled)
        private set

    var secondary by mutableStateOf(secondary)
        private set
    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var secondaryDisabled by mutableStateOf(secondaryDisabled)
        private set

    var background by mutableStateOf(background)
        private set
    var backgroundVariant by mutableStateOf(backgroundVariant)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set

    var logoNormalBackgroundColor by mutableStateOf(logoNormalBackgroundColor)
        private set
    var logoNormalCellShadowColor by mutableStateOf(logoNormalCellShadowColor)
        private set
    var logoNormalCellShadowDarkColor by mutableStateOf(logoNormalCellShadowDarkColor)
        private set
    var logoNormalRhombusColor by mutableStateOf(logoNormalRhombusColor)
        private set
    var logoNormalTextColor by mutableStateOf(logoNormalTextColor)
        private set
    var logoNormalShadowColor by mutableStateOf(logoNormalShadowColor)
        private set
    var logoCrownColor by mutableStateOf(logoCrownColor)
        private set
    var logoCrownDarkColor by mutableStateOf(logoCrownDarkColor)
        private set

    var cellTextColor by mutableStateOf(cellTextColor)
        private set
    var cellEmptyBackgroundColor by mutableStateOf(cellEmptyBackgroundColor)
        private set
    var cellEmptyShadowColor by mutableStateOf(cellEmptyShadowColor)
        private set
    var cell2BackgroundColor by mutableStateOf(cell2BackgroundColor)
        private set
    var cell2ShadowColor by mutableStateOf(cell2ShadowColor)
        private set

    var cell4BackgroundColor by mutableStateOf(cell4BackgroundColor)
        private set
    var cell4ShadowColor by mutableStateOf(cell4ShadowColor)
        private set

    var cell8BackgroundColor by mutableStateOf(cell8BackgroundColor)
        private set
    var cell8ShadowColor by mutableStateOf(cell8ShadowColor)
        private set

    var cell16BackgroundColor by mutableStateOf(cell16BackgroundColor)
        private set
    var cell16ShadowColor by mutableStateOf(cell16ShadowColor)
        private set

    var cell32BackgroundColor by mutableStateOf(cell32BackgroundColor)
        private set
    var cell32ShadowColor by mutableStateOf(cell32ShadowColor)
        private set
    var cell64BackgroundColor by mutableStateOf(cell64BackgroundColor)
        private set
    var cell64ShadowColor by mutableStateOf(cell64ShadowColor)
        private set
    var cell128BackgroundColor by mutableStateOf(cell128BackgroundColor)
        private set
    var cell128ShadowColor by mutableStateOf(cell128ShadowColor)
        private set
    var cell256BackgroundColor by mutableStateOf(cell256BackgroundColor)
        private set
    var cell256ShadowColor by mutableStateOf(cell256ShadowColor)
        private set
    var cell512BackgroundColor by mutableStateOf(cell512BackgroundColor)
        private set
    var cell512ShadowColor by mutableStateOf(cell512ShadowColor)
        private set
    var cell1024BackgroundColor by mutableStateOf(cell1024BackgroundColor)
        private set
    var cell1024ShadowColor by mutableStateOf(cell1024ShadowColor)
        private set

    var cell2048BackgroundColor by mutableStateOf(cell2048BackgroundColor)
        private set
    var cell2048ShadowColor by mutableStateOf(cell2048ShadowColor)
        private set
    var cell2048CenterLineColor by mutableStateOf(cell2048CenterLineColor)
        private set

    var cell4096CenterLineColor by mutableStateOf(cell4096CenterLineColor)
        private set

    var cell8192CenterLineColor by mutableStateOf(cell8192CenterLineColor)
        private set

    var cellUnlimitedCenterLineColor by mutableStateOf(cellUnlimitedCenterLineColor)
        private set

    var undoTextBorderColor by mutableStateOf(undoTextBorderColor)
        private set

    var undoTextBackgroundColor by mutableStateOf(undoTextBackgroundColor)
        private set

    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: GameColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        onPrimary = other.onPrimary
        primaryDisabled = other.primaryDisabled

        secondary = other.secondary
        secondaryVariant = other.secondaryVariant
        onSecondary = other.onSecondary
        secondaryDisabled = other.secondaryDisabled

        background = other.background
        backgroundVariant = other.backgroundVariant
        onBackground = other.onBackground

        logoCrownColor = other.logoCrownColor
        logoCrownDarkColor = other.logoCrownDarkColor

        logoNormalBackgroundColor = other.logoNormalBackgroundColor
        logoNormalCellShadowColor = other.logoNormalCellShadowColor
        logoNormalRhombusColor = other.logoNormalRhombusColor
        logoNormalTextColor = other.logoNormalTextColor
        logoNormalShadowColor = other.logoNormalShadowColor
        logoNormalCellShadowDarkColor = other.logoNormalCellShadowDarkColor
        logoCrownColor = other.logoCrownColor
        logoCrownDarkColor = other.logoCrownDarkColor

        cellTextColor = other.cellTextColor
        cellEmptyBackgroundColor = other.cellEmptyBackgroundColor
        cellEmptyShadowColor = other.cellEmptyShadowColor
        cell2BackgroundColor = other.cell2BackgroundColor
        cell2ShadowColor = other.cell2ShadowColor
        cell4BackgroundColor = other.cell4BackgroundColor
        cell4ShadowColor = other.cell4ShadowColor
        cell8BackgroundColor = other.cell8BackgroundColor
        cell8ShadowColor = other.cell8ShadowColor
        cell16BackgroundColor = other.cell16BackgroundColor
        cell16ShadowColor = other.cell16ShadowColor
        cell32BackgroundColor = other.cell32BackgroundColor
        cell32ShadowColor = other.cell32ShadowColor
        cell64BackgroundColor = other.cell64BackgroundColor
        cell64ShadowColor = other.cell64ShadowColor
        cell128BackgroundColor = other.cell128BackgroundColor
        cell128ShadowColor = other.cell128ShadowColor
        cell256BackgroundColor = other.cell256BackgroundColor
        cell256ShadowColor = other.cell256ShadowColor
        cell512BackgroundColor = other.cell512BackgroundColor
        cell512ShadowColor = other.cell512ShadowColor
        cell1024BackgroundColor = other.cell1024BackgroundColor
        cell1024ShadowColor = other.cell1024ShadowColor

        cell2048BackgroundColor = other.cell2048BackgroundColor
        cell2048ShadowColor = other.cell2048ShadowColor
        cell2048CenterLineColor = other.cell2048CenterLineColor

        cell4096CenterLineColor = other.cell4096CenterLineColor
        cell8192CenterLineColor = other.cell8192CenterLineColor

        undoTextBorderColor = other.undoTextBorderColor
        undoTextBackgroundColor = other.undoTextBackgroundColor
        isDark = other.isDark
    }

    fun copy(): GameColors = GameColors(
        primary = lightPrimary,
        primaryVariant = lightPrimaryVariant,
        onPrimary = lightOnPrimary,
        primaryDisabled = lightPrimaryDisabled,

        secondary = lightSecondary,
        secondaryVariant = lightSecondaryVariant,
        onSecondary = lightOnSecondary,
        secondaryDisabled = lightSecondaryDisabled,

        background = lightBackground,
        backgroundVariant = lightBackgroundVariant,
        onBackground = lightOnBackground,

        logoNormalBackgroundColor = logoNormalBackgroundColor,
        logoNormalCellShadowColor = logoNormalCellShadowColor,
        logoNormalRhombusColor = logoNormalRhombusColor,
        logoNormalTextColor = logoNormalTextColor,
        logoNormalShadowColor = logoNormalShadowColor,
        logoNormalCellShadowDarkColor = logoNormalCellShadowDarkColor,
        logoCrownColor = logoCrownColor,
        logoCrownDarkColor = logoCrownDarkColor,

        cellTextColor = cellTextColor,
        cellEmptyBackgroundColor = cellEmptyBackgroundColor,
        cellEmptyShadowColor = cellEmptyShadowColor,
        cell2BackgroundColor = cell2BackgroundColor,
        cell2ShadowColor = cell2ShadowColor,
        cell4BackgroundColor = cell4BackgroundColor,
        cell4ShadowColor = cell4ShadowColor,
        cell8BackgroundColor = cell8BackgroundColor,
        cell8ShadowColor = cell8ShadowColor,
        cell16BackgroundColor = cell16BackgroundColor,
        cell16ShadowColor = cell16ShadowColor,
        cell32BackgroundColor = cell32BackgroundColor,
        cell32ShadowColor = cell32ShadowColor,
        cell64BackgroundColor = cell64BackgroundColor,
        cell64ShadowColor = cell64ShadowColor,
        cell128BackgroundColor = cell128BackgroundColor,
        cell128ShadowColor = cell128ShadowColor,
        cell256BackgroundColor = cell256BackgroundColor,
        cell256ShadowColor = cell256ShadowColor,
        cell512BackgroundColor = cell512BackgroundColor,
        cell512ShadowColor = cell512ShadowColor,
        cell1024BackgroundColor = cell1024BackgroundColor,
        cell1024ShadowColor = cell1024ShadowColor,

        cell2048BackgroundColor = cell2048BackgroundColor,
        cell2048ShadowColor = cell2048ShadowColor,
        cell2048CenterLineColor = cell2048CenterLineColor,
        cell4096CenterLineColor = cell4096CenterLineColor,
        cell8192CenterLineColor = cell8192CenterLineColor,
        cellUnlimitedCenterLineColor = cellUnlimitedCenterLineColor,

        undoTextBorderColor = undoTextBorderColor,
        undoTextBackgroundColor = undoTextBackgroundColor,
        isDark = isDark,
    )
}

internal val LightColorPalette = GameColors(
    primary = lightPrimary,
    primaryVariant = lightPrimaryVariant,
    onPrimary = lightOnPrimary,
    primaryDisabled = lightPrimaryDisabled,

    secondary = lightSecondary,
    secondaryVariant = lightSecondaryVariant,
    onSecondary = lightOnSecondary,
    secondaryDisabled = lightSecondaryDisabled,

    background = lightBackground,
    backgroundVariant = lightBackgroundVariant,
    onBackground = lightOnBackground,

    logoNormalBackgroundColor = lightLogoNormalBackgroundColor,
    logoNormalCellShadowColor = lightLogoNormalCellShadowColor,
    logoNormalCellShadowDarkColor = lightLogoNormalCellShadowDarkColor,
    logoNormalRhombusColor = lightLogoNormalRhombusColor,
    logoNormalTextColor = lightLogoNormalTextColor,
    logoNormalShadowColor = lightLogoNormalShadowColor,
    logoCrownColor = lightLogoCrownColor,
    logoCrownDarkColor = lightLogoCrownDarkColor,

    cellTextColor = lightPrimaryTextColor,
    cellEmptyBackgroundColor = lightCellEmptyBackgroundColor,
    cellEmptyShadowColor = lightCellEmptyShadowColor,
    cell2BackgroundColor = lightCell2BackgroundColor,
    cell2ShadowColor = lightCell2ShadowColor,

    cell4BackgroundColor = lightCell4BackgroundColor,
    cell4ShadowColor = lightCell4ShadowColor,

    cell8BackgroundColor = lightCell8BackgroundColor,
    cell8ShadowColor = lightCell8ShadowColor,

    cell16BackgroundColor = lightCell16BackgroundColor,
    cell16ShadowColor = lightCell16ShadowColor,

    cell32BackgroundColor = lightCell32BackgroundColor,
    cell32ShadowColor = lightCell32ShadowColor,

    cell64BackgroundColor = lightCell64BackgroundColor,
    cell64ShadowColor = lightCell64ShadowColor,

    cell128BackgroundColor = lightCell128BackgroundColor,
    cell128ShadowColor = lightCell128ShadowColor,

    cell256BackgroundColor = lightCell256BackgroundColor,
    cell256ShadowColor = lightCell256ShadowColor,

    cell512BackgroundColor = lightCell512BackgroundColor,
    cell512ShadowColor = lightCell512ShadowColor,

    cell1024BackgroundColor = lightCell1024BackgroundColor,
    cell1024ShadowColor = lightCell1024ShadowColor,

    cell2048BackgroundColor = lightCell2048BackgroundColor,
    cell2048ShadowColor = lightCell2048ShadowColor,
    cell2048CenterLineColor = lightCell2048CenterLineColor,

    cell4096CenterLineColor = lightCell4096CenterLineColor,
    cell8192CenterLineColor = lightCell8192CenterLineColor,

    cellUnlimitedCenterLineColor = lightCellUnlimitedCenterLineColor,

    undoTextBorderColor = lightUndoTextBorderColor,
    undoTextBackgroundColor = lightUndoTextBackgroundColor,
    isDark = false,
)

internal val DarkColorPalette = GameColors(
    primary = darkPrimary,
    primaryVariant = darkPrimaryVariant,
    onPrimary = darkOnPrimary,
    primaryDisabled = darkPrimaryDisabled,

    secondary = darkSecondary,
    secondaryVariant = darkSecondaryVariant,
    onSecondary = darkOnSecondary,
    secondaryDisabled = darkSecondaryDisabled,

    background = darkBackground,
    backgroundVariant = darkBackgroundVariant,
    onBackground = darkOnBackground,

    logoNormalBackgroundColor = lightLogoNormalBackgroundColor,
    logoNormalCellShadowColor = lightLogoNormalCellShadowColor,
    logoNormalCellShadowDarkColor = lightLogoNormalCellShadowDarkColor,
    logoNormalRhombusColor = lightLogoNormalRhombusColor,
    logoNormalTextColor = lightLogoNormalTextColor,
    logoNormalShadowColor = lightLogoNormalShadowColor,
    logoCrownColor = lightLogoCrownColor,
    logoCrownDarkColor = lightLogoCrownDarkColor,

    cellTextColor = darkPrimaryTextColor,
    cellEmptyBackgroundColor = darkCellEmptyBackgroundColor,
    cellEmptyShadowColor = darkCellEmptyShadowColor,
    cell2BackgroundColor = darkCell2BackgroundColor,
    cell2ShadowColor = darkCell2ShadowColor,

    cell4BackgroundColor = darkCell4BackgroundColor,
    cell4ShadowColor = darkCell4ShadowColor,

    cell8BackgroundColor = darkCell8BackgroundColor,
    cell8ShadowColor = darkCell8ShadowColor,

    cell16BackgroundColor = darkCell16BackgroundColor,
    cell16ShadowColor = darkCell16ShadowColor,

    cell32BackgroundColor = darkCell32BackgroundColor,
    cell32ShadowColor = darkCell32ShadowColor,

    cell64BackgroundColor = darkCell64BackgroundColor,
    cell64ShadowColor = darkCell64ShadowColor,

    cell128BackgroundColor = darkCell128BackgroundColor,
    cell128ShadowColor = darkCell128ShadowColor,

    cell256BackgroundColor = darkCell256BackgroundColor,
    cell256ShadowColor = darkCell256ShadowColor,

    cell512BackgroundColor = darkCell512BackgroundColor,
    cell512ShadowColor = darkCell512ShadowColor,

    cell1024BackgroundColor = darkCell1024BackgroundColor,
    cell1024ShadowColor = darkCell1024ShadowColor,

    cell2048BackgroundColor = darkCell2048BackgroundColor,
    cell2048ShadowColor = darkCell2048ShadowColor,
    cell2048CenterLineColor = darkCell2048CenterLineColor,

    cell4096CenterLineColor = darkCell4096CenterLineColor,
    cell8192CenterLineColor = darkCell8192CenterLineColor,

    cellUnlimitedCenterLineColor = darkCellUnlimitedCenterLineColor,

    undoTextBorderColor = darkUndoTextBorderColor,
    undoTextBackgroundColor = darkUndoTextBackgroundColor,
    isDark = true,
)

@Composable
internal fun dynamicDarkBinumbersColors(): GameColors {
    return dynamicDarkColorScheme(LocalContext.current).toColors()
}

@Composable
internal fun dynamicLightBinumbersColors(): GameColors {
    return dynamicLightColorScheme(LocalContext.current).toColors()
}

private fun ColorScheme.toColors(): GameColors {
    return GameColors(
        primary = this.primary,
        primaryVariant = this.primaryContainer,
        onPrimary = this.onPrimary,
        primaryDisabled = this.inversePrimary.copy(alpha = 0.75f),

        secondary = this.secondary,
        secondaryVariant = this.secondaryContainer,
        onSecondary = this.onSecondary,
        secondaryDisabled = this.secondary,

        background = this.background,
        backgroundVariant = this.background,
        onBackground = this.onBackground,

        logoNormalBackgroundColor = this.secondary,
        logoNormalCellShadowColor = this.secondary,
        logoNormalCellShadowDarkColor = this.secondaryContainer,
        logoNormalRhombusColor = this.secondaryContainer.copy(alpha = 0.23f),
        logoNormalTextColor = onSecondary,
        logoNormalShadowColor = lightLogoNormalShadowColor,
        logoCrownColor = this.primary,
        logoCrownDarkColor = this.inversePrimary,

        cellTextColor = this.onPrimary,
        cellEmptyBackgroundColor = this.primaryContainer.copy(alpha = ALPHA_NEAR_OPAQUE),
        cellEmptyShadowColor = this.primaryContainer.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell2BackgroundColor = this.primary,
        cell2ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell4BackgroundColor = this.primary,
        cell4ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell8BackgroundColor = this.primary,
        cell8ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell16BackgroundColor = this.primary,
        cell16ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell32BackgroundColor = this.primary,
        cell32ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell64BackgroundColor = this.primary,
        cell64ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell128BackgroundColor = this.primary,
        cell128ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell256BackgroundColor = this.primary,
        cell256ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell512BackgroundColor = this.primary,
        cell512ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell1024BackgroundColor = this.primary,
        cell1024ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell2048BackgroundColor = this.primary,
        cell2048ShadowColor = this.primary.copy(alpha = ALPHA_NEAR_OPAQUE),
        cell2048CenterLineColor = this.primaryContainer.copy(0.22f),

        cell4096CenterLineColor = this.primaryContainer.copy(0.22f),
        cell8192CenterLineColor = this.primaryContainer.copy(0.22f),
        cellUnlimitedCenterLineColor = this.primaryContainer.copy(0.22f),

        undoTextBorderColor = this.primaryContainer,
        undoTextBackgroundColor = this.primary,

        isDark = false,
    )
}
