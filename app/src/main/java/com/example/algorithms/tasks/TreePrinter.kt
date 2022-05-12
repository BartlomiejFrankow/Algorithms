package com.example.algorithms.tasks

import com.example.algorithms.Relation

/*
* Time complexity: O(n)
* Space complexity: O(n)
*/

class TreePrinter {
    val parentsAndChildsMap = hashMapOf<String, MutableList<String>>()

    fun printTree(relations: List<Relation>) {

        val childs = mutableListOf<String>()
        // Expected output:
        /*  lifeform
                animal
                    mammal
                        cat
                            lion
                    bird
                    fish
        */

        /* Connections
        * parent (lifeform) -> child(animal)
        * parent(animal) -> child(mammal, bird, fish)
        * parent(mammal) -> child(cat)
        * parent(cat) -> child(lion)
        */

        relations.forEach { relation ->
            childs.add(relation.child)

            if (parentsAndChildsMap.containsKey(relation.parent)) {
                parentsAndChildsMap[relation.parent]!!.add(relation.child)
            } else {
                parentsAndChildsMap[relation.parent] = mutableListOf(relation.child)
            }
        }

        var root = ""
        parentsAndChildsMap.forEach { entry ->
            if (!childs.contains(entry.key)) root = entry.key
        }


        println("ANIMALS_TREE:")
        printWithLevels(root, 0)
    }

    private fun printWithLevels(parent: String, level: Int) {

        for (i in 0..level) {
            print("\t")
        }

        println(parent)

        parentsAndChildsMap[parent]?.let { childrens ->
            for (child in childrens) {
                printWithLevels(child, level + 1)
            }
        }
    }
}
