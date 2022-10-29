package com.appdevelopment.tictactoefirsttry;

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
        if(model.isLegal(row,col))
        {
            // doMove
            model.doMove(row,col,currentPlayer);

            // update view board
            // current player, row col
            view.updateView(row,col,currentPlayer);
            // checkWin

            Constants.GAME_STATUS status = model.checkWin();
            if(status == Constants.GAME_STATUS.WIN)
            {
                // Update view board
                // display message of WIN/ GAME OVER
                view.displayMessage("WIN");

            }

            }
            else
            {

            }
    }




}
