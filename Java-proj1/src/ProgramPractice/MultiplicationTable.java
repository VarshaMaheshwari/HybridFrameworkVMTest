package ProgramPractice;

public class MultiplicationTable {

    public static void main(String[] args) {
        //5*1=5
        //i*j=k

        int tabNum2 = 12, multiResult = 1;
        multiTable(tabNum2, multiResult);

    }

    public static void multiTable(int tabNum2, int multiResult) {
        for (int j = 11; j <= tabNum2; j++) {
            for (int k = 1; k <= 10; k++) {
                multiResult = j * k;
                System.out.println(j + " * " + k + "=" + multiResult);
            }
        }
    }


}



