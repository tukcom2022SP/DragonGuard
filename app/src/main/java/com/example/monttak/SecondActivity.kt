package com.example.monttak

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        secondnotice.setOnClickListener {
            var dialogView = View.inflate(this@SecondActivity, R.layout.dlgnotice, null)
            var dlg = AlertDialog.Builder(this@SecondActivity)
            dlg.setView(dialogView)
            dlg.show()
        }
    }
}