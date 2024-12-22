package com.lld.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.lld.tictactoe.model.Board;
import com.lld.tictactoe.model.PieceType;
import com.lld.tictactoe.model.Player;
import com.lld.tictactoe.model.PlayingPeiceX;
import com.lld.tictactoe.model.PlayingPieceO;

public class TicTacToeGame {

	Deque<Player> players;
	Board gameBoard;
	
	TicTacToeGame(){
		initalizeGame();
	}
	
	public void initalizeGame() {
		players = new LinkedList<>();
		PlayingPeiceX crossPeice = new PlayingPeiceX();
		Player player1 = new Player("Player1", crossPeice);
		
		PlayingPieceO oPiece = new PlayingPieceO();
		Player player2 = new Player("Player2", oPiece);
		
		players.add(player1);
		players.add(player2);
		
		gameBoard = new Board(3);
	}
	
	public String startGame() {
		boolean noWinner = true;
		Scanner sc = new Scanner(System.in);
		while(noWinner) {
			Player playerTurn = players.removeFirst();
			gameBoard.printBoard();
			List<int[]> freeSpace = gameBoard.getFreeCells();
			if(freeSpace.isEmpty()) {
				noWinner = false;
				continue;
			}
			
			//take input
			System.out.println("Player: "+playerTurn.getName()+" Enter row,col: ");
			String s = sc.nextLine();
			String[]values = s.split(",");
			int inputRow = Integer.valueOf(values[0]);
			int inputCol = Integer.valueOf(values[1]);
			
			//place the piece
			boolean isSuccessful = gameBoard.addPiece(inputRow, inputCol, playerTurn.getPiece());
			if(!isSuccessful) {
				System.out.println("incorrect position chosen, try again");
				players.addFirst(playerTurn);
				continue;
			}
			players.addLast(playerTurn);
			
			boolean winner = isWinner(inputRow, inputCol,playerTurn.getPiece().pieceType);
			if(winner) {
				sc.close();
				return playerTurn.getName()+" is the winner";
			}
		}
		sc.close();
		return "game is a tie";
		
	}

	private boolean isWinner(int row, int col, PieceType pieceType) {
		boolean rowMatch = true;
		boolean colMatch = true;
		boolean diagonalMatch = true;
		boolean antiDiagonal = true;
		
		//check row
		for (int i = 0; i < gameBoard.size; i++) {
			if(gameBoard.board[row][i]==null|| gameBoard.board[row][i].pieceType != pieceType) {
				rowMatch = false;
			}
		}
		//check column
		for (int i = 0; i < gameBoard.size; i++) {
			if(gameBoard.board[i][col]==null|| gameBoard.board[i][col].pieceType != pieceType) {
				colMatch = false;
			}
		}
		//diagonal
		for (int i = 0,j=0; i < gameBoard.size; i++,j++) {
			if(gameBoard.board[i][j]==null|| gameBoard.board[i][j].pieceType != pieceType) {
				diagonalMatch = false;
			}
		}
		//anti diagonal
		for (int i = 0,j=gameBoard.size-1; i < gameBoard.size; i++,j--) {
			if(gameBoard.board[i][j]==null|| gameBoard.board[i][j].pieceType != pieceType) {
				antiDiagonal = false;
			}
		}
		
		return rowMatch||colMatch||diagonalMatch||antiDiagonal;
	}
}
