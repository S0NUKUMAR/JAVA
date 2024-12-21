package dataStructure.DynamicProgramming.PartitionProblems;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args){
        int[] array = new int[]{10, 20 , 30 , 40 , 50};
        int miniOp = recursionSolution(array , 1,array.length -1);
        System.out.println(miniOp);


        int[][] dp = new int[array.length][array.length];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        int miniOpMemo = memoizationSolution(array,1 , array.length -1,dp);
        System.out.println(miniOpMemo);
    }

    private static int memoizationSolution(int[] array, int i, int j, int[][] dp) {
        if(i == j) return 0;
        if(dp[i][j]!= -1 ) return  dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int ind = i ; ind < j ; ind++){
            int s = array[i-1] * array[ind] * array[j] + recursionSolution(array, i , ind) + recursionSolution(array, ind + 1 , j);
            mini = Math.min(mini , s);
        }
        return mini ;

    }

    private static int recursionSolution(int[] array , int i, int j) {
        if(i==j) return  0;
        int mini = Integer.MAX_VALUE;
        for(int ind = i ; ind < j ; ind++){
            int s = array[i-1] * array[ind] * array[j] + recursionSolution(array, i , ind) + recursionSolution(array, ind + 1 , j);
            mini = Math.min(mini , s);
        }
        return mini;
    }

}
