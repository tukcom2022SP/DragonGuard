//
//  KakaoMap.swift
//  montak
//
//  Created by 정호진 on 2022/08/06.
//

import SwiftUI
import MapKit

struct KakaoMap: UIViewRepresentable {
    
    
    func makeUIView(context: Context) -> MTMapView {
        print("맵 생성")
        
        return MTMapView()
    }
    
    func updateUIView(_ uiView: MTMapView, context: Context) {
        print("업데이트완료")
    }
    
}

//struct FieldReservView: View {
//    var latitude: Double
//    var longitude: Double
//    
//    @State private var region = MKCoordinateRegion(
//        center: CLLocationCoordinate2D(latitude: latitude, longitude: longitude),
//        span: MKCoordinateSpan(latitudeDelta: 0.5, longitudeDelta: 0.5)
//    )
//    
//    var body: some View {
//        Map(coordinateRegion: $region, showsUserLocation: false, userTrackingMode: .constant(.follow))
//            .frame(width: 200, height: 200)
//    }
//    
//}
