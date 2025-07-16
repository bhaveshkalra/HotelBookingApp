package com.example.hotelbooking.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Booking(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val hotelName: String,
    val location: String,
    val price: Int
)