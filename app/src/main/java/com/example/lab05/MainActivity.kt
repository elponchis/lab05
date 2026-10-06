package com.example.lab05

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    private val opt = FourBasicOpt()

    private lateinit var editFirst: EditText
    private lateinit var editSecond: EditText
    private lateinit var textOperator: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editFirst = findViewById(R.id.editFirst)
        editSecond = findViewById(R.id.editSecond)
        textOperator = findViewById(R.id.textOperator)
        textResult = findViewById(R.id.textResult)

        findViewById<Button>(R.id.btnAdd).setOnClickListener { calculate("+", opt::add) }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { calculate("-", opt::subtract) }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { calculate("×", opt::multiply) }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { calculate("÷", opt::divide) }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clear() }
    }

    private fun calculate(symbol: String, operation: (Double, Double) -> Double) {
        val firstText = editFirst.text.toString().trim()
        val secondText = editSecond.text.toString().trim()

        if (firstText.isEmpty() || secondText.isEmpty()) {
            Toast.makeText(this, R.string.msg_empty_input, Toast.LENGTH_SHORT).show()
            return
        }

        // inputType 이 "-" 나 "." 단독 입력은 막지 못한다
        val x = firstText.toDoubleOrNull()
        val y = secondText.toDoubleOrNull()
        if (x == null || y == null) {
            Toast.makeText(this, R.string.msg_invalid_input, Toast.LENGTH_SHORT).show()
            return
        }

        textOperator.text = symbol
        textResult.text = getString(R.string.result_format, format(operation(x, y)))
    }

    private fun format(value: Double): String =
        if (!value.isFinite()) value.toString()
        else BigDecimal(value).setScale(10, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString()

    private fun clear() {
        editFirst.text.clear()
        editSecond.text.clear()
        textOperator.setText(R.string.op_none)
        textResult.setText(R.string.result_placeholder)
        editFirst.requestFocus()
    }
}
