package dataStructure.DynamicProgramming.PartitionProblems;

import java.util.Arrays;

public class  PalindromePartitioning{
    public static void main(String[] args) {
        String str = "abbaab";

        //subtracting 1 because the last cut is happening after the string
        int minCut = recursiveSolution(str,0) - 1;
        System.out.println(minCut);

        int n = str.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);

        for(int i = n -1 ; i>=0 ; i--){
            int mini = Integer.MAX_VALUE;
            for(int k = i ; k < str.length() ; k++){
                if(isPalindrome(str, i, k)) {
                    int cut = 1 + dp[k+1];
                    mini  = Math.min(cut,mini);
                }
                dp[i] = mini;
            }
        }
        System.out.println(dp[0] -1);
    }

    private static int recursiveSolution(String str, int i){
        if(i == str.length()) return 0;

        int mini = Integer.MAX_VALUE;
        for(int k = i ; k < str.length() ; k++){
            if(isPalindrome(str, i, k)) {
                int cut = 1 + recursiveSolution(str,k+1);
                mini  = Math.min(cut,mini);
            }
        }
        return  mini;
    }

    private static boolean isPalindrome(String str ,int i , int j){
        while(i<j){
            if(str.charAt(i) !=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
