package com.example.supplifyz.Domain

import java.io.Serializable

data class ItemsModel(
    var title: String = "",
    var description: String = "",
    var thumbnail: String = "",
    var picUrl: String = "",
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0,
    var extra: String = "",
) : Serializable
