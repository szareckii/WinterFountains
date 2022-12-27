package com.zareckii.winterfountains.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zareckii.winterfountains.ui.theme.AppTheme

@Composable
fun WTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    placeholder: String,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    enabled: Boolean = true,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions(onDone = {}),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    corner: Dp = 4.dp,
    isError: Boolean = false,
    errorMessage: String = "",
    readOnly: Boolean = false,
) {
    Column {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp),
            value = value,
            textStyle = TextStyle(fontSize = 16.sp),
            placeholder = { Text(text = placeholder) },
            label = { Text(text = label) },
            shape = RoundedCornerShape(corner),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = AppTheme.colors.primaryBackground,
                textColor = AppTheme.colors.primaryTextColor,
                disabledTextColor = AppTheme.colors.primaryTextColor,
                focusedBorderColor = AppTheme.colors.primaryAccentColor,
                unfocusedBorderColor = AppTheme.colors.primaryTextColor,
                errorBorderColor = AppTheme.colors.warningColor,
                focusedLabelColor = AppTheme.colors.primaryAccentColor,
                unfocusedLabelColor = AppTheme.colors.primaryTextColor,
                errorLabelColor = AppTheme.colors.warningColor,
                cursorColor = AppTheme.colors.primaryAccentColor,
            ),
            onValueChange = onValueChange,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            enabled = enabled,
            isError = isError,
            readOnly = readOnly
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = AppTheme.colors.warningColor,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
