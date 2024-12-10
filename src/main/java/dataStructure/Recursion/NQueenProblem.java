package dataStructure.Recursion;

public class NQueenProblem {
    public static void main(String[] args) {
        int[][] board = new int[][]{ { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        int n = board.length;


        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n - 1];
        int[] lowerDiagonal = new int[2*n - 1];

        solve(board , 0 , leftRow , upperDiagonal , lowerDiagonal);

    }

    private static void solve(int[][] board, int col, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        //step 6: if column reaches the last value stop and return
        if(col == board.length){
            for (int[] ints : board){
                for (int j = 0; j < board.length; j++)
                    System.out.print(ints[j] + " ");
                System.out.println();
            }
            System.out.println("--------------------------");;
            return;
        }

        //step 1 : iterate over the rows for the placing the Queen
        for(int row = 0 ; row < board.length ;row++){

            //step 2 : find the valid place for the queen
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0){

                //step 3 : setting the visited array to true and placing the queen on board
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1 ;
                upperDiagonal[board.length - 1 + col - row] = 1;
                board[row][col] = 1;

                //step 4: move to other column as the queen is placed for this column
                solve(board,col+1,leftRow,upperDiagonal,lowerDiagonal);

                //step 5: removing the old values
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0 ;
                upperDiagonal[board.length - 1 + col - row] = 0;
                board[row][col] = 0;


            }
        }
    }
}
