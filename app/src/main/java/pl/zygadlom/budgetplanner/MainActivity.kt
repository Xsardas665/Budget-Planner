package pl.zygadlom.budgetplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    fun checkIfSharedPreferencesExists(): Boolean {
        val sharedPrefs = getSharedPreferences("sp_name", MODE_PRIVATE)
        return sharedPrefs.contains("initialized")
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_container, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        if(savedInstanceState == null) {
            if (!checkIfSharedPreferencesExists()) {
                val settingsFragment = SettingsFragment()
                val manager = supportFragmentManager
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.root_container, settingsFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

    }
}