package com.design.behavioural.chainOfRespnsibiity;

public class LoggerMain {
	public static void main(String[] args) {
		LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		logger.log(LogProcessor.ERROR, "exception occurred");
		logger.log(LogProcessor.DEBUG, "debug message");
		logger.log(LogProcessor.ERROR, "info the log");
	}
}
