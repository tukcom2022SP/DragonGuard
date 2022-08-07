//
//  SubScreenInfo.swift
//  montak
//
//  Created by 정호진 on 2022/08/05.
//

import SwiftUI

struct SubScreenInfo: View {
    var mItem : [Item]      //JSON 정보
    var index : Int         //해당 정보의 인덱스
    @State var check : Bool = false
    
    
    
    func timer(){
        DispatchQueue.main.asyncAfter(deadline: .now() + .milliseconds(1000)){
            self.check = true
        }
    }
    var body: some View {
        VStack {
            ZStack{
                Image("textbar")
                    .resizable()
                    .frame(width: 230, height: 70)
                    .padding(.trailing)
                Text(mItem[index].title)
                    .font(Font.custom("BinggraeSamanco-Bold",size:20))
            }//ZStack
            
            
            VStack(alignment: .leading) {
                
                HStack{
                    Text("주소:")
                        .font(Font.custom("BinggraeSamanco-Bold",size:16))
                    Text(mItem[index].address ?? "정보 없음")
                        .font(Font.custom("BinggraeSamanco-Bold",size:15))
                }
                HStack {
                    Text("도로명주소:")
                        .font(Font.custom("BinggraeSamanco-Bold",size:16))
                    Text(mItem[index].roadaddress ?? "정보 없음")
                        .font(Font.custom("BinggraeSamanco-Bold",size:15))
                }
                
                HStack {
                    Text("정보:")
                        .font(Font.custom("BinggraeSamanco-Bold",size:16))
                    Text(mItem[index].introduction ?? "정보 없음")
                        .font(Font.custom("BinggraeSamanco-Bold",size:15))
                }
                
                HStack {
                    Text("전화번호: ")
                        .font(Font.custom("BinggraeSamanco-Bold",size:16))
                    Text(mItem[index].phoneno ?? "정보 없음")
                        .font(Font.custom("BinggraeSamanco-Bold",size:15))
                }
                
                
                KakaoMap()
                    .frame(width: 200, height: 100)
                
                
                    Image(systemName: "image")
                        .data(url: URL(string: mItem[index].repPhoto?.photoid.imgpath ?? "")!)
                        .frame(width: 150, height: 150, alignment: .leading)
                    
                    
                
                
            }}
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
