//
//  SubScreenInfo.swift
//  montak
//
//  Created by 정호진 on 2022/08/05.
//

import SwiftUI
import MapKit

struct SubScreenInfo: View {
    var mItem : [Item]      //JSON 정보
    var index : Int         //해당 정보의 인덱스
    @State var check : Bool = true
    @State var la : Double? = 0
    @State var long : Double? = 0
    
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
                        .foregroundColor(.black)
                        .lineLimit(1)
                }//ZStack
                .onAppear{
                    self.la = mItem[index].latitude
                    self.long = mItem[index].longitude
                    checkLaLong()
                }
                
                VStack(alignment: .leading) {
                    HStack{
                        Text("주소)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                            .foregroundColor(.black)
                            .frame(width: 55,  alignment: .leading)
                        Text(mItem[index].address ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                            .foregroundColor(.black)
                    }
                    HStack {
                        Text("도로명주소)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                            .foregroundColor(.black)
                            .frame(width: 55,  alignment: .leading)
                        Text(mItem[index].roadaddress ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                            .foregroundColor(.black)
                    }
                    
                    HStack {
                        Text("정보)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                            .foregroundColor(.black)
                            .frame(width: 55,  alignment: .topLeading)
                        Text(mItem[index].introduction ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                            .foregroundColor(.black)
                    }
                    
                    HStack {
                        Text("전화번호)")
                            .font(Font.custom("BinggraeSamanco-Bold",size:16))
                            .foregroundColor(.black)
                            .frame(width: 55,  alignment: .leading)
                        Text(mItem[index].phoneno ?? "정보 없음")
                            .font(Font.custom("BinggraeSamanco-Bold",size:15))
                            .foregroundColor(.black)
                    }
                    
                    Image(systemName: "image")
                        .data(url: URL(string: mItem[index].repPhoto?.photoid.imgpath ?? "")!)
                        .frame(width: 200, height: 200, alignment: .leading)
                    
                    KakaoMap(la: la,long: long)
                        .frame(width: 200  , height: 150)
                        .opacity(check ? 0: 1)
                    
                    
                    
                }
            }//VStack
        }
    }
    // latitude, longitude가 0과 nil인지 구분
    func checkLaLong() {
        if(mItem[index].latitude == 0 && mItem[index].longitude == 0){
            guard mItem[index].latitude == 0 else{ return self.check = false}
            guard mItem[index].longitude == 0 else{ return self.check = false}
        }
        else{
            guard mItem[index].latitude == nil else{ return self.check = false}
            guard mItem[index].longitude == nil else{ return self.check = false}
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
