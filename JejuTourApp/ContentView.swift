//
//  ContentView.swift
//  JejuTourApp
//
//  Created by 정호진 on 2022/07/27.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var decodingData: Parsing
    
    var temp : String {String(format: "%d", decodingData.data.currentPage) }
    
    
        
    var body: some View {
        
        VStack{
            Text("HEllo \(temp)")
            
            
            
        }.onAppear{
            decodingData.getData()
        }
    }
    
}





struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .environmentObject(Parsing())
        
    }
}
