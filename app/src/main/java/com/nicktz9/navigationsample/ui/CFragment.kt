package com.nicktz9.navigationsample.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NavUtils
import androidx.core.app.TaskStackBuilder
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import com.nicktz9.navigationsample.R
import com.nicktz9.navigationsample.databinding.FragmentBBinding
import com.nicktz9.navigationsample.databinding.FragmentCBinding
import com.nicktz9.navigationsample.ext.setBackStackData
import com.nicktz9.navigationsample.ext.setParticularBackStackData
import com.nicktz9.navigationsample.util.NavigationUtil
import com.nicktz9.navigationsample.util.popToStartDest
import com.nicktz9.navigationsample.util.resetAndBuildStack


class CFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.screenName.text = "C"
        binding.action.setOnClickListener {
            findNavController().navigate(R.id.action_c_fragment_to_exp_navigation)
        }
        binding.deeplink.setOnClickListener {
            //findNavController().resetAndBuildStack(R.id.action_to_exp_navigation, R.id.action_d_fragment_to_e_fragment)
            NavDeepLinkBuilder(requireContext()).setGraph(findNavController().navInflater.inflate(R.navigation.exp_navigation))
                .setDestination(R.id.d_fragment)
                .createTaskStackBuilder()
                .startActivities()
        }
        binding.setBackData.setOnClickListener {
            //setBackStackData(AFragment.BUNDLE_KEY_DISPLAY_NAME, "Come from C Fragment", true)
            setParticularBackStackData(R.id.d_fragment, AFragment.BUNDLE_KEY_DISPLAY_NAME, "Come from C Fragment")
        }
        return root
    }

}
