package com.example.hotelbooking.ui.hotelList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelbooking.databinding.FragmentHotelListBinding
import com.example.hotelbooking.viewmodel.HotelViewModel
import com.example.hotelbooking.ui.hotelList.adapter.HotelAdapter

class HotelListFragment : Fragment() {
    private var _binding: FragmentHotelListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HotelViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHotelListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.fetchHotels()

        viewModel.hotels.observe(viewLifecycleOwner) { hotels ->
            val adapter = HotelAdapter(hotels) { selectedHotel ->
                viewModel.selectedHotel = selectedHotel
                findNavController().navigate(HotelListFragmentDirections.actionHotelListFragmentToHotelDetailsFragment())
            }
            binding.hotelRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.hotelRecyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}