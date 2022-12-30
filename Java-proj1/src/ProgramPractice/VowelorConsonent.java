package ProgramPractice;

public class VowelorConsonent {
public static void main(String[] args){
    char c='o';

    switch (c){
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            System.out.println(c +" char is a vowel");
            break;
        default :
            System.out.println(c +" char is a Consonent");

    }

    //STring contains vowels

    String str="Varsha";

   if( str.contains("a")||str.contains("e")||str.contains("i")||str.contains("o")||str.contains("u")){
       System.out.println(str+" string contains vowel");

   }
   else{
       System.out.println(str+" string does not contain any vowel");
   }
}

}
