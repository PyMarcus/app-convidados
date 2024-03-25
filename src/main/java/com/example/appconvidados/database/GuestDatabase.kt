package com.example.appconvidados.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.repository.GuestDAO


@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDatabase: RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object{
        private lateinit var INSTANCE: GuestDatabase

        fun getDatabase(context: Context): GuestDatabase{
            if(!::INSTANCE.isInitialized){
                synchronized(GuestDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, GuestDatabase::class.java, "guest_db")
                        .allowMainThreadQueries().addMigrations(MIGRATIONS_1_2).build()
                }
            }
            return INSTANCE
        }

        private val MIGRATIONS_1_2: Migration = object : Migration(1, 2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM guest")
            }

        }
    }
}