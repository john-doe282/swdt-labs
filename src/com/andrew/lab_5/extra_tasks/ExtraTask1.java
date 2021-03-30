package com.andrew.lab_5.extra_tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExtraTask1 {
    public static Integer nextBigger(Integer num) {
        List<Character> numList = num.toString().
                chars().
                mapToObj(c -> (char) c).
                collect(Collectors.toList());

        for (int i = numList.size() - 1; i > -1; i--) {
            int before = numList.get(i);
            List<Character> subNumList = numList.subList(i, numList.size());
            subNumList.sort(Comparator.reverseOrder());

            if (numList.get(i) != before) {
                break;
            }
        }

        String nextBiggerStr = numList.stream().
                map(Objects::toString).
                collect(Collectors.joining());

        Integer nextBigger = Integer.valueOf(nextBiggerStr);

        if (nextBigger > num) {
            return nextBigger;
        }
        return -1;
    }
}
