package com.example.kotlinhomework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener {
            if (ed_name.length() < 1) {
                tv_text.text = "Please Enter a Username"
                return@setOnClickListener
            }
            val playerName = ed_name.text
            val comMora = (Math.random() * 3).toInt()
            val playerMoraText = when {
                btn_scissor.isChecked -> "Scissors"
                btn_stone.isChecked -> "Rock"
                else -> "Paper"
            }
            val comMoraText = when (comMora) {
                0 -> "Scissors"
                1 -> "Rock"
                else -> "Paper"
            }
            tv_name.text = "Name\n$playerName"
            tv_mmora.text = "Me\n$playerMoraText"
            tv_cmora.text = "Computer\n$comMoraText"
            when {
                btn_scissor.isChecked && comMora == 2 ||
                        btn_stone.isChecked && comMora == 0 ||
                        btn_paper.isChecked && comMora == 1 -> {
                    tv_winner.text = "Winner\n$playerName"
                    tv_text.text = "Congratulations! You Won!"
                }

                btn_scissor.isChecked && comMora == 1 ||
                        btn_stone.isChecked && comMora == 2 ||
                        btn_paper.isChecked && comMora == 0 -> {
                    tv_winner.text = "Winner\nComputer"
                    tv_text.text = "Too Bad, You Lost!"
                }

                else -> {
                    tv_winner.text = "Winner\nTie"
                    tv_text.text = "Tie, Please Try Again!"
                }
            }
        }
    }
}