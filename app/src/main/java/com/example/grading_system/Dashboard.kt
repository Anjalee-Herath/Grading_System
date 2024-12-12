package com.example.grading_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun onCardClicked(view: View) {
        when (view.id) {
            R.id.cardHome -> {
                startActivity(Intent(this, Home::class.java))
            }
            R.id.cardSubjects -> {
                startActivity(Intent(this, Subjects::class.java))
            }
            R.id.cardMarks -> {
                startActivity(Intent(this, Marks::class.java))
            }
            R.id.cardGrade -> {
                startActivity(Intent(this, Grade::class.java))
            }
        }
    }
}