package ProgramPractice;

import java.util.Scanner;

public class BasicOperationsProg {
    public static void main(String[] args) {
//2nd prog

//        int a =20, b=32;
//        int sum=a+b;
//        System.out.println("sum of 2 numb: "+ sum);

        //3rd prog: Multiple 2 float numbers

        float num1 = 23.456f, num2 = 9.8f;
        float multipliedNum = num1 * num2;
        System.out.println("Multiplication for 2 float numbers: " + multipliedNum);

        //4th prog:

        char c = 's';
        int ascii = c;
        System.out.println("Char assigning to int gives value as: " + ascii);
        int ascNum = (int) c;
        System.out.println("Char casting to int gives value as: " + ascNum);

        //5th prog: Print Remainder of 2 num division

        int dividend = 30, divisor = 4;
        int divOutput = dividend / divisor;
        int remainder = dividend % divisor;

        System.out.println("Division output value is: " + divOutput);
        System.out.println("Division remainder value is: " + remainder);

        //Swap 2 numbers
        int x = 456, y = 123;
        int temp;

        System.out.println("Value of var x before swap: " + x);
        System.out.println("Value of var y before swap: " + y);

//        temp=x;
//        x=y;
//        y=temp;
//
//        System.out.println("Value of var x after swap: "+ x);
//        System.out.println("Value of var y after swap: "+ y);

//Swap without temp variable

        x = x + y; //579
        y = x - y; //123
        x = x - y;//456
        System.out.println("Value of var x after swap: " + x);
        System.out.println("Value of var y after swap: " + y);

        //EvenandOdd numbers

        Scanner read = new Scanner(System.in);
        System.out.println("Please enter a number");
        int testNum = read.nextInt();

        if (testNum % 2 == 0) {
            System.out.println(testNum + ": Number is even number");
        } else {
            System.out.println(testNum + ": Number is odd number");
        }


//factorial no
        int  numTofact = 0;
      getFact(numTofact);
System.out.println("test msg");



        //largest numb in 3 numbers

        int m = 345, n = 145, o = 900;

        if ((m > n) && (m > o)) {
            System.out.println(m + ": m is greatest number");
        } else if (n > o) {
            System.out.println(n + ": n is greatest number");
        } else {
            System.out.println(o + ": o is greatest number");
        }


        //Check if number is positive or negative
        Scanner dNumRead = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        Double dNum = dNumRead.nextDouble();

        if (dNum == 0.0) {
            System.out.println(dNum + "Number is 0");
        } else if (dNum > 0.0) {
            System.out.println(dNum + "Number is a positive number");

        } else {
            System.out.println(dNum + "Number is a negative number");
        }

        //Sum of all natural numbers
        Scanner natNumScan = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int natNum = natNumScan.nextInt();
        int sum = 0;


        for (int i = 1; i < natNum; i++) {
            sum = sum + i;

        }
        System.out.println("Sum of natural numbers till" + natNum + " is:  " + sum);
        sum = 0;
        int j = 1;
        while (j < natNum) {
            sum = sum + j;
            j++;
        }
        System.out.println("Sum of natural numbers till" + natNum + " is:  " + sum);
        //check if char is an alphabets
        char ch = '*';

        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            System.out.println(ch + " char is an alphabet");
        } else {
            System.out.println(ch + " char is not an alphabet");
        }

        }
    public static void getFact(int numTofact) {
        int fact=1;

        for (int i = 1; i <= numTofact; i++) {
            fact = fact * i;

        }
        System.out.println("Factorial of a "+numTofact+ "is: " +fact);
    }
    }

