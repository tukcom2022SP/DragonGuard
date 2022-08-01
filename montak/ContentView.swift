//
//  ContentView.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var decodingData: Parsing
//    var temp : String {String(format: "%d", decodingData.data.currentPage) }
    @ObservedObject var value = Parsing()
    @State var a : String = ""
    
    init(){
        self.value.getData()
        self.timer()
        
    }
    func timer(){
        DispatchQueue.main.asyncAfter(deadline: .now() + .milliseconds(500)){
            var mItem: Item
            mItem = self.value.getFirstItem()
            self.a = mItem.title
            print(mItem.title)
        }
    }

    
    var body: some View {
        ZStack{
            Image("monttakpause")
                .resizable()
                .edgesIgnoringSafeArea(.all)
            
            Text("hello \(a)")
                
            
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
