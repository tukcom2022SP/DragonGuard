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
    
    let field = UITextField()
    var body: some View {
        ScrollView{
            VStack {
                ForEach(0..<self.mItem.count){ i in
                    
                    if((self.mItem[i].contentscd.label == "음식점") && (index == 0)){
                        Scroll_In_Button(mItem: self.mItem, index: i)
                    }
                    else if(self.mItem[i].contentscd.label == "정보" && index == 2){
                        Scroll_In_Button(mItem: self.mItem, index: i)
                    }
                    else if(self.mItem[i].contentscd.label == "숙박" && index == 3){
                        Scroll_In_Button(mItem: self.mItem, index: i)
                    }
                    else if (self.mItem[i].contentscd.label == "축제/행사" && index == 1){
                        Scroll_In_Button(mItem: self.mItem, index: i)
                    }
                    else if (self.mItem[i].contentscd.label == "테마여행" && index == 1){
                        Scroll_In_Button(mItem: self.mItem, index: i)
                    }
                    else if (self.mItem[i].contentscd.label == "쇼핑" && index == 1){
                        Scroll_In_Button(mItem: self.mItem, index: i)
                    }
                    
                }
            }
            .frame(maxWidth:.infinity)
        }
    }
}


