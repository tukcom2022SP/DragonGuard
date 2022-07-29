//
//  jsonDecode.swift
//  JejuTourApp
//
//  Created by 정호진 on 2022/07/28.

import Foundation

struct Result: Codable {
    let result, resultMessage: String
    let totalCount, resultCount, pageSize, pageCount: Int
    let currentPage: Int
    let items: [Item]
}

struct Item: Codable {
    let alltag: String?
    let contentsid: String
    let contentscd: Contentscd
    let title: String
    let region1CD, region2CD: Contentscd?
    let address, roadaddress, tag, introduction: String?
    let latitude, longitude: Double?
    let postcode, phoneno: String?
    let repPhoto: RepPhoto?

    enum CodingKeys: String, CodingKey {
        case alltag, contentsid, contentscd, title
        case region1CD = "region1cd"
        case region2CD = "region2cd"
        case address, roadaddress, tag, introduction, latitude, longitude, postcode, phoneno, repPhoto
    }
}

struct Contentscd: Codable {
    let value, label, refID: String

    enum CodingKeys: String, CodingKey {
        case value, label
        case refID = "refId"
    }
}

struct RepPhoto: Codable {
    let descseo: String
    let photoid: Photoid
}

struct Photoid: Codable {
    let photoid: Int
    let imgpath, thumbnailpath: String
}
