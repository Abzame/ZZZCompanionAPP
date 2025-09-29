package com.example.zzzcompanionapp

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonUtils {
    fun loadAgents(context: Context): List<Agent> {
        val json = context.assets.open("agents.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Agent>>() {}.type
        return Gson().fromJson(json, type)
    }
}
