package pl.zygadlom.budgetplanner

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private fun checkIfSharedPreferencesExists(): Boolean {
        val sharedPrefs = getSharedPreferences("sp_name", MODE_PRIVATE)
        return sharedPrefs.contains("initialized")
    }

    private fun replaceFragment(fragment: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.root_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        if(savedInstanceState == null) {
            if (!checkIfSharedPreferencesExists()) {
                val settingsFragment = SettingsFragment()
                replaceFragment(settingsFragment)
            } else {
                val settingsFragment = SettingsFragment()
                replaceFragment(settingsFragment)
            }
        }

    }

    fun onClickSettingsLoad(view: View) {
        val settingsFragment = SettingsFragment()
        replaceFragment(settingsFragment)
    }
}