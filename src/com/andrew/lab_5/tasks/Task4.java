package com.andrew.lab_5.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {
    public static int find(ArrayList<Integer> array, int num) {
        int res = array.lastIndexOf(num);
        if (res < 0) {
            return 0;
        }
        res = 1 + res - array.indexOf(num);
        return res;
    }
    public static int countPairsUsingFor(ArrayList<Integer> array, int target) {
        ArrayList<Integer> sortedArray = new ArrayList<>(array);
        sortedArray.sort(Integer::compareTo);
        int count = 0;

        for (int i = 0; i < sortedArray.size(); i++) {
            int num = target - sortedArray.get(i);
            if (num == sortedArray.get(i)) {
                count -= 1;
            }
            count += find(sortedArray, target - sortedArray.get(i));
        }

        return count / 2;
    }

    public static int countPairsUsingStream(ArrayList<Integer> array, int target) {
        ArrayList<Integer> sortedArray = new ArrayList<>(array);
        sortedArray.sort(Integer::compareTo);

        int count = sortedArray.stream().reduce(0, (partialCount, el) -> {
            int num = target - el;
            if (num == el) {
                partialCount -= 1;
            }
            partialCount += find(sortedArray, target - el);
            return partialCount;
        });

        return count / 2;
    }
}
