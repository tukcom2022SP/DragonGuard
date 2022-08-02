//
//  ScrollView.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Scroll: View {
    var index : Int
    var mItem: [Item]
    
    func divideInfo(){
        
        
    }
    
    
    var body: some View {
        ScrollView{
            VStack {
                ForEach(0..<self.mItem.count){ i in
                    Button(action: {print("\(i)hihiashfidsjflkafjdsf")} ){
                        ZStack{
                            Image("textbar")
                                .resizable()
                                .frame(width: 230, height: 70)
                                .padding(.leading)
                            Text("\(mItem[i].title)")
                                .lineLimit(2)
                                .foregroundColor(.black)
                                .allowsTightening(true)
                        }
                    }
                }
            }
            .frame(maxWidth:.infinity)
        }
    }
}


