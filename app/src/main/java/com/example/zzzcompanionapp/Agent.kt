package com.example.zzzcompanionapp

data class Agent(
    val id: Int,
    val name: String,
    val element: String,
    val rarity: String,
    val role: String,
    val image: String,
    val build: Build
)

data class Build(
    val description: String,
    val bestEngineW: List<Engine>,
    val discs: List<Disc>,
    val mainStats: List<String>,
    val subStats: List<String>,
    val skillPriority: List<SkillPriority>,
    val f2PParty: List<F2PParty>,
    val recommendedParty: List<RecommendedParty>
)

data class Engine(
    val name: String,
    val stars: Int,
    val image: String
)

data class Disc(
    val name: String,
    val pieces: Int,
    val image: String
)

data class SkillPriority(
    val name: String,
    val priority: Int,
    val image: String
)

data class F2PParty(
    val name: String,
    val role: String,
    val image: String
)

data class RecommendedParty(
    val name: String,
    val role: String,
    val image: String
)

