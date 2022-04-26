package com.lyons.usat.gas.ui.view.sales

import android.os.Bundle
import com.lyons.usat.gas.databinding.ActivityMySalesBinding
import com.lyons.usat.gas.util.BaseActivity

class MySalesActivity : BaseActivity() {

    private lateinit var binding: ActivityMySalesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySalesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}