package com.bootcamp.quis.day4;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(leapYear(1900));
        System.out.println(leapYear(2000));
        System.out.println(leapYear(2020));

    }

    public static String leapYear(int year) {
        String result = "";
        if (year % 400 == 0) {
            result = "Leap Year";
        } else {
            if (year % 100 == 0) {
                result = "Not Leap Year";
            } else {
                if (year % 4 == 0) {
                    result = "Leap Year";
                } else {
                    result = "Not Leap Year";
                }
            }
        }
        return result;
    }
}
