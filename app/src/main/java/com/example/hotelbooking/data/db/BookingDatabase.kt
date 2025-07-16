package com.example.hotelbooking.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Booking::class], version = 1)
abstract class BookingDatabase : RoomDatabase() {
    abstract fun bookingDao(): BookingDao

    companion object {
        private var INSTANCE: BookingDatabase? = null
        fun getDatabase(context: Context): BookingDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    BookingDatabase::class.java,
                    "hotel_booking_db"
                ).build()
                INSTANCE!!
            }
        }
    }
}