package com.example.algorithms.dataStructures.hash

/**
 * Mutable storage for values only.
 * `add` function is always O(1), but `getOrNull` and `remove` are always O(n).
 * Immutable equivalent is `Set`.
 * */
class HashSetExample {

    val hashSet = hashSetOf<String>()

    fun add(value: String) = hashSet.add(value)

    fun remove(value: String) = hashSet.remove(value)

    fun getOrNull(value: String) = hashSet.firstOrNull { it == value }
}
