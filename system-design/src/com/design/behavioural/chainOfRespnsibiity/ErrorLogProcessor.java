package com.design.behavioural.chainOfRespnsibiity;

public class ErrorLogProcessor extends LogProcessor {

	public ErrorLogProcessor(LogProcessor nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void log(int loglevel, String message) {
		if(loglevel ==ERROR) {
			System.out.println("ERROR: "+message);
		}
		super.log(loglevel, message);
	}

}
