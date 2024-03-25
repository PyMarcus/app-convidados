package com.example.appconvidados.repository

import android.content.Context
import com.example.appconvidados.database.GuestDatabase
import com.example.appconvidados.models.GuestModel

class GuestRepository(context: Context){
    private val guestDatabase: GuestDAO = GuestDatabase.getDatabase(context).guestDAO()

    fun insert(guest: GuestModel){
        guestDatabase.insert(guest)
    }

    fun getAll(): List<GuestModel>{
        return guestDatabase.getAll()
    }

    fun get(id: Int) : GuestModel{
        return guestDatabase.get(id)
    }

    fun getPresents() : List<GuestModel>{
        return guestDatabase.getPresents()
    }

    fun getAbsent(): List<GuestModel>{
        return guestDatabase.getAbsent()
    }

    fun update(guest: GuestModel){
        guestDatabase.update(guest)
    }

    fun remove(id: Int){
        val g = get(id)
        guestDatabase.remove(g)
    }
}