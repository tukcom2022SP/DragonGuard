//
//  subScreen2.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct subScreen2: View {
    var body: some View {
        ZStack{
                    Image("monttakmain")
                        .resizable()
                        .edgesIgnoringSafeArea(.all)
                    
                    VStack{
                        Report_Back()
                        .padding(.leading)
                        .frame(width: 340, height: 660,alignment: .trailing)
                    }
                }//ZStack
    }
}

struct subScreen2_Previews: PreviewProvider {
    static var previews: some View {
        subScreen2()
    }
}
