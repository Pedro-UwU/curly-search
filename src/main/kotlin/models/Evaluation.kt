package com.pedrito.models

import java.util.*

data class Evaluation(
    val ruleSet: RuleSet,
    val score: Double = 0.0,
    val success: Boolean = false,
) {

}