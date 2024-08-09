package com.example.calculator_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {

    private lateinit var display : TextView
    private var currentInput : String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val buttonsId = listOf(
            R.id.btnOne, R.id.btnTwo, R.id.btnThree,
            R.id.btnFour, R.id.btnFive, R.id.btnSix,
            R.id.btnSeven, R.id.btnEight, R.id.btnNine,
            R.id.btnZero
        )
        for (id in buttonsId) {
            findViewById<Button>(id).setOnClickListener {
                button -> val buttonText = (button as Button).text.toString()
                currentInput += buttonText
                display.text = currentInput
            }
        }

        val operatorButtonsId = listOf(
            R.id.btnPlus, R.id.btnDivide,
            R.id.btnSubtract, R.id.btnMultiple
        )
        for (id in operatorButtonsId) {
            findViewById<Button>(id).setOnClickListener { button ->
                val buttonText = (button as Button).text.toString()
                currentInput += buttonText
                display.text = currentInput
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            display.text = currentInput
        }
        findViewById<Button>(R.id.btnDecimalDot).setOnClickListener {
            currentInput += "."
            display.text = currentInput
        }
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            calculateResults()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateResults() {

        try {
            val result = evaluate(currentInput)
            display.text = result.toString()
            currentInput = result.toString()

        }catch(e : Exception){
            display.text = "Error"
            currentInput = ""
        }
    }

    private fun evaluate(expr: String): Double {
        return ExpressionBuilder(expr).build().evaluate()
    }
}






















