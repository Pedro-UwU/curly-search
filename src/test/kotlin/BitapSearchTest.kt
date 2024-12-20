import me.rulos.BitapSearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitapSearchTest {

    @Test
    fun `Test exact match`() {
        val stringToTest = "Lorem ipsum dolor sit amet"
        val toSearch = "ipsum"

        val searchResult = BitapSearch.search(stringToTest, toSearch, 0)
        assertEquals(searchResult.first, "ipsum")
        assertEquals(searchResult.second, 0)
    }

    @Test
    fun `Test fuzzy match with distance 1`() {
        val stringToTest = "Lorem ipsum dolor sit amet"
        val toSearch = "ips0m"
        val searchResult = BitapSearch.search(stringToTest, toSearch, 1)
        assertEquals(searchResult.first, "ipsum")
        assertEquals(searchResult.second, 1)
    }

    @Test
    fun `Test fuzzy match with distance 2`() {
        val stringToTest = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        val toSearch = "iTs0m"
        val searchResult = BitapSearch.search(stringToTest, toSearch, 2)
        assertEquals(searchResult.first, "ipsum")
        assertEquals(searchResult.second, 2)
    }

    @Test
    fun `Test fuzzy match with no match`() {
        val stringToTest = "Lorem ipsum dolor sit amet"
        val toSearch = "pedrito"
        val searchResult = BitapSearch.search(stringToTest, toSearch, 2)
        assertEquals(searchResult.first, "")
        assertEquals(searchResult.second, -1)
    }
}