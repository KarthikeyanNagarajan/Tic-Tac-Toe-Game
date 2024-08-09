package com.karthik.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

import com.karthik.TicTacToe.piece.Piece;

public class Board
{
	public int size;
	public Piece[][] board;

	public Board(int size)
	{
		this.size = size;
		this.board = new Piece[size][size];
	}

	public boolean addPiece(int row, int col, Piece piece)
	{
		if (board[row][col] != null)
			return false;
		board[row][col] = piece;
		return true;
	}

	public List<Pair> getFreeCells()
	{
		List<Pair> freeCell = new ArrayList<>();
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (board[i][j] == null)
				{
					Pair rowCol = new Pair(i, j);
					freeCell.add(rowCol);
				}
			}
		}
		return freeCell;
	}

	public void printBoard()
	{
		for (int row = 0; row < size; row++)
		{
			for (int col = 0; col < size; col++)
			{
				if (board[row][col] != null)
					System.out.print(board[row][col].type.name() + " ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
