package ProgramPractice;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter year");
        int year = scan.nextInt();
        boolean leap;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    leap = true;
                    System.out.println(year + ": Year is a leap year");
                } else {
                    leap = false;
                    System.out.println(year + ": Year is not a leap year");
                }
            }
            else{
                leap = true;
                System.out.println(year + ": Year is a leap year");
            }

        } else {
            leap = false;
            System.out.println(year + ": Year is not a leap year");
        }

    }

}
