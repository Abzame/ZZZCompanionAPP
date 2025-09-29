package com.example.zzzcompanionapp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class AgentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_detail)

        val json = intent.getStringExtra("agent")
        val agent = Gson().fromJson(json, Agent::class.java)

        val agentImage = findViewById<ImageView>(R.id.agentImage)
        val agentName = findViewById<TextView>(R.id.agentName)
        val agentInfo = findViewById<TextView>(R.id.agentInfo)
        val buildDescription = findViewById<TextView>(R.id.buildDescription)

        val bestEngineList = findViewById<LinearLayout>(R.id.bestEngineList)
        val discsList = findViewById<LinearLayout>(R.id.discsList)
        val mainStatsList = findViewById<LinearLayout>(R.id.mainStatsList)
        val subStatsList = findViewById<LinearLayout>(R.id.subStatsList)

        val skillPriority = findViewById<LinearLayout>(R.id.skillPriority)
        val f2PParty = findViewById<LinearLayout>(R.id.f2PParty)

        val imagemAgent = findViewById<LinearLayout>(R.id.imagemAgent)


        // Preenche cabeçalho
        agentName.text = agent.name
        agentInfo.text = "${agent.element} | ${agent.rarity} | ${agent.role}"

        // Imagem (assumindo que está em drawable com nome igual ao JSON)
        val resId = resources.getIdentifier(agent.image, "drawable", packageName)
        if (resId != 0) {
            agentImage.setImageResource(resId)
        }

        // Descrição
        buildDescription.text = agent.build.description


        // Lista de Best Engines
        for (engine in agent.build.bestEngineW) {
            val tv = TextView(this)
            tv.text = "⭐${engine.stars} - ${engine.name}"
            bestEngineList.addView(tv)
        }

        // Lista de Discs
        for (disc in agent.build.discs) {
            val tv = TextView(this)
            tv.text = "${disc.pieces}x - ${disc.name}"
            discsList.addView(tv)
        }

        // Lista de Main Stats
        for (main in agent.build.mainStats) {
            val tv = TextView(this)
            tv.text = main
            mainStatsList.addView(tv)
        }

        // Lista de Sub Stats
        for (sub in agent.build.subStats) {
            val tv = TextView(this)
            tv.text = sub
            subStatsList.addView(tv)
        }

        // Lista de Skill Priority
        for (skill in agent.build.skillPriority) {
            val tv = TextView(this)
            tv.text = "⭐${skill.priority} - ${skill.name}"
            skillPriority.addView(tv)
        }

        // Lista de Party F2P
        for (party in agent.build.f2PParty) {
            val tv = TextView(this)
            val iv = ImageView(this)
            val resId = resources.getIdentifier(party.image, "drawable", packageName)
            if (resId != 0) {
                iv.setImageResource(resId)
                f2PParty.addView(iv)
            }
            iv.layoutParams = LinearLayout.LayoutParams(
                200, // largura px
                200  // altura px
            ).apply {
                marginEnd = 16
                tv.text = "${party.name}"
                f2PParty.addView(tv)
            }
         
        }
    }
}
