package com.design.structural.composite.problemStatement;

public class File {
	String fileName;

	public File(String fileName) {
		this.fileName = fileName;
	}
	
	public void ls() {
		System.out.println("file Name is : "+fileName);
	}
	

}
