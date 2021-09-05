package com.light.hogwartslibrary.ui.scenes.teachers

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.light.hogwartslibrary.databinding.FragmentTeachersBinding
import com.light.hogwartslibrary.ui.scenes.teachers.adapter.TeachersAdapter

class TeachersFragment : Fragment() {

    private lateinit var teachersViewModel: TeachersViewModel
    private var _binding: FragmentTeachersBinding? = null
    private lateinit var adapter: TeachersAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = TeachersAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        teachersViewModel =
            ViewModelProvider(this).get(TeachersViewModel::class.java)

        _binding = FragmentTeachersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
        setupLoading()

        context.let {
            binding.recyclerTeachers.adapter = adapter
            binding.recyclerTeachers.layoutManager =
                LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
        }

        teachersViewModel.fetchStudents()

        binding.textStudentSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapter.filter(query = p0.toString())
                println(p0)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun setupLoading() {
        teachersViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.txtStudentLoading.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.textStudentSearch.visibility = if (it) {
                View.GONE
            } else {
                View.VISIBLE
            }
        })
    }

    private fun setupData() {
        teachersViewModel.teachersCell.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                adapter.setData(newData = it)
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}