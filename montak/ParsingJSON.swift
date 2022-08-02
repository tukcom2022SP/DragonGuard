//
//  Created by 정호진 on 2022/07/29.
//
import SwiftUI
import Foundation

class Parsing: ObservableObject{

    @Published var data:Result = Result.sample
    @Published var decodedItem : [Item] = [Item.ItemSample]
    

    let apiKey = ""

    func getData(){
        let urlString = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=\(apiKey)&locale=kr&page=1"

        guard let url = URL(string: urlString)else{print("url 찾을 수 없음"); return}
        var request = URLRequest.init(url: url)
        request.httpMethod = "GET"

        let daskTask = URLSession.shared.dataTask(with: request){ data, res, err in
            if let err = err{ print("Error!",err); return }
            guard data != nil else { print("data 없음"); return }

            guard let res = res as? HTTPURLResponse else { return }

            if res.statusCode == 200 {
                guard let data = data else { return }
                DispatchQueue.main.async {
                    do {
                        let decodedData = try JSONDecoder().decode(Result.self, from: data)
                        self.data = decodedData
                        self.decodedItem = decodedData.items
                    } catch let error {
                        print("Error decoding: ", error)
                    }
                }
            }

        }
            daskTask.resume()
    }//getData
    
    func getItemInfo() -> [Item]{
        return self.decodedItem
    }
    
}
