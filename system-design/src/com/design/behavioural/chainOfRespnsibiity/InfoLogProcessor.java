package com.design.behavioural.chainOfRespnsibiity;

public class InfoLogProcessor extends LogProcessor {

	
	public InfoLogProcessor(LogProcessor nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void log(int loglevel, String message) {
		if(loglevel==INFO) {
			System.out.println("INFO: "+message);
		}
		super.log(loglevel, message);
	}

}
