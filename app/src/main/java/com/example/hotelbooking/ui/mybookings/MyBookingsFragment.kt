package com.example.hotelbooking.ui.bookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelbooking.databinding.FragmentMyBookingsBinding
import com.example.hotelbooking.viewmodel.HotelViewModel
import kotlinx.coroutines.launch

class MyBookingsFragment : Fragment() {
    private var _binding: FragmentMyBookingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HotelViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyBookingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            val bookings = viewModel.getBookings()
            binding.bookingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.bookingRecyclerView.adapter = BookingAdapter(bookings)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}