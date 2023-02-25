package com.fawry.publicapis.ui.categories

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fawry.presentation.viewmodel.CategoriesState
import com.fawry.presentation.viewmodel.CategoriesViewModel
import com.fawry.publicapis.R
import com.fawry.publicapis.databinding.FragmentCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CategoriesViewModel by viewModels()

    @Inject
    lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.refresh) {
                    viewModel.getCategories()
                    return true
                }
                return false
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
        setupRecyclerView()
        categoriesAdapter.setItemClickListener { category ->
            findNavController().navigate(
                CategoriesFragmentDirections.actionCategoriesFragmentToCategoryEntriesFragment(
                    category = category.category
                )
            )
        }
    }

    private fun setupRecyclerView() = binding.recyclerView.apply {
        adapter = categoriesAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setObservers() {
        viewModel.stateObservable.observe(viewLifecycleOwner) { characterState ->
            updateView(characterState)
        }
    }

    private fun updateView(categoriesState: CategoriesState) {
        when (categoriesState) {
            is CategoriesState.Success -> {
                binding.recyclerView.isVisible = true
                binding.progressBar.isVisible = false
                categoriesAdapter.list = categoriesState.categories
            }
            is CategoriesState.Error -> {
//                showSnackBar(binding.rootView, getString(characterState.message), true)
                binding.recyclerView.isVisible = false
                binding.progressBar.isVisible = false
            }
            CategoriesState.Init -> {
                binding.recyclerView.isVisible = false
                binding.progressBar.isVisible = false
            }
            CategoriesState.Loading -> {
                binding.recyclerView.isVisible = false
                binding.progressBar.isVisible = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}