//
//  ContentView.swift
//  JejuTourApp
//
//  Created by 정호진 on 2022/07/27.
//

import SwiftUI

struct ContentView: View {
    
    @State var item: [Item] = []
    
    
    let apiKey = ""
    let index = 1
    func getData(){
//        DispatchQueue.global(qos: .userInteractive).sync {
            let urlString = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=\(apiKey)&locale=kr&page=1"
            
            if let url = URL(string: urlString){
                var request = URLRequest.init(url: url)
                request.httpMethod = "GET"
                
                URLSession.shared.dataTask(with: request){ data, res, err in
                    guard let data = data else { return }
                    
                    if let json = try? JSONDecoder().decode(Result.self,from: data){
                        self.item = json.items
                    }
                    
                }.resume()
//            }
        }
    }//getData
    
    
    var body: some View {
    
        VStack{
            Text("hello \(item[0].title)")
            
        }.onAppear(perform: getData)
    
    }

}





struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
        
    }
}
