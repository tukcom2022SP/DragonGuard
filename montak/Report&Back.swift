//
//  Report&Back.swift
//  montak
//
//  Created by 홍길동 on 2022/08/03.
//

import SwiftUI

struct Report_Back: View {
    var body: some View {
        VStack{
            Spacer()
                .frame(height:60)
            Button(action:{print("Button")}){
                Image("whitereport")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            Spacer()
                .frame(height:330)
            Button(action: {print("Button")}){
                Image("back")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            Spacer()
        }
    }
}

struct Report_Back_Previews: PreviewProvider {
    static var previews: some View {
        Report_Back ()
    }
}

