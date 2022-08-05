package com.example.monttak

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.net.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.notice
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


class MainActivity : Activity() {
    lateinit var item : JSONArray

    private lateinit var cm2: ConnectivityManager

    private val networkCallBack = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            // 네트워크가 연결될 때 호출됩니다.
            Toast.makeText(this@MainActivity, "연결성공", Toast.LENGTH_SHORT).show()
        }

        override fun onLost(network: Network) {
            // 네트워크가 끊길 때 호출됩니다.
            Toast.makeText(this@MainActivity, "연결실패", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, LoadingActivity::class.java)
        startActivity(intent)
        val cm: ConnectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        cm2 = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val builder = NetworkRequest.Builder()
        cm2.registerNetworkCallback(builder.build(), networkCallBack)

        // NetworkInfo부분
        if (isConnectInternet() != "null") {
            var nThread = NetworkThread()
            nThread.start()
            nThread.join()
        } else {

        }
        //먹거리 버튼 구현
        mainmuk.setOnClickListener {
            if (isConnectInternet() == "null") {
                Toast.makeText(this@MainActivity, "인터넷 연결 끊김", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (item==null){
                var nThread = NetworkThread()
                nThread.start()
                nThread.join()
            }
            val thread = MukThread()
            thread.start()
            thread.join()
            returnMain.visibility = View.VISIBLE
        }

        //놀멍 버튼 구현
        mainnol.setOnClickListener {
            if (isConnectInternet() == "null") {
                Toast.makeText(this@MainActivity, "인터넷 연결 끊김", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (item==null){
                var nThread = NetworkThread()
                nThread.start()
                nThread.join()
            }
            val thread = NolThread()
            thread.start()
            thread.join()
            returnMain.visibility = View.VISIBLE
        }

        //볼거리 버튼 구현
        mainbol.setOnClickListener {
            if (isConnectInternet() == "null") {
                Toast.makeText(this@MainActivity, "인터넷 연결 끊김", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (item==null){
                var nThread = NetworkThread()
                nThread.start()
                nThread.join()
            }
            val thread = BolThread()
            thread.start()
            thread.join()
            returnMain.visibility = View.VISIBLE
        }
        //쉴멍 버튼 구현
        mainshuil.setOnClickListener {
            if (isConnectInternet() == "null") {
                Toast.makeText(this@MainActivity, "인터넷 연결 끊김", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (item==null){
                var nThread = NetworkThread()
                nThread.start()
                nThread.join()
            }
            val thread = ShuilThread()
            thread.start()
            thread.join()
            returnMain.visibility = View.VISIBLE
        }

        //공지사항 구현
        notice.setOnClickListener {
            var dialogView = View.inflate(this@MainActivity, R.layout.dlgnotice, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setView(dialogView)
            dlg.show()
        }

        returnMain.setOnClickListener {
            textbar1.text = "[몬딱, 제주]"
            content.removeAllViews()
            val appExplain = TextView(this@MainActivity)
            appExplain.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            appExplain.textSize = 20f
            appExplain.text =
                "- '몬딱, 제주'는 '모두 함께, 제주'라는 뜻의 제주 방언입니다. 육지에 사는 당신이 아름다운 섬 제주도를 만끽할 수 있도록 여러가지 정보를 제공합니다.\n\n - 아래의 각 버튼을 클릭하면 정보가 나옵니다. 먹거리, 놀거리, 볼거리와 쉴 곳이 가득한 제주에서 당신의 인생에 쉼표를 찍어보세요.\n\n- 먹거리에는 식당과 카페, 놀멍에는 테마여행과 쇼핑, 볼거리에는 축제 및 행사 정보, 쉴멍에는 숙박업소 정보가 있습니다.\n\n- 이 앱의 정보는 제주관광공사의 오픈API를 받아서 제작했습니다."
            val typeFace = Typeface.createFromAsset(assets, "mokwoosoosimgyul.ttf")
            appExplain.setTypeface(typeFace)
            appExplain.setTextColor(Color.BLACK)
            content.addView(appExplain)
            returnMain.visibility = View.INVISIBLE
        }
    }

    override fun onDestroy() { // 콜백 해제
        super.onDestroy()
        cm2 = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm2.unregisterNetworkCallback(networkCallBack)
    }

    private fun isConnectInternet(): String { // 인터넷 연결 체크 함수
        val cm: ConnectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = cm.activeNetworkInfo
        return networkInfo.toString()
    }

    //api 연동
    fun JsonArray(): JSONArray {
        val pageNo = 1
        val key = ""
        val site =
            "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=&${key}&locale=kr&page=" + pageNo.toString()

        val url = URL(site)
        val conn = url.openConnection()
        val input = conn.getInputStream()
        val isr = InputStreamReader(input)
        val br = BufferedReader(isr)

        var str: String? = null
        val buf = StringBuffer()

        do {
            str = br.readLine()

            if (str != null) {
                buf.append(str)
            }
        } while (str != null)

        val root = JSONObject(buf.toString())
        val item = root.getJSONArray("items")
        return item
    }

    fun JSON_Parse(obj: JSONObject, data: String): String {
        // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다."로 리턴받는다.
        return try {
            obj.getString(data)
        } catch (e: Exception) {
            "없습니다."
        }
    }
    inner class NetworkThread: Thread(){
        override fun run() {
            item = JsonArray()
        }
    }
    //먹거리 나열
    inner class MukThread : Thread() {
        override fun run() {
            if (item == null) {
                return
            }
            runOnUiThread {
                content.removeAllViews()
                for (i in 0 until item.length()) {
                    val jObject = item.getJSONObject(i)
//                    textView.append("${i+1}. 주소: ${ JSON_Parse(jObject,"title")}\n")
                    val jContentscd = jObject.getJSONObject("contentscd")
//                    val jLabel = jContentscd.getJSONObject("label")
//                    textbar2.append("${JSON_Parse(jContentscd ,"label")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
//                    textbar2.append("${JSON_Parse(jObject, "title")}\n")
                    val jLabel = JSON_Parse(jContentscd, "label")
                    if (jLabel == "음식점") {
                        textbar1.setText("[먹거리]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        listButton.setOnClickListener {
                            var intent = Intent(applicationContext, SecondActivity::class.java)
                            intent.putExtra("title","${JSON_Parse(jObject, "title")}")
                            startActivity(intent)
                        }
                        content.addView(listButton)
                    }

                }
            }
        }
    }

    //놀멍 나열
    inner class NolThread : Thread() {
        override fun run() {
            if (item == null) {
                return
            }
            runOnUiThread {
                content.removeAllViews()
                for (i in 0 until item.length()) {
                    val jObject = item.getJSONObject(i)
                    val jContentscd = jObject.getJSONObject("contentscd")
                    val jLabel = JSON_Parse(jContentscd, "label")
                    if (jLabel == "테마여행" || jLabel == "쇼핑") {
                        textbar1.setText("[놀멍]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        listButton.setOnClickListener {
                            var intent = Intent(applicationContext, SecondActivity::class.java)
                            intent.putExtra("title","${JSON_Parse(jObject, "title")}")
                            startActivity(intent)
                        }
                        content.addView(listButton)

                    }

                }
            }
        }

    }

    //볼거리 나열
    inner class BolThread : Thread() {
        override fun run() {
            if (item == null) {
                return
            }
            runOnUiThread {
                content.removeAllViews()
                for (i in 0 until item.length()) {
                    val jObject = item.getJSONObject(i)
                    val jContentscd = jObject.getJSONObject("contentscd")
                    val jLabel = JSON_Parse(jContentscd, "label")
                    if (jLabel == "정보" || jLabel == "축제/행사") {
                        textbar1.setText("[볼거리]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        listButton.setOnClickListener {
                            var intent = Intent(applicationContext, SecondActivity::class.java)
                            intent.putExtra("title","${JSON_Parse(jObject, "title")}")
                            startActivity(intent)
                        }
                        content.addView(listButton)

                    }

                }
            }
        }
    }

    //쉴멍 구현
    inner class ShuilThread : Thread() {
        override fun run() {
            if (item == null) {
                return
            }
            runOnUiThread {
                content.removeAllViews()
                for (i in 0 until item.length()) {
                    val jObject = item.getJSONObject(i)
                    val jContentscd = jObject.getJSONObject("contentscd")
                    val jLabel = JSON_Parse(jContentscd, "label")
                    if (jLabel == "숙박") {
                        textbar1.setText("[쉴멍]")
                        val listButton = Button(this@MainActivity)
                        listButton.setText("${JSON_Parse(jObject, "title")}")
                        listButton.layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        listButton.setBackgroundResource(R.drawable.textbar)
                        listButton.textSize = 20f
                        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
                        listButton.setTypeface(typeFace)
                        listButton.setTextColor(Color.BLACK)
                        listButton.setOnClickListener {
                            var intent = Intent(applicationContext, SecondActivity::class.java)
                            intent.putExtra("title","${JSON_Parse(jObject, "title")}")
                            startActivity(intent)
                        }
                        content.addView(listButton)
                    }

                }
            }
        }
    }
}