package com.cccinfotech.logindemomvvm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cccinfotech.logindemomvvm.databinding.FragmentLoginBinding
import com.cccinfotech.logindemomvvm.model.LoginRequest
import com.cccinfotech.logindemomvvm.utils.NetworkResult
import com.cccinfotech.logindemomvvm.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var binding : FragmentLoginBinding?=null
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container, false)


        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding?.btnLogin?.setOnClickListener {

            val validateResult = validUserMobilePassword()
            if (validateResult.first)
            {

                authViewModel.loginUser(getUserRequest())

                 loginAPIcall()

            }
            else{
                binding!!.errorMessage.text=validateResult.second
            }




        }*/

        binding?.etMobile?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                val textLength = s?.length ?: 0
                if (textLength == 10) {


                    // Trigger your observer here

                    mobileValidation()

                }
            }
        })




    }

    /*private fun loginAPIcall() {

        val validateResult = validUserMobilePassword()

        if (validateResult.first)
        {

            authViewModel.loginUser(getUserRequest())
           callUser()

        }
        else{
            binding!!.errorMessage.text=validateResult.second
        }




    }*/

    /*private fun callUser() {


        authViewModel.userResponseLiveData.observe(viewLifecycleOwner) {
            // binding?.progressBar?.isVisible  = false  // hide progress bar
            when (it) {
                is NetworkResult.Success -> {



                    // findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                   findNavController().navigate(R.id.action_loginFragment_to_mainFragment)


                }
                is NetworkResult.Error -> {

                    binding?.errorMessage?.text = it.message
                }
                is NetworkResult.Loading -> {
                    //binding?.progressBar?.isVisible  =true // show progress bar
                }
            }


        }




    }*/

    private fun mobileValidation(){

        val validateResult = validUserInput()
        if (validateResult.first)
        {

            authViewModel.loginUser(getUserRequest())
            bindObservers()

        }
        else{
            binding!!.errorMessage.text=validateResult.second
        }



    }

   /* private fun validUserMobilePassword(): Pair<Boolean, String> {
        val userRequest = inputUserRequest()
        return authViewModel.validateCredentials(userRequest.Mobile.toString(),userRequest.Password.toString())
    }*/

    /*private fun inputUserRequest(): LoginRequest {
        val userMobile = binding?.etMobile?.text.toString()
        val userPassword = binding?.etMobile?.text.toString()
        return LoginRequest(userMobile,userPassword)
    }*/


    private fun getUserRequest(): LoginRequest {
        val userMobile = binding?.etMobile?.text.toString()

        return LoginRequest(userMobile)

    }
    private fun validUserInput(): Pair<Boolean, String> {

        val userRequest = getUserRequest()
        return authViewModel.mobileValidation(userRequest.Mobile.toString())
    }


    private fun bindObservers() {

        authViewModel.userResponseLiveData.observe(viewLifecycleOwner) {
           // binding?.progressBar?.isVisible  = false  // hide progress bar
            when (it) {
                is NetworkResult.Success -> {

                 binding?.companyCodeLayout?.visibility = View.GONE
                 binding?.hidePassword?.visibility = View.VISIBLE


                }
                is NetworkResult.Error -> {

                    binding?.errorMessage?.text = it.message
                }
                is NetworkResult.Loading -> {
                    //binding?.progressBar?.isVisible  =true // show progress bar
                }
            }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}