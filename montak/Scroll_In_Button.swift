//
//  Scroll_In_Button.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Scroll_In_Button: View {
    var mItem : [Item]
    var index : Int
    
    var body: some View {
        Button(action: {print("\(index)")} ){
            ZStack{
                Image("textbar")
                    .resizable()
                    .frame(width: 230, height: 70)
                    .padding(.leading)
                Text("\(mItem[index].title)")
                    .lineLimit(2)
                    .foregroundColor(.black)
                    .truncationMode(.middle)
            }
        }//Button
    }
}

