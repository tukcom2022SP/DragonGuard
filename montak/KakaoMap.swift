//
//  KakaoMap.swift
//  montak
//
//  Created by 정호진 on 2022/08/06.
//

import SwiftUI
import Foundation
import MapKit

struct KakaoMap: UIViewRepresentable {
    
    
    
    func makeUIView(context: Context) -> MTMapView {
        print("맵 생성")
        ViewController().viewDidLoad()
        
        return MTMapView()
    }
    
    func updateUIView(_ uiView: MTMapView, context: Context) {
        print("업데이트완료")
    }
    
 
}
