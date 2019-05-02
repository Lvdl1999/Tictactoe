package com.example.tictactoe;

import android.service.quicksettings.Tile;
import android.util.Log;

import java.io.Serializable;

public class Game implements Serializable {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    public Boolean gameOver;

    public Game() {

        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    // choose method to change tilestate for current player
    public TileState choose(int row, int column) {
                switch (board[row][column]){
                    case CIRCLE:
                        return TileState.INVALID;
                    case CROSS:
                        return TileState.INVALID;
                    case BLANK:
                        if (playerOneTurn) {
                            playerOneTurn = false;
                            board[row][column] = TileState.CROSS;
                            return TileState.CROSS;
                        }
                        else {
                            playerOneTurn = true;
                            board[row][column] = TileState.CIRCLE;

                            return TileState.CIRCLE;
                        }
                    default: return TileState.BLANK;
                }
            }

    // get tilestate
    public TileState getTile(int row, int column) {
        switch (board[row][column]){
            case CROSS:
                return TileState.CROSS;
            case CIRCLE:
                return TileState.CIRCLE;
            case BLANK:
                return TileState.BLANK;
            default:
                return TileState.BLANK;
        }
    }

//
    public GameState won() {

        int counter = 0;
        int moves = 9;

        // check if game is won vertical by player_one
        for (int i = 0; i < BOARD_SIZE; i++) {
        // check if game is won horizontal by player one
            if (TileState.CROSS == board[i][0] && TileState.CROSS == board[i][1]
                    && TileState.CROSS == board[i][2]){
                gameOver = true;
                return GameState.PLAYER_ONE;}

            // check if game is won horizontal by player two
            if (TileState.CIRCLE == board[i][0] && TileState.CIRCLE == board[i][1]
                    && TileState.CIRCLE == board[i][2]){
                gameOver = true;
                return GameState.PLAYER_TWO;}

            // check if game is won vertical by player_one
            if (TileState.CROSS == board[0][i] && TileState.CROSS == board[1][i]
                    && TileState.CROSS == board[2][i]){
                gameOver = true;
                return GameState.PLAYER_ONE;}

            // check if game is won vertical by player two
            if (TileState.CIRCLE == board[0][i] && TileState.CIRCLE == board[1][i]
                    && TileState.CIRCLE == board[2][i]){
                gameOver = true;
                return GameState.PLAYER_TWO;}

            // check if game is won first diagonal by player one
            if (TileState.CROSS == board[0][0] && TileState.CROSS == board[1][1]
                    && TileState.CROSS == board[2][2]){
                gameOver = true;
                return GameState.PLAYER_ONE;}

            // check if game is won second diagonal by player two
            if (TileState.CIRCLE == board[0][2] && TileState.CIRCLE == board[1][1]
                    && TileState.CIRCLE == board[2][0]) {
                gameOver = true;
                return GameState.PLAYER_TWO;}

            // keep track of blank tiles
            if (TileState.BLANK == board[i][0] || TileState.BLANK == board[i][1] ||
                    TileState.BLANK == board[i][2]){
                counter ++;

            }
        }

        // check if board is full
        if (counter < moves) {
            gameOver = false;
            return GameState.DRAW;

        }
        // no one won and board is not full
        else {
            gameOver = false;
            return GameState.IN_PROGRESS;
        }
    }
}






