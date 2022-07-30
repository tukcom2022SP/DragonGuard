//
//  JejuTourAppApp.swift
//  JejuTourApp
//
//  Created by 정호진 on 2022/07/27.
//

import SwiftUI

@main
struct JejuTourAppApp: App {
    
    var data = Parsing()
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(data)
                
        }
    }
}
