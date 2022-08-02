//
//  FirstNotice.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct FirstNotice: View {
    var body: some View {
        VStack {
            Image("textbar")
                .resizable()
                .frame(width: 230, height: 60)
                .padding(.leading)
            Spacer()
                .frame(height:20)
            Text("안녕하세요")
                .frame(width: 230, height: 400)
                .padding(.leading)
                .font(.system(size: 20))
            
        }
    }
}

struct FirstNotice_Previews: PreviewProvider {
    static var previews: some View {
        FirstNotice()
    }
}
