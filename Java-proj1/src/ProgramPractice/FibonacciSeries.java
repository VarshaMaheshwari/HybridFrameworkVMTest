package ProgramPractice;

public class FibonacciSeries {

    public static void main(String[] args) {
        //0 1 1 2 3 5 8 13 21 34
        int tillNum = 8, fibo = 0;
        int num1 = 0, num2 = 1;

        System.out.print("Fibonacci series:" + num1 + " " + num2);
        for (int i = 0; i < tillNum; i++) {
            fibo = num1 + num2;
            System.out.print(" " + fibo);
            num1 = num2;
            num2 = fibo;
        }

    }
    //System.out.println("Fibonacci value is:" + fibo + "till number:" + tillNum);
}



