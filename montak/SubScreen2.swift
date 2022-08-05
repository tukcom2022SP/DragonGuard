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
                
                VStack {
                    Spacer()
                        .frame(height: 40)
                    HStack{
                        VStack{
                            SubScreenInfo()
                                
                                
                        }
                        .frame(width: 240, height: 550,alignment: .leading)
                        .padding(.bottom)
                        
                        
                        Report_Back()
                            .frame(width: 50, height: 500, alignment: .top)
                            .padding(.bottom)
                        
                    }
                    .frame(width: 340, height: 610)
                    
                        
                    VStack{
                        Image("JejuTour")
                            .resizable()
                            .frame(width:.infinity, height: 150)
                    }
                    
                }
            }//ZStack
        
        
    }
}

struct SubScreen2_Previews: PreviewProvider {
    static var previews: some View {
        SubScreen2()
    }
}
