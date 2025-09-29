package com.example.zzzcompanionapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class AgentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_agents, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_agents)

        val agents = JsonUtils.loadAgents(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = AgentsAdapter(agents) { agent ->
            val intent = Intent(requireContext(), AgentDetailActivity::class.java)
            intent.putExtra("agent", Gson().toJson(agent))
            startActivity(intent)
        }

        return view
    }
}