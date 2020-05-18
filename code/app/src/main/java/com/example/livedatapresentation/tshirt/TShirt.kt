package com.example.livedatapresentation.tshirt

import timber.log.Timber
import kotlin.random.Random

class TShirt(
    val color: String,
    val size: String
) {
    val id = id_counter++

    companion object {
        fun createRandom(): TShirt {
            val randomSize = Random.nextInt(0, 7)
            val size = listOf<String>("xxs", "xs", "s", "m", "l", "xl", "xxl")[randomSize]
                .toUpperCase()
            var color = "#"
            for (i in 0..5) {
                color = color.plus(Integer.toHexString(Random.nextInt(0, 15)))
            }
            Timber.d("create random T-Shirt with $color , $size")
            return TShirt(color, size)
        }

        private var id_counter = 0
    }
}