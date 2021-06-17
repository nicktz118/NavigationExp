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
import com.nicktz9.navigationsample.util.NavigationUtil
import com.nicktz9.navigationsample.util.popToStartDest
import com.nicktz9.navigationsample.util.resetAndBuildStack

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
