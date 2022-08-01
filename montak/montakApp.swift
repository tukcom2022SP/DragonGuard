//
//  montakApp.swift
//  montak
//
//  Created by 정호진 on 2022/08/01.
//

import SwiftUI

@main
struct montakApp: App {
    var data = Parsing()
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(data)
        }
    }
}
