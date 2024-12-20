package com.pedrito.models

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.pedrito.BitapSearch
import java.io.File
import kotlin.math.abs


class RuleSet(
    val name: String,
    val threshold: Double,
    val rules: List<Rule> = emptyList()
) {
    companion object {
        @JvmStatic
        fun fromJsonFile(path: String): RuleSet {
            // Read an create a RuleSet
            val mapper = jacksonObjectMapper()
            return mapper.readValue<RuleSet>(File(path))
        }

        @JvmStatic
        fun fromJsonString(json: String): RuleSet {
            val mapper = jacksonObjectMapper()
            return mapper.readValue<RuleSet>(json)
        }

        @JvmStatic
        fun fromYamlFile(path: String): RuleSet {
            val yamlMapper = ObjectMapper(YAMLFactory()).apply {
                findAndRegisterModules() // This registers kotlin module automatically
            }
            return yamlMapper.readValue<RuleSet>(File(path))
        }

        @JvmStatic
        fun fromYamlString(yaml: String): RuleSet {
            val yamlMapper = ObjectMapper(YAMLFactory()).apply {
                findAndRegisterModules()
            }
            return yamlMapper.readValue<RuleSet>(yaml)
        }
    }

    fun evaluate(text: String): Evaluation {
        val scores = rules.map { evaluateRule(it, text)}
        val score = rules.sumOf { r -> evaluateRule(r, text) }
        return Evaluation(
            ruleSet = this,
            score = score,
            success = score >= this.threshold
        )
    }

    fun evaluate(lines: List<String>): Evaluation {
        val scores = lines.map { line -> rules.map { r -> evaluateRule(r, line)} }
        val best = ArrayList<Double>()
        for (i in 0..<scores[0].size) {
            best.add(
                scores.map { it[i] }
                .sortedWith { score1, score2 -> abs(score2).compareTo(abs(score1)) }
                .first()
            )
        }
        val finalScore = best.sum()
        return Evaluation(
            ruleSet = this,
            score = finalScore,
            success = finalScore >= this.threshold
        )
    }

    private fun evaluateRule(rule: Rule, text: String): Double {
        val searchResult = BitapSearch.search(
            text,
            rule.keyword,
            rule.maxDistance
        )
        return if (searchResult.second < 0)
            0.0
        else
            (1.0 - (1.0 * searchResult.second) / (rule.maxDistance + 1)) * rule.weight
    }
}