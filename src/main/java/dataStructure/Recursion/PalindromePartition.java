package dataStructure.Recursion;

import java.util.ArrayList;

public class PalindromePartition {
    public static void main(String[] args) {
        String str = "aabb";
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        findAllPalindrome(str, 0, new ArrayList<String>(),list);
        System.out.println(list);
    }

    private static void findAllPalindrome(String str, int idx, ArrayList<String> temp, ArrayList<ArrayList<String>> list) {
        if(idx == str.length()){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx ; i < str.length() ; i++){
            String prefix = str.substring(idx,i+1);
            if(isPalindrome(prefix)){
                temp.add(prefix);
                findAllPalindrome(str,idx+1,temp ,list);
                temp.remove(temp.size() -1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int start = 0 ;
        int end = s.length() -1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}
