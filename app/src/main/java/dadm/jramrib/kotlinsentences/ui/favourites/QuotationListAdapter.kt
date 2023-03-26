package dadm.jramrib.kotlinsentences.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dadm.jramrib.kotlinsentences.databinding.QuotationItemBinding
import dadm.jramrib.kotlinsentences.domain.model.Quotation

class QuotationListAdapter(private val itemClicked: ItemClicked):
    ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff) {

    object QuotationDiff: DiffUtil.ItemCallback<Quotation>() {
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(quotationItemBinding: QuotationItemBinding, itemClicked: ItemClicked):
        RecyclerView.ViewHolder(quotationItemBinding.root) {

            private val binding = dadm.jramrib.kotlinsentences.databinding.QuotationItemBinding.bind(itemView)

            init {
                binding.root.setOnClickListener{
                    itemClicked.onClick(binding.tvQuotationAuthor.text.toString())
                }
            }

            fun bind(quotation: Quotation) {
                binding.tvQuotationText.text = quotation.text
                binding.tvQuotationAuthor.text = quotation.author
            }
        }

    interface ItemClicked {
        fun onClick(author: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, itemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}