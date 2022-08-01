//
//  SubScreen1.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct SubScreen1: View {
    var body: some View {
        ZStack{
            Image("monttakmain")
                .resizable()
                .edgesIgnoringSafeArea(.all)
            
            VStack{
                HStack{

                    VStack {
                        Image("textbar")
                            .resizable()
                            .frame(width: 230, height: 30)
                        .padding(.leading)
                        Image("textbar")
                            .resizable()
                            .frame(width: 230, height: 30)
                            .padding(.leading)
                        
                    }
                        

                    VStack{
                        Spacer()
                        Image("mainenroll")
                            .resizable()
                            .padding(.leading)
                            .frame(width: 90, height: 90)

                        Spacer()
                        Spacer()
                        Spacer()

                        Image("notice")
                            .resizable()
                            .padding(.leading)
                            .frame(width: 90, height: 90)
                    }
                    .padding(.leading)
                    .frame(width: 90, height: 610,alignment: .trailing)

                }//HStack
                .frame(width: 350, height: 610)
                
                Spacer()
                HStack{
                    Image("mainmuk")
                        .resizable()
                    Spacer()
                    Image("mainnol")
                        .resizable()
                    Spacer()
                    Image("mainbol")
                        .resizable()
                    Spacer()
                    Image("mainshuil")
                        .resizable()
                    Spacer()
                }//HStack
                .frame(width: 350, height: 130)
            }//VStack
            .frame(width: 350)
            
        }//ZStack
        
        
        
        
    }
}

struct SubScreen1_Previews: PreviewProvider {
    static var previews: some View {
        SubScreen1()
    }
}
