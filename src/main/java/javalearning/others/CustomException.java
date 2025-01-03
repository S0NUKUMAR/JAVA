package javalearning.others;

/*
  Write a Java program to create a method that takes a string as input and throws an exception if the string does not contain vowels;
 */
public class CustomException {
    public static void main(String[] args) {
        try {
            checkVowelFunction("bcdfgh");
        }
        catch (NoVowelsException e){
            System.out.println("exception occured" + e.getMessage());
        }
    }

    public static void checkVowelFunction(String str) throws NoVowelsException {
        String vowels = "aeiouAEIOU";

        //Option 1:
        boolean flag = false;
        for(int i = 0 ; i< str.length() ; i++){
            if(vowels.contains(String.valueOf(str.charAt(i)))){
                flag = true;
                break;
            }
        }

        //Option 2:
        flag =  str.chars().mapToObj(e -> (char)e).anyMatch(character -> vowels.indexOf(character)>=0);
        if(!flag){
           throw new NoVowelsException("String does not contains vowels");
        }
    }
}

class NoVowelsException extends Exception{
    public NoVowelsException(String str){
        super(str);
    }
}


