package com.example.algorithms.timeComplexity

class TimeComplexity {

    // O(1) - Constant Time
    val characters = arrayOf("donkey kong", "zelda", "mario", "pac-man")
    fun checkO1(line: Array<String>): String {
        return line[0]
    }

    // O(n) - Linear Time Complexity
    fun checkOn() {
        val desserts = arrayOf("cinnamon", "cinnamon roll", "flan", "favorite")

        desserts.forEach {
            if (it == "favorite") println("Yas! $it is my fave!")
        }
    }
    // -------------------------------------------------------------

    // O(log n)
    private fun halfToZero(input: Int) {
        var i = input
        var operations = 0
        while (i > 0) {
            i /= 2
            println("i is now = $i")
            operations++
        }
        println("$operations total operations")
    }

    fun checkOLogN() {
        halfToZero(40) // 6 total operations
        halfToZero(400) // 9 total operations
        halfToZero(4000) // 12 total operations
    }
    // -------------------------------------------------------------

    // O(n^2) - Quadratic Time Complexity
    fun checkOn2() {
        val numbers = arrayOf(1, 2, 3, 4, 5)
        numbers.forEach { num1 ->
            numbers.forEach { num2 ->
                println("$num1, $num2")
            }
        }
    }
    // -------------------------------------------------------------

    // O(2^n) - Exponential
    fun check02n(number: Int): Int {
        return if (number < 1) {
            number
        } else {
            check02n(number - 1) + check02n(number - 2)
        }
    }
    // -------------------------------------------------------------
}
