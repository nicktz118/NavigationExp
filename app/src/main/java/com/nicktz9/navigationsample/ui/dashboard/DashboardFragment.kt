package com.nicktz9.navigationsample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nicktz9.navigationsample.MainActivity
import com.nicktz9.navigationsample.R
import com.nicktz9.navigationsample.databinding.FragmentDashboardBinding
import com.nicktz9.navigationsample.ui.AFragment
import com.nicktz9.navigationsample.ui.EFragment
import com.nicktz9.navigationsample.ui.adapter.TextViewAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var label: String

    private val adapter by lazy {
        val textList = mutableListOf<String>()
            .apply {
                for (i in 0..50) {
                    add("ITEM $i")
                }
            }
        TextViewAdapter(
            textList,
            onClick = {
                findNavController().navigate(R.id.action_global_a_fragment)
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        label = "aaa"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        binding.textDashboard.text = label

        binding.recyclerView.adapter = adapter

        return root
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
