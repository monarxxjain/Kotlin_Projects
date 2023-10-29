package com.example.mjapp2diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.Roll)
        rollButton.setOnClickListener{

            val resultText: TextView = findViewById(R.id.textView2)
            val resultImage :ImageView= findViewById(R.id.imageView)
            val dice= Dice(6)
            val rolledValue = dice.roll()
            resultText.text=rolledValue.toString()
            val toast = Toast.makeText(this,"Dice Rolled !",Toast.LENGTH_SHORT)
            toast.show()
            when(rolledValue){
                1-> resultImage.setImageResource(R.drawable.dice_1)
                2-> resultImage.setImageResource(R.drawable.dice_2)
                3-> resultImage.setImageResource(R.drawable.dice_3)
                4-> resultImage.setImageResource(R.drawable.dice_4)
                5-> resultImage.setImageResource(R.drawable.dice_5)
                6-> resultImage.setImageResource(R.drawable.dice_6)
            }
        }
    }
}


class Dice(val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}