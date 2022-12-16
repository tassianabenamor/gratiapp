package br.edu.infnet.gratiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.gratiapp.databinding.GratiappListItemBinding
import br.edu.infnet.gratiapp.models.GratiappWithId

class GratiappWithIdAdapter(val listener: GratiappWithIdListener) :
    ListAdapter<
            GratiappWithId,
            GratiappWithIdAdapter.ViewHolder
            >(GratiappWithIdDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent, listener)
    }

    class ViewHolder private constructor(
        val binding: GratiappListItemBinding,
        val listener: GratiappWithIdListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GratiappWithId, position: Int){
            binding.apply {
                gratiappNome.text = item.nomeGratiapp
                data.text = item.data
                ivEdit.setOnClickListener{
                    listener.onEditClick(item)
                }
                ivDelete.setOnClickListener {
                    listener.onDeleteClick(item)
                }
                ivView.setOnClickListener {
                    listener.onViewClick(item)
                }
            }
        }

        companion object{
            fun from(parent: ViewGroup, listener: GratiappWithIdListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GratiappListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }
}

class GratiappWithIdDiffCallback : DiffUtil.ItemCallback<GratiappWithId>() {
    override fun areItemsTheSame(oldItem: GratiappWithId, newItem: GratiappWithId): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: GratiappWithId, newItem: GratiappWithId): Boolean {
        return oldItem == newItem
    }
}

interface GratiappWithIdListener{
    fun onEditClick(gratiapp: GratiappWithId)
    fun onDeleteClick(gratiapp: GratiappWithId)
    fun onViewClick(gratiapp: GratiappWithId)
}