package com.light.hogwartslibrary.ui.scenes.student.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.light.hogwartslibrary.databinding.CellStudentBinding
import kotlin.coroutines.coroutineContext

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    private val mDataList = ArrayList<StudentsCellModel>()
    private val mDisplaylist = ArrayList<StudentsCellModel>()

    fun setData(newData: List<StudentsCellModel>) {
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
        return ViewHolder(CellStudentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cellModel = mDataList[position])
    }

    override fun getItemCount(): Int = mDisplaylist.count()

    class ViewHolder(val binding: CellStudentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cellModel: StudentsCellModel) {
            binding.txtStudentName.text = cellModel.name
            binding.txtStudentFaculty.text = cellModel.facultyName
        }

    }
}