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
                        Button(action: {print("\(i)음식점")} ){
                            ZStack{
                                Image("textbar")
                                    .resizable()
                                    .frame(width: 230, height: 70)
                                    .padding(.leading)
                                Text("\(mItem[i].title)")
                                    .lineLimit(2)
                                    .foregroundColor(.black)
                                    .truncationMode(.middle)
                            }
                        }//Button
                    }
                    else if(self.mItem[i].contentscd.label == "정보" && index == 2){
                        Button(action: {print("\(i)정보")} ){
                            ZStack{
                                Image("textbar")
                                    .resizable()
                                    .frame(width: 230, height: 70)
                                    .padding(.leading)
                                Text("\(mItem[i].title)")
                                    .lineLimit(2)
                                    .foregroundColor(.black)
                                    .truncationMode(.middle)
                            }
                        }//Button
                    }
                    else if(self.mItem[i].contentscd.label == "숙박" && index == 3){
                        Button(action: {print("\(i)숙박")} ){
                            ZStack{
                                Image("textbar")
                                    .resizable()
                                    .frame(width: 230, height: 70)
                                    .padding(.leading)
                                Text("\(mItem[i].title)")
                                    .lineLimit(2)
                                    .foregroundColor(.black)
                                    .truncationMode(.middle)
                            }
                        }//Button
                    }
                    else if (self.mItem[i].contentscd.label == "테마여행" &&
                             self.mItem[i].contentscd.label == "축제/행사" &&
                             self.mItem[i].contentscd.label == "쇼핑" && index == 1){
                        Button(action: {print("\(i)")} ){
                            ZStack{
                                Image("textbar")
                                    .resizable()
                                    .frame(width: 230, height: 70)
                                    .padding(.leading)
                                Text("\(mItem[i].title)")
                                    .lineLimit(2)
                                    .foregroundColor(.black)
                                    .truncationMode(.middle)
                            }
                        }//Button
                    }
                    
                }
            }
            .frame(maxWidth:.infinity)
        }
    }
}


