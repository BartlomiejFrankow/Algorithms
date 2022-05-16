package com.example.algorithms.sort.shell;

import static com.example.algorithms.help.StdOut.println;
import static com.example.algorithms.sort.SortHelperKt.exchange;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

// Time complexity: O(n^3/2)
public class ShellSort {

    public void sortIntegersAscending(@NotNull Integer[] array) {
        long beginTime = System.nanoTime();
        println("SHELL SORT INPUT DATA: " + Arrays.toString(array));

        int arraySize = array.length;

        int sequence = 1;

        while (sequence < arraySize / 3) {
            sequence = 3 * sequence + 1; // 1, 4, 13, 40, 121, 364...
        }

        while (sequence >= 1) {
            for (int i = sequence; i < arraySize; i++) {
                for (int j = i; j >= sequence && array[j] < array[j - sequence]; j -= sequence) {
                    exchange(array, j, j - sequence);
                }
            }

            sequence = sequence / 3;
        }

        long endTime = System.nanoTime();
        println("SHELL SORT TIME: " + (endTime - beginTime) / 1000 + ", results: " + Arrays.toString(array));

    }
}
