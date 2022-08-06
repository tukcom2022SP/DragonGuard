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
                            SubScreenInfo(mItem : mItem, index : index)
                        }
                        .frame(width: 240, height: 550,alignment: .leading)
                        .padding(.bottom)
                        
                        
                        SubScreen_Back_Notice()
                            .frame(width: 50, height: 500, alignment: .top)
                            .padding(.bottom)
                        
                    }
                    .frame(width: 340, height: 610)
                    
                        
                    VStack{
                        Image("JejuTour")
                            .resizable()
                            .frame(width:.infinity, height: 150)
                    }
                    
                }
            }//ZStack
    }
}


