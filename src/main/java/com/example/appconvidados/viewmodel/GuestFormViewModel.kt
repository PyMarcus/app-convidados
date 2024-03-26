package com.example.appconvidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private var guestRepository: GuestRepository = GuestRepository(application.applicationContext)
    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    var allGuests: LiveData<List<GuestModel>> = listAllGuests

    fun save(guest: GuestModel){
        guestRepository.insert(guest)
    }

    fun getAll() {
        listAllGuests.value = guestRepository.getAll()
    }
}