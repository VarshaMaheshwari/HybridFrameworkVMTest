package ProgramPractice;

public class PowerConcept {
    public static void main(String[] args) {
        //3^4=3*3*3*3
        int base = 3, exponent = 4;

        long resBaseToPowerExponent = 1;

        while (exponent != 0) { //4, 3, 2, 1
            resBaseToPowerExponent = resBaseToPowerExponent * base;//3,9,27,81 //exp=4,3,2,1
            --exponent;//3,2,1,0

        }

        System.out.println(resBaseToPowerExponent);
        System.out.println((int)Math.pow(3,4));
    }


}
