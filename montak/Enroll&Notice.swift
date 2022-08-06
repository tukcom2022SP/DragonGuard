//
//  Enroll&Notice.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Enroll_Notice: View {
    @State var alertBox : Bool
    @Binding var backButton : Bool
    @Binding var checkButtonList : Bool
    
    var body: some View {
        VStack{
            Spacer()
                .frame(height:100)
            
                Button(action:{
                    self.backButton = false
                    self.checkButtonList = false
                }){

                    Image("whiteback")
                        .resizable()
                        .padding(.leading)
                        .frame(width: 90, height: 90)
                    
                }
                .opacity(backButton ? 1: 0)
            
            Spacer()
                .frame(height:310)
            Button(action: {
                self.alertBox = true
            }){
                Image("notice")
                    .resizable()
                    .padding(.leading)
                    .frame(width: 90, height: 90)
            }
            .alert(isPresented: $alertBox){
                Alert(title: Text("hi")
                        .font(.system(size: 20)),
                      message: Text("aaa"),
                      dismissButton: .default(Text("close"))
                )
            }
            Spacer()
        }
    }
}
