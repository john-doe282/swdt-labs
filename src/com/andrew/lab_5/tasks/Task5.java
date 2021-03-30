package com.andrew.lab_5.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

public class Task5 {
    public static String meeting(String friendListString) {
        String[] friends = friendListString.
                toUpperCase(Locale.ROOT).
                split(";");

        return Arrays.stream(friends).
                map((friend) -> {
                    String[] names = friend.split(":");
                    return new Friend(names[0], names[1]);
                }).
                sorted(Friend.comparator()).
                map(Friend::toString).
                collect(Collectors.joining());
    }

    private static class Friend {
        public String firstName;
        public String lastName;

        public Friend(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public static FriendComparator comparator() {
            return new FriendComparator();
        }

        @Override
        public String toString() {
            return "(" + lastName + ", " + firstName + ")";
        }

        private static class FriendComparator implements Comparator<Friend> {

            @Override
            public int compare(Friend f1, Friend f2) {
                int compare = f1.lastName.compareTo(f2.lastName);
                if (compare == 0) {
                    compare = f1.firstName.compareTo(f2.firstName);
                }
                return compare;
            }
        }
    }
}
