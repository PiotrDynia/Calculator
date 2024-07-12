package com.example.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.buttons.ButtonsContent

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var input by remember {
        mutableStateOf("0")
    }
    Column {
        Spacer(modifier = modifier.size(104.dp))
        Text(
            text = input,
            fontSize = 80.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.End)
            )
        ButtonsContent() 
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Calculator()
}