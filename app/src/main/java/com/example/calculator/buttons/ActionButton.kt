package com.example.calculator.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ActionButton(value: String,
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
        Text(
            text = value,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    ActionButton(value = "+",
        onClick = {  },
        textColor = Color.White,
        backgroundColor = Color(0xFFFFA500)
    )
}