package com.example.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var salary: EditText

    lateinit var needs: EditText
    lateinit var wants: EditText
    lateinit var savings: EditText

    lateinit var buttonCompute: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
        setupToolbar()

        salary = findViewById(R.id.editTextSalary)
        needs = findViewById(R.id.editTextNeeds)
        wants = findViewById(R.id.editTextWants)
        savings = findViewById(R.id.editTextSavings)

        buttonCompute = findViewById(R.id.buttonCompute)

        buttonCompute.setOnClickListener(View.OnClickListener {
            compute()
        })
    }

    private fun setupToolbar() {
        toolbar.title = "Salary Divider"
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun compute() {
        val map: Map<String, Double>

        val total: Double

        val needsComputed: Double
        val wantsComputed: Double
        val savingsComputed: Double

        val salary: Double = editTextSalary.text.toString().toDouble()
        val needs: Double = editTextNeeds.text.toString().toDouble() / 100
        val wants: Double = editTextWants.text.toString().toDouble() / 100
        val savings: Double = editTextSavings.text.toString().toDouble() / 100

        total = needs + wants + savings

        if (total == 1.toDouble()) {
            needsComputed = salary * needs
            wantsComputed = salary * wants
            savingsComputed = salary * savings

            editTextNeeds.setText(needsComputed.toString())
            editTextWants.setText(wantsComputed.toString())
            editTextSavings.setText(savingsComputed.toString())

        } else {
            Toast.makeText(baseContext, "Invalid percentage total", LENGTH_SHORT).show()
        }

    }
}