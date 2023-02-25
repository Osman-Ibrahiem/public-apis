package com.fawry.publicapis.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.fawry.presentation.viewmodel.CategoriesState
import com.fawry.presentation.viewmodel.CategoriesViewModel
import com.fawry.publicapis.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CategoriesViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
    }

    private fun setObservers() {
        viewModel.stateObservable.observe(this) { categoriesState ->
            updateView(categoriesState)
        }
//        viewModel.getCharacters()
    }

    private fun updateView(categoriesState: CategoriesState) {
        when (categoriesState) {
            is CategoriesState.Success -> {
                binding.progressBar.isVisible = false
                binding.textView.isVisible = true
                binding.textView.text = categoriesState.categories.joinToString { it.category }
            }
            is CategoriesState.Error -> {
                binding.progressBar.isVisible = false
                binding.textView.isVisible = true
                binding.textView.text = getString(categoriesState.message)
            }
            CategoriesState.Init -> {
                binding.textView.isVisible = false
                binding.progressBar.isVisible = false
            }
            CategoriesState.Loading -> {
                binding.progressBar.isVisible = true
                binding.textView.isVisible = false
            }
        }
    }

}