package com.example.calculator.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R

@Composable
fun InputButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    textColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    val isZero = stringResource(text) == "0"
    val buttonModifier = if (isZero) {
        modifier.size(width = 152.dp, height = 72.dp)
    } else {
        modifier.size(72.dp)
    }

    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = buttonModifier,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = stringResource(text),
            color = textColor,
            fontSize = 38.sp,
            modifier = Modifier
                .wrapContentWidth(if (isZero) Alignment.Start else Alignment.CenterHorizontally),
            maxLines = 1
        )
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