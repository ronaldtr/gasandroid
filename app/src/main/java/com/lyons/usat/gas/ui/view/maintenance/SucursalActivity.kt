package com.lyons.usat.gas.ui.view.maintenance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.lyons.usat.gas.databinding.ActivitySucursalBinding
import com.lyons.usat.gas.ui.viewmodel.SucursalViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SucursalActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySucursalBinding

    private val sucursalViewModel: SucursalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySucursalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sucursalViewModel.onCreate()

    }
}