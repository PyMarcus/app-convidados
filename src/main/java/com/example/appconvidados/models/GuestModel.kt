package com.example.appconvidados.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "guest")
class GuestModel(name: String, presence: Boolean){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Int = 0

    @ColumnInfo(name="name")
    var name: String = name

    @ColumnInfo(name="presence")
    var presence: Boolean = presence

}