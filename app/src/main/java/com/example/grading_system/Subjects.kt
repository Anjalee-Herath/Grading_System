package com.example.grading_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Subjects : AppCompatActivity() {

    private lateinit var next: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        next = findViewById(R.id.next)
        next.setOnClickListener {
            startActivity(Intent(this, Marks::class.java))
        }
    }
}