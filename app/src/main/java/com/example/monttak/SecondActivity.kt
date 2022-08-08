package com.example.monttak


import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second2.*
import kotlinx.android.synthetic.main.map.*
import net.daum.mf.map.api.MapView


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
//        getAppKeyHash()

        var intent = intent
        val titleBar = intent.getStringExtra("title")
        val address = intent.getStringExtra("address")
        val roadaddress = intent.getStringExtra("roadaddress")
        val introduction = intent.getStringExtra("introduction")
        val phoneno = intent.getStringExtra("phoneno")

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
        secondcontent.removeAllViews()

        secondbar.text = titleBar
        if(address != "null"){
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "주소)          \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "${address}\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)

        }else{
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "주소)          \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "정보 없음\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }
        if(roadaddress != "null"){
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "도로명주소)   \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "${roadaddress}\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }else{
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "도로명주소)   \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "정보 없음\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }
        if(introduction != "null"){
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "정보)          \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "${introduction}\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }else{
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "정보)         \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "정보 없음\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }
        if(phoneno != "null"){
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "전화번호)     \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "${phoneno}\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }else{
            var myLinear = LinearLayout(this)
            myLinear.orientation = LinearLayout.HORIZONTAL
            myLinear.layoutParams = params
            var myextitle = LinearLayout(this)
            myextitle.orientation = LinearLayout.VERTICAL
            myextitle.layoutParams = params
            var myexcontent = LinearLayout(this)
            myexcontent.orientation = LinearLayout.VERTICAL
            myexcontent.layoutParams = params

            var extitle = TextView(this)
            extitle.text = "전화번호)     \n"
            extitle.layoutParams = params
            extitle.setTextColor(Color.BLACK)
            extitle.setTypeface(typeFace)

            var excontent = TextView(this)
            excontent.text = "정보 없음\n"
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 15f
            excontent.textSize = 15f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }



        whiteback.setOnClickListener {
            finish()
        }
        secondnotice.setOnClickListener {
            var dialogView = View.inflate(this@SecondActivity, R.layout.dlgnotice, null)
            var dlg = AlertDialog.Builder(this@SecondActivity)
            dlg.setView(dialogView)
            dlg.show()
        }
//        val mapView = MapView(this)
//        secondcontent.addView(mapView)
    }

    //    fun getAppKeyHash() {
//        try {
//            val info =
//                packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
//            for (signature in info.signatures) {
//                var md: MessageDigest
//                md = MessageDigest.getInstance("SHA")
//                md.update(signature.toByteArray())
//                val something = String(Base64.encode(md.digest(), 0))
//                Log.e("Hash key", something)
//            }
//        } catch (e: Exception) {
//
//            Log.e("name not found", e.toString())
//        }
//    }
}