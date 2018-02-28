package com.softdev.movie_library.reader;

import java.io.IOException;
import java.util.HashMap;

import com.softdev.movie_library.data.Movie;

public class MoviesReader extends Reader {
	private int numberOfMovies;

	private HashMap<Integer, Movie> moviesArray = new HashMap<Integer, Movie>();

	public MoviesReader(String fileName) {
		super(fileName);
		numberOfMovies = readFile();
	}

	public int readFile() {
		String line;
		try {
			bufferreader.readLine();
			while ((line = bufferreader.readLine()) != null) {
				numberOfMovies++;
				addMovie(line);
			}
			System.out.println("Diavasa " + numberOfMovies + " tainies.");
			return numberOfMovies;
		} catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
	}

	private void addMovie(String line) {
		String data[] = line.split("\t");
		moviesArray.put(Integer.parseInt(data[0]), new Movie(data));

	}

	public HashMap<Integer, Movie> getData() {
		return moviesArray;
	}

}
