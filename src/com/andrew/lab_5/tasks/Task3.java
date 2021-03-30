package com.andrew.lab_5.tasks;

public class Task3 {
    public static Long numberSum(Long number) {
        Long sum = 0L;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static Long digitalRoot(Long number) {
        while (number / 10 > 0) {
            number = numberSum(number);
        }
        return number;
    }
}
