//
//  test.swift
//  montak
//
//  Created by 정호진 on 2022/08/07.
//

import SwiftUI

struct test: View {
    var body: some View {
        KakaoMap()
            .frame(width: 200, height: 100)
    }
}

struct test_Previews: PreviewProvider {
    static var previews: some View {
        test()
    }
}
