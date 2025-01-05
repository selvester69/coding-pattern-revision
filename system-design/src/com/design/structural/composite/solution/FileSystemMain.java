package com.design.structural.composite.solution;

public class FileSystemMain {
	public static void main(String[] args) {
		Directory movieDirectory = new Directory("Movie");

		FileSystem border = new File("Border");
		movieDirectory.add(border);

		Directory comedyMovieDirectory = new Directory("ComedyMovie");
		File hulchul = new File("Hulchul");
		comedyMovieDirectory.add(hulchul);
		movieDirectory.add(comedyMovieDirectory);

		movieDirectory.ls();

	}

}
