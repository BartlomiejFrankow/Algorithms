package com.example.algorithms.dataStructures.hash

import com.example.algorithms.dataStructures.hash.HashMapAction.ADD
import com.example.algorithms.dataStructures.hash.HashMapAction.REMOVE

/**
 * Mutable storage for keys and values with different types.
 * In best case `add`, `getByValue` and `remove` are constant time O(1) if value is single.
 * In worst case `add` and `remove` are linear O(n). `getByValue` is always O(1) in
 * case of single value. When value is list and need to traverse it then `getByValue` is O(n/k).
 * Immutable equivalent is `Map`.
 * */
class HashMapExample {

    private val hashMap = hashMapOf<Char, MutableList<String>>()

    private fun doAction(action: HashMapAction, hashKeyOfNewValue: Char, value: String) {
        hashMap[hashKeyOfNewValue]?.let { keyList ->
            when (action) {
                ADD -> keyList.add(value)
                REMOVE -> keyList.remove(value)
            }
            hashMap[hashKeyOfNewValue] = keyList
        }
    }

    fun getByKey(key: Char) = hashMap[key]

    fun getByValue(value: String): String? {
        value.replaceFirstChar { it.uppercase() }

        val hashKeyOfNewValue = value[0]

        return if (hashMap.containsKey(hashKeyOfNewValue)) {
            hashMap[hashKeyOfNewValue]?.find { it == value }
        } else {
            null
        }
    }

    fun add(value: String) {
        value.replaceFirstChar { it.uppercase() }

        val hashKeyOfNewValue = value[0]

        if (hashMap.containsKey(hashKeyOfNewValue)) {
            doAction(ADD, hashKeyOfNewValue, value)
        } else {
            hashMap[hashKeyOfNewValue] = mutableListOf(value)
        }

        println("Action add: $value to $hashKeyOfNewValue")
    }

    fun remove(value: String) {
        value.replaceFirstChar { it.uppercase() }

        val hashKeyOfNewValue = value[0]

        if (hashMap.containsKey(hashKeyOfNewValue)) {
            println("Action remove: $value from $hashKeyOfNewValue")
            doAction(REMOVE, hashKeyOfNewValue, value)
        }
    }

    fun printMap() {
        println("-----------ACTIONS-----------")

        hashMap.forEach { (index, value) ->
            println("$index, $value")
        }

        println("-----------END-OF-HASHMAP-----------")
        println()
    }
}

enum class HashMapAction {
    ADD,
    REMOVE
}

fun main() {
    HashMapExample().apply {
        add("Banana")
        add("Avokado")
        add("Blueberry")
        add("Apple")
        add("Coconut")

        printMap()

        remove("Blueberry")

        printMap()
    }
}
