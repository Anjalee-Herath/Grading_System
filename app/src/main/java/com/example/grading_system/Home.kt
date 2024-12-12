package com.example.grading_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sub1 = findViewById<TextView>(R.id.sub1)
        val mark1 = findViewById<TextView>(R.id.mark1)
        val grade1 = findViewById<TextView>(R.id.grade1)

        val sub2 = findViewById<TextView>(R.id.sub2)
        val mark2 = findViewById<TextView>(R.id.mark2)
        val grade2 = findViewById<TextView>(R.id.grade2)

        val sub3 = findViewById<TextView>(R.id.sub3)
        val mark3 = findViewById<TextView>(R.id.mark3)
        val grade3 = findViewById<TextView>(R.id.grade3)

        val total_mark = findViewById<TextView>(R.id.total_mark)
        val avg_mark = findViewById<TextView>(R.id.avg_mark)

        val button = findViewById<Button>(R.id.button)

        val intent = intent
        val mark1Val = intent.getIntExtra("MARK1", 0)
        val mark2Val = intent.getIntExtra("MARK2", 0)
        val mark3Val = intent.getIntExtra("MARK3", 0)
        val grade1Val = intent.getStringExtra("GRADE1") ?: ""
        val grade2Val = intent.getStringExtra("GRADE2") ?: ""
        val grade3Val = intent.getStringExtra("GRADE3") ?: ""

        sub1.text = "Mobile Application"
        mark1.text = mark1Val.toString()
        grade1.text = grade1Val

        sub2.text = "Advanced Programming"
        mark2.text = mark2Val.toString()
        grade2.text = grade2Val

        sub3.text = "Intelligent System"
        mark3.text = mark3Val.toString()
        grade3.text = grade3Val

        val totalMarks = mark1Val + mark2Val + mark3Val
        val averageMarks = totalMarks / 3

        total_mark.text = totalMarks.toString()
        avg_mark.text = averageMarks.toString()

        button.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }
    }
}
