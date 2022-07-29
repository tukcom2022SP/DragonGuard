////
////  ParsingJSON.swift
////  JejuTourApp
////
////  Created by 정호진 on 2022/07/29.
////
//
//import SwiftUI
//
//struct Parsing  {
//    
//    @Binding var item : [Item] 
//    
//    let apiKey = "rrq71a2rotyj9tqm"
//    let index = 1
//    
//    func getData(){
//        DispatchQueue.main.sync {
//            let urlString = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=\(apiKey)&locale=kr&page=1"
//            
//            if let url = URL(string: urlString){
//                var request = URLRequest.init(url: url)
//                request.httpMethod = "GET"
//                
//                URLSession.shared.dataTask(with: request){ data, res, err in
//                    guard let data = data else {
//                        return
//                    }
//                    
//                    if let json = try? JSONDecoder().decode(Result.self,from: data){
//                        self.item = json.items
//                    }
//                    
//                }.resume()
//            }
//        }
//    }//getData
//    
//}
