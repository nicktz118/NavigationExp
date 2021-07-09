package com.nicktz9.navigationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nicktz9.navigationsample.R
import com.nicktz9.navigationsample.databinding.FragmentBBinding
import com.nicktz9.navigationsample.ext.setBackStackData
import com.nicktz9.navigationsample.ui.AFragment.Companion.BUNDLE_KEY_DISPLAY_NAME


class BFragment : Fragment() {

   // private val args: BFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.screenName.text = "B"
        //binding.displayNameEditText.setText(args.displayName)
        binding.displayNameEditText.addTextChangedListener {
            //setBackStackData(BUNDLE_KEY_DISPLAY_NAME, it.toString(), doBack = false)
        }
        binding.action.setOnClickListener {
            //findNavController().navigate(R.id.action_global_c_fragment)
        }

        return root
    }
}
