package com.example.appconvidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appconvidados.databinding.RowGuestBinding
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.view.listener.OnGuestListener
import com.example.appconvidados.view.view_holder.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>(){
    private var guestList: List<GuestModel> = listOf()
    private lateinit var listener: OnGuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        // cria o layout (item a item)
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        // faz a cola, ou seja, envia o item para o layout
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        // tamanho da lista
        return guestList.count()
    }

    fun updateGuests(list: List<GuestModel>){
        guestList = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener: OnGuestListener){
        listener = guestListener
    }
}