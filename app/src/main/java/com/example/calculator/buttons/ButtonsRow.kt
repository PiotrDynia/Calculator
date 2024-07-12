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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.utils.Operation

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
fun GenerateButton(buttonData: ButtonData, isHighlighted: Boolean) {
    if (buttonData.isActionButton) {
        ActionButton(
            text = buttonData.text,
            onClick = buttonData.onClick,
            isHighlighted = isHighlighted
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
    var inputString by remember { mutableStateOf("0") }
    var inputDouble by remember { mutableDoubleStateOf(0.0) }
    var lastInput by remember { mutableDoubleStateOf(0.0) }
    var lastOperation: Operation? by remember { mutableStateOf(null) }
    var isNewInput by remember { mutableStateOf(true) }
    var hasInput by remember {
        mutableStateOf(false)
    }
    var selectedOperation by remember { mutableStateOf<Operation?>(null) }

    val onDigitClick: (String) -> Unit = { digit ->
        hasInput = true
        if (isNewInput) {
            inputString = digit
            isNewInput = false
        } else {
            if (!(inputString == "0" && digit == "0")) {
                if (inputString == "0" && digit != ".") {
                    inputString = digit
                } else {
                    inputString += digit
                }
            }
        }
        selectedOperation = null
    }

    val onOperationClick: (Operation) -> Unit = { operation ->
        if (!isNewInput) {
            lastInput = inputString.toDouble()
            inputDouble = if (lastOperation != null) {
                lastOperation!!.apply(inputDouble, lastInput)
            } else {
                lastInput
            }
            inputString = formatNumber(inputDouble)
            isNewInput = true
        }
        lastOperation = operation
        selectedOperation = operation
    }

    val onEqualsClick = {
        if (lastOperation != null && !isNewInput) {
            if (lastOperation is Operation.Division && inputString == "0") {
                inputString = "Error"
                lastOperation = null
                isNewInput = true
            } else {
                lastInput = inputString.toDouble()
                inputDouble = lastOperation!!.apply(inputDouble, lastInput)
                inputString = formatNumber(inputDouble)
                lastOperation = null
                isNewInput = true
            }
        }
        selectedOperation = null
    }

    val buttonRows = listOf(
        listOf(
            ButtonData(
                text = if (!hasInput) R.string.ac else R.string.clear,
                onClick = {
                    inputString = "0"
                    inputDouble = 0.0
                    lastInput = 0.0
                    lastOperation = null
                    selectedOperation = null
                    hasInput = false
                    isNewInput = false
                },
                textColor = Color.Black,
                backgroundColor = Color.LightGray
            ),
            ButtonData(
                text = R.string.plus_minus,
                onClick = {
                    if (inputString != "0") {
                        inputString = if (inputString.startsWith("-")) {
                            inputString.drop(1)
                        } else {
                            "-$inputString"
                        }
                    }
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
                onClick = { onOperationClick(Operation.Division) },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.seven,
                onClick = { onDigitClick("7") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.eight,
                onClick = { onDigitClick("8") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.nine,
                onClick = { onDigitClick("9") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.multiply,
                onClick = { onOperationClick(Operation.Multiplication) },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.four,
                onClick = { onDigitClick("4") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.five,
                onClick = { onDigitClick("5") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.six,
                onClick = { onDigitClick("6") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.minus,
                onClick = { onOperationClick(Operation.Subtraction) },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.one,
                onClick = { onDigitClick("1") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.two,
                onClick = { onDigitClick("2") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.three,
                onClick = { onDigitClick("3") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(
                text = R.string.plus,
                onClick = { onOperationClick(Operation.Addition) },
                textColor = Color.White,
                backgroundColor = Color.DarkGray,
                isActionButton = true
            )
        ),
        listOf(
            ButtonData(
                text = R.string.zero,
                onClick = { onDigitClick("0") },
                textColor = Color.White,
                backgroundColor = Color.DarkGray
            ),
            ButtonData(text = R.string.dot, onClick = {
                if (!inputString.contains(".")) {
                    inputString += "."
                }
            }, textColor = Color.White, backgroundColor = Color.DarkGray),
            ButtonData(
                text = R.string.equals,
                onClick = { onEqualsClick() },
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
            ButtonRow(buttons = row.map {
                {
                    GenerateButton(
                        it,
                        it.text == selectedOperation?.nameRes
                    )
                }
            })
        }
    }
}

fun formatNumber(number: Double): String {
    return if (number == number.toLong().toDouble()) {
        number.toLong().toString()
    } else {
        number.toString()
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ButtonsContent()
}