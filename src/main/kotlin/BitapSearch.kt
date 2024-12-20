package com.pedrito

class BitapSearch {
    companion object {
        @JvmStatic
        fun search(haystack: String, needle: String, maxErrors: Int): Pair<String, Int> {
            val haystackLen = haystack.length
            val needleLen = needle.length

            fun generateAlphabet(needle: String, haystack: String): Map<Char, Int> {
                return haystack.toSet().associateWith { letter ->
                    needle.fold(0) { acc, symbol ->
                        (acc shl 1) or if (letter != symbol) 1 else 0
                    }
                }
            }
            val alphabet = generateAlphabet(needle, haystack)
            val table = mutableListOf<MutableList<Int>>()
            val emptyColumn = (2 shl (needleLen - 1)) - 1
            table.add(MutableList(haystackLen + 1) { emptyColumn })
            table.add(mutableListOf(emptyColumn))
            for (columnNum in 1..haystackLen) {
                val prevColumn = table[1][columnNum - 1] shr 1
                val letterPattern = alphabet[haystack[columnNum - 1]] ?: emptyColumn
                val curColumn = prevColumn or letterPattern
                table[1].add(curColumn)

                if (curColumn and 0x1 == 0) {
                    val place = haystack.substring(columnNum - needleLen, columnNum)
                    return Pair(place, 0)
                }
            }
            for (k in 2..maxErrors + 1) {
                table.add(mutableListOf(emptyColumn))

                for (columnNum in 1..haystackLen) {
                    val prevColumn = table[k][columnNum - 1] shr 1
                    val letterPattern = alphabet[haystack[columnNum - 1]] ?: emptyColumn
                    val curColumn = prevColumn or letterPattern

                    val insertColumn = curColumn and table[k - 1][columnNum - 1]
                    val deleteColumn = curColumn and (table[k - 1][columnNum] shr 1)
                    val replaceColumn = curColumn and (table[k - 1][columnNum - 1] shr 1)
                    val resColumn = insertColumn and deleteColumn and replaceColumn

                    table[k].add(resColumn)

                    if (resColumn and 0x1 == 0) {
                        // Taking into account Replace operation
                        val startPos = maxOf(0, columnNum - needleLen)
                        // Taking into account Replace operation
                        val endPos = minOf(columnNum, haystackLen)
                        val place = haystack.substring(startPos, endPos)
                        return Pair(place, k - 1)
                    }
                }
            }
            return Pair("", -1)
        }
    }
}