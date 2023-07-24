package lamdapractice;

import java.util.Scanner;
import java.util.function.Predicate;

public class CheckValidString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Predicate<String> checkValidity = (value)->{
            if(value ==  null) return false;
          char[] charArray =  value.toCharArray();
          for(char c : charArray){
              if(Character.isDigit(c)) return false;
          }
          return true;
        };
        System.out.println( checkValidity.test(input));
    }
}
