package com.example.calculator.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.R

@Composable
fun InputButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    textColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        if (stringResource(text) == "0") {
            Text(
                text = stringResource(text),
                color = textColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
        } else {
            Text(
                text = stringResource(text),
                color = textColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputButtonPreviewNumber() {
    InputButton(
        text = R.string.one,
        onClick = { },
        textColor = Color.White,
        backgroundColor = Color.DarkGray
    )
}

@Preview(showBackground = true)
@Composable
fun InputButtonPreviewZero() {
    InputButton(
        text = R.string.zero,
        onClick = { },
        textColor = Color.White,
        backgroundColor = Color.DarkGray
    )
}

@Preview(showBackground = true)
@Composable
fun InputButtonPreviewSpecial() {
    InputButton(
        text = R.string.ac,
        onClick = { },
        textColor = Color.Black,
        backgroundColor = Color.LightGray
    )
}