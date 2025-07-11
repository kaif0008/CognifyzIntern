import java.util.Scanner;

public class palindromeChecker {

    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter word or phrase : ");
        String input=new String(sc.nextLine());
        sc.close();
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean check=true;
        for(int i=0;i<cleanedInput.length();i++){
            if(cleanedInput.charAt(i)!=cleanedInput.charAt(cleanedInput.length()-1-i)){
                 System.out.println(input+" is not a Palindrome");
                 check=false;
                 break;
            }
        }
        if(check){
           System.out.println(input+" is a Palindrome."); 
        }
    }
}
