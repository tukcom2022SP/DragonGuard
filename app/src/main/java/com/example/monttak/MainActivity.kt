package com.example.monttak

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
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
//            var dialogView = View.inflate(this@MainActivity, R.layout.dlgmuk, null)
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("제목")
//            dlg.setView(dialogView)
            val thread = MukThread()
            thread.start()
            thread.join()
//            dlg.setPositiveButton("확인") { dialog, which ->
//
//            }
//            dlg.show()
        }
        mainnol.setOnClickListener {
//            val listText = Button(this@MainActivity)
//            listText.setText("id")
//            mukName.addView(listText)
//            var dialogView = View.inflate(this@MainActivity, R.layout.dlgmuk, null)
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("제목")
//            dlg.setView(dialogView)
            val thread = NolThread()
            thread.start()
            thread.join()
//            dlg.setPositiveButton("확인") { dialog, which ->
//
//            }
//            dlg.show()
        }
        mainbol.setOnClickListener {
//            val listText = Button(this@MainActivity)
//            listText.setText("id")
//            mukName.addView(listText)
//            var dialogView = View.inflate(this@MainActivity, R.layout.dlgmuk, null)
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("제목")
//            dlg.setView(dialogView)
            val thread = BolThread()
            thread.start()
            thread.join()
//            dlg.setPositiveButton("확인") { dialog, which ->
//
//            }
//            dlg.show()
        }
        mainshuil.setOnClickListener {
//            val listText = Button(this@MainActivity)
//            listText.setText("id")
//            mukName.addView(listText)
//            var dialogView = View.inflate(this@MainActivity, R.layout.dlgmuk, null)
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("제목")
//            dlg.setView(dialogView)
            val thread = ShuilThread()
            thread.start()
            thread.join()
//            dlg.setPositiveButton("확인") { dialog, which ->
//
//            }
//            dlg.show()
        }
        notice.setOnClickListener {
            var dialogView = View.inflate(this@MainActivity, R.layout.dlgnotice, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setView(dialogView)
            dlg.show()
        }
    }
    fun JsonArray() : JSONArray{


        val pageNo = 1
        val key = ""
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
        return item
    }
    inner class MukThread : Thread(){
        override fun run() {
            val item = JsonArray()
            runOnUiThread{
                content.removeAllViews()
                for(i in 0 until item.length()){
                    val jObject = item.getJSONObject(i)
//                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"title")}\n")
                    val jContentscd = jObject.getJSONObject("contentscd")
//                    val jLabel = jContentscd.getJSONObject("label")
//                    textbar2.append("${JSON_Parse(jContentscd ,"label")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
                    val jLabel = JSON_Parse(jContentscd ,"label")
                    if( jLabel == "음식점"){
                        textbar1.setText("[먹거리]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        listButton.setOnClickListener {

                        }
                        content.addView(listButton)
                    }

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
    inner class NolThread : Thread(){
        override fun run() {

            val item = JsonArray()
            runOnUiThread{
                content.removeAllViews()
                for(i in 0 until item.length()){
                    val jObject = item.getJSONObject(i)
//                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"title")}\n")
                    val jContentscd = jObject.getJSONObject("contentscd")
//                    val jLabel = jContentscd.getJSONObject("label")
//                    textbar2.append("${JSON_Parse(jContentscd ,"label")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
                    val jLabel = JSON_Parse(jContentscd ,"label")
                    if( jLabel == "테마여행" || jLabel == "쇼핑"){
                        textbar1.setText("[놀멍]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        content.addView(listButton)

                    }

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
    inner class BolThread : Thread(){
        override fun run() {
            val item = JsonArray()
            runOnUiThread{
                content.removeAllViews()
                for(i in 0 until item.length()){
                    val jObject = item.getJSONObject(i)
//                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"title")}\n")
                    val jContentscd = jObject.getJSONObject("contentscd")
//                    val jLabel = jContentscd.getJSONObject("label")
//                    textbar2.append("${JSON_Parse(jContentscd ,"label")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
                    val jLabel = JSON_Parse(jContentscd ,"label")
                    if( jLabel == "정보" || jLabel == "축제/행사"){
                        textbar1.setText("[볼거리]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        content.addView(listButton)

                    }

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
    inner class ShuilThread : Thread(){
        override fun run() {
            val item = JsonArray()
            runOnUiThread{
                content.removeAllViews()
                for(i in 0 until item.length()){
                    val jObject = item.getJSONObject(i)
//                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"title")}\n")
                    val jContentscd = jObject.getJSONObject("contentscd")
//                    val jLabel = jContentscd.getJSONObject("label")
//                    textbar2.append("${JSON_Parse(jContentscd ,"label")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
                    val jLabel = JSON_Parse(jContentscd ,"label")
                    if( jLabel == "숙박"){
                        textbar1.setText("[쉴멍]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        content.addView(listButton)

                    }

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