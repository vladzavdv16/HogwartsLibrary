package com.light.hogwartslibrary.ui.scenes.teachers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.light.hogwartslibrary.databinding.CellHumanBinding

class TeachersAdapter : RecyclerView.Adapter<TeachersAdapter.ViewHolder>() {

    private val mDataList = ArrayList<TeachersCellModel>()
    private val mDisplaylist = ArrayList<TeachersCellModel>()

    fun setData(newData: List<TeachersCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        filter(query = "")
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        mDisplaylist.clear()

        if (query.isEmpty()) {
            mDisplaylist.addAll(mDataList)
            return
        }
        mDisplaylist.addAll(mDataList.filter {
            it.name.contains(query, true) ||
                    it.facultyName.contains(query, true)
        })
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CellHumanBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cellModel = mDataList[position])
    }

    override fun getItemCount(): Int = mDisplaylist.count()

    class ViewHolder(val binding: CellHumanBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cellModel: TeachersCellModel) {
            binding.txtStudentName.text = cellModel.name
            binding.txtStudentFaculty.text = cellModel.facultyName
        }
    }
}