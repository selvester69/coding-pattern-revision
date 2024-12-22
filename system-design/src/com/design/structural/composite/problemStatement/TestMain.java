package com.design.structural.composite.problemStatement;

public class TestMain {
	public static void main(String[] args) {
		Directory directory = new Directory("testDir");
		directory.addObj(new File("TestFile1"));
		directory.addObj(new File("TestFile2"));
		directory.addObj(new Directory("MyDir1"));
		directory.ls();
	}

}
