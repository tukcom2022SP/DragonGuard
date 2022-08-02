//
//  Created by 정호진 on 2022/07/29.
//
import SwiftUI
import Foundation

class Parsing: ObservableObject{
    @Published var decodedItem : [Item] = [Item.ItemSample]
    let apiKey = "rrq71a2rotyj9tqm"

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
                        self.decodedItem = decodedData.items
                    } catch let error {
                        print("Error decoding: ", error)
                    }
                }   //thread
            } // if문
        }//daskTask
        daskTask.resume()
    }//getData
    
    func getItemInfo() -> [Item]{       //MainScreen으로 파싱된 데이터를 전달하는 함수
        return self.decodedItem
    }
    
}
