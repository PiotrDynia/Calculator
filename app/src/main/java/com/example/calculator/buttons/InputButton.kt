package com.example.calculator.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputButton(
    value: String,
    onClick: () -> Unit,
    textColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        if (value == "0") {
            Text(
                text = value,
                color = textColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
        } else {
            Text(
                text = value,
                color = textColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputButtonPreviewNumber() {
    InputButton(
        value = "1",
        onClick = { },
        textColor = Color.White,
        backgroundColor = Color.DarkGray
    )
}

@Preview(showBackground = true)
@Composable
fun InputButtonPreviewZero() {
    InputButton(
        value = "0",
        onClick = { },
        textColor = Color.White,
        backgroundColor = Color.DarkGray
    )
}

@Preview(showBackground = true)
@Composable
fun InputButtonPreviewSpecial() {
    InputButton(
        value = "AC",
        onClick = { },
        textColor = Color.Black,
        backgroundColor = Color.LightGray
    )
}