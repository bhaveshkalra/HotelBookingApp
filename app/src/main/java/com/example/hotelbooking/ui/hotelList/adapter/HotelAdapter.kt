package com.example.hotelbooking.ui.hotelList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelbooking.data.model.Hotel
import com.example.hotelbooking.databinding.ItemHotelBinding

class HotelAdapter(
    private val hotels: List<Hotel>,
    private val onHotelClick: (Hotel) -> Unit
) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    inner class HotelViewHolder(val binding: ItemHotelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val binding = ItemHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotels[position]
        holder.binding.apply {
            hotelName.text = hotel.name
            hotelLocation.text = hotel.location
            hotelPrice.text = "₹${hotel.price} / night"

            root.setOnClickListener {
                onHotelClick(hotel)
            }
        }
    }

    override fun getItemCount() = hotels.size
}
