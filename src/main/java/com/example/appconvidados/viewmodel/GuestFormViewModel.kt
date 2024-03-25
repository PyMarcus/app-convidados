package com.example.appconvidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private var guestRepository: GuestRepository = GuestRepository(application.applicationContext)

    fun save(guest: GuestModel){
        guestRepository.insert(guest)
    }
}