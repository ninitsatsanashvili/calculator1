package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.text.trimmedLength

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }


    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {

            var result: String = resultTextView.text.toString()
            val number: String = clickedView.text.toString()
            if (result == "0") {
                result = ""
            }
            resultTextView.text = result + number
        }

    }

    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {

            val result: String = resultTextView.text.toString()



            if (result.isNotEmpty()) {
                this.operand = result.toDouble()
            }
            resultTextView.text = ""

            this.operation = clickedView.text.toString()
        }
    }
    fun equalsClick(clickedView: View){

        val result: String = resultTextView.text.toString()
        var secOperand: Double = 0.0
        if (result.isNotEmpty()){
            secOperand = result.toDouble()


        }


        when(operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "CLEAN" -> resultTextView.text =("").toString()
        }

    }

    fun delClick(clickedView: View){
        val lenght = resultTextView.text.trimmedLength()
        if (lenght > 0){
            resultTextView.text = resultTextView.text.subSequence(0, lenght - 1)
        }
        var result = resultTextView.text

        fun result(clickedView: View){

            if (resultTextView.text.endsWith(".0")) {
                result = resultTextView.text.dropLast(2)
                resultTextView.text = result}
    }

    }



}

