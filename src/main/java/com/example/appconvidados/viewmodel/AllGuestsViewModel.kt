package com.example.appconvidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: GuestRepository = GuestRepository(application.applicationContext)
    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun getAll(){
        listAllGuests.value = repository.getAll()
    }

    fun remove(id: Int){
        repository.remove(id)
    }
}