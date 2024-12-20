import me.rulos.models.Rule
import me.rulos.models.RuleSet
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RuleSetTest {

    val EPSILON = 0.00001

    @Test
    fun `Test reading RuleSet from json`() {
        val ruleSetJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleSetJsonPath)
        assertNotNull(ruleSet)
        assertEquals("Test", ruleSet.name)
        assertEquals(1.0, ruleSet.threshold)
        assertEquals(4, ruleSet.rules.size)
        val rules = listOf(
            Rule("dragon", 2, 1.0),
            Rule("dungeons", 2, 1.0),
            Rule("monster", 1, 0.5),
            Rule("chest", 0, -1.0),
        )
        for (pair in rules.zip(ruleSet.rules)) {
            assertEquals(pair.first, pair.second)
        }
    }

    @Test
    fun `Test reading RuleSet from yaml`() {
        val ruleYamlPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromYamlFile(ruleYamlPath)
        assertNotNull(ruleSet)
        assertEquals("Test", ruleSet.name)
        assertEquals(1.0, ruleSet.threshold)
        assertEquals(4, ruleSet.rules.size)
        val rules = listOf(
            Rule("dragon", 2, 1.0),
            Rule("dungeons", 2, 1.0),
            Rule("monster", 1, 0.5),
            Rule("chest", 0, -1.0),
        )
        for (pair in rules.zip(ruleSet.rules)) {
            assertEquals(pair.first, pair.second)
        }
    }

    @Test
    fun `Test RuleSet Evaluation against a perfect match`() {
        val ruleJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleJsonPath)
        val textToTest =
            "Some dragons attacked our homes, killing like monsters." +
                    " They came from the deep dungeons. All because you stole that chest..."
        val evaluation = ruleSet.evaluate(textToTest)
        assertTrue(abs(evaluation.score - 1.5) < EPSILON)
        assertTrue(evaluation.success)
    }

    @Test
    fun `Test RuleSet Evaluation against a fuzzy match`() {
        val ruleJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleJsonPath)
        val textToTest =
            "Some drag0ns attacked our homes, killing like nonsters." +
                    " They came from the deep dunjeons. All because you stole that crest..."
        val evaluation = ruleSet.evaluate(textToTest)
        assertTrue(abs(evaluation.score - (2.0/3 + 2.0/3 + 1.0 /4)) < EPSILON)
        assertTrue(evaluation.success)
    }


    @Test
    fun `Test RuleSet Evaluation against a negative match`() {
        val ruleJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleJsonPath)
        val textToTest =
            "Some dolphins spawn at our homes, swimming like angels." +
                    " They came from the deep ocean. All looking for you and that chest..."
        val evaluation = ruleSet.evaluate(textToTest)
        assertTrue(abs(evaluation.score - -1.0) < EPSILON)
        assertTrue(!evaluation.success)
    }

    @Test
    fun `Test RuleSet Evalueation agains a list of strings`() {
        val ruleJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleJsonPath)
        val textToTest = listOf(
            "Some dragons attacked our homes",
            "killing like monsters.",
            " They came from the deep dungeons.",
            " All because you stole that chest"
        )
        val evaluation = ruleSet.evaluate(textToTest)
        assertTrue(abs(evaluation.score - 1.5) < EPSILON)
        assertTrue(evaluation.success)
    }


    @Test
    fun `Test RuleSet Evalueation agains a fuzzy list of strings`() {
        val ruleJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleJsonPath)
        val textToTest = listOf(
            "Some dRagons attacked our homes",
            "killing like mnsters.",
            " They came from the deep dungeon",
            " All because you stole that mhest"
        )
        val evaluation = ruleSet.evaluate(textToTest)
        assertTrue(abs(evaluation.score - (2.0/3 + 2.0/3 + 1.0/4)) < EPSILON)
        assertTrue(evaluation.success)
    }

    @Test
    fun `Test RuleSet Evalueation agains a not matching list of strings`() {
        val ruleJsonPath = "src/test/resources/ruleSet.json"
        val ruleSet = RuleSet.fromJsonFile(ruleJsonPath)
        val textToTest = listOf(
            "Some attacked our homes",
            "killing like .",
            " They came from the deep ",
            " All because you stole that chest"
        )
        val evaluation = ruleSet.evaluate(textToTest)
        assertTrue(abs(evaluation.score - -1.0) < EPSILON)
        assertTrue(!evaluation.success)
    }
}


