package com.example.myapp.NavigationDrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.myapp.Fragment.PerfilFragment
import com.example.myapp.Fragment.ListaFragment
import com.example.myapp.Fragment.usuarioGlobal
import com.example.myapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.activity_navigation_drawer.btRosa
import kotlinx.android.synthetic.main.activity_navigation_drawer.btVerde
import kotlinx.android.synthetic.main.drawer_header.view.*
import kotlinx.android.synthetic.main.drawer_header.view.dhFoto

class NavigationDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        var usuario = crearUsuario()
        usuarioGlobal.usuario=usuario
        initDrawer(usuario)

        mostrarFragment()
    }

    private fun crearUsuario(): Perfil {
        var usuario = Perfil(
            "LUIS VP",
            "https://static.adweek.com/adweek.com-prod/wp-content/uploads/sites/2/2015/02/shutterstock_106771871.jpg",
            "luisvalles1192@gmail.com"
        )
        return usuario
    }

    private fun initDrawer(usuario: Perfil) {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.app_name,
            R.string.app_name
        )
        drawer.addDrawerListener(toggle)
        navigation.setNavigationItemSelectedListener {
            var title = ""
            var fragment: Fragment? = null
            when (it.itemId) {
                R.id.nav_perfil -> {
                    title = "Perfil"
                    fragment = PerfilFragment()
                    usuarioGlobal.usuario = usuario
                }
                R.id.nav_listado -> {
                    title = "Listado"
                    fragment = ListaFragment()
                }
                else -> {
                }
            }
            fragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }

            setTitle(title)
            it.isChecked = true
            drawer.closeDrawer(GravityCompat.START)
            true
        }
        toggle.syncState()

        val header = navigation.getHeaderView(0)
        header.dhNombre.text = usuario.nombreUser
        Picasso.get().load(usuario.fotoURLUser).into(header.dhFoto)
        header.dhCorreo.text = usuario.correoUser

        header.dhFoto.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra("usuario", usuario)
            startActivityForResult(intent, 370)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 370) {
            val header = navigation.getHeaderView(0)
            val usuario = data?.extras?.getSerializable("usuario") as Perfil
            header.dhNombre.text = usuario.nombreUser
            Picasso.get().load(usuario.fotoURLUser).into(header.dhFoto)
            header.dhCorreo.text = usuario.correoUser
        }
    }

    private fun mostrarFragment() {

        btRosa.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    PerfilFragment()
                )
                .commit()
        }

        btVerde.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    ListaFragment()
                )
                .commit()
        }
    }
}
