package com.example.homework1

import android.util.Log.d

fun main() {
    val math = TbcMath()
    println("udidesi saerto gamyofi - ${math.gcdOf(15, 48)}")
    println("umciresi saerto jeradi - ${math.lcmOf(54, 3)}")
    println("sheicavs simbolos \$ - ${math.containsDollar("ads\$hdsdf")}")
    println("luwebis jami 100-mde - ${math.sumOfEven(100)}")
    println("shebrunebuli ricxvi - ${math.reverseInt(2450)}")
    println("palindromi - ${math.isPalindrome("asdfda")}")
    println("palindromi - ${math.isPalindrome("asksa")}")
}

class TbcMath {
    /**
     * @return the Greatest Common Divisor of two numbers
     */
    fun gcdOf(num1: Int, num2: Int): Int {
        return if (num2 != 0)
            gcdOf(num2, num1 % num2)
        else
            num1
    }

    /**
     * @return the Lowest Common Multiple of two numbers
     */
    fun lcmOf(num1: Int, num2: Int): Int {
        return (num1 * num2 / gcdOf(num1, num2))
    }

    /**
     * @return true if the string contains '$' symbol
     */
    fun containsDollar(string: String): Boolean {
        var result = false
        for (i in string.indices) {
            if (string[i] == '$')
                result = true
        }
        return result
    }

    /**
     * @return the sum of even numbers from 0 to indicated number
     */
    fun sumOfEven(num: Int): Int {
        if (num == 0)
            return 0
        return if (num % 2 == 0) {
            num + sumOfEven(num - 1)
        } else {
            sumOfEven(num - 1)
        }
    }

    /**
     * @return reverse number
     */
    fun reverseInt(num: Int): Int {
        var newNum = num
        var result = 0
        while (newNum != 0) {
            result = result * 10 + newNum % 10
            newNum /= 10
        }
        return result
    }

    /**
     * Checks if the string is palindrome
     */
    fun isPalindrome(string: String): Boolean {
        var result = true
        for (i in 0 until string.length / 2) {
            if (string[i] != string[string.length - 1 - i])
                result = false
        }
        return result
    }


}