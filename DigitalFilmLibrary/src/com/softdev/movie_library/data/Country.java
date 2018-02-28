package com.softdev.movie_library.data;

import java.util.ArrayList;
import java.util.HashSet;

public class Country {
	private String country;
	private HashSet<Movie> moviesOfaCountry = new HashSet<Movie>();

	public Country(String type) {
		country = type;
	}

	public int addMovie(Movie movieObject) {
		moviesOfaCountry.add(movieObject);
		return 1;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return country;
	}

	public ArrayList<String> getInfo() {
		ArrayList<String> data = new ArrayList<String>();
		data.add(country);
		data.add("Our collection has " + moviesOfaCountry.size() + " Movies of " + country);
		data.add("-@@@List of " + country + "'s Movies");
		for (Movie movie : moviesOfaCountry) {
			data.add(movie.getTitle() + "|" + movie.getMovieData()[5] + "|" + movie.getDirectorsToString());
		}
		return data;
	}

	/**
	 * @return the moviesOfaCountry
	 */
	public HashSet<Movie> getMoviesOfaCountry() {
		return moviesOfaCountry;
	}
}
