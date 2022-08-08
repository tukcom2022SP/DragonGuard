//
//  ContentView.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//
import SwiftUI

struct MainScreen: View {
    @ObservedObject var value = Parsing()
    @State var checkButtonList : Bool = false   //버튼을 눌렀을 경우 정보 목록 출력하기 위한 변수
    @State var changeScreen : Bool = false  //시작화면에서 메인화면으로 전환하기 위한 변수
    @State var buttonIndex : Int = 0    //먹거리, 놀거리, 볼거리, 쉴곳 구분하기 위한 인덱스
    @State var backButton: Bool = false
    
    init(){ self.value.getData()}   //메인화면 실행시 시작하는 화면
    
    func timer(){
        DispatchQueue.main.asyncAfter(deadline: .now() + .milliseconds(1000)){
            self.changeScreen = true
        }
    }
    
    var body: some View {
        
        if(changeScreen){
            ZStack{
                Image("monttakmain")
                    .resizable()
                    .edgesIgnoringSafeArea(.all)
                
                VStack{
                    HStack{
                        if(checkButtonList){
                            
                            Scroll(index: buttonIndex,mItem: value.getItemInfo())
                                .frame(width: 220, height: 480)
                                .padding(.top)
                            
                            
                        }
                        else{
                           FirstNotice()
                                .frame(width: 230, height: 550)
                                .padding(.top)
                        }
                        
                        Enroll_Notice(backButton: $backButton,checkButtonList: $checkButtonList)
                        .padding(.leading)
                        .frame(width: 90, height: 600,alignment: .trailing)
                        
                    }//HStack
                    .frame(width: 350, height: 610)
                    
                    Spacer()
                    HStack{
                        Button(action: {//먹거리
                            self.checkButtonList = true
                            self.buttonIndex = 0
                            self.backButton = true
                            
                        }){
                            Image("mainmuk")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {//놀거리
                            self.checkButtonList = true
                            self.buttonIndex = 1
                            self.backButton = true
                        }){
                            Image("mainnol")
                                .resizable()
                            
                        }
                        Spacer()
                        Button(action: {//볼거리
                            self.checkButtonList = true
                            self.buttonIndex = 2
                            self.backButton = true
                        }){
                            Image("mainbol")
                                .resizable()
                        }
                        Spacer()
                        Button(action: {//쉴곳
                            self.checkButtonList = true
                            self.buttonIndex = 3
                            self.backButton = true
                        }){
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

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
