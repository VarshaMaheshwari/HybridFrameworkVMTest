package ProgramPractice;

import java.util.Scanner;

public class PrintIntFromUser
{

    public static void main (String[] args){

        Scanner read= new Scanner(System.in);
        System.out.println("Please enter number to print:  ");

        int num= read.nextInt();
        System.out.println("Interger shared by user is: " + num);


}



}
