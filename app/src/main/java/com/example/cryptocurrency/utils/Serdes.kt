package com.example.cryptocurrency.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*

/**
 * Objects for common serialization / deserialization
 */
object Serdes {
    val moshi: Moshi by lazy {
        return@lazy Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
    }
}