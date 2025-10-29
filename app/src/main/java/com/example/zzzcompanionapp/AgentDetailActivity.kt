package com.example.zzzcompanionapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.zzzcompanionapp.R.*
import com.google.gson.Gson



class AgentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_agent_detail)

        val json = intent.getStringExtra("agent")
        val agent = Gson().fromJson(json, Agent::class.java)

        val agentImage = findViewById<ImageView>(id.agentImage)
        val agentName = findViewById<TextView>(id.agentName)
        val agentInfo = findViewById<TextView>(id.agentInfo)
        val buildDescription = findViewById<TextView>(id.buildDescription)


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
        agent?.build?.bestEngineW?.let { engineList ->
            val enginesList = findViewById<LinearLayout>(id.enginesList)

            for (engine in engineList) {
                // Layout horizontal de cada engine
                val engineLayout = LinearLayout(this)
                engineLayout.orientation = LinearLayout.HORIZONTAL
                engineLayout.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 16, 0, 16)
                }

                // 🔹 Aqui adicionamos o fundo arredondado
                engineLayout.setBackgroundResource(R.drawable.party_item_bg)
                engineLayout.setPadding(16, 16, 16, 16)

                // Imagem do engine
                val imageView = ImageView(this)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    150, 150
                ).apply { marginEnd = 24 }

                val resId = resources.getIdentifier(engine.image, "drawable", packageName)

                if (resId != 0) {
                    imageView.setImageResource(resId)
                } else {
                    imageView.setImageResource(android.R.drawable.ic_menu_report_image)
                }

                // Nome do engine
                val textView = TextView(this)
                textView.text = "⭐${engine.stars} - ${engine.name}"
                textView.textSize = 18f
                textView.setTextColor(getColor(android.R.color.white))
                textView.setTypeface(null, android.graphics.Typeface.BOLD)

                // Adiciona os dois ao layout
                engineLayout.addView(imageView)
                engineLayout.addView(textView)

                // Adiciona o layout final no container
                enginesList.addView(engineLayout)

            }


        }


        // Lista de Discs
        agent?.build?.discs?.let { discList ->
            val discsList = findViewById<LinearLayout>(id.discsList)

            for (disc in discList) {
                // Layout horizontal de cada disco
                val discLayout = LinearLayout(this)
                discLayout.orientation = LinearLayout.HORIZONTAL
                discLayout.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 16, 0, 16)

                }

                // 🔹 Aqui adicionamos o fundo arredondado
                discLayout.setBackgroundResource(R.drawable.party_item_bg)
                discLayout.setPadding(16, 16, 16, 16)

                // Imagem do disco
                val imageView = ImageView(this)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    150, 150
                ).apply { marginEnd = 24 }

                val resId = resources.getIdentifier(disc.image, "drawable", packageName)

                if (resId != 0) {
                    imageView.setImageResource(resId)
                } else {
                    imageView.setImageResource(android.R.drawable.ic_menu_report_image)
                }

                // Nome do disco
                val textView = TextView(this)
                textView.text = "${disc.pieces}x - ${disc.name}"
                textView.textSize = 18f
                textView.setTextColor(getColor(android.R.color.white))
                textView.setTypeface(null, android.graphics.Typeface.BOLD)

                // Adiciona os dois ao layout
                discLayout.addView(imageView)
                discLayout.addView(textView)

                // Adiciona o layout final no container
                discsList.addView(discLayout)

            }
        }

            // Lista de Main Stats
          agent?.build?.mainStats?.let { mainStats ->
            val mainStatsList = findViewById<LinearLayout>(id.mainStatsList)

              for (mainStats in mainStats) {
                    // Layout horizontal de cada stat
                    val statLayout = LinearLayout(this)
                    statLayout.orientation = LinearLayout.HORIZONTAL
                    statLayout.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply { setMargins(0, 16, 0, 16)
                    }
                  statLayout.setBackgroundResource(R.drawable.party_item_bg)
                  statLayout.setPadding(16, 16, 16, 16)

                // Atribui as stats
                  val textView = TextView(this)
                  textView.text = mainStats
                  textView.textSize = 18f
                  textView.setTextColor(getColor(android.R.color.white))
                  textView.setTypeface(null, android.graphics.Typeface.BOLD)

                  // Adiciona os dois ao layout
                  statLayout.addView(textView)

                  // Adiciona o layout final no container
                  mainStatsList.addView(statLayout)
              }
          }

            // Lista de Sub Stats
            agent?.build?.subStats?.let { subStats ->
                val subStatsList = findViewById<LinearLayout>(id.subStatsList)

                for (subStats in subStats) {
                    // Layout horizontal de cada stat
                    val statLayout = LinearLayout(this)
                    statLayout.orientation = LinearLayout.HORIZONTAL
                    statLayout.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply { setMargins(0, 16, 0, 16)
                    }
                    statLayout.setBackgroundResource(R.drawable.party_item_bg)
                    statLayout.setPadding(16, 16, 16, 16)

                    //Atribue os subStats
                    val textView = TextView(this)
                    textView.text = subStats
                    textView.textSize = 18f
                    textView.setTextColor(getColor(android.R.color.white))
                    textView.setTypeface(null, android.graphics.Typeface.BOLD)

                    // Adiciona o sub stat ao layout
                    statLayout.addView(textView)

                    // Adiciona o layout final no container
                    subStatsList.addView(statLayout)

                }

             }

            // Lista de Skill Priority
           agent?.build?.skillPriority?.let { skillList ->
               val skillPriority = findViewById<LinearLayout>(id.skillPriority)
               for (skill in skillList) {
                val skillLayout = LinearLayout(this)
                skillLayout.orientation = LinearLayout.HORIZONTAL
                skillLayout.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { setMargins(0, 16, 0, 16)

                }
                   skillLayout.setBackgroundResource(R.drawable.party_item_bg)
                   skillLayout.setPadding(16, 16, 16, 16)

                    //imagem da skill
                   val imageView = ImageView(this)
                   imageView.layoutParams = LinearLayout.LayoutParams(
                       150, 150).apply { marginEnd = 24 }

                   val resId = resources.getIdentifier(skill.image, "drawable", packageName)
                   if (resId != 0) {
                       imageView.setImageResource(resId)
                   } else {
                       imageView.setImageResource(android.R.drawable.ic_menu_report_image)
                   }

                   //nome da skill
                   val textView = TextView(this)
                   textView.text = "⭐${skill.priority} - ${skill.name}"
                   textView.textSize = 18f
                   textView.setTextColor(getColor(android.R.color.white))
                   textView.setTypeface(null, android.graphics.Typeface.BOLD)

                   // Adiciona os dois ao layout
                   skillLayout.addView(imageView)
                   skillLayout.addView(textView)

                   // Adiciona o layout final no container
                   skillPriority.addView(skillLayout)

               }

           }

            // Lista de Party F2P
            agent?.build?.f2PParty?.let { partyList ->
                val f2PPartyContainer = findViewById<LinearLayout>(R.id.f2PPartyContainer)

                for (partyMember in partyList) {

                    // Layout horizontal de cada membro
                    val memberLayout = LinearLayout(this)
                    memberLayout.orientation = LinearLayout.HORIZONTAL
                    memberLayout.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(0, 16, 0, 16)
                    }

                    // 🔹 Aqui adicionamos o fundo arredondado
                    memberLayout.setBackgroundResource(R.drawable.party_item_bg)
                    memberLayout.setPadding(16, 16, 16, 16)

                    // Imagem do agente
                    val imageView = ImageView(this)
                    imageView.layoutParams = LinearLayout.LayoutParams(
                        150, 150
                    ).apply { marginEnd = 24 }

                    val resId = resources.getIdentifier(partyMember.image, "drawable", packageName)
                    if (resId != 0) {
                        imageView.setImageResource(resId)
                    } else {
                        imageView.setImageResource(android.R.drawable.ic_menu_report_image)
                    }

                    // Nome do agente
                    val textView = TextView(this)
                    textView.text = partyMember.name
                    textView.textSize = 18f
                    textView.setTextColor(getColor(android.R.color.white))
                    textView.setTypeface(null, android.graphics.Typeface.BOLD)

                    // Adiciona os dois ao layout
                    memberLayout.addView(imageView)
                    memberLayout.addView(textView)

                    // Adiciona o layout final no container
                    f2PPartyContainer.addView(memberLayout)

                }

            }

            // Mostra Party Recomendada (imagem + nome lado a lado)
            agent?.build?.recommendedParty?.let { partyList ->
                val recommendedPartyContainer =
                    findViewById<LinearLayout>(R.id.recommendedPartyContainer)

                for (partyMember in partyList) {

                    // Layout horizontal de cada membro
                    val memberLayout = LinearLayout(this)
                    memberLayout.orientation = LinearLayout.HORIZONTAL
                    memberLayout.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(0, 16, 0, 16)
                    }

                    // 🔹 Aqui adicionamos o fundo arredondado
                    memberLayout.setBackgroundResource(R.drawable.party_item_bg)
                    memberLayout.setPadding(16, 16, 16, 16)

                    // Imagem do agente
                    val imageView = ImageView(this)
                    imageView.layoutParams = LinearLayout.LayoutParams(150, 150).apply {
                        marginEnd = 24
                    }

                    val resId = resources.getIdentifier(partyMember.image, "drawable", packageName)
                    if (resId != 0) {
                        imageView.setImageResource(resId)
                    } else {
                        imageView.setImageResource(android.R.drawable.ic_menu_report_image)
                    }

                    // Nome do agente
                    val textView = TextView(this)
                    textView.text = partyMember.name
                    textView.textSize = 18f
                    textView.setTextColor(getColor(android.R.color.white))
                    textView.setTypeface(null, android.graphics.Typeface.BOLD)

                    // Adiciona os dois ao layout
                    memberLayout.addView(imageView)
                    memberLayout.addView(textView)

                    // Adiciona o layout final no container
                    recommendedPartyContainer.addView(memberLayout)
                }
            }



    }
}
