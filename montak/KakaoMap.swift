//
//  KakaoMap.swift
//  montak
//
//  Created by 정호진 on 2022/08/06.
//

import SwiftUI
import MapKit

struct KakaoMap: UIViewRepresentable {
    var la : Double?
    var long: Double?
    
    func makeUIView(context: Context) -> MTMapView {
        print("맵 생성")
        print("la = \(la), long = \(long)")
        let view = MTMapView(frame: .zero)
        view.baseMapType = .standard
        
//        view.setZoomLevel(1, animated: false)
//        view.setMapCenter(MTMapPoint(geoCoord: MTMapPointGeo(latitude: la ?? 0, longitude: long ?? 0)), animated: true)
//
//        let poiItem = MTMapPOIItem()
//        poiItem.itemName = "1"
//        poiItem.mapPoint = MTMapPoint(geoCoord: MTMapPointGeo(latitude: 33.462147, longitude: 126.936424  ))
//        poiItem.markerType = .redPin
//        view.addPOIItems([poiItem])
        
        return view
        
    }
    
    func updateUIView(_ uiView: MTMapView, context: UIViewRepresentableContext<KakaoMap>) {
        let view = MTMapView(frame: .zero)
        view.baseMapType = .standard
        
        view.setZoomLevel(1, animated: true)
        view.setMapCenter(MTMapPoint(geoCoord: MTMapPointGeo(latitude: la ?? 0, longitude: long ?? 0)), animated: true)
        
        let poiItem = MTMapPOIItem()
        poiItem.itemName = "1"
        poiItem.mapPoint = MTMapPoint(geoCoord: MTMapPointGeo(latitude: la ?? 0, longitude: long ?? 0  ))
        poiItem.markerType = .redPin
        view.addPOIItems([poiItem])
        print("업데이트완료")
        
    }
    
    func makeCoordinator() -> Coordinate {
        return Coordinate()
    }
    class Coordinate  {}
}

