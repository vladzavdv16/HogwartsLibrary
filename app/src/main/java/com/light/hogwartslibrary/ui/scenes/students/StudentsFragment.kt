package com.light.hogwartslibrary.ui.scenes.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.light.hogwartslibrary.R
import com.light.hogwartslibrary.databinding.FragmentStudentsBinding
import com.light.hogwartslibrary.ui.scenes.students.adapter.StudentsAdapter

class StudentsFragment : Fragment() {

    private lateinit var studentsViewModel: StudentsViewModel
    private var _binding: FragmentStudentsBinding? = null
    private val adapter = StudentsAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        studentsViewModel =
            ViewModelProvider(this).get(StudentsViewModel::class.java)

        _binding = FragmentStudentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecycler()
        configureDataDisplay()

        binding.btnGriffindor.setOnClickListener {
            binding.btnGriffindor.isSelected = !binding.btnGriffindor.isSelected
            studentsViewModel.pressFilter(
                faculty = "Gryffindor",
                isSelected = binding.btnGriffindor.isSelected
            )
        }
        binding.btnHufflepuff.setOnClickListener {
            binding.btnHufflepuff.isSelected = !binding.btnHufflepuff.isSelected
            studentsViewModel.pressFilter(
                faculty = "Hufflepuff",
                isSelected = binding.btnHufflepuff.isSelected
            )
        }
        binding.btnRavenclaw.setOnClickListener {
            binding.btnRavenclaw.isSelected = !binding.btnRavenclaw.isSelected
            studentsViewModel.pressFilter(
                faculty = "Ravenclaw",
                isSelected = binding.btnRavenclaw.isSelected
            )
        }
        binding.btnSlytherin.setOnClickListener {
            binding.btnSlytherin.isSelected = !binding.btnSlytherin.isSelected
            studentsViewModel.pressFilter(
                faculty = "Slytherin",
                isSelected = binding.btnSlytherin.isSelected
            )
        }
    }

    private fun configureDataDisplay() {
        studentsViewModel.studentsDisplay.observe(viewLifecycleOwner, Observer { data ->
            adapter.setData(newData = data)
        })
    }

    private fun configureRecycler() {
        binding.recyclerStudents.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerStudents.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}