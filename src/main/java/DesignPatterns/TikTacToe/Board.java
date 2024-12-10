package DesignPatterns.TikTacToe;

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

    public boolean isWinner(){
        return checkRow() || checkColumn() || checkDiagonal();
    }

    private boolean checkRow(){
        for (char[] chars : grid) {
            if (chars[0] != '-' && chars[0] == chars[1] && chars[1] == chars[2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(){
        for(int i=0; i< grid.length;i++){
            if(grid[0][i]!='-' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(){
        return checkLeftDiagonal() || checkRightDiagonal();
    }

    private boolean checkLeftDiagonal(){
        for(int i=0; i< grid.length;i++){
            if(grid[i][i]!='-' && grid[i][i] != grid[0][0]){
                return true;
            }
        }
        return false;
    }

    private boolean checkRightDiagonal(){
        for(int i=0; i< grid.length;i++){
            if(grid[i][grid.length-i-1]!='-' && grid[i][grid.length-i-1] != grid[0][grid.length-1]){
                return true;
            }
        }
        return false;
    }


    private boolean checkValidMove(int x , int y , char symbol){
        return this.grid[x][y]=='-' && x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
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
