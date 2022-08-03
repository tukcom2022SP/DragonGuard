//
//  FirstNotice.swift
//  montak
//
//  Created by 정호진 on 2022/08/02.
//

import SwiftUI

struct FirstNotice: View {
    var body: some View {
        VStack {
            
            ZStack {
                Image("textbar")
                    .resizable()
                    .frame(width: 230, height: 60)
                .padding(.leading)
                
                Text("[몬딱, 제주]")
                    .padding(.leading)
                    .font(Font.custom("BinggraeSamanco-Bold",size:30))
            }
            Spacer()
                .frame(height:20)
            Text("""
                 - '몬딱, 제주'는 '모두 함께, 제주'라는 뜻의 제주 방언입니다. 육지에 사는 당신이 아름다운 섬 제주도를 만끽할 수 있도록 여러가지 정보를 제공합니다.
                
                 - 아래의 각 버튼을 클릭하면 정보가 나옵니다. 먹거리, 놀거리, 볼거리와 쉴 곳이 가득한 제주에서 당신의 인생에 쉼표를 찍어보세요.

                 - 먹거리에는 식당과 카페, 놀멍에는 테마여행과 쇼핑, 볼거리에는 축제 및 행사 정보, 쉴멍에는 숙박업소 정보가 있습니다.

                 - 이 앱의 정보는 제주관광공사의 오픈API를 받아서 제작했습니다.
                """)
                .padding(.leading)
                .font(Font.custom("BinggraeSamanco-Bold",size:20))
            
        }
    }
}

struct FirstNotice_Previews: PreviewProvider {
    static var previews: some View {
        FirstNotice()
    }
}
