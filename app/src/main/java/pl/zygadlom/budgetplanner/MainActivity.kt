package pl.zygadlom.budgetplanner

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private val sTAG = "Main_Activity"

    private fun checkIfSharedPreferencesExists(): Boolean {
        val sharedPrefs = getPreferences(Context.MODE_PRIVATE)
        return sharedPrefs.contains("currency")
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
        val button = findViewById<ImageView>(R.id.settings_IV)
        button.setOnClickListener { onClickSettingsLoad() }
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

    private fun onClickSettingsLoad() {
        val settingsFragment = SettingsFragment()
        Log.i(sTAG, "onClickSettingsLoad: settingsButtonPressed")
        replaceFragment(settingsFragment)
    }
}