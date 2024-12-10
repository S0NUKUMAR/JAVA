package dataStructure.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public  static void main(String[] args){
        String a = "abc";
        String b = "abcd";

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];
        Arrays.fill(dp[a.length()-1],-1);

        int length = RecursionFunction(a,a.length() -1 ,b,b.length()-1);
        System.out.println(length);

        int l = MemoizationFunction(a,a.length() -1 ,b,b.length()-1 ,dp);
        System.out.println(l);

        int[][] dp1 = new int[n+1][m+1];
        Arrays.fill(dp1[0], 0);
        int l1 = DynamicProgram(a,n + 1, b,m+1,dp1);
        System.out.println(l1);

        int sum = sum(10,20);
        System.out.println(sum);
    }


    private static int DynamicProgram(String a, int n, String b, int m, int[][] dp) {
        for(int i = 0 ; i <n ; i++){
            for(int j =  0; j <m ; j++){
                if(i==0 || j== 0){
                    dp[i][j]=0;
                }
                else if(a.charAt(i-1) == b.charAt(j -1)){
                    dp[i][j] = 1  + dp[i -1][j -1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j -1]);
                }
            }
        }
            return dp[n-1][m-1];
    }

    private static int MemoizationFunction(String a, int i, String b, int j, int[][] dp) {
        if(i < 0 || j < 0)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j))
            return 1 + RecursionFunction(a,i - 1 , b,j -1);
        return Math.max(RecursionFunction(a,i,b, j-1),RecursionFunction(a , i-1 ,b, j));
    }

    private static int RecursionFunction(String a , int l1, String b,int l2) {
        if(l1 <0 || l2< 0){
            return 0;
        }

        if(a.charAt(l1) == b.charAt(l2))
            return 1 + RecursionFunction(a,l1 - 1 , b,l2 -1);
        return Math.max(RecursionFunction(a,l1,b, l2 -1),RecursionFunction(a , l1-1 ,b, l2));
    }

    private static int sum(int a , int b){
        return a + b;
    }
}



