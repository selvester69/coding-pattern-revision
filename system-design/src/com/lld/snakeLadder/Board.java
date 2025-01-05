package com.lld.snakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	Cell[][] cells;

	public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
		initializeCell(boardSize);
		addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
	}

	private void initializeCell(int boardSize) {
		cells = new Cell[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Cell cellObj = new Cell();
				cells[i][j] = cellObj;
			}
		}
	}

	private void addSnakesLadders(Cell[][]cells, int numberOfSnakes,int numberOfLadders) {
		while(numberOfSnakes>0) {
			int bound = cells.length*cells.length-1;
			int head = ThreadLocalRandom.current().nextInt(1,bound);
			int tail = ThreadLocalRandom.current().nextInt(1,bound);
			if(tail>=head) {
				continue;
			}
			Jump snake = new Jump();
			snake.start = head;
			snake.end = tail;
			
			Cell cell = getCell(head);
			cell.jump = snake;
			
			numberOfSnakes--;
		}
		
		while(numberOfLadders>0) {
			int bound = cells.length*cells.length-1;
			int head = ThreadLocalRandom.current().nextInt(1,bound);
			int tail = ThreadLocalRandom.current().nextInt(1,bound);
			if(head>=tail) {
				continue;
			}
			Jump ladder = new Jump();
			ladder.start = head;
			ladder.end = tail;
			
			Cell cell = getCell(head);
			cell.jump = ladder;
			
			numberOfLadders--;
		}
	}
	
	 Cell getCell(int playerPosition) {
	        int boardRow = playerPosition / cells.length;
	        int boardColumn = (playerPosition % cells.length);
	        return cells[boardRow][boardColumn];
	    }


}
