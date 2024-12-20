package com.pedrito.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Rule(
    val keyword: String,
    @JsonProperty("max_distance")
    val maxDistance: Int,
    val weight: Double)