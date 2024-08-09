package com.example.calculator_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var display : TextView
    private var currentInput : String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val buttonsId = listOf(
            R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnDivide
        )


    }
}






















