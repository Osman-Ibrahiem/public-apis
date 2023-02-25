package com.fawry.publicapis.ui.entries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.fawry.presentation.viewmodel.EntriesState
import com.fawry.presentation.viewmodel.EntriesViewModel
import com.fawry.publicapis.databinding.FragmentCategoryEntriesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CategoryEntriesFragment : Fragment() {

    private var _binding: FragmentCategoryEntriesBinding? = null
    private val binding get() = _binding!!

    private val args: CategoryEntriesFragmentArgs by navArgs()

    private val viewModel: EntriesViewModel by viewModels()

    @Inject
    lateinit var entriesAdapter: EntriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryEntriesBinding.inflate(inflater, container, false)
        viewModel.getEntries(args.category)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
        setupRecyclerView()
        entriesAdapter.setItemClickListener { entry ->
            findNavController().navigate(
                CategoryEntriesFragmentDirections.actionCategoryEntriesFragmentToPhoneDialog(
                    link = entry.link
                )
            )
        }
    }

    private fun setupRecyclerView() = binding.recyclerView.apply {
        adapter = entriesAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setObservers() {
        viewModel.stateObservable.observe(viewLifecycleOwner) { entriesState ->
            updateView(entriesState)
        }
    }

    private fun updateView(entriesState: EntriesState) {
        when (entriesState) {
            is EntriesState.Success -> {
                binding.recyclerView.isVisible = true
                binding.progressBar.isVisible = false
                entriesAdapter.list = entriesState.entries
            }
            is EntriesState.Error -> {
//                showSnackBar(binding.rootView, getString(characterState.message), true)
                binding.recyclerView.isVisible = false
                binding.progressBar.isVisible = false
            }
            EntriesState.Init -> {
                binding.recyclerView.isVisible = false
                binding.progressBar.isVisible = false
            }
            EntriesState.Loading -> {
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