//
//  ContentView.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var decodingData: Parsing
    var temp : String {String(format: "%d", decodingData.data.totalCount) }
    
    
    var body: some View {
        VStack{
            Text("HEllo")
            Text("HEllo \(temp)")
            
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
