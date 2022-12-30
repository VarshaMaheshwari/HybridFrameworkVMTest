package ProgramPractice;

public class NumbersofDigits {

    public static void main(String[] args) {

        int num = 1111, count = 0;

        while (num != 0) {
            num = num / 10;
            count++;
        }
        System.out.print("Count of numbers:" + count);

    }
}
