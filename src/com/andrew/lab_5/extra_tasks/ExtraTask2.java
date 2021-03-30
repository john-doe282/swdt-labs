package com.andrew.lab_5.extra_tasks;

import static java.lang.Math.pow;

public class ExtraTask2 {
    public static String toIPv4(long ip) {
        if (ip < 0 || ip > pow(2, 32) - 1) {
            throw new IllegalArgumentException();
        }

        return ((ip >> 24) & 0xFF) + "." +
               ((ip >> 16) & 0xFF) + "." +
               ((ip >> 8)  & 0xFF) + "." +
               ( ip        & 0xFF);
    }
}
