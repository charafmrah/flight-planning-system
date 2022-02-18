package com.example.aviationsystem.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aviationsystem.databinding.FragmentHomepageBinding
import com.example.aviationsystem.City
import com.example.aviationsystem.databinding.FragmentAddpageBinding
import com.example.aviationsystem.databinding.FragmentListBinding
import com.example.aviationsystem.datastructures.Edge
import com.example.aviationsystem.datastructures.Graph


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) : View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        Log.e("HomePage", "OnCreateView called")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}