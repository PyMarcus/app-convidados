package com.example.appconvidados.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.appconvidados.databinding.ActivityGuestFormBinding
import com.example.appconvidados.models.GuestModel
import com.example.appconvidados.view.adapter.GuestAdapter
import com.example.appconvidados.viewmodel.AllGuestsViewModel
import com.example.appconvidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel
    private var guestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]
        binding.radioYes.isChecked = true
        setContentView(binding.root)


        viewModel.guest.observe(this){
            if(it != null){
                println("OKOKO "+ guestId)
                if(guestId == -1) {
                    binding.editName.setText(it.name)
                    if (it.presence) {
                        binding.radioYes.isChecked = true
                    } else {
                        binding.radioNot.isChecked = true
                    }
                }
            }else{
                guestId = 0
            }
        }

        setEventListener()
        loadData()
    }

    override fun finish() {
        super.finish()

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

        if(guestId == -1){
            viewModel.update(viewModel.guest.value!!.id, name, present)
        }else{
            viewModel.save(GuestModel(name, present))
        }
        finish()
    }

    private fun loadData(){
        var i = intent.getIntExtra("guestid", -1)
        guestId = -1
        viewModel.getOne(i)
    }




}