package pl.zygadlom.budgetplanner

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainScreenFragment : Fragment() {
    
    private lateinit var currency: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_main_screen, container, false)
        currency = getCurrencyPreferencesValue().toString()
        return root
    }

    private fun getCurrencyPreferencesValue(): String? {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val defaultValue = resources.getString(R.string.usd)
        return sharedPref?.getString("currency", defaultValue)
    }
}
