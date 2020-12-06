package es.attomic.meloappuntoeoi.Navigation

import android.support.v4.app.Fragment
import es.attomic.meloappuntoeoi.MainActivity
import es.attomic.meloappuntoeoi.R


object NavigatorFragment {

    fun replaceFragment(activity: MainActivity, fragment: Fragment, name: String, backStack: Boolean = true) {

        val navigate =  activity.supportFragmentManager?.beginTransaction()?.replace(R.id.content_frame, fragment, name)

        if(backStack){
            navigate?.addToBackStack(name)?.commit()
        } else {
            navigate?.commit()
        }

    }

    fun replaceTabFragment(activity: MainActivity, fragment: Fragment, name: String, backStack: Boolean = true) {

        val navigate =  activity.supportFragmentManager?.beginTransaction()?.replace(R.id.contentTab, fragment, name)

        if(backStack){
            navigate?.addToBackStack(name)?.commit()
        } else {
            navigate?.commit()
        }

    }

}

