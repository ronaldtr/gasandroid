package com.lyons.usat.gas.ui.view.buys

import android.os.Bundle
import com.lyons.usat.gas.databinding.ActivityNewPurchaseBinding
import com.lyons.usat.gas.util.BaseActivity

class NewPurchaseActivity : BaseActivity() {

    private lateinit var binding: ActivityNewPurchaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}