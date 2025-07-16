package com.example.hotelbooking.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookingDao {
    @Insert
    suspend fun insertBooking(booking: Booking)

    @Query("SELECT * FROM Booking")
    suspend fun getAllBookings(): List<Booking>
}