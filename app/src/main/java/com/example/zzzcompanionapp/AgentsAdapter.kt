package com.example.zzzcompanionapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AgentsAdapter(
    private val agents: List<Agent>,
    private val onClick: (Agent) -> Unit
) : RecyclerView.Adapter<AgentsAdapter.AgentViewHolder>() {

    inner class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.agentName)
        val element = itemView.findViewById<TextView>(R.id.agentElement)
        val image = itemView.findViewById<ImageView>(R.id.agentImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_agent, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = agents[position]
        holder.name.text = agent.name
        holder.element.text = agent.element
        // se as imagens estão em drawable:
        val resId = holder.itemView.context.resources.getIdentifier(agent.image, "drawable", holder.itemView.context.packageName)
        holder.image.setImageResource(resId)

        holder.itemView.setOnClickListener { onClick(agent) }
    }

    override fun getItemCount() = agents.size
}
