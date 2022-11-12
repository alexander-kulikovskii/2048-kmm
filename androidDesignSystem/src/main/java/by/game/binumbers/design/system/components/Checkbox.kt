package by.game.binumbers.design.system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme
import by.game.binumbers.design.system.theme.Shapes

@Composable
fun CheckBoxWithLabel(
    text: String,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = true,
    onCheckedChange: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(Shapes.small)
            .clickable(
                indication = rememberRipple(color = GameTheme.colors.onPrimary),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onCheckedChange() }
            )
            .requiredHeight(ButtonDefaults.MinHeight)
            .padding(4.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = GameTheme.colors.onPrimary,
                uncheckedColor = GameTheme.colors.onPrimary,
                checkmarkColor = GameTheme.colors.onPrimary,
            )
        )

        Spacer(Modifier.size(6.dp))

        Text(text = text, color = GameTheme.colors.onPrimary)
    }
}

@Preview
@Composable
private fun PreviewCheckbox() {
    BinumbersTheme(darkTheme = false, useDynamicColor = false) {
        Column(Modifier.background(GameTheme.colors.background)) {
            CheckBoxWithLabel(text = "Text")
            CheckBoxWithLabel(text = "Checked", checked = true)
        }
    }
}

@Preview
@Composable
private fun PreviewCheckbox2() {
    BinumbersTheme(darkTheme = true, useDynamicColor = false) {
        Column(Modifier.background(GameTheme.colors.background)) {
            CheckBoxWithLabel(text = "Text")
            CheckBoxWithLabel(text = "Checked", checked = true)
        }
    }
}

@Preview
@Composable
private fun PreviewCheckbox3() {
    BinumbersTheme(darkTheme = true, useDynamicColor = true) {
        Column(Modifier.background(GameTheme.colors.background)) {
            CheckBoxWithLabel(text = "Text")
            CheckBoxWithLabel(text = "Checked", checked = true)
        }
    }
}

@Preview
@Composable
private fun PreviewCheckbox4() {
    BinumbersTheme(darkTheme = false, useDynamicColor = true) {
        Column(Modifier.background(GameTheme.colors.background)) {
            CheckBoxWithLabel(text = "Text")
            CheckBoxWithLabel(text = "Checked", checked = true)
        }
    }
}
