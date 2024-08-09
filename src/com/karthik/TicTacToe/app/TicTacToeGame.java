package com.karthik.TicTacToe.app;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.karthik.TicTacToe.model.Board;
import com.karthik.TicTacToe.model.Pair;
import com.karthik.TicTacToe.model.Player;
import com.karthik.TicTacToe.piece.Piece;
import com.karthik.TicTacToe.piece.PieceO;
import com.karthik.TicTacToe.piece.PieceType;
import com.karthik.TicTacToe.piece.PieceX;

public class TicTacToeGame
{
	Deque<Player> players;
	Board board;

	public TicTacToeGame()
	{
		initializeGame();
	}

	public void initializeGame()
	{
		players = new LinkedList<>();
		Player player1 = new Player("Player1", new PieceX());
		Player player2 = new Player("Player2", new PieceO());
		players.add(player1);
		players.add(player2);
		board = new Board(3);
	}

	public String startGame()
	{
		boolean noWinner = true;
		while (noWinner)
		{
			Player player = players.removeFirst();

			List<Pair> freeCells = board.getFreeCells();
			if (freeCells.isEmpty())
			{
				noWinner = false;
				continue;
			}

			System.out.println("Player : " + player.name + " Enter row, col : ");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			String[] values = str.split(",");
			int row = Integer.valueOf(values[0]);
			int col = Integer.valueOf(values[1]);

			boolean isPieceAdded = board.addPiece(row, col, player.piece);
			if (!isPieceAdded)
			{
				System.out.println("Incorrect Position, try again");
				players.addFirst(player);
				continue;
			}
			players.addLast(player);

			board.printBoard();

			boolean winner = isWinner(row, col, player.piece.type);
			if (winner)
			{
				return player.name;
			}
		}
		return "Tie";
	}

	private boolean isWinner(int row, int col, PieceType type)
	{
		Piece[][] arr = board.board;
		int n = board.size;

		boolean rowMatch = true;
		boolean colMatch = true;
		boolean diagMatch = true;
		boolean revdiagMatch = true;

		// Check rows
		for (int i = 0; i < n; i++)
		{
			if (arr[row][i] == null || arr[row][i].type != type)
			{
				rowMatch = false;
			}
		}

		// Check columns
		for (int i = 0; i < n; i++)
		{
			if (arr[i][col] == null || arr[i][col].type != type)
			{
				colMatch = false;
			}
		}

		// Check diagonals
		for (int i = 0; i < n; i++)
		{
			if (arr[i][i] == null || arr[i][i].type != type)
			{
				diagMatch = false;
			}
		}

		// Check reverse diagonals
		for (int i = 0, j = n - 1; i < n; i++, j--)
		{
			if (arr[i][j] == null || arr[i][j].type != type)
			{
				revdiagMatch = false;
			}
		}

		return rowMatch || colMatch || diagMatch || revdiagMatch;
	}
}
