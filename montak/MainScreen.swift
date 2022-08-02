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
    @State var checkButtonList : Bool = false
    @State var changeScreen : Bool = false
    @State var tourTitle : String = ""
    init(){ self.value.getData()}
    
    func timer(){
        DispatchQueue.main.asyncAfter(deadline: .now() + .milliseconds(1000)){
            var mItem: Item
            mItem = self.value.getFirstItem()
            self.changeScreen = true
            if let addr = mItem.address {print(addr)}
            self.tourTitle = mItem.title
            print("\(mItem.repPhoto)")
            
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
                        if(checkButtonList){
                           Scroll()
                                .frame(width: 230, height: 550)
                                .padding(.top)
                        }
                        else{
                           FirstNotice()
                                .frame(width: 230, height: 550)
                                .padding(.top)
                        }
                        
                        Enroll_Notice()
                        .padding(.leading)
                        .frame(width: 90, height: 610,alignment: .trailing)
                        
                    }//HStack
                    .frame(width: 350, height: 610)
                    
                    Spacer()
                    HStack{
                        Button(action: {
                            print("먹거리")
                            self.checkButtonList = true
                            
                        }){
                            Image("mainmuk")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {print("놀거리"); self.checkButtonList = true}){
                            Image("mainnol")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {print("볼거리");self.checkButtonList = true}){
                            Image("mainbol")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {print("쉴 곳");self.checkButtonList = true}){
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
