package es.attomic.meloappuntoeoi.Navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import es.attomic.meloappuntoeoi.Fragments.DoneFragment
import es.attomic.meloappuntoeoi.Fragments.LoginFragment
import es.attomic.meloappuntoeoi.Fragments.TodoFragment
import es.attomic.meloappuntoeoi.MainActivity
import es.attomic.meloappuntoeoi.R

abstract class NavigationChildFragment : Fragment() {

    lateinit var mAuth: FirebaseAuth
    lateinit var mainActivity: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        mainActivity = activity as MainActivity
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when {
            item.itemId == android.R.id.home -> {
                mainActivity.onBackPressed()
                return true
            }
            item.itemId == R.id.logout -> {

                // Cerrar sesión
                mAuth.signOut()
                NavigatorFragment.replaceFragment(mainActivity, LoginFragment(), "Login", false)
                return true
            }
            item.itemId == R.id.done -> {
                // Ir a la pantall de tareas hechas
                NavigatorFragment.replaceFragment(mainActivity, DoneFragment(), "Done", false)
                return true
            }
            item.itemId == R.id.todo -> {
                // Ir a la pantall de tareas por hacer
                NavigatorFragment.replaceFragment(mainActivity, TodoFragment(), "Todo", false)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

}

