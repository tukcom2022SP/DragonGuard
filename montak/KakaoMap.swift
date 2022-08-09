//
//  KakaoMap.swift
//  montak
//
//  Created by 정호진 on 2022/08/06.
//

import SwiftUI
import MapKit

//SubScreenInfo가 시작할 때 같이 돌아감
struct KakaoMap: UIViewRepresentable {
    var la : Double?
    var long: Double?
    let poiItem = MTMapPOIItem()
    let view = MTMapView(frame: .zero)
    
    func makeUIView(context: Context) -> MTMapView {
        view.baseMapType = .standard
        view.setZoomLevel(1, animated: true)
        return view
    }
    
    func updateUIView(_ uiView: MTMapView, context: UIViewRepresentableContext<KakaoMap>) {
        //맵 중심 잡기
        view.setMapCenter(MTMapPoint(geoCoord: MTMapPointGeo(latitude: la ?? 0, longitude: long ?? 0)), animated: true)
    
        //마커 찍을 좌표 저장
        poiItem.mapPoint = MTMapPoint(geoCoord: MTMapPointGeo(latitude: la ?? 0, longitude: long ?? 0  ))
        poiItem.markerType = .redPin
        //마커 등록
        view.addPOIItems([poiItem])
    }

}

