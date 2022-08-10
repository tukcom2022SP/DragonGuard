package com.example.monttak


import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.monttak.databinding.ActivitySecond2Binding
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
    private lateinit var binding: ActivitySecond2Binding
    lateinit var titleBar: String
    lateinit var address: String
    lateinit var roadaddress: String
    lateinit var introduction: String
    lateinit var phoneno: String
    lateinit var thumbnail: String
    lateinit var mapView: MapView

    var latitude = 0.0
    var longitude = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getAppKeyHash()

        var intent = intent
        titleBar = intent.getStringExtra("title")!!
        address = intent.getStringExtra("address")!!
        roadaddress = intent.getStringExtra("roadaddress")!!
        introduction = intent.getStringExtra("introduction")!!
        phoneno = intent.getStringExtra("phoneno")!!
        thumbnail = intent.getStringExtra("thumbnailpath")!!
        latitude = intent.getDoubleExtra("latitude", 0.0)
        longitude = intent.getDoubleExtra("longitude", 0.0)

//        secondcontent.removeAllViews()

//        위도 경도 있는 장소들을 지도에 보여주기(binding)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT)
        if (latitude != 0.0){
            clKakaoMapView.isEnabled = true
            mapView = MapView(this)
            binding.clKakaoMapView.addView(mapView)
            mapView.layoutParams = params
            val mapPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude)
            mapView.setMapCenterPoint(mapPoint, true)
            mapView.setZoomLevel(1, true)
            mapView.layoutParams = params
            val marker = MapPOIItem()
            marker.itemName = titleBar
            marker.mapPoint = mapPoint
            marker.markerType = MapPOIItem.MarkerType.RedPin
            marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin
            mapView.addPOIItem(marker)
        }else{
            clKakaoMapView.isEnabled = false
        }

//        제목 및 관련 정보 넣기
        secondbar.text = titleBar
        arrangeView("주소")
        arrangeView("도로명주소")
        arrangeView("정보")
        arrangeView("전화번호")

//        val params = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.WRAP_CONTENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//        var myLinear = LinearLayout(this@SecondActivity)
//        myLinear.orientation = LinearLayout.VERTICAL
//        myLinear.layoutParams = params
//        myLinear.setBackgroundResource(R.drawable.textbar)

//        코루틴을 이용한 url 이미지 가져오기
        val corutin = CoroutineScope(Dispatchers.Main)
        corutin.launch {
            val originalDeferred = corutin.async(Dispatchers.IO) {
                getOriginalBitmap()
            }
            val originalBitmap = originalDeferred.await()
            loadImage(originalBitmap)

        }

//        Glide 사용
//        Glide.with(this).load(thumbnail).into(imageview)

//        var mThread = mapViewSetting()
//        mThread.start()
//        mThread.join()
//        val handler = Handler()
//        handler.postDelayed({ }, 500)


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
        secondunder.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ijto.or.kr/korean/"))
            startActivity(intent)
        }
    }

//    inner class mapViewSetting : Thread() {
//        override fun run() {
//            val params = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//
//            if (latitude != 0.0) {
//                mapView = MapView(this@SecondActivity)
//                mapView.layoutParams = params
//                val mapPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude)
//                mapView.setMapCenterPoint(mapPoint, true)
//                mapView.setZoomLevel(1, true)
//
//                val marker = MapPOIItem()
//                marker.itemName = titleBar
//                marker.mapPoint = mapPoint
//                marker.markerType = MapPOIItem.MarkerType.RedPin
//                marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin
//                mapView.addPOIItem(marker)
//
//                Log.d(TAG, "Log ----- Map")
//            } else {
//                return
//            }
//            runOnUiThread{
//                maplayout.addView(mapView)
//
//            }
//        }
//
//    }

//    URL의 bitmap가져오기
    private fun getOriginalBitmap(): Bitmap =
        URL(thumbnail).openStream().use {
            BitmapFactory.decodeStream(it)
        }

//    이미지뷰에 가져온 bitmap 넣기
    private fun loadImage(bmp: Bitmap) {

        imageview.setImageBitmap(bmp)
        imageview.visibility = View.VISIBLE
        Log.d(TAG, "Log ----- Image")
    }

    fun arrangeView(part: String) {
        if (part == "주소") {
            if (address != "null") {
                addcontent.text = "${address}\n"
            } else {
                addcontent.text = "정보 없음\n"
            }

        } else if (part == "도로명주소") {
            if (roadaddress != "null") {
                roadaddcontent.text = "${roadaddress}\n"
            } else {
                roadaddcontent.text = "정보 없음\n"
            }
        } else if (part == "정보") {

            if (introduction != "null") {
                infocontent.text = "${introduction}\n"
            } else {
                infocontent.text = "정보 없음\n"
            }
        } else if (part == "전화번호") {

            if (phoneno != "null") {
                phonecontent.text = "${phoneno}\n"
            } else {
                phonecontent.text = "정보 없음\n"
            }
        }
    }

//    해시 키 구하기
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