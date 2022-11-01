package com.appdevelopment.tictactoefirsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IView {

    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);

    }

    @Override
    public void updateView(int row, int col, int player) {


        // update it with currentPlayer
        //2 using id
        // create String id

        String strID = "button" + row + col;
        int resID = getResources().getIdentifier(strID, "id", getPackageName());
        Button b = findViewById(resID);
        if (player == -1)
            b.setText("O");

        else
            b.setText("X");
    }

    @Override
    public void displayMessage(String message)
    {
        int res = getResources().getIdentifier("winner", "id",getPackageName());
        TextView txt = findViewById(res);
        txt.setText(message);
        disabledButtons();
    }

    public void disabledButtons() {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                int res = getResources().getIdentifier("button" + i + j, "id", getPackageName());
                Button btn = (Button)findViewById(res);
                btn.setEnabled(false);
            }
        }
    }

    public void userMove(View view) {
        Button button = (Button)view;
        String str = button.getResources().getResourceEntryName(button.getId());
        char[] arr = str.toCharArray();


        int row = arr[arr.length-2]-48; // s[0]
        int col = arr[arr.length-1]-48; // s[1]

        presenter.moveFromUser(row,col);
    }
}