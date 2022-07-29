//
//  ContentView.swift
//  JejuTourApp
//
//  Created by 정호진 on 2022/07/27.
//

import SwiftUI

struct ContentView: View {
    
    @State var result: [Result] = []
    
    let apiKey = "rrq71a2rotyj9tqm"
    func getData(){
            let urlString = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=\(apiKey)&locale=kr&page=1"
            
            if let url = URL(string: urlString){
                var request = URLRequest.init(url: url)
                request.httpMethod = "GET"
                
                URLSession.shared.dataTask(with: request){ data, res, err in
                    guard let data = data else { return }
                    
                    if let json = try? JSONDecoder().decode(Result.self,from: data){
                        self.result.append(json)
                        print(result[0].items[99].title)
                        
                        /*
                         함수 내부에서 print하는 경우 오류가 발생하지 않지만
                         함수 외부나 ui에 적용하는 경우 thread1 out of range 발생
                            -> 데이터값을 찾지 못하는 것 같음
                         */
                        
                    }
                }.resume()
        }
    }//getData
    
    
    var body: some View {
    
        VStack{
            Text("HEllo")
            
        }.onAppear(perform: getData)
    
    }

}





struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
        
    }
}
