package com.example.mjapp3tiptimecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mjapp3tiptimecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }
    fun calculateTip(){
        val stringInTextField= binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedTip = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedTip){
            R.id.option_20->0.20
            R.id.option_15->0.15
            else->0.10
        }
        var tipAmount = cost*tipPercentage
        val isChecked = binding.roundUpSwitch.isChecked
        if(isChecked){
            tipAmount=kotlin.math.ceil(tipAmount)
        }
        binding.finalAmount.text="Tip Amount : ${tipAmount.toString()}"

    }
}