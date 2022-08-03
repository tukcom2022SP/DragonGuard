//
//  subScreen2.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct SubScreen2: View {
    var body: some View {
        ZStack{
            Image("monttakmain")
                .resizable()
                .edgesIgnoringSafeArea(.all)
            
            HStack{
                VStack{
                    
                    
                }
                Report_Back()
                    .frame(width: 50, height: 550, alignment: .trailing)
                
            }
            .frame(width: 340, height: 550)
        }//ZStack
    }
}

struct SubScreen2_Previews: PreviewProvider {
    static var previews: some View {
        SubScreen2()
    }
}
