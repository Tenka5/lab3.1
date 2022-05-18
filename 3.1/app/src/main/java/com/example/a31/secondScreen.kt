package com.example.a31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class secondScreen : AppCompatActivity() {

    var fNum: Int = 0
    var sNum: Int = 0
    var num: Int = 0
    var s: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guessing)


        fNum = intent.getIntExtra("fNum", fNum)
        sNum = intent.getIntExtra("sNum", sNum)
        val b1: Button = findViewById(R.id.b1)
        val b2: Button = findViewById(R.id.b2)
        val question : TextView = findViewById(R.id.question)


        num = (fNum+sNum+1)/2
        s= getString(R.string.question).replace("\$num", "$num")
        question.setText(s)


        b1.setOnClickListener(){
            if(calc(true)){
                b1.isEnabled = false
                b2.isEnabled = false
            }
        }
        b2.setOnClickListener(){
            if(calc(false)){
                b1.isEnabled = false
                b2.isEnabled = false
            }
        }


    }

    private fun calc(gt: Boolean):Boolean
    {
        val question : TextView = findViewById(R.id.question)
        var num: Int = (fNum+sNum+1)/2


        if (gt) fNum = num else sNum = num - 1


        if (fNum==sNum){
            question.setText(getString(R.string.answer).replace("\$num", "$sNum"))
            return true
        }


        num = (fNum+sNum+1)/2
        question.setText(getString(R.string.question).replace("\$num", "$num"))
        return false
    }
}