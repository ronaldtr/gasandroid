package com.lyons.usat.gas.ui.view.sales

import android.os.Bundle
import com.lyons.usat.gas.databinding.ActivityNewSaleBinding
import com.lyons.usat.gas.util.BaseActivity

class NewSaleActivity : BaseActivity() {

    private lateinit var binding: ActivityNewSaleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}