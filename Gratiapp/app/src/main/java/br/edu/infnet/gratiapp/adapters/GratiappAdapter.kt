package br.edu.infnet.gratiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.gratiapp.databinding.GratiappListItemBinding
import br.edu.infnet.gratiapp.models.Gratiapp

class GratiappAdapter(val listener: GratiappListener) :
        ListAdapter<
                Gratiapp,
                GratiappAdapter.ViewHolder
                >(GratiappDiffCallback()) {

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
            val listener: GratiappListener
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Gratiapp, position: Int) {
                binding.apply {
                    gratiappNome.text = item.nomeGratiapp
                    data.text = item.data
                    ivEdit.setOnClickListener {
                        listener.onEditClick(item)
                    }
                    ivDelete.setOnClickListener {
                        listener.onDeleteClick(item)
                    }
                }
            }
            companion object {
                fun from(parent: ViewGroup, listener: GratiappListener): ViewHolder {
                    val layoutInflater = LayoutInflater.from(parent.context)
                    val binding = GratiappListItemBinding.inflate(
                        layoutInflater, parent, false
                    )
                    return ViewHolder(binding, listener)
                }
            }
        }
}


class GratiappDiffCallback : DiffUtil.ItemCallback<Gratiapp>() {
    override fun areItemsTheSame(oldItem: Gratiapp, newItem: Gratiapp): Boolean {
        return oldItem.nomeGratiapp == newItem.nomeGratiapp
    }
    override fun areContentsTheSame(oldItem: Gratiapp, newItem: Gratiapp): Boolean {
        return oldItem == newItem
    }
}

interface GratiappListener {
    fun onEditClick(gratiapp: Gratiapp)
    fun onDeleteClick(gratiapp: Gratiapp)
}

