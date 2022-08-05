package com.example.monttak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second2.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        var intent = intent
        var titleBar = intent.getStringExtra("title")
        secondbar.text = titleBar
        secondcontent.removeAllViews()

        whiteback.setOnClickListener {
            finish()
        }
    }
}