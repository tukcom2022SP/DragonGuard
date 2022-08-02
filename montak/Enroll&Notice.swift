//
//  Enroll&Notice.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Enroll_Notice: View {
    var body: some View {
        VStack{
            Spacer()
                .frame(height:60)
            Button(action:{print("Button")}){
                Image("mainenroll")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            Spacer()
                .frame(height:330)
            Button(action: {print("notice")}){
                Image("notice")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            Spacer()
        }
    }
}

struct Enroll_Notice_Previews: PreviewProvider {
    static var previews: some View {
        Enroll_Notice()
    }
}
