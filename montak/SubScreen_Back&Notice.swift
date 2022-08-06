//
//  Report&Back.swift
//  montak
//
//  Created by 홍길동 on 2022/08/03.
//

import SwiftUI

struct SubScreen_Back_Notice: View {
    @State var alertBox :Bool = false
    @Environment(\.presentationMode) var presentation
    var body: some View {
        VStack{
            Spacer()
                .frame(height:30)
            Button(action:{
                presentation.wrappedValue.dismiss()
                    
            }){
                Image("whiteback")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            Spacer()
                .frame(height:330)
            
            Button(action: {
                self.alertBox = true
            }){
                Image("notice")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            .alert(isPresented: $alertBox){
                Alert(title: Text("'몬딱, 제주'")
                        .font(.system(size: 20)),
                      message: Text("""
                        v1.0
                        Copyright. 2022. Dragonguard.
                        All rights reserved
                        """),
                      dismissButton: .default(Text("close"))
                )
            }
            
            Spacer()
        }
    }
}


