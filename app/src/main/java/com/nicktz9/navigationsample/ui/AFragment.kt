package com.nicktz9.navigationsample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nicktz9.navigationsample.R
import com.nicktz9.navigationsample.databinding.FragmentABinding
import com.nicktz9.navigationsample.ext.getBackStackData


class AFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentABinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.screenName.text = "A"
        binding.action.setOnClickListener {
            findNavController().navigate(AFragmentDirections.actionAFragmentToBFragment(binding.displayName.text.toString()))
        }
        getBackStackData<String>(BUNDLE_KEY_DISPLAY_NAME, result =  { data ->
            Log.d(AFragment::class.java.simpleName, data)
            binding.displayName.text = data
        })
        return root
    }

    companion object {
        const val BUNDLE_KEY_DISPLAY_NAME = "bundle_key_display_name"
    }
}
