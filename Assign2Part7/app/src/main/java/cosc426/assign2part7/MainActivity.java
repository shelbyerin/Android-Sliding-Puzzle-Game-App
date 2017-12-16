package cosc426.assign2part7;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.apduServiceBanner;
import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    InterfaceBuilder appInterface;
    Game game;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButtonHandler buttonHandler = new ButtonHandler();
        //gets the interface from the class
        appInterface = new InterfaceBuilder(this, buttonHandler);
        setContentView(appInterface);
        //creates boards in the constructor and draws by calling to appInterface
        game = new Game();
        appInterface.drawBoard(game.board);
        appInterface.drawGoal(game.goal);
    }

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){

            //gets the correct button and acts accordingly
            int buttonPressed = appInterface.findButton((Button)v);
            if(buttonPressed == 1){
                game.north();
                appInterface.drawBoard(game.board);
            }else if(buttonPressed == 2){
                game.south();
                appInterface.drawBoard(game.board);
            }else if(buttonPressed == 3){
                game.east();
                appInterface.drawBoard(game.board);
            }else if(buttonPressed == 4){
                game.west();
                appInterface.drawBoard(game.board);
            }else{}
            //gets the current boards
            char[][] gameBoard = game.getBoard();
            char[][] gameGoal = game.getGoal();
            int numCorrect = 0;
            //checks for the number of squares that match with the board and goal
            for(int i = 0 ; i< 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    if(gameBoard[i][j] == gameGoal[i][j]){
                        numCorrect = numCorrect+1;
                    }
                    else{
                        numCorrect = numCorrect;
                    }
                }
            }//if all 9 are in correct spots - display that they won
            if(numCorrect == 9){
                Toast.makeText(getApplicationContext(),"Congratulations you won!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}