package Practice2;

public class ReverseString {

    public static void main(String[] args) {
//        String str = "Level";
//        String reverseStr = "";
//
//        char[] chararr = str.toCharArray();
//        for (int i = chararr.length; i > 0; i--) {
//            reverseStr = reverseStr + str.charAt(i - 1);
//            System.out.println("reverseStr value: " + reverseStr);
//        }
//

      // }

        String str="I Love India";
       String[] arrStr= str.split(" ");
        for( String strTest:arrStr){
            System.out.println("printing string array: "+ strTest);
        }
        for(int i=1;i<arrStr.length;i++){
         char[] arrCharStr= arrStr[i].toCharArray();
            String revstr= "";
            for (int j=arrCharStr.length;j>0;j--){

                revstr=revstr+arrCharStr[j];
                System.out.println ("revSTr value is:" + revstr);



            }
        }

    }
}
