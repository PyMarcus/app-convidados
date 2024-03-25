package com.example.appconvidados.view

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.appconvidados.databinding.ActivityGuestFormBinding
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]
        binding.radioYes.isChecked = true
        setContentView(binding.root)

        setEventListener()
    }

    override fun onClick(v: View) {
        when(v.id){
            binding.save.id -> saveGuest()
        }
    }

    private fun setEventListener(){
        binding.save.setOnClickListener(this)
    }

    private fun saveGuest(){
        val name: String = binding.editName.text.toString()
        val present: Boolean = binding.radioYes.isChecked

        viewModel.save(GuestModel(name, present))
    }
}