//
//  ContentView.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var decodingData: Parsing
    @ObservedObject var value = Parsing()
    @State var checking : Bool = false
    @State var changeScreen : Bool = false
    
    init(){ self.value.getData()}
    
    func timer(){
        DispatchQueue.main.asyncAfter(deadline: .now() + .milliseconds(1000)){
            var mItem: Item
            mItem = self.value.getFirstItem()
            self.changeScreen = true
            guard let addr = mItem.address else{return}
            print(mItem.title)
            print(addr)
        }
    }
    
    var body: some View {
        if(changeScreen){
            ZStack{
                Image("monttakmain")
                    .resizable()
                    .edgesIgnoringSafeArea(.all)
                
                VStack{
                    Spacer()
                        .frame (height: 50)
                    HStack{
                        if(checking){
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
                            }.frame(width: 230, height: 550)
                                .padding(.top)
                        }
                        else{
                            VStack {
                                Image("textbar")
                                    .resizable()
                                    .frame(width: 230, height: 60)
                                    .padding(.leading)
                                Spacer()
                                    .frame(height:20)
                                Text("안녕하세요")
                                    .frame(width: 230, height: 400)
                                    .padding(.leading)
                                    .font(.system(size: 20))
                                
                            }.frame(width: 230, height: 550)
                                .padding(.top)
                            
                        }
                        
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
                        .padding(.leading)
                        .frame(width: 90, height: 610,alignment: .trailing)
                        
                    }//HStack
                    .frame(width: 350, height: 610)
                    
                    Spacer()
                    HStack{
                        Button(action: {print("먹거리");self.checking = true}){
                            Image("mainmuk")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {print("놀거리"); self.checking = true}){
                            Image("mainnol")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {print("볼거리");self.checking = true}){
                            Image("mainbol")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {print("쉴 곳");self.checking = true}){
                            Image("mainshuil")
                                .resizable()
                        }
                        Spacer()
                    }//HStack
                    .frame(width: 350, height: 130)
                }//VStack
                .frame(width: 350)
                
            }//ZStack
        }//if
        else{
            Image("monttakpause")
                .resizable()
                .edgesIgnoringSafeArea(.all)
                .onAppear{
                    timer()
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
