package com.example.aviationsystem.fragments

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.aviationsystem.databinding.FragmentHomepageBinding
import com.example.aviationsystem.City
import com.example.aviationsystem.RouteApplication
import com.example.aviationsystem.databinding.FragmentAddpageBinding
import com.example.aviationsystem.datastructures.Edge
import com.example.aviationsystem.datastructures.Graph
import com.example.aviationsystem.viewmodel.RouteViewModel
import com.example.aviationsystem.viewmodel.RouteViewModelFactory


class AddpageFragment : Fragment() {

    // To share the view  model accross fragments
    private val viewModel: RouteViewModel by activityViewModels {
        RouteViewModelFactory(
            (activity?.application as RouteApplication).database.routeDao()
        )
    }

    private var _binding: FragmentAddpageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) : View? {
        _binding = FragmentAddpageBinding.inflate(inflater, container, false)
        Log.e("HomePage", "OnCreateView called")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    // Called before fragment is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }

}