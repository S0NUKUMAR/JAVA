package dataStructure.DynamicProgramming;

import java.util.ArrayList;

public class CoinChange {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2};

        // multiple selection is allowed
        ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
        int sum = 0;
        int ans = findMinimumCountCoin(array,array.length -1, sum);
        System.out.println(ans);
    }

    private static int  findMinimumCountCoin(int[] array , int idx , int sum){
        if(idx == 0)
            if(sum%array[idx]==0)
                return sum/array[idx];
            else
                return Integer.MAX_VALUE;

        int exclusion = findMinimumCountCoin(array,idx-1 , sum);
        int inclusion = Integer.MAX_VALUE;
        if(array[idx]<=sum)
            inclusion = 1 + findMinimumCountCoin(array , idx , sum - array[idx]);

        return Math.min(inclusion,exclusion);
    }

    }

