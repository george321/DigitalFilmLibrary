package com.softdev.movie_library.data;

import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {

	private HashMap<Integer, Movie> movies = new HashMap<Integer, Movie>();
	private HashMap<String, Actor> actors = new HashMap<String, Actor>();
	private HashMap<String, Director> directors = new HashMap<String, Director>();
	private HashMap<String, Genre> genres = new HashMap<String, Genre>();
	private HashMap<String, Country> countries = new HashMap<String, Country>();

	public ArrayList<String> findMovieWithId(int idOfMovie) {
		if (movies.containsKey(idOfMovie)) {
			System.out.println("I found Movie: " + movies.get(idOfMovie).getTitle());
			return movies.get(idOfMovie).getMovieInfo();
		}
		return null;
	}

	public ArrayList<String> findMovieWithName(String text) {
		for (Integer key : movies.keySet()) {
			if (movies.get(key).getTitle().equalsIgnoreCase(text)) {
				return movies.get(key).getMovieInfo();
			}
		}
		return null;
	}

	public ArrayList<String> findGenreMovies(String genre) {
		if (genres.containsKey(genre)) {
			System.out.println("I found Genre: " + genres.get(genre).getGenre());
			return genres.get(genre).getInfo();
		}
		return null;
	}

	public ArrayList<String> findActorMovies(String actor) {
		for (String key : actors.keySet()) {
			if (actors.get(key).getActorName().equalsIgnoreCase(actor)) {
				System.out.println("I found " + actors.get(key).getActorName());
				return actors.get(key).getInfo();
			}
		}

		return null;
	}

	public ArrayList<String> findCountryMovies(String country) {
		if (countries.containsKey(country)) {
			System.out.println("I found " + countries.get(country).getCountry());
			return countries.get(country).getInfo();
		}
		return null;
	}

	public ArrayList<String> findDirectorMovies(String director) {

		for (String key : directors.keySet()) {
			if (directors.get(key).getDirectorName().equalsIgnoreCase(director)) {
				return directors.get(key).getInfo();
			}
		}

		return null;
	}

	/**
	 * @param movies
	 *            the movies to set
	 */
	public void setMovies(HashMap<Integer, Movie> movies) {
		this.movies = movies;
	}

	/**
	 * @param actors
	 *            the actors to set
	 */
	public void setActors(HashMap<String, Actor> actors) {
		this.actors = actors;
	}

	/**
	 * @param directors
	 *            the directors to set
	 */
	public void setDirectors(HashMap<String, Director> directors) {
		this.directors = directors;
	}

	/**
	 * @param genres
	 *            the genres to set
	 */
	public void setGenres(HashMap<String, Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(HashMap<String, Country> countries) {
		this.countries = countries;
	}

}
