//
//  Scroll_In_Button.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Scroll_In_Button: View {
    var mItem : [Item]      //JSON 정보
    var index : Int         //해당 정보의 인덱스
    
    var body: some View {
        
        NavigationLink(destination: Text("hi")) {
            ZStack{
                Image("textbar")
                    .resizable()
                    .frame(width: 230, height: 70)
                    .padding(.leading)
                Text("\(mItem[index].title)")
                    .lineLimit(2)
                    .font(Font.custom("BinggraeSamanco-Bold",size:20))
                    .foregroundColor(.black)
                    .truncationMode(.middle)
            }
        }
        
    }
}

