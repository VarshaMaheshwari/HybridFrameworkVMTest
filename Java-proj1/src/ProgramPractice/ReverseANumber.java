package ProgramPractice;

public class ReverseANumber {

    public static void main(String[] args) {

        String str="Varsha", revStr="";
        char ch;
int strLen=str.length();
        System.out.println(strLen+ "strLen");
        for(int i=strLen;i<=0;i--){
            ch=str.charAt(i);
            revStr=revStr+ch;
        }
System.out.println(revStr+ "revStr is");




        int num = 1221;
        int reveresedNum = reverse(num);
        System.out.println("Reverse number is :" + reveresedNum);

        boolean isPalindrome = palindrom(reveresedNum, num);
        if (isPalindrome == true) {
            System.out.println("Number is a palindrome number");
        }
        else{
            System.out.println("Number is not a palindrome number");
        }
    }


    public static boolean palindrom(int rev, int num) {
        boolean palindrome;
        if (rev == num) {
            palindrome = true;
        } else {
            palindrome = false;
        }

        return palindrome;
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) { //54321
            int modulo = num % 10;//1
            rev = rev * 10 + modulo;//1
            System.out.println("Number value is" + num);
            num = num / 10;

        }
        return rev;
    }



}
