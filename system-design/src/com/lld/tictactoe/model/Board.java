package com.lld.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public int size;
	public PlayingPiece[][]board;
	
	public Board(int size ) {
		super();
		this.size = size;
		this.board = new PlayingPiece[size][size];
	}
	
	public boolean addPiece(int row, int col,PlayingPiece playingPiece) {
		if(board[row][col]!=null) {
			return false;
		}
		board[row][col]=playingPiece;
		return true;
	}
	
	public List<int[]> getFreeCells(){
		List<int[]> freeCells = new ArrayList<int[]>();
//		cell by cell traversal
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				int[] rowCol = new int[] {i,j};
				freeCells.add(rowCol);
			}
		}
		return freeCells;
	}
	public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                   System.out.print(board[i][j].pieceType.name() + " ");
                } else {
                    System.out.print("  ");

                }
                System.out.print("|");
            }
            System.out.println();

        }
    }

	
}
