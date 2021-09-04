package com.light.hogwartslibrary.ui.scenes.hat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.light.hogwartslibrary.R
import com.light.hogwartslibrary.databinding.ActivityHatBinding
import com.light.hogwartslibrary.databinding.ActivityMainBinding
import com.light.hogwartslibrary.helpers.Keys
import com.light.hogwartslibrary.ui.scenes.main.MainActivity

class HatActivity : AppCompatActivity() {

    private lateinit var hatViewModel: HatViewModel

    private lateinit var binding: ActivityHatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hatViewModel = ViewModelProvider(this).get(HatViewModel::class.java)

        binding.textWelcomeUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                hatViewModel.applyUserName(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.btnWelcomeSelected.setOnClickListener {
            if (binding.btnWelcomeSelected.text == getString(R.string.welcome_next)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                hatViewModel.getFacultyName()
            }

        }

        setupFaculty(viewModel = hatViewModel)
        setupLoading(viewModel = hatViewModel)

    }

    private fun setupFaculty(viewModel: HatViewModel) {
        viewModel.facultyName.observe(this, { facultyName ->
            if (facultyName.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences(getString(R.string.app_name), 0)
                sharedPreferences.edit()
                    .putString(Keys.Username.value, binding.textWelcomeUsername.text.toString())
                    .putString(Keys.Faculty.value, facultyName)
                    .apply()
                binding.txtWelcomeSelected.text =
                    getString(R.string.welcome_selected).replace("[faculty_name]", facultyName)
                binding.txtWelcomeSelected.visibility = View.VISIBLE
                binding.textWelcomeUsername.isEnabled = false
                binding.btnWelcomeSelected.text = getString(R.string.welcome_next)
            }

        })
    }

    private fun setupLoading(viewModel: HatViewModel) {
        viewModel.isLoading.observe(this, { isLoading ->
            binding.btnWelcomeSelected.isEnabled = !isLoading
            binding.textWelcomeUsername.isEnabled = !isLoading
            if (isLoading) {
                binding.btnWelcomeSelected.text = getString(R.string.welcome_selecting)
            }
        })
    }
}