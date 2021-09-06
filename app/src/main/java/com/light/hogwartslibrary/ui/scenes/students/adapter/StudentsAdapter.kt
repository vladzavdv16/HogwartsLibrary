package com.light.hogwartslibrary.ui.scenes.students.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.light.hogwartslibrary.databinding.CellHumanBinding

class StudentsAdapter : RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private val mDataList = ArrayList<StudentsCellModel>()

    fun setData(newData: List<StudentsCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CellHumanBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cellModel = mDataList[position])
    }

    override fun getItemCount(): Int = mDataList.count()

    class ViewHolder(private val binding: CellHumanBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cellModel: StudentsCellModel) {
            binding.txtStudentName.text = cellModel.name
            binding.txtStudentFaculty.text = cellModel.facultyName
        }

    }
}