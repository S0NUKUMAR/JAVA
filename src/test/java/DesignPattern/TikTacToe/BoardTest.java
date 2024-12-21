package DesignPattern.TikTacToe;

import DesignPatterns.TikTacToe.Board;
import org.junit.jupiter.api.*;

public class BoardTest {
    static Board board;

    @BeforeEach
    public void Init(){
        board = new Board();
    }

    @AfterAll
    public static void tearDown(){
        board.resetBoard();
    }

    @AfterEach
    public void printBoardTest(){
        board.printBoard();
    }

    @Test
    public void boardInitialization(){
        assert(board.totalMoves == 0);
        assert(board.grid.length == 3);
        assert(board.grid[0].length == 3);
        for(int i= 0 ; i < board.grid.length ; i++){
            for(int j=0 ; j< board.grid[0].length ; j++){
                Assertions.assertEquals(board.grid[i][j], '-');
            }
        }
    }

    @Test
    public void isFullTest(){
        boolean result = board.isFull();
        Assertions.assertEquals(false , result);
    }

    @Test
    public void isWinnerRowTest() {
        board.grid[0][0] = 'X';
        board.grid[0][1] = 'X';
        board.grid[0][2] = 'X';
        boolean result = board.isWinner();
        Assertions.assertEquals(true, result);

        board.grid[0][0] = 'O';
        board.grid[0][1] = 'O';
        board.grid[0][2] = 'O';
        result = board.isWinner();
        Assertions.assertEquals(true, result);
    }

    @Test
    public void isWinnerColumnTest() {
        board.grid[0][0] = 'X';
        board.grid[1][0] = 'X';
        board.grid[2][0] = 'X';
        boolean result = board.isWinner();
        Assertions.assertEquals(true, result);

        board.grid[0][0] = 'O';
        board.grid[1][0] = 'O';
        board.grid[2][0] = 'O';
        result = board.isWinner();
        Assertions.assertEquals(true, result);
    }

    @Test
    public void isWinnerLeftDiagonalTest() {
        board.grid[0][0] = 'X';
        board.grid[1][1] = 'X';
        board.grid[2][2] = 'X';
        boolean result = board.isWinner();
        Assertions.assertEquals(true, result);

        board.grid[0][0] = 'O';
        board.grid[1][1] = 'O';
        board.grid[2][2] = 'O';
        result = board.isWinner();
        Assertions.assertEquals(true, result);
    }

    @Test
    public void isWinnerRightDiagonalTest() {
        board.grid[0][2] = 'X';
        board.grid[1][1] = 'X';
        board.grid[2][0] = 'X';
        boolean result = board.isWinner();
        Assertions.assertEquals(true, result);

        board.grid[0][2] = 'O';
        board.grid[1][1] = 'O';
        board.grid[2][0] = 'O';
        result = board.isWinner();
        Assertions.assertEquals(true, result);
    }

    @Test
    public void makeMovesTest(){
        board.makeMove(0,0,'X');
        board.makeMove(0,1,'O');
        board.makeMove(0,2,'X');
        board.makeMove(1,0,'O');
        board.makeMove(1,1,'X');
        board.makeMove(1,2,'O');
        board.makeMove(2,0,'X');
        board.makeMove(2,1,'O');
        board.makeMove(2,2,'X');
        boolean result = board.isFull();
        Assertions.assertEquals(true, result);

        Assertions.assertTrue(board.isWinner());
    }
}
