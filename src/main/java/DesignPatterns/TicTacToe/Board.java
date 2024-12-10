package DesignPatterns.TicTacToe;

public class Board {
    public int totalMoves ;
    public char[][] grid ;

    public Board(){
        this.totalMoves = 0;
        this.grid = new char[3][3];
        initializeBoard();
    }

    public void resetBoard(){
        System.out.println("---------------Resetting Board-------------");
        this.totalMoves = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i= 0 ; i < grid.length ; i++){
            for(int j=0 ; j< grid[0].length ; j++){
                grid[i][j] = '-';
            }
        }
    }

    public boolean isFull() {
        return this.totalMoves == 9;
    }

    public void printBoard(){
        for (char[] chars : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isWinner() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (grid[row][0] != '-' && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (grid[0][col] != '-' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }
        return grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0];
    }

    private boolean checkValidMove(int x , int y , char symbol){
        return this.grid[x][y] == '-' && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public void makeMove(int x , int y , char symbol){
        boolean isValidMove = checkValidMove( x,  y , symbol);
        if(!isValidMove){
            throw new IllegalArgumentException("Invalid Move !!");
        }
        this.totalMoves++;
        this.grid[x][y] = symbol;
    }
}
