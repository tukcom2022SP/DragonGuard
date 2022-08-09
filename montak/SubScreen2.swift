//
//  subScreen2.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct SubScreen2: View {
    var mItem : [Item]      //JSON 정보
    var index : Int         //해당 정보의 인덱스
    @State var checkWebView : Bool = false
    
    var body: some View {
            ZStack{
                Image("monttakmain")
                    .resizable()
                    .edgesIgnoringSafeArea(.all)
                
                VStack {
                    Spacer()
                        .frame(height: 40)
                    HStack{
                        VStack{
                            SubScreenInfo(mItem : mItem, index : index) //버튼 누르는 경우 뜨는 모달 뷰
                        }
                        .frame(width: 240, height: 450,alignment: .leading)
                        .padding(.bottom)
                        
                        SubScreen_Back_Notice() //뒤로가기 버튼과 공지사항 버튼
                            .frame(width: 50, height: 500, alignment: .top)
                            .padding(.bottom)
                        
                    }
                    .frame(width: 340, height: 610)

                    VStack{
                        Image("JejuTour")
                            .resizable()
                            .frame(width:.infinity, height: 150)
                            .onTapGesture {
                                self.checkWebView = true
                            }
                            .sheet(isPresented: $checkWebView){
                                JejuWebView(urlToLoad: "https://ijto.or.kr/korean/")
                            }
                    }
                    
                }
            }//ZStack
    }
}


