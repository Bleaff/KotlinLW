package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText = findViewById<EditText>(R.id.UInput)
        inputText.setText("Lorem ipsum dolor sit amet consectetur adipiscing elit Pellentesque vestibulum leo et turpis egestas id facilisis ante aliquam Nunc et mollis enim Duis mattis ut nisl at volutpat")
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
        val inputText = findViewById<EditText>(R.id.UInput)
        val set_of_words = inputText.text.toString()

        multe.text = ""

        if(set_of_words.isNotEmpty()){
            val row_processed_values = set_of_words.split(" ").toMutableList()

            Log.d("ButtonCheck", set_of_words)

            processWords(row_processed_values)
            inputText.text!!.clear()
        }
    }
}