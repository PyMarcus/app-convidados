package com.example.appconvidados.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appconvidados.models.GuestModel

@Dao
interface GuestDAO {

    @Query("SELECT * FROM guest")
    fun getAll() : List<GuestModel>

    @Query("SELECT * FROM guest WHERE id = :id")
    fun get(id: Int) : GuestModel

    @Query("SELECT * FROM guest WHERE presence = 1")
    fun getPresents() : List<GuestModel>

    @Query("SELECT * FROM guest WHERE presence = 0")
    fun getAbsent(): List<GuestModel>

    @Insert
    fun insert(guest: GuestModel)

    @Update
    fun update(guest: GuestModel)

    @Delete
    fun remove(guest: GuestModel)

}