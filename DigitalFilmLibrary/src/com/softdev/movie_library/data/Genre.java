package com.softdev.movie_library.data;

import java.util.ArrayList;
import java.util.HashSet;

public class Genre {
	private String genre;
	private HashSet<Movie> moviesOfaGenre = new HashSet<Movie>();

	public Genre(String type) {
		genre = type;
	}

	public int addMovie(Movie movieObject) {
		moviesOfaGenre.add(movieObject);
		return 1;
	}

	public String getGenre() {
		// TODO Auto-generated method stub
		return genre;
	}

	public ArrayList<String> getInfo() {
		ArrayList<String> data = new ArrayList<String>();
		data.add(genre);
		data.add("Our collection has " + moviesOfaGenre.size() + " " + genre + " Movies");
		data.add("-@@@List of " + genre + " Movies");
		for (Movie movie : moviesOfaGenre) {
			data.add(movie.getTitle() + "|" + movie.getMovieData()[5] + "|" + movie.getDirectorsToString());
		}
		return data;
	}

	/**
	 * @return the moviesOfaGenre
	 */
	public HashSet<Movie> getMoviesOfaGenre() {
		return moviesOfaGenre;
	}
}
