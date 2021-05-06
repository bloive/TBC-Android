package com.example.homework1

fun main() {
    val math = TbcNumbersInGeorgian()

    for (i in 3..1000 step 63) {
        println("$i - ${math.toVerbalMeaning(i)}")
    }
    for (i in 0..200 step 15) {
        println("$i - ${math.toVerbalMeaning(i)}")
    }
}

class TbcNumbersInGeorgian {
    /**
     * @returns Georgian name of passed number
     */
    fun toVerbalMeaning(num: Int): String {
        var res = ""
        var tensString = "ოცი"

        val essentialsMap = mapOf(
            0 to "ნული", 1 to "ერთი", 2 to "ორი", 3 to "სამი", 4 to "ოთხი", 5 to "ხუთი",
            6 to "ექვსი", 7 to "შვიდი", 8 to "რვა", 9 to "ცხრა", 10 to "ათი", 11 to "თერთმეტი",
            12 to "თორმეტი", 13 to "ცამეტი", 14 to "თოთხმეტი", 15 to "თხუთმეტი",
            16 to "თექვსმეტი", 17 to "ჩვიდმეტი", 18 to "თვრამეტი", 19 to "ცხრამეტი",
            20 to "ოცი", 100 to "ასი")

        if (essentialsMap.containsKey(num)) {
            res = essentialsMap.getValue(num)
        } else {
            val base = num % 100
            if (essentialsMap.containsKey(base))
                tensString = essentialsMap.getValue(base)
            else if (base % 20 != 0) {
                tensString = "ოცდა${essentialsMap.getValue(base % 20)}"
            }
            when {
                base / 20 == 2 ->
                    tensString = "ორმ$tensString"
                base / 20 == 3 ->
                    tensString = "სამ$tensString"
                base / 20 == 4 ->
                    tensString = "ოთხმ$tensString"
            }
            res = tensString

            if (num > 100) {
                var firstDigit = essentialsMap.getValue(num / 100)
                if (firstDigit[firstDigit.lastIndex] == 'ი') {
                    firstDigit = firstDigit.substring(0, firstDigit.length - 1)
                }
                val baseHundredsString = "ას $tensString"
                res = if (num / 100 == 1) {
                    baseHundredsString
                } else {
                    "$firstDigit$baseHundredsString"
                }
            }
        }
        return res
    }
}