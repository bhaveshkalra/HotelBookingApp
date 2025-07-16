package com.example.hotelbooking.data.api

import com.example.hotelbooking.data.model.Hotel
import retrofit2.http.GET

/**
 * Retrofit API – HotelApiService.kt*/

interface HotelApiService {
    @GET("69f2db3c-3cc5-43c2-b1d8-0868bdbfb17a")
    suspend fun getHotels(): List<Hotel>
}