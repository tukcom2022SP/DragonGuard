//
//  Enroll&Notice.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct Enroll_Notice: View {
    @State var alertBox : Bool
    @State var backButton : Bool
    var body: some View {
        VStack{
            Spacer()
                .frame(height:60)
            
                Button(action:{
                    print("Button")
                    self.backButton = false
                }){
                    if(backButton){
                        Image("whiteback")
                            .resizable()
                            .padding(.leading)
                            .frame(width: 90, height: 90)
                    }
                }
            
            Spacer()
                .frame(height:450)
            Button(action: {
                print("notice")
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
