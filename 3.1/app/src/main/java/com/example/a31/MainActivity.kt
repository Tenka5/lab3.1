package com.example.a31

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val N1 : EditText = findViewById(R.id.N1)
        val N2 : EditText = findViewById(R.id.N2)
        val b :Button = findViewById(R.id.b)

        b.setOnClickListener{
            val intent = Intent(this, secondScreen::class.java)
                var N1I = N1.getText().toString().toInt()
                var N2I = N2.getText().toString().toInt()
                if (N1I>N2I)
                    N1I = N2I.also { N2I = N1I }
                intent.putExtra("fNum", N1I)
                intent.putExtra("sNum", N2I)
                startActivity(intent)
        }
    }


}

