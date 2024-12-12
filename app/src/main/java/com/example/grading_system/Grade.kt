package com.example.grading_system

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Grade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        // Get marks passed from Marks activity
        val mark1 = intent.getIntExtra("MARK1", 0)
        val mark2 = intent.getIntExtra("MARK2", 0)
        val mark3 = intent.getIntExtra("MARK3", 0)

        // Calculate grades
        val grade1 = calculateGrade(mark1)
        val grade2 = calculateGrade(mark2)
        val grade3 = calculateGrade(mark3)

        // Set grades to TextViews with colors
        setGrade(findViewById(R.id.sub1), findViewById(R.id.mark1), findViewById(R.id.grade1), "Mobile Application", mark1, grade1)
        setGrade(findViewById(R.id.sub2), findViewById(R.id.mark2), findViewById(R.id.grade2), "Advanced Programming", mark2, grade2)
        setGrade(findViewById(R.id.sub3), findViewById(R.id.mark3), findViewById(R.id.grade3), "Intelligent System", mark3, grade3)

        // Next icon click listener
        val nextButton = findViewById<ImageView>(R.id.next)
        nextButton.setOnClickListener {
            // Redirect to Home activity and pass marks and grades
            val intent = Intent(this, Home::class.java).apply {
                putExtra("MARK1", mark1)
                putExtra("MARK2", mark2)
                putExtra("MARK3", mark3)
                putExtra("GRADE1", grade1)
                putExtra("GRADE2", grade2)
                putExtra("GRADE3", grade3)
            }
            startActivity(intent)
        }
    }

    // Function to calculate grade based on marks
    private fun calculateGrade(mark: Int): String {
        return when {
            mark >= 75 -> "A"
            mark >= 65 -> "B"
            mark >= 55 -> "C"
            mark >= 40 -> "D"
            else -> "F"
        }
    }

    // Function to set TextViews with grades and colors
    private fun setGrade(subjectView: TextView, markView: TextView, gradeView: TextView, subject: String, mark: Int, grade: String) {
        subjectView.text = subject
        markView.text = mark.toString()
        gradeView.text = grade

        val color = when (grade) {
            "A" -> Color.parseColor("#FF0000") // Red
            "B" -> Color.parseColor("#FFFF00") // Yellow
            "C" -> Color.parseColor("#FFA500") // Orange
            "D" -> Color.parseColor("#00FF00") // Green
            "F" -> Color.parseColor("#000000") // Black
            else -> Color.parseColor("#0000FF") // Blue
        }
        gradeView.setTextColor(color)
    }
}
