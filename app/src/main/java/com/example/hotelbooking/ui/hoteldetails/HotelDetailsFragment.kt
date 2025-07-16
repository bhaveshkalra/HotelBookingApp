package com.example.hotelbooking.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hotelbooking.databinding.FragmentHotelDetailsBinding
import com.example.hotelbooking.viewmodel.HotelViewModel

class HotelDetailsFragment : Fragment() {
    private var _binding: FragmentHotelDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HotelViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHotelDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hotel = viewModel.selectedHotel
        binding.hotelNameText.text = hotel?.name
        binding.hotelLocationText.text = hotel?.location
        binding.hotelRatingText.text = "Rating: ${hotel?.rating}"
        binding.hotelPriceText.text = "Price: ₹${hotel?.price}"

        binding.bookNowButton.setOnClickListener {
            hotel?.let { viewModel.bookHotel(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}