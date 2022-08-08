//
//  ScrollView.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//
import UIKit
import SwiftUI

struct Scroll: View {
    var index : Int
    var mItem: [Item]
    
//  폰트 목록 보는 코드
//    func font(){
//        for fontFamily in UIFont.familyNames {
//            for fontName in UIFont.fontNames(forFamilyName: fontFamily) {
//                print("font : " + fontName)
//            }
//        }
//    }
    
    var body: some View {
        VStack{
            ZStack {
                Image("textbar")
                    .resizable()
                    .frame(width: 230, height: 70)
                    .padding(.leading)
                
                if(index == 0 ){Text("[먹거리]").font(Font.custom("OTMogujasusimgyeolB",size:30))}
                else if( index == 1){Text("[놀멍]").font(Font.custom("OTMogujasusimgyeolB", size: 30))}
                else if( index == 2){Text("[볼거리]").font(Font.custom("OTMogujasusimgyeolB", size: 30))}
                else if( index == 3){Text("[쉴멍]").font(Font.custom("OTMogujasusimgyeolB", size: 30))}
                
            }
            ScrollView{
                VStack {
                    ForEach(0..<self.mItem.count,id:\.self){ i in
                        if((self.mItem[i].contentscd.label == "음식점") && (index == 0)){
                            Scroll_In_Button(mItem: self.mItem, index: i)
                        }
                        else if(self.mItem[i].contentscd.label == "정보" && index == 2){
                            Scroll_In_Button(mItem: self.mItem, index: i)
                        }
                        else if(self.mItem[i].contentscd.label == "숙박" && index == 3){
                            Scroll_In_Button(mItem: self.mItem, index: i)
                        }
                        else if (self.mItem[i].contentscd.label == "축제/행사" && index == 2){
                            Scroll_In_Button(mItem: self.mItem, index: i)
                        }
                        else if (self.mItem[i].contentscd.label == "테마여행" && index == 1){
                            Scroll_In_Button(mItem: self.mItem, index: i)
                        }
                        else if (self.mItem[i].contentscd.label == "쇼핑" && index == 1){
                            Scroll_In_Button(mItem: self.mItem, index: i)
                        }
                    }//ForEach
                }//VStack
                .frame(maxWidth:.infinity)
            }//ScrollView
        }
    }
    
}


