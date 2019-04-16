# TicTacToe
## By Levy van der Linde 
## Minor Programmeren

Once someone opens the app, an empty board of tictactoe will show up.
It's a basic game where two players take turns pressing buttons in a 3x3 grid to mark "X" or "O" characters. If a player can place three of their letter in a row horizontally, vertically or diagonally, that player wins the game. 

### the game
First of all the grid was made with a GridLayout. The constructor is made when creating a new game. All the buttons are empty. Once the game starts, it's player ones turn (checked by a boolean). 
After this we'll use the tileClicked method, where every button was identified by it's id and location on the grid (X,Y).

There are a few enums representing the state of the game:
IN_PROGRESS,
PLAYER_ONE,
PLAYER_TWO,
DRAW

and the state of particular tile:
BLANK,
CROSS,
CIRCLE,
INVALID

Depending on which user is pressing the button, the switch function makes sure it becomes a cross or circle. In case the button was already pressed, it's an invalid move.

The app also includes a NewGame button, which makes sure a user can start a new game at any moment.
Once the button is pressed, the game starts over for every button and the UI will be updated (empty buttons again). 

### winning
To check if someone is winning, the won method was implemented. It checks if a player has won horizontally, vertically or diagonally. If so, it returns a gamestate with which player has won. After that the app will popup a text saying: "Congratulations! Player one has won." or "Congratulations! Player two has won."
When someone has won the game, the players automatically can't make any moves any more because the game is over. This is checked by a boolean if gameover = true or false.

Because this is an Android app, the layout may be reloaded when leaving the app. To make sure it remembers which button was blank, a cross or circle. In case someone turns the phone into landscape vision, the app will reload and get all data from the bundle. 

So to show you how this app does work, here is an example with screenshots:

1. open the app

2. play the game

3. start new game

3. win the game with player one

4. turn the phone to landscape and remember current game











