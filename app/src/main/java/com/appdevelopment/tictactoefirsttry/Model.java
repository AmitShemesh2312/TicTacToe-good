package com.appdevelopment.tictactoefirsttry;

public class Model
{

    // תכונות
    private final int[][]  board;
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
        if (numTurns>4)
        {
            int row = 0;
            int column = 0;
            int val = board.length;
            if (board[0][0] == board[1][1] && board[2][2] == board[1][1])
                return Constants.GAME_STATUS.WIN;
            if (board[0][2] == board[1][1] && board[2][0] == board[1][1])
                return Constants.GAME_STATUS.WIN;
            for (int i = 0; i < val; i++) {
                for (int j = 0; j < val; j++) {
                    row += board[i][j];
                    column += board[j][i];
                }
                if (column == 3 || column == -3)
                    return Constants.GAME_STATUS.WIN;
                if (row == -3 || row == 3)
                    return Constants.GAME_STATUS.WIN;
                row = 0;
                column = 0;

            }
        }
        if (numTurns == 9)
        {
            return Constants.GAME_STATUS.TIE;
        }

        return Constants.GAME_STATUS.NOT_SURE;

    }

    // called only after isLegal is called
    // 1 move is legal
    // place move on board
    // increase num turns
    public void doMove(int row, int col, int player)
    {
        this.board[row][col] = player;
        this.numTurns++;
    }


}
