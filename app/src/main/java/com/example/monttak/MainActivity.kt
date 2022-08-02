package com.example.monttak

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dlgmuk.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, LoadingActivity::class.java)
        startActivity(intent)
        mainmuk.setOnClickListener {
//            val listText = Button(this@MainActivity)
//            listText.setText("id")
//            mukName.addView(listText)
            var dialogView = View.inflate(this@MainActivity, R.layout.dlgmuk, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("제목")
            dlg.setView(dialogView)
            val thread = NetworkThread()
            thread.start()
            thread.join()
            dlg.setPositiveButton("확인") { dialog, which ->

            }
            dlg.show()
        }
    }
    inner class NetworkThread : Thread(){
        override fun run() {
            var dialogView = View.inflate(this@MainActivity, R.layout.dlgmuk, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("제목")
            dlg.setView(dialogView)

            val pageNo = 1
            val key = "rrq71a2rotyj9tqm"
            val site = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=&${key}&locale=kr&page="+pageNo.toString()

            val url = URL(site)
            val conn = url.openConnection()
            val input = conn.getInputStream()
            val isr = InputStreamReader(input)
            val br = BufferedReader(isr)

            var str: String? = null
            val buf = StringBuffer()

            do{
                str = br.readLine()

                if(str!=null){
                    buf.append(str)
                }
            }while (str!=null)

            val root = JSONObject(buf.toString())
            val item = root.getJSONArray("items")
            runOnUiThread{
                textbar2.append("\n")
                for(i in 0 until item.length()){
                    val jObject = item.getJSONObject(i)
//                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"title")}\n")
                    val jContentscd = jObject.getJSONObject("contentscd")
//                    val jLabel = jContentscd.getJSONObject("label")
//                    textbar2.append("${JSON_Parse(jContentscd ,"label")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
                    val jLabel = JSON_Parse(jContentscd ,"label")
//                    if( jLabel == "음식점"){
//                        textbar2.append("${JSON_Parse(jObject, "title")}\n")
//                        val listText = Button(this@MainActivity)
//                        listText.setText("${JSON_Parse(jObject, "title")}")
//                        var lLayout = findViewById<LinearLayout>(R.id.mukName)
//                        lLayout.addView(listText)
//                    }

                }
            }
        }
        fun JSON_Parse(obj:JSONObject, data : String): String {
            // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다."로 리턴받는다.
            return try {
                obj.getString(data)
            } catch (e: Exception) {
                "없습니다."
            }
        }
    }
}