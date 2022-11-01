package com.appdevelopment.tictactoefirsttry;

import android.widget.Toast;

public class Presenter
{

    private Model model;
    private IView view;
    private int currentPlayer=1;
    public Presenter(IView view)
    {
        model = new Model();
        this.view = view;
    }

    public void moveFromUser(int row, int col)
    {
        // islegal
        if (model.isLegal(row,col)) {
            // doMove
            model.doMove(row, col, currentPlayer);

            // update view board
            // current player, row col
            view.updateView(row, col, currentPlayer);
            // checkWin

            Constants.GAME_STATUS status = model.checkWin();
            if (status == Constants.GAME_STATUS.WIN) {
                // Update view board
                // display message of WIN/ GAME OVER
                if (currentPlayer == 1)
                    view.displayMessage("X WON!");
                else
                    view.displayMessage("O WON!");

            } else if (status == Constants.GAME_STATUS.NOT_SURE) {
                if (currentPlayer == -1)
                    currentPlayer = 1;
                else
                    currentPlayer = -1;
            }
            else
                view.displayMessage("TIE");
        }
    }




}
