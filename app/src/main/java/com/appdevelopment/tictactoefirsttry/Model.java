package com.appdevelopment.tictactoefirsttry;

public class Model
{

    // תכונות
    private int[][]  board;
    private int numTurns;
    private final int ROWS = 3,COLS = 3;


    public Model()
    {
        this.numTurns = 0;
        this.board = new int[ROWS][COLS];
    }

    public boolean isLegal(int row,int col)
    {
        return this.board[row][col]==0;
    }
    public Constants.GAME_STATUS checkWin()
    {

        int val = board.length;
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {

            }
        }

        return Constants.GAME_STATUS.WIN;

    }

    // called only after isLagel is called
    // 1 move is legal
    // place move on board
    // increase num turns
    public void doMove(int row, int col, int player)
    {
        this.board[row][col] = player;
        this.numTurns++;
    }


}
