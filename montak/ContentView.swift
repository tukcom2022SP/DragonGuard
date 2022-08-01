//
//  ContentView.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var decodingData: Parsing
    //var temp : String {String(format: "%d", decodingData.data.currentPage) }
    //var str = decodingData.data.items[0].title
    
    var body: some View {
        Image("monttakpause")
            .resizable()
            .edgesIgnoringSafeArea(.all)
        
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
