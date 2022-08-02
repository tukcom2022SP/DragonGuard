//
//  ScrollView.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Scroll: View {
    var body: some View {
        ScrollView{
            VStack {
                ForEach(0..<100){i in
                    Image("textbar")
                        .resizable()
                        .frame(width: 230, height: 30)
                        .padding(.leading)
                }
            }
            .frame(maxWidth:.infinity)
        }
    }
}

struct Scroll_Previews: PreviewProvider {
    static var previews: some View {
        Scroll()
    }
}
