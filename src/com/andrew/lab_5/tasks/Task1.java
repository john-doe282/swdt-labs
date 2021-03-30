package com.andrew.lab_5.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static List<Integer> getIntegersFromList(List<Object> input) {
        return input.stream()
                .filter(el -> el instanceof Integer)
                .map(el -> (Integer) el)
                .collect(Collectors.toList());
    }
}
