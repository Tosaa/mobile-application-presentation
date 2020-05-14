package com.example.livedatapresentation.tshirt

class TShirt(
    val color: String,
    val size: String
) {
    val id = id_counter++

    companion object{
        private var id_counter = 0
    }
}