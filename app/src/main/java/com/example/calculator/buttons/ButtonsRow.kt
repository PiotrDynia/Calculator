package com.example.calculator.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var inputString by remember {
        mutableStateOf("0")
    }
    var inputDouble by remember {
        mutableDoubleStateOf(0.0)
    }
    var hasInput by remember {
        mutableStateOf(false)
    }
    var isNegative by remember {
        mutableStateOf(false)
    }
    var isInteger by remember {
        mutableStateOf(true)
    }

    val buttonRows = listOf(
        listOf(
            ButtonData(
                text = if (hasInput) R.string.clear else R.string.ac,
                onClick = {
                    hasInput = false
                    inputString = "0"
                },
                textColor = Color.Black,
                backgroundColor = Color.LightGray
            ),
            ButtonData(
                text = R.string.plus_minus,
                onClick = {
                    inputString = if (isNegative) inputString.drop(1) else "-".plus(inputString)
                    isNegative = !isNegative
                },
                textColor = Color.Black,
                backgroundColor = Color.LightGray
            ),
            ButtonData(
                text = R.string.percentage,
                onClick = {
                    if (inputString != "0") {
                        inputDouble = inputString.toDouble() / 100
                        inputString = inputDouble.toString()
                    }
                },
                textColor = Color.Black,
                backgroundColor = Color.LightGray
            ),
            ButtonData(
                text = R.string.divide,
                onClick = { },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.seven,
                onClick = {
                    inputString = if (inputString == "0") "7" else inputString.plus("7")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.eight,
                onClick = {
                    inputString = if (inputString == "0") "8" else inputString.plus("8")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.nine,
                onClick = {
                    inputString = if (inputString == "0") "9" else inputString.plus("9")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.multiply,
                onClick = { },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.four,
                onClick = {
                    inputString = if (inputString == "0") "4" else inputString.plus("4")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.five,
                onClick = {
                    inputString = if (inputString == "0") "5" else inputString.plus("5")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.six,
                onClick = {
                    inputString = if (inputString == "0") "6" else inputString.plus("6")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.minus,
                onClick = { },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.one,
                onClick = {
                    inputString = if (inputString == "0") "1" else inputString.plus("1")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.two,
                onClick = {
                    inputString = if (inputString == "0") "2" else inputString.plus("2")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.three,
                onClick = {
                    inputString = if (inputString == "0") "3" else inputString.plus("3")
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.plus,
                onClick = { },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.zero,
                onClick = {
                    inputString = if (inputString == "0") inputString else inputString.plus("0")
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.dot,
                onClick = {
                    inputString = if (isInteger) inputString.plus(".") else inputString
                    isInteger = false
                    hasInput = true
                },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.equals,
                onClick = { },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        )
    )

    Column(modifier) {
        Text(
            text = inputString,
            fontSize = 80.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.End)
        )
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