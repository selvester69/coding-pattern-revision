package com.design.behavioural.chainOfRespnsibiity;

public class DebugLogProcessor extends LogProcessor {

	public DebugLogProcessor(LogProcessor nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void log(int loglevel, String message) {
		if(loglevel ==DEBUG) {
			System.out.println("DEBUG: "+message);
		}
		super.log(loglevel, message);
	}

}
