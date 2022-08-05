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
    
    var body: some View {
        ZStack{
            Image("textbar")
                .resizable()
                .frame(width: 230, height: 70)
                .padding(.trailing)
            Text(mItem[index].title)
                .font(.system(size: 20))
        }
    }
}

//struct SubScreenInfo_Previews: PreviewProvider {
//    static var previews: some View {
//        SubScreenInfo()
//    }
//}
