package com.example.monttak


import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.net.URL


class SecondActivity : AppCompatActivity() {
    lateinit var mapView: MapView
    lateinit var titleBar : String
    lateinit var address: String
    lateinit var roadaddress: String
    lateinit var introduction: String
    lateinit var phoneno: String
    lateinit var thumbnail: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
//        getAppKeyHash()

        var intent = intent
        titleBar = intent.getStringExtra("title")!!
        address = intent.getStringExtra("address")!!
        roadaddress = intent.getStringExtra("roadaddress")!!
        introduction = intent.getStringExtra("introduction")!!
        phoneno = intent.getStringExtra("phoneno")!!
        thumbnail = intent.getStringExtra("thumbnailpath")!!
        var latitude = intent.getDoubleExtra("latitude",0.0)
        var longitude = intent.getDoubleExtra("longitude",0.0)

        secondcontent.removeAllViews()

        secondbar.text = titleBar
        arrangeView("주소")
        arrangeView("도로명주소")
        arrangeView("정보")
        arrangeView("전화번호")

        val corutin = CoroutineScope(Dispatchers.Main)
        corutin.launch {
            val originalDeferred = corutin.async(Dispatchers.IO) {
                getOriginalBitmap()
            }
            val originalBitmap = originalDeferred.await()
            loadImage(originalBitmap)
        }

        mapView(longitude,latitude)

        whiteback.setOnClickListener {
            secondcontent.removeAllViews()
            finish()
        }
        secondnotice.setOnClickListener {
            var dialogView = View.inflate(this@SecondActivity, R.layout.dlgnotice, null)
            var dlg = AlertDialog.Builder(this@SecondActivity)
            dlg.setView(dialogView)
            dlg.show()
        }
    }

    fun mapView(longitude:Double, latitude:Double){

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        var myLinear = LinearLayout(this@SecondActivity)
        myLinear.orientation = LinearLayout.VERTICAL
        myLinear.layoutParams = params

        if(latitude != 0.0){
            mapView = MapView(this@SecondActivity)
            mapView.layoutParams = params
            val mapPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude)
            mapView.setMapCenterPoint(mapPoint, true)
            mapView.setZoomLevel(1,true)

            val marker = MapPOIItem()
            marker.itemName = titleBar
            marker.mapPoint = mapPoint
            marker.markerType = MapPOIItem.MarkerType.RedPin
            marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin
            mapView.addPOIItem(marker)

            myLinear.addView(mapView)
            secondcontent.addView(myLinear)
            Log.d(TAG, "Log ----- Map")
        }else{
            return
        }
    }


    fun getOriginalBitmap(): Bitmap =
        URL(thumbnail).openStream().use {
            BitmapFactory.decodeStream(it)
        }

    private fun loadImage(bmp: Bitmap) {
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        var myLinear = LinearLayout(this@SecondActivity)
        myLinear.orientation = LinearLayout.VERTICAL
        myLinear.layoutParams = params

        var myImg = LinearLayout(this@SecondActivity)
        myImg.orientation = LinearLayout.VERTICAL
        myImg.layoutParams = params

        var imageView = ImageView(this@SecondActivity)
        imageView.layoutParams = params
        imageView.setImageBitmap(bmp)
        imageView.visibility = View.VISIBLE

        myImg.addView(imageView)
        myLinear.addView(myImg)
        secondcontent.addView(myLinear)
        Log.d(TAG, "Log ----- Image")
    }

    fun arrangeView(part: String) {
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val typeFace = Typeface.createFromAsset(assets, "binggraesamancobold.ttf")
        if (part == "주소") {
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
            if (address != "null") {
                excontent.text = "${address}\n"
            } else {
                excontent.text = "정보 없음\n"
            }
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 18f
            excontent.textSize = 18f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        } else if (part == "도로명주소") {
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
            if (roadaddress != "null") {
                excontent.text = "${roadaddress}\n"
            } else {
                excontent.text = "정보 없음\n"
            }

            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 18f
            excontent.textSize = 18f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        } else if (part == "정보") {
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
            if (introduction != "null") {
                excontent.text = "${introduction}\n"
            } else {
                excontent.text = "정보 없음\n"
            }
            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 18f
            excontent.textSize = 18f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        } else if (part == "전화번호") {
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
            if (phoneno != "null") {
                excontent.text = "${phoneno}\n"
            } else {
                excontent.text = "정보 없음\n"
            }

            excontent.layoutParams = params
            excontent.setTextColor(Color.BLACK)
            excontent.setTypeface(typeFace)

            extitle.textSize = 18f
            excontent.textSize = 18f

            myextitle.addView(extitle)
            myexcontent.addView(excontent)
            myLinear.addView(myextitle)
            myLinear.addView(myexcontent)
            secondcontent.addView(myLinear)
        }
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