//
//  SubScreenInfo.swift
//  montak
//
//  Created by 정호진 on 2022/08/05.
//

import SwiftUI

struct SubScreenInfo: View {
    var body: some View {
        Image("textbar")
            .resizable()
            .frame(width: 230, height: 70)
            .padding(.trailing)
        
    }
}

struct SubScreenInfo_Previews: PreviewProvider {
    static var previews: some View {
        SubScreenInfo()
    }
}
