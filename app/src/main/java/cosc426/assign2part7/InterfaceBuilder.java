package cosc426.assign2part7;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;

public class InterfaceBuilder extends RelativeLayout{
    private TextView[][] board;
    private TextView[][] goal;
    private Button north;
    private Button south;
    private Button east;
    private Button west;
    NumberFormat money = NumberFormat.getCurrencyInstance();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public InterfaceBuilder(Context context, View.OnClickListener buttonHandler) {
        super(context);

        final int DP = (int) (getResources().getDisplayMetrics().density);

        //grid layout for the playing board
        GridLayout gridOne = new GridLayout(context);
        gridOne.setId(GridLayout.generateViewId());
        gridOne.setColumnCount(3);
        gridOne.setRowCount(3);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
        params.width = 270 * DP;
        params.height = 270 * DP;
        params.topMargin = 20 * DP;
        params.addRule(CENTER_HORIZONTAL);
        gridOne.setLayoutParams(params);
        //gets the board for within the grid
        board = new TextView[3][3];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                board[i][j] = new TextView(context);
                board[i][j].setBackgroundColor(Color.parseColor("#66cad7"));
                board[i][j].setText("");
                board[i][j].setTextColor(Color.parseColor("#28193c"));
                board[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
                params1.width = 90*DP;
                params1.height = 90*DP;
                params1.bottomMargin = 1;
                params1.rightMargin = 1;
                board[i][j].setLayoutParams(params1);
                gridOne.addView(board[i][j]);
            }
        }
        addView(gridOne);
        //grid two for the goal board
        GridLayout gridTwo = new GridLayout(context);
        gridTwo.setId(GridLayout.generateViewId());
        gridTwo.setColumnCount(3);
        gridTwo.setRowCount(3);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(0, 0);
        params2.width = 270 * DP;
        params2.height = 270 * DP;
        params2.topMargin = 20 * DP;
        params2.addRule(CENTER_HORIZONTAL);
        params2.addRule(BELOW, gridOne.getId());
        gridTwo.setLayoutParams(params2);
        //board to go within the grid two
        goal = new TextView[3][3];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                goal[i][j] = new TextView(context);
                goal[i][j].setBackgroundColor(Color.parseColor("#66cad7"));
                goal[i][j].setText("");
                goal[i][j].setTextColor(Color.parseColor("#28193c"));
                goal[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                goal[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
                params1.width = 90*DP;
                params1.height = 90*DP;
                params1.bottomMargin = 1;
                params1.rightMargin = 1;
                goal[i][j].setLayoutParams(params1);
                gridTwo.addView(goal[i][j]);
            }
        }
        addView(gridTwo);
        //north button
        north = new Button(context);
        north.setId(Button.generateViewId());
        north.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        north.setTextColor(Color.parseColor("#d9e2ea"));
        north.setBackgroundColor(Color.parseColor("#345a7b"));
        north.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        north.setText("North");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.topMargin = 35*DP;
        params.leftMargin = 20*DP;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, gridTwo.getId());
        north.setLayoutParams(params);
        north.setOnClickListener(buttonHandler);
        addView(north);
        //south button
        south = new Button(context);
        south.setId(Button.generateViewId());
        south.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        south.setTextColor(Color.parseColor("#d9e2ea"));
        south.setBackgroundColor(Color.parseColor("#345a7b"));
        south.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        south.setText("South");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.topMargin = 35*DP;
        params.leftMargin = 5*DP;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, gridTwo.getId());
        params.addRule(RIGHT_OF, north.getId());
        south.setLayoutParams(params);
        south.setOnClickListener(buttonHandler);
        addView(south);
        //east button
        east = new Button(context);
        east.setId(Button.generateViewId());
        east.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        east.setTextColor(Color.parseColor("#d9e2ea"));
        east.setBackgroundColor(Color.parseColor("#345a7b"));
        east.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        east.setText("East");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.topMargin = 35*DP;
        params.leftMargin = 5*DP;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, gridTwo.getId());
        params.addRule(RIGHT_OF, south.getId());
        east.setLayoutParams(params);
        east.setOnClickListener(buttonHandler);
        addView(east);
        //west button
        west = new Button(context);
        west.setId(Button.generateViewId());
        west.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        west.setTextColor(Color.parseColor("#d9e2ea"));
        west.setBackgroundColor(Color.parseColor("#345a7b"));
        west.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        west.setText("West");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.topMargin = 35*DP;
        params.leftMargin = 5*DP;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, gridTwo.getId());
        params.addRule(RIGHT_OF, east.getId());
        west.setLayoutParams(params);
        west.setOnClickListener(buttonHandler);
        addView(west);
    }
    //draws the board
    public void drawBoard(char[][] board){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(board[i][j] == '0'){
                    this.board[i][j].setText(' '+ "");
                }else {
                    this.board[i][j].setText(board[i][j] + "");
                }
            }
        }
    }
    //draws the goal
    public void drawGoal(char[][] goal){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(goal[i][j] == '0'){
                    this.goal[i][j].setText(' '+ "");
                }else {
                    this.goal[i][j].setText(goal[i][j] + "");
                }
            }
        }
    }
    //finds what button is pushed
    public int findButton(Button button){
        if(button == north){
            return 1;
        }else if(button == south){
            return 2;
        }else if(button == east){
            return 3;
        }else{
            return 4;
        }
    }
}