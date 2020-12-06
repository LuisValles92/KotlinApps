package es.attomic.meloappuntoeoi.Fragments


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.*
import es.attomic.meloappuntoeoi.Navigation.NavigationChildFragment
import es.attomic.meloappuntoeoi.Navigation.NavigatorFragment

import es.attomic.meloappuntoeoi.R
import kotlinx.android.synthetic.main.fragment_bottom_nav.*

class BottomNavFragment : NavigationChildFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ocultar el botón de atras
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        navigation.selectedItemId = R.id.tab_todo
    }

    // Muevo esta funcion del NavigationChildFragment aqui, porque si no crea muchos menus
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        // Asignar un menu de opciones en el toolbar
        inflater?.inflate(R.menu.home_menu, menu)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                NavigatorFragment.replaceTabFragment(mainActivity, HomeFragment(), "home", false)

                return@OnNavigationItemSelectedListener true
            }
            R.id.tab_todo -> {
                NavigatorFragment.replaceTabFragment(mainActivity, TodoFragment(), "todo", false)

                return@OnNavigationItemSelectedListener true
            }
            R.id.tab_done -> {
                NavigatorFragment.replaceTabFragment(mainActivity, DoneFragment(), "done", false)

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
