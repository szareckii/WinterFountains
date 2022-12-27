package com.zareckii.winterfountains.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zareckii.winterfountains.ui.theme.AppTheme

@Composable
fun ButtonWithText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    colorBackground: Color = AppTheme.colors.primaryAccentColor,
    colorText: Color = AppTheme.colors.primaryTextInvertColor,
    colorEnabledText: Color = AppTheme.colors.secondaryTextColor,
    disabledBackgroundColor: Color = AppTheme.colors.disableBackground,
    disableContentBtnColor: Color = AppTheme.colors.disableContentBtnColor,
    text: String,
    fontWeight: FontWeight = FontWeight.W400
) {
    Button(
        modifier = modifier.fillMaxWidth().height(50.dp),
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorBackground,
            contentColor = Color.White,
            disabledBackgroundColor = disabledBackgroundColor,
            disabledContentColor = disableContentBtnColor
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        enabled = enabled,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = text,
            fontWeight = fontWeight,
            fontSize = 14.sp,
            letterSpacing = 0.1.sp,
            color = if(enabled) colorText else colorEnabledText
        )
    }
}
