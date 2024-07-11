package com.example.calculator.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.R

@Composable
fun ActionButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isHighlighted by remember { mutableStateOf(false) }
    val backgroundColor = if (isHighlighted) Color.White else Color(0xFFFFA500)
    val textColor = if (isHighlighted) Color(0xFFFFA500) else Color.White

    Button(
        onClick = {
            isHighlighted = !isHighlighted
            onClick()
        },
        modifier = modifier,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = stringResource(text),
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    ActionButton(text = R.string.plus,
        onClick = { }
    )
}