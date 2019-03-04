package com.psato.kdbexemple.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.psato.kdbcore.databind.AdapterViewModel
import com.psato.kdbcore.databind.LifeCycleAdapter
import com.psato.kdbcore.databind.LifeCycleViewHolder
import com.psato.kdbcore.databind.bind
import com.psato.kdbexemple.R
import com.psato.kdbexemple.infrastructure.bindView


class QuerryAdapter(private val viewModel: AdapterViewModel<ShowResponseItem>) :
    LifeCycleAdapter<ShowResponseItem, QuerryAdapter.SearchViewHolder>(viewModel) {

    override fun onBindViewHolderImpl(holder: SearchViewHolder, position: Int) {
        holder.bindView(viewModel.getItemAtPosition(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.show_item, parent, false)
        return SearchViewHolder(v)
    }

    class SearchViewHolder(itemView: View) : LifeCycleViewHolder(itemView) {
        val showName: TextView by bindView(R.id.show_name)
        fun bindView(item: ShowResponseItem) {
            bind(item.showName, showName::setText)
        }
    }

}