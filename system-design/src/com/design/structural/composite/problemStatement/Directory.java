package com.design.structural.composite.problemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	String dirName;
	List<Object> objList;

	public Directory(String dirName) {
		super();
		this.dirName = dirName;
		this.objList = new ArrayList<Object>();
	}

	public void addObj(Object o) {
		objList.add(o);
	}

	public void ls() {
		System.out.println("ls inside dir: "+dirName);
		for(Object o:objList) {
			if(o instanceof File) {
				((File) o).ls();
			}else if(o instanceof Directory) {
				((Directory) o).ls();
			}
		}
	}

}
