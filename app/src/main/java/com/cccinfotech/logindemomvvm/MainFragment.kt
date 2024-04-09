package com.cccinfotech.logindemomvvm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.cccinfotech.logindemomvvm.databinding.FragmentLoginBinding
import com.cccinfotech.logindemomvvm.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var binding : FragmentMainBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(inflater,container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Handle back press in the Dashboard Fragment
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Move the task containing this activity to the back of the stack
            requireActivity().moveTaskToBack(true)
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}