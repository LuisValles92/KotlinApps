package com.example.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.Fragment.FragmentActivity
import com.example.myapp.Fragment2.Fragment2Activity
import com.example.myapp.Horario.HorarioActivity
import com.example.myapp.NavigationDrawer.NavigationDrawerActivity
import com.example.myapp.Tab.TabActivity
import com.example.myapp.album.AlbumActivity
import com.example.myapp.calculadora.calculadoraActivity
import com.example.myapp.dado.DadoActivity
import com.example.myapp.firebase.firebaseActivity
import com.example.myapp.horas.horasActivity
import com.example.myapp.juego.juegoActivity
import com.example.myapp.suma.sumaActivity
import com.example.myapp.superheroes.superheroesActivity
import com.example.myapp.wallapop.WallapopActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonsuma.setOnClickListener{
            val intent= Intent(this, sumaActivity::class.java)
            startActivity(intent)
        }

        botonhoras.setOnClickListener{
            val intent= Intent(this, horasActivity::class.java)
            startActivity(intent)
        }

        botonjuego.setOnClickListener{
            val intent= Intent(this, juegoActivity::class.java)
            startActivity(intent)
        }

        botondado.setOnClickListener{
            val intent= Intent(this, DadoActivity::class.java)
            startActivity(intent)
        }

        botoncalculadora.setOnClickListener{
            val intent= Intent(this, calculadoraActivity::class.java)
            startActivity(intent)
        }

        botonalbum.setOnClickListener{
            val intent= Intent(this, AlbumActivity::class.java)
            startActivity(intent)
        }

        botonwallapop.setOnClickListener{
            val intent= Intent(this, WallapopActivity::class.java)
            startActivity(intent)
        }

        botondrawer.setOnClickListener{
            val intent= Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
        }

        botonfragment.setOnClickListener{
            val intent= Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        botonfragment2.setOnClickListener{
            val intent= Intent(this, Fragment2Activity::class.java)
            startActivity(intent)
        }

        botontab.setOnClickListener{
            val intent= Intent(this, TabActivity::class.java)
            startActivity(intent)
        }

        botonapphorario.setOnClickListener{
            val intent= Intent(this, HorarioActivity::class.java)
            startActivity(intent)
        }

        botonsuperheroes.setOnClickListener{
            val intent= Intent(this, superheroesActivity::class.java)
            startActivity(intent)
        }

        botonfirebase.setOnClickListener{
            val intent= Intent(this, firebaseActivity::class.java)
            startActivity(intent)
        }

    }

}
