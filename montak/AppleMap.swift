//
//  AppleMap.swift
//  montak
//
//  Created by 정호진 on 2022/08/08.
//

import SwiftUI
import MapKit
struct AppleMap: UIViewRepresentable {
    
    let locationManager = CLLocationManager()
    
    func makeUIView(context: Context) -> MKMapView {
        print("맵 생성")
        
        let mkMapView = MKMapView()
        mkMapView.delegate = context.coordinator

        self.locationManager.desiredAccuracy = kCLLocationAccuracyBest
        
        self.locationManager.delegate = context.coordinator
        mkMapView.showsUserLocation = true
        
        let regionRadius : CLLocationDistance = 200
        
//        let coordinateRegion = MKCoordinateRegion(center: AppleMap.userLocation.coordinate, latitudinalMeters: regionRadius, longitudinalMeters: regionRadius)
        
        return mkMapView
    }
    
    func updateUIView(_ uiView: MKMapView, context: Context) {
        print("업데이트완료")
    }
    
    func makeCoordinator() -> AppleMap.Coordinator {
        return AppleMap.Coordinator(self)
        
    }
    
    class Coordinator: NSObject{
        var map : AppleMap
        init(_ map: AppleMap){
            self.map = map
        }
    }
    
}

extension AppleMap.Coordinator : MKMapViewDelegate{
    
}

extension AppleMap.Coordinator : CLLocationManagerDelegate{
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        guard let lat = locations.first?.coordinate.latitude,
              let long = locations.first?.coordinate.longitude else{
            return
        }
    }
}
