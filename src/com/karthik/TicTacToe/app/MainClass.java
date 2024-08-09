package com.karthik.TicTacToe.app;

public class MainClass
{

	public static void main(String[] args)
	{
		TicTacToeGame game = new TicTacToeGame();
		System.out.println("Winner is : " + game.startGame());
	}

}
