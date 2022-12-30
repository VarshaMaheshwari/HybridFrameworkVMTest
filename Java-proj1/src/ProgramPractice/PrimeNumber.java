package ProgramPractice;

public class PrimeNumber {

    public static void main(String[] args) {

        //prime number= divisible by it self and 1 only

        int num = 21;
        boolean prime = false;
        int fromNum = 2, toNum = 40;
        prime = isPrimeNumber(num);
        if (prime == true) {
            System.out.println(num + "num is a prime number");
        } else {
            System.out.println(num + "num is not a prime number");
        }

        int primeCount= countPrimeNum(fromNum,toNum);
        System.out.println("Prime number count between "+fromNum+ "and "+ toNum+ "is: "+ primeCount);

    }

    public static boolean isPrimeNumber(int num) {
        boolean isPrime = false;
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }

        return isPrime;
    }

    public static int countPrimeNum(int from, int to) {
        boolean isPrime = false;
        int count=0;
        for (int j = from; j <= to; j++) {
            for (int i = 2; i <= (j - 1); i++) {
                if (j % i == 0) {
                    isPrime = false;
                    break;
                } else {
                    isPrime = true;
                    System.out.println(j+" is a prime number");
                }

            }
            if(isPrime==true){
              count++;
            }
        }

        return count;
    }


}
