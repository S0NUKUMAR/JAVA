package dataStructure.DynamicProgramming;

public class TargetSum {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2};

        int totalWays = findTotalNoWays(array ,array.length -1 , 3);
        System.out.println(totalWays);
    }

    public static int findTotalNoWays(int[] array , int idx , int sum){
        if(sum == 0) return 1;
        if(idx == 0) return array[idx] == sum ? 1 : 0;

        int exclusion = findTotalNoWays(array,idx -1 , sum);
        int inclusion = 0;
        if(array[idx]<=sum)
            inclusion = findTotalNoWays(array,idx , sum - array[idx]);

        return inclusion + exclusion;
    }
}
