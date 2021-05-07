package com.example.homework1

fun main() {
    val math = Tbc()
    println(math.differentNums(listOf(5, 78, 45 )))
    println(math.commonNumbers(listOf(5, 78, 45 ), listOf(5, 8, 9, 45)))
    println(math.joinLists(listOf(5, 78, 45 ), listOf(5, 8, 9, 45)))
    println(math.lessThanMean(listOf(5, 78, 45 )))
    println(math.secondMinMax(listOf(5, 78, 45, 45, 6, 789, 789, 900, 789 )))
}

class Tbc {
    /**
     * @return distinct numbers
     */
    fun differentNums(intArray : List<Int>) : Int {
        return intArray.distinct().size
    }

    /**
     * @return xommon elements of two lists
     */
    fun commonNumbers( list1: List<Int>, list2: List<Int>) : List<Int> {
        val commonList = mutableListOf<Int>()
        for (i in list1.indices) {
            for (element in list2) {
                if (list1[i] == element)
                    commonList.add(list1[i])
            }
        }
        return commonList
    }

    /**
     * @return concatinated lists
     */
    fun joinLists (list1: List<Int>, list2: List<Int>) : List<Int> {
        val newList = mutableListOf<Int>()
        for (element in list1)
            newList.add(element)
        for (element in list2)
            newList.add(element)
        return newList
    }

    /**
     * @return elements less then tehir mean
     */
    fun lessThanMean (list : List<Int>) : List<Int> {
        val meansList = mutableListOf<Int>()
        var sum = 0
        for (element in  list) {
            sum += element
        }
        val mean = sum / list.size

        for (element in list) {
            if (element < mean)
                meansList.add(element)
        }
        return meansList
    }

    /**
     * @return second min and second max elements of the list
     */
    fun secondMinMax (list : List<Int>) : List<Int> {
        var resultList = mutableListOf<Int>()
        val sortedSet = list.sorted()
        println("sorted $sortedSet")
        resultList.add(sortedSet[1])
        resultList.add(sortedSet[sortedSet.size-2])
        println("list = $resultList")
        return resultList
    }
}