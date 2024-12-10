package dataStructure.DynamicProgramming.PartitionProblems;

public class BooleanExpression {
    public static void main(String[] args) {
        String exp = "T|T&F";
        boolean isTrue = true;
        int waysToMakeTrue = recursiveSolutionExpression(exp , 0 , exp.length(),isTrue);
        System.out.println(waysToMakeTrue);
    }

    private static int recursiveSolutionExpression(String exp, int i, int j, boolean isTrue) {
        if(i < j ) return 0 ;
        if(i == j){
            if(isTrue){
               return exp.charAt(i) == 'T' ? 1  : 0;
            }
            return  exp.charAt(i) == 'F' ? 1 : 0;
        }
        int totalWays = 0;
        for(int ind = i+1 ; ind <= j -1 ; ind++){
           int lT = recursiveSolutionExpression(exp,i , ind -1,true);
           int lF = recursiveSolutionExpression(exp,i , ind -1,false);

           int rT = recursiveSolutionExpression(exp,ind +1  , j,true);
           int rF = recursiveSolutionExpression(exp,ind +1  , j,false);

           if(exp.charAt(ind) == '&'){
               if(isTrue) totalWays+=lT * rT;
               else totalWays+=rF*lT + rT*lF;
           }

           else if(exp.charAt(ind) == '|'){
                if(isTrue) totalWays+=rF*lT + rT*lF;
                else totalWays+=rF*lF;
           }
           else {
               if (isTrue) totalWays+=rF*lT + rT*lF;
               else totalWays += rF * lT + rT * lF;
           }
        }
        return 0;
    }
}
