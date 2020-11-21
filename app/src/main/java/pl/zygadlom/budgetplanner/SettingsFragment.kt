package pl.zygadlom.budgetplanner

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment  : Fragment() {

    private val fTAG: String? = "SETTINGS_FRAGMENT"
    private var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton

    private fun setMainScreenFragment(){
        Log.i(fTAG, "setMainScreenFragment: MainScreenLoaded")
        val mainScreenFragment = MainScreenFragment()
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.root_container, mainScreenFragment, "findThisFragment")
                ?.addToBackStack(null)
                ?.commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val button = root.findViewById(R.id.btSave) as Button
        radioGroup = root.findViewById(R.id.currencyRadioGroup) as RadioGroup
        setSaveButtonListener(root, button)
        return root
    }

    private fun setSaveButtonListener(view: View, saveButton: Button) {
        saveButton.setOnClickListener {
            savePreferences()
            getCurrency(view)
            //setMainScreenFragment()
        }
    }

    private fun getCurrency(view: View) {
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId
        radioButton = view.findViewById(selectedOption)
        Log.i(fTAG, "getCurrency: "+ radioButton.text)

    }

    private fun savePreferences() {
        Log.i(fTAG, "savePreferences: SavePreferencesButton Clicked")
    }

}