package com.softdev.movie_library.data;

import java.util.ArrayList;
import java.util.HashSet;

public class Director {

	private String directorId;
	private String directorName;
	private HashSet<Movie> moviesOfDirector = new HashSet<Movie>();

	public Director(String id, String name) {
		directorId = id;
		directorName = name;

	}

	public int addMovie(Movie movieObject) {
		moviesOfDirector.add(movieObject);
		return 1;
	}

	/**
	 * @return the directorId
	 */
	public String getDirectorId() {
		return directorId;
	}

	public ArrayList<String> getInfo() {
		ArrayList<String> data = new ArrayList<String>();
		data.add(directorName);
		data.add("Our collection has " + moviesOfDirector.size() + " movies with the director " + directorName);
		data.add("-@@@List of " + directorName + "'s Movies");
		for (Movie movie : moviesOfDirector) {
			data.add(movie.getTitle() + "|" + movie.getMovieData()[5] + "|" + movie.getDirectorsToString());
		}
		return data;
	}

	/**
	 * @return the directorName
	 */
	public String getDirectorName() {
		return directorName;
	}

	/**
	 * @return the moviesOfDirector
	 */
	public HashSet<Movie> getMoviesOfDirector() {
		return moviesOfDirector;
	}

}
