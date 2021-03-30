package com.andrew.lab_5;

import com.andrew.lab_5.extra_tasks.ExtraTask1;
import com.andrew.lab_5.tasks.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void mainTasks() {
        System.out.println(Task1.getIntegersFromList(List.of(1, "a", 2, "b")));

        System.out.println(Task2.firstNonRepeatedLetter("sTrRess"));

        System.out.println(Task3.digitalRoot(132189L));

        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 2, 5, 3, 0));
        System.out.println(Task4.countPairsUsingFor(arrayList, 5));
        System.out.println(Task4.countPairsUsingStream(arrayList, 5));

        System.out.println(Task5.meeting("Fred:Corwill;Wilfried:" +
                "Corwill;Barney:Tornbull;Bjorn:Tornbull"));
    }

    public static void extraTasks() {
        System.out.println(ExtraTask1.nextBigger(2017));
    }
    public static void main(String[] args) {
	// write your code here
        mainTasks();
        extraTasks();

    }
}
