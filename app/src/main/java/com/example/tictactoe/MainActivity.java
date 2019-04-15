package com.example.tictactoe;

import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Game game;
    private Button NewGame;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check if something is saved in savedInstanceState
        if (savedInstanceState != null) {
        // get current came if saved in bundle
            game = (Game) savedInstanceState.getSerializable("Current_game");

            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);
            Button button4 = findViewById(R.id.button4);
            Button button5 = findViewById(R.id.button5);
            Button button6 = findViewById(R.id.button6);
            Button button7 = findViewById(R.id.button7);
            Button button8 = findViewById(R.id.button8);
            Button button9 = findViewById(R.id.button9);

            // get current tilestate at X,Y and change buttontext for landscape
            TileState tilestate1 = game.getTile(0,0);
            setButtonText(tilestate1, button1);

            TileState tilestate2 = game.getTile(0,1);
            setButtonText(tilestate2, button2);

            TileState tileState3 = game.getTile(0,2);
            setButtonText(tileState3, button3);

            TileState tilestate4 = game.getTile(1,0);
            setButtonText(tilestate4, button4);

            TileState tilestate5 = game.getTile(1,1);
            setButtonText(tilestate5, button5);

            TileState tilestate6 = game.getTile(1,2);
            setButtonText(tilestate6, button6);

            TileState tilestate7 = game.getTile(2,0);
            setButtonText(tilestate7, button7);

            TileState tilestate8 = game.getTile(2,1);
            setButtonText(tilestate8, button8);

            TileState tilestate9 = game.getTile(2,2);
            setButtonText(tilestate9, button9);
            }

        // start new game if there was no game running
        else {
            game = new Game();
        }
            NewGame = findViewById(R.id.Newgamebutton);
        }

    // change chosen tile to X or O depending on player
    public void setButtonText (TileState state, Button button){
            switch (state) {
                case CROSS:
                    button.setText("X");
                    break;
                case CIRCLE:
                    button.setText("O");
                    break;
                case BLANK:
                    button.setText(" ");
                    break;
            }
    }


        @Override
        protected void onSaveInstanceState (Bundle outState){
            super.onSaveInstanceState(outState);

            outState.putSerializable("Current_game", game);
        }

        public void tileClicked (View view){

            Button button = (Button) view;
            TileState state;
            int Id = button.getId();

            Log.d("test", game.gameOver.toString());
            if (!game.gameOver) {
                switch (Id) {

//          saving all locations of the buttons in the grid
                    case R.id.button1:
                        state = game.choose(0, 0);
                        break;
                    case R.id.button2:
                        state = game.choose(0, 1);
                        break;
                    case R.id.button3:
                        state = game.choose(0, 2);
                        break;
                    case R.id.button4:
                        state = game.choose(1, 0);
                        break;
                    case R.id.button5:
                        state = game.choose(1, 1);
                        break;
                    case R.id.button6:
                        state = game.choose(1, 2);
                        break;
                    case R.id.button7:
                        state = game.choose(2, 0);
                        break;
                    case R.id.button8:
                        state = game.choose(2, 1);
                        break;
                    default:
                        state = game.choose(2, 2);
                        break;

                }
                // change chosen tile to X or O depending on player
                switch (state) {
                    case CROSS:
                        button.setText("X");
                        break;
                    case CIRCLE:
                        button.setText("O");
                        break;
                    case INVALID:
                        break;
                }
            }

            // check if one of the players has won by the game state
            if (game.won() == GameState.PLAYER_ONE) {
                Toast.makeText(getApplicationContext(), "Congratulations! Player one has won.",
                        Toast.LENGTH_SHORT).show();
            }
            if (game.won() == GameState.PLAYER_TWO) {
                Toast.makeText(getApplicationContext(), "Congratulations! Player two has won.",
                        Toast.LENGTH_SHORT).show();
            }

        }
        public void resetClicked (View view){
            game = new Game();
            Button button = (Button) view;

            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);
            Button button4 = findViewById(R.id.button4);
            Button button5 = findViewById(R.id.button5);
            Button button6 = findViewById(R.id.button6);
            Button button7 = findViewById(R.id.button7);
            Button button8 = findViewById(R.id.button8);
            Button button9 = findViewById(R.id.button9);

            // reset user interface as well
            button1.setText(" ");
            button2.setText(" ");
            button3.setText(" ");
            button4.setText(" ");
            button5.setText(" ");
            button6.setText(" ");
            button7.setText(" ");
            button8.setText(" ");
            button9.setText(" ");

        }

}

