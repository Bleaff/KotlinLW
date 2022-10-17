package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    @SuppressLint("SetTextI18n")
    private fun processWords(list: MutableList<String>){
        val multe = findViewById<TextView>(R.id.textView)
        val sortedList:MutableList<String> = list.sortedWith(compareBy { it.length }).toMutableList()
        Log.d("AlgoCheck", sortedList.toString())
        if(sortedList.size == 0){
            return
        }
        for (i in 0..4)
        {
            if(sortedList.size != 0){
                multe.text = multe.text.toString() + " " + sortedList.last().toString()
                sortedList.removeLast()
            }
            Log.d("AlgoCheck", multe.text.toString())
        }
    }

    fun onClickMagic(view:View){
        val multe = findViewById<TextView>(R.id.textView)
        val inputText = findViewById<TextInputLayout>(R.id.UInput)
        val set_of_words = inputText.editText?.text.toString()

        multe.text = ""

        if(set_of_words.length != 0){
            val row_processed_values = set_of_words.split(" ").toMutableList()

            Log.d("ButtonCheck", set_of_words)

            processWords(row_processed_values)
            inputText.editText?.text!!.clear()
        }
    }
}