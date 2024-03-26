package com.example.appconvidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appconvidados.databinding.FragmentAllGuestsBinding
import com.example.appconvidados.view.adapter.GuestAdapter
import com.example.appconvidados.view.listener.OnGuestListener
import com.example.appconvidados.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null
    private lateinit var viewModel: AllGuestsViewModel
    private val binding get() = _binding!!
    private var guestAdapter: GuestAdapter = GuestAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // recycle layout
        binding.recycleAllGuests.layoutManager = LinearLayoutManager(context)

        // recycle adapter
        binding.recycleAllGuests.adapter = guestAdapter

        val listener = object : OnGuestListener{
            override fun onClick(id: Int) {
                TODO("Not yet implemented")
            }

            override fun onDelete(id: Int) {
                viewModel.remove(id)
                viewModel.getAll()
            }
        }

        // associa adapter ao listener para separar responsabilidades
        guestAdapter.attachListener(listener)

        // view model
        viewModel.getAll()

        observe()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe(){
        viewModel.guests.observe(viewLifecycleOwner) {
            guestAdapter.updateGuests(it)
        }
    }

    fun refreshGuestList() {
        viewModel.getAll()
    }
}