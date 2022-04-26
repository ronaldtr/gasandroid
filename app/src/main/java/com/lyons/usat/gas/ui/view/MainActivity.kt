package com.lyons.usat.gas.ui.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.button.MaterialButton
import com.google.gson.Gson
import com.lyons.usat.gas.data.model.MenuModel
import com.lyons.usat.gas.data.model.UserModel
import com.lyons.usat.gas.databinding.ActivityMainBinding
import com.lyons.usat.gas.util.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import com.lyons.usat.gas.R

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val menus = bundle?.getString("menus")

        val gson = Gson()
        val userModel = gson.fromJson(menus, UserModel::class.java)

        agregarBotones(userModel)
    }

    private fun agregarBotones(user: UserModel) {
        var llBotonera = binding.llBotonera

        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.FILL_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            1f
        )

        user.data?.menu.let { it ->
            it?.forEach {
                val button = MaterialButton(this)
                //Asignamos propiedades de layout al boton
                button.layoutParams = lp
                //Asignamos Propiedades al botón
                button.text = it.nombre
                button.setBackgroundColor(Color.WHITE)
                button.setTextColor(Color.BLACK)
                button.layoutParams = LinearLayout.LayoutParams(227, 227)

                val img: Drawable = this.resources.getDrawable(R.drawable.ic_launcher_background)
                img.setBounds(0, 0, 150, 150)
                button.setCompoundDrawables(null, img, null, null)
                //Asignamose el Listener
                button.setOnClickListener(ButtonsOnClickListenerMain(this, it))
                //Añadimos el botón a la botonera
                llBotonera.addView(button)
            }
        }
    }

    internal class ButtonsOnClickListenerMain(context: Context, menu: MenuModel) :
        View.OnClickListener,
        BaseActivity() {
        val context: Context = context
        val menu: MenuModel = menu
        override fun onClick(v: View?) {
            val gson = Gson()
            var menuString = gson.toJson(menu)

            val intent = Intent(context, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("menus", menuString)
            context.startActivity(intent)
        }
    }
}

