//
//  SubScreenInfo.swift
//  montak
//
//  Created by 정호진 on 2022/08/05.
//

import SwiftUI
import MapKit

struct SubScreenInfo: View {
    var value = Parsing()
    var mItem : [Item]      //JSON 정보
    var index : Int         //해당 정보의 인덱스
    @State var position = MKCoordinateRegion(center:
                                CLLocationCoordinate2D(
                                    latitude:CLLocationDegrees( 37.331705),
                                    longitude:CLLocationDegrees( -122.030737    )
                                ),
                            span: MKCoordinateSpan())
    
    var body: some View {
        
        ScrollView {
            VStack{
                ZStack{
                    Image("textbar")
                        .resizable()
                        .frame(width: 230, height: 70)
                        .padding(.trailing)
                    Text(mItem[index].title)
                        .font(Font.custom("OTMogujasusimgyeolB",size:20))
                        .lineLimit(1)
                }//ZStack
                
                
                VStack(alignment: .leading) {
                    HStack{
                        Text("주소)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                        Text(mItem[index].address ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                    }
                    HStack {
                        Text("도로명주소)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                        Text(mItem[index].roadaddress ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                    }
                    
                    HStack {
                        Text("정보)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                        Text(mItem[index].introduction ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                    }
                    
                    HStack {
                        Text("전화번호)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                        Text(mItem[index].phoneno ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                    }
                    
                    
                    Image(systemName: "image")
                        .data(url: URL(string: mItem[index].repPhoto?.photoid.imgpath ?? "")!)
                        .frame(width: 150, height: 150, alignment: .leading)
                    
                    
                    
                    AppleMap()
                        .frame(width: 200  , height: 150)
//                    KakaoMap()
//                        .frame(width: 100  , height: 100)
                    
                    
                }
                
            }//VStack
            
            
        }
    }
}

extension Image{
    func data(url:URL) -> Self{
        if let data = try? Data(contentsOf: url){
            return Image(uiImage: UIImage(data:data)!)
                .resizable()
        }
        return  self.resizable()
    }
}
