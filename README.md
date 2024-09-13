# Tic Tac Toe Game

This Repository contains codebase for Tic Tac Toe Game.

## Rules of the game

Below are the rules of the game,

> **Setup:** The game is played on a 3 * 3 grid. One player uses ‘X’ another player uses ‘O’ and each player takes turns making their moves.
> 
> **Winner:** The game is won by the player placing his or her symbol in a row, column, or diagonal. The first player to get three symbols in a row wins the game. When the player reaches this, the game ends immediately.
> 
> **Draw:** If all the grid cells are filled and no player has three symbols in a row, the game will be a tie or a draw.
> 
> **Illegal Moves:** A player cannot place his or her symbol on a tile occupied by an opponent’s symbol or their own symbol. The move must be made to an empty cell.

## Requirements

1. The game should have a user interface to display the grid and allow players to make their moves.
2. The game should handle player turns and validate moves to ensure they are legal.
3. The game should detect and announce the winner or a draw at the end of the game.


## Classes/Interfaces Details

1. The Player class represents a player in the game, with a name and a symbol (X or O).
2. The Board class represents the game board, which is a 3x3 grid. It provides methods to make moves, check for a winner, and check if the board is full.
3. The TicTacToeGame class manages the game flow and player interactions. It creates instances of the players, handles player turns, validates moves, and determines the winner or a draw.
4. The Main class is the entry point of the game.
