//
//  decode.swift
//  JejuTourApp
//
//  Created by 정호진 on 2022/07/28.
//

import Foundation
import SwiftUI

class Network: ObservableObject{
    @Published var jsonData : Welcome = Welcome.sample
    var apiKey = ""
    
    func getData(){
        let index = 1
        
        if let url = URL(string: "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=\(apiKey)&locale=kr&page=\(index)") {
            var request = URLRequest.init(url: url)
            
            request.httpMethod = "GET"
            
            URLSession.shared.dataTask(with: request) { (data, response, error) in
                if error != nil{
                    print("ERROR")
                    return
                }
                
                guard let response = response as? HTTPURLResponse else { return }
                
                if(response.statusCode == 200){
                    guard let data = data else { return }

                    DispatchQueue.main.async {
                        do{
                            let decode = try JSONDecoder().decode(Welcome.self, from: data)
                            self.jsonData = decode
                        }catch _{
                            print("ERROR")
                        }
                    }
                }
                
            }.resume()
        }
        
    }
}
