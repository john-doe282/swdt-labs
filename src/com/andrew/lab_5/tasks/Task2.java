package com.andrew.lab_5.tasks;

import java.util.Arrays;
import java.util.Locale;

public class Task2 {
    public static String firstNonRepeatedLetter(String input) {
        String lowerCase = input.toLowerCase(Locale.ROOT);
        char[] lowerCaseSortedArray = lowerCase.toCharArray();
        Arrays.sort(lowerCaseSortedArray);

        boolean repeated = false;
        int min_idx = lowerCaseSortedArray.length;

        for (int i = 0; i < lowerCaseSortedArray.length - 1; i++) {
            if (lowerCaseSortedArray[i + 1] == lowerCaseSortedArray[i]) {
                repeated = true;
            } else {
                if (repeated && i != lowerCaseSortedArray.length - 2) {
                    repeated = false;
                    continue;
                }

                if (repeated) {
                    i += 1;
                }

                int idx = lowerCase.indexOf(lowerCaseSortedArray[i]);
                if (idx < min_idx) {
                    min_idx = idx;
                }
            }
        }
        if (min_idx < lowerCaseSortedArray.length) {
            return String.valueOf(input.charAt(min_idx));
        }

        return "";
    }
}
