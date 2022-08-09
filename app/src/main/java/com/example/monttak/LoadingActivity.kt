package com.example.monttak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monttakpause)
        startLoading()
    }
    fun startLoading(){
        val handler = Handler()
        handler.postDelayed({ finish() }, 1500)
    }
}