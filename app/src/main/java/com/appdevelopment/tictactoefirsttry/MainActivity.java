package com.appdevelopment.tictactoefirsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        // get view by row and col
        String tag = ""+row+","+col;
        ConstraintLayout cl = findViewById(R.id.parentLayout);
        Button v = cl.findViewWithTag(tag);
        v.setText("0");

        // update it with currentPlayer
        //2 using id
        // create String id

        String strID = "btnStart"+row+col;
        int resID = getResources().getIdentifier(strID, "id", getPackageName());
        Button b = findViewById(resID);
        b.setText("X");
    }

    @Override
    public void displayMessage(String message) {

    }

    public void userMove(View view) {
        //1
        Button button = (Button)view;
        String str = button.getResources().getResourceEntryName(button.getId());
        char[] arr = str.toCharArray();

        String s = button.getTag().toString();
        String[] res = s.split(",");
        int row = arr[arr.length-2]; // s[0]
        int col = arr[-1]; // s[1]
        Toast.makeText(this, "row" + row, Toast.LENGTH_SHORT).show();


        presenter.moveFromUser(row,col);


    }
}