package com.lld.snakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	int diceCount;
	final int min=1;
	final int max=6;
	
	Dice(int count){
		this.diceCount = count;
	}
	
	public int rollDice() {
		 int totalSum=0;
	        int diceUsed=0;

	        while(diceUsed<diceCount){

	            totalSum += ThreadLocalRandom.current().nextInt(min,max+1);
	            diceUsed++;
	        }

	        return totalSum;


	}
}
