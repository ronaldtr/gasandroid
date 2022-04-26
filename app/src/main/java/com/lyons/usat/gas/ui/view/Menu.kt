package com.lyons.usat.gas.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.google.gson.Gson
import com.lyons.usat.gas.BuildConfig
import com.lyons.usat.gas.data.model.MenuModel
import com.lyons.usat.gas.databinding.ActivityMenuBinding
import com.lyons.usat.gas.util.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : BaseActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val menus = bundle?.getString("menus")

        val gson = Gson()
        val menuModel = gson.fromJson(menus, MenuModel::class.java)

        agregarBotones(menuModel)
    }

    private fun agregarBotones(menu: MenuModel) {
        var llBotonera = binding.llBotonera

        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        menu.menus.let { it ->
            it.forEach {
                val button = Button(this)
                //Asignamos propiedades de layout al boton
                button.layoutParams = lp
                //Asignamos Texto al botón
                button.text = it.nombre
                //button.show
                //Asignamose el Listener
                button.setOnClickListener(ButtonsOnClickListenerBuy(this, it))
                //Añadimos el botón a la botonera
                llBotonera.addView(button)
            }
        }
    }
}


internal class ButtonsOnClickListenerBuy(val context: Context, private val menu: MenuModel) :
    View.OnClickListener,
    BaseActivity() {
    override fun onClick(v: View?) {
        val i = Intent()
        i.setClassName(BuildConfig.APPLICATION_ID, "com.lyons.usat.gas.ui.view.${menu.accion}")
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(i)
    }
}
