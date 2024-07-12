package com.example.calculator.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.R

@Composable
fun ButtonRow(
    buttons: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        buttons.forEach { it() }
    }
}

@Composable
fun GenerateButton(buttonData: ButtonData) {
    if (buttonData.isActionButton) {
        ActionButton(
            text = buttonData.text,
            onClick = buttonData.onClick
        )
    } else {
        InputButton(
            text = buttonData.text,
            onClick = buttonData.onClick,
            textColor = buttonData.textColor,
            backgroundColor = buttonData.backgroundColor
        )
    }
}

@Composable
fun ButtonsContent(modifier: Modifier = Modifier) {
    val buttonRows = listOf(
        listOf(
            ButtonData(R.string.ac, {}, Color.Black, Color.LightGray),
            ButtonData(R.string.plus_minus, {}, Color.Black, Color.LightGray),
            ButtonData(R.string.percentage, {}, Color.Black, Color.LightGray),
            ButtonData(R.string.divide, {}, Color.White, Color.DarkGray, isActionButton = true)
        ),
        listOf(
            ButtonData(R.string.seven, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.eight, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.nine, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.multiply, {}, Color.White, Color.DarkGray, isActionButton = true)
        ),
        listOf(
            ButtonData(R.string.four, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.five, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.six, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.minus, {}, Color.White, Color.DarkGray, isActionButton = true)
        ),
        listOf(
            ButtonData(R.string.one, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.two, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.three, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.plus, {}, Color.White, Color.DarkGray, isActionButton = true)
        ),
        listOf(
            ButtonData(R.string.zero, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.dot, {}, Color.White, Color.DarkGray),
            ButtonData(R.string.equals, {}, Color.White, Color.DarkGray, isActionButton = true)
        )
    )

    Column(modifier) {
        buttonRows.forEach { row ->
            ButtonRow(buttons = row.map { { GenerateButton(it) } })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ButtonsContent()
}