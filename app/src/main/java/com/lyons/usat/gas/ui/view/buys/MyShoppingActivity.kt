package com.lyons.usat.gas.ui.view.buys

import android.os.Bundle
import com.lyons.usat.gas.databinding.ActivityMyShoppingBinding
import com.lyons.usat.gas.util.BaseActivity

class MyShoppingActivity : BaseActivity() {

    private lateinit var binding: ActivityMyShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}