package com.wizeline.heroes.Network

import com.wizeline.heroes.Characters
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroesServicesCorrutina {
    @GET("characters")
    suspend fun nameStartsWith(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("nameStartsWith")name:String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Characters
}