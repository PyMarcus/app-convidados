package com.example.appconvidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private var guestRepository: GuestRepository = GuestRepository(application.applicationContext)
    private val getGuest = MutableLiveData<GuestModel>()
    var guest: LiveData<GuestModel> = getGuest

    fun save(guest: GuestModel){
        //if(guest.name != "")
        guestRepository.insert(guest)
    }

    fun update(id: Int, name: String, present: Boolean){
        val guest1 = guestRepository.get(id)
        getGuest.value = guest1
        guest1.name = name
        guest1.presence = present
        guestRepository.update(guest1)
    }

    fun getOne(id: Int){
        val guest1 = guestRepository.get(id)
        getGuest.value = guest1
    }
}