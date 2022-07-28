package com.sys.jeju

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = ""

        button.setOnClickListener {
            val thread = NetworkThread()
            thread.start()
            thread.join()
        }
    }
    inner class NetworkThread : Thread(){
        override fun run() {
            val pageNo = 1
	val key = ""
            val site = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=&{key}&locale=kr&page="+pageNo.toString()

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
                for(i in 0 until item.length()){
                    val jObject = item.getJSONObject(i)
                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"address")}\n")
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