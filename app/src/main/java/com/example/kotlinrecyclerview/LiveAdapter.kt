package com.example.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrecyclerview.models.Live
import kotlinx.android.synthetic.main.res_item_live.view.*

class LiveAdapter: RecyclerView.Adapter <RecyclerView.ViewHolder>() {

    private var items : List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is LiveViewHolder -> {
                holder.bind(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(lives : List<Live>) {
        this.items = lives
    }

    class LiveViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Pode ser utilisado o binding para pegar os elementos de inteface
        private val liveTitle = itemView.title
        private val liveAuthot = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live: Live) {

            liveTitle.text = live.title
            liveAuthot.text = live.author

        }

    }

}