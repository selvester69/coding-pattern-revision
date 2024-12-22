package com.design.structural.composite.solution;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
	String dirName;
	List<FileSystem> fileList;

	public Directory(String dirName) {
		super();
		this.dirName = dirName;
		this.fileList = new ArrayList<FileSystem>();
	}
	
	public void add(FileSystem obj) {
		fileList.add(obj);
	}

	@Override
	public void ls() {
		System.out.println("DirName: "+dirName);
		for(FileSystem fs:fileList) {
			fs.ls();
		}

	}

}
