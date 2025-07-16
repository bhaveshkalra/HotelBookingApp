package com.example.hotelbooking.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.hotelbooking.data.api.HotelApiService
import com.example.hotelbooking.data.db.Booking
import com.example.hotelbooking.data.db.BookingDatabase
import com.example.hotelbooking.data.model.Hotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HotelViewModel(application: Application) : AndroidViewModel(application) {

    private val _hotels = MutableLiveData<List<Hotel>>()
    val hotels: LiveData<List<Hotel>> = _hotels

    var selectedHotel: Hotel? = null

    private val db = BookingDatabase.getDatabase(application)
    private val dao = db.bookingDao()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(HotelApiService::class.java)

    fun fetchHotels() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.getHotels()
                _hotels.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun bookHotel(hotel: Hotel) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertBooking(
                Booking(hotelName = hotel.name, location = hotel.location, price = hotel.price)
            )
        }
    }

    suspend fun getBookings(): List<Booking> {
        return dao.getAllBookings()
    }
}