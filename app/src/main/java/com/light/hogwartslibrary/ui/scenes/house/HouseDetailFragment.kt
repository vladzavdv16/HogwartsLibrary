package com.light.hogwartslibrary.ui.scenes.house

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.light.hogwartslibrary.R
import com.light.hogwartslibrary.databinding.FragmentHousesBinding
import com.light.hogwartslibrary.databinding.HouseDetailFragmentBinding
import com.light.hogwartslibrary.helpers.Keys

class HouseDetailFragment : Fragment() {

    private lateinit var binding: HouseDetailFragmentBinding

    companion object {
        fun newInstance() = HouseDetailFragment()
    }

    private lateinit var viewModel: HouseDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HouseDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HouseDetailViewModel::class.java)
        viewModel.fetchData(houses = arguments?.get(Keys.Faculty.value) as Houses)

        configureLayout()
    }

    private fun configureLayout() {
        viewModel.fonder.observe(viewLifecycleOwner, Observer {
            binding.txtHouseOwner.text =
                getString(R.string.house_detail_owner).replace("[FOUNDER_NAME]", it)
        })
        viewModel.leader.observe(viewLifecycleOwner, Observer {
            binding.txtHouseLeader.text =
                getString(R.string.house_detail_leader).replace("[LEADER_NAME]", it)
        })
        viewModel.houseName.observe(viewLifecycleOwner, Observer {
            binding.txtHouseName.text = it
        })
        viewModel.houseImage.observe(viewLifecycleOwner, Observer {
            binding.imgGriffindor.setImageResource(it)
        })
    }

}