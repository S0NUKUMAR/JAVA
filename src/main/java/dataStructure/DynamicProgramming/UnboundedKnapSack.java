package dataStructure.DynamicProgramming;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int[] wt = {2,4,6};
        int[] val = {5, 11, 13};

        int total = 10;

        int profit = unboundedKnapSack(wt.length -1, wt , val , total);
        System.out.println(profit);
    }

    private static int unboundedKnapSack(int idx , int[] wt , int[] val , int total){
        if(idx == 0 ) return wt[idx] == total ? val[idx] : Integer.MIN_VALUE;

        int exclusion = unboundedKnapSack(idx - 1 , wt , val , total);
        int inclusion = Integer.MIN_VALUE;

        if(wt[idx] <= total)
            inclusion = unboundedKnapSack(idx , wt , val , total - wt[idx]) + val[idx];

        return Math.max(inclusion,exclusion);

    }
}
