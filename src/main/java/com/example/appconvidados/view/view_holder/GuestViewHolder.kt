package com.example.appconvidados.view.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appconvidados.databinding.RowGuestBinding
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.view.listener.OnGuestListener

class GuestViewHolder(binding: RowGuestBinding,private val listener: OnGuestListener): RecyclerView.ViewHolder(binding.root) {
    // tem as referências dos elementos do layout

    private val b = binding

    fun bind(guest: GuestModel){
        b.name.text = guest.name

        b.name.setOnClickListener{
            listener.onClick(guest.id)
        }

        b.btn.setOnClickListener{
            listener.onDelete(guest.id)
        }
    }
}