package com.udacity.project1.fragment

import android.os.Bundle
import android.view.Menu
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.project1.R
import com.udacity.project1.databinding.FragmentListshoeScreenBinding
import com.udacity.project1.databinding.InflateviewBinding
import com.udacity.project1.models.Shoe
import com.udacity.project1.models.Viewmodel
import android.view.MenuInflater
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class ListshoeScreen : Fragment() {

    private val viewmodel:Viewmodel by activityViewModels()
    private lateinit var details: FragmentListshoeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: FragmentListshoeScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_listshoe_screen,
            container,
            false)

        val view = binding.root
        binding.details = viewmodel
        binding.lifecycleOwner = this


        viewmodel.shoesList.observe(viewLifecycleOwner) { list ->
            for (shoe in list) {
                addShoeToView(container, shoe)
            }
        }
            binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_listshoeScreen_to_detailsScreen)}



        return view
    }
    private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {


        val shoeBinding: InflateviewBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.inflateview, container, false
        )
        shoeBinding.shoe = shoe
        details.shoeListLinearLayout.addView(shoeBinding.root)

    }






}