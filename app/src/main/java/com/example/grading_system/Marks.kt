package com.example.grading_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.EditText

class Marks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

        val nextButton = findViewById<ImageView>(R.id.next)
        val mark1EditText = findViewById<EditText>(R.id.mark1)
        val mark2EditText = findViewById<EditText>(R.id.mark2)
        val mark3EditText = findViewById<EditText>(R.id.mark3)

        nextButton.setOnClickListener {
            // Get marks entered by the user for each subject
            val mark1 = mark1EditText.text.toString().toInt()
            val mark2 = mark2EditText.text.toString().toInt()
            val mark3 = mark3EditText.text.toString().toInt()

            // Redirect to the Grade activity and pass the marks as extras
            val intent = Intent(this@Marks, Grade::class.java)
            intent.putExtra("MARK1", mark1)
            intent.putExtra("MARK2", mark2)
            intent.putExtra("MARK3", mark3)
            startActivity(intent)
        }
    }
}
