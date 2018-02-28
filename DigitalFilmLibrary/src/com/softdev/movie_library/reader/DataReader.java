package com.softdev.movie_library.reader;

import java.util.ArrayList;
import java.util.HashMap;

import com.softdev.movie_library.data.Actor;
import com.softdev.movie_library.data.Country;
import com.softdev.movie_library.data.Director;
import com.softdev.movie_library.data.Genre;
import com.softdev.movie_library.data.Movie;

public class DataReader {
	private MoviesReader moviesReader;
	private ActorsReader actorsReader;
	private DirectorsReader directorsReader;
	private GenresReader genresReader;
	private CountriesReader countriesReader;
	private LocationsReader locationsReader;

	private HashMap<Integer, Movie> movies = new HashMap<Integer, Movie>();
	private HashMap<String, Actor> actors = new HashMap<String, Actor>();
	private HashMap<String, Director> directors = new HashMap<String, Director>();
	private HashMap<String, Genre> genres = new HashMap<String, Genre>();
	private HashMap<String, Country> countries = new HashMap<String, Country>();

	private int numberOfMovies = 0;
	private int numberOfActors = 0;
	private int numberOfDirectors = 0;
	private int numberOfGenres = 0;
	private int numberOfCountries = 0;
	private int numberOfLocations = 0;

	public DataReader() {
		moviesReader = new MoviesReader("movies.dat");
		movies = moviesReader.getData();
		numberOfMovies = movies.size();
		actorsReader = new ActorsReader("movie_actors.dat");
		numberOfActors = linkActors();
		directorsReader = new DirectorsReader("movie_directors.dat");
		numberOfDirectors = linkDirectors();
		genresReader = new GenresReader("movie_genres.dat");
		numberOfGenres = linkGenres();
		countriesReader = new CountriesReader("movie_countries.dat");
		numberOfCountries = linkCountries();
		locationsReader = new LocationsReader("movie_locations.dat");
		numberOfLocations = linkLocations();

	}

	private int linkCountries() {
		ArrayList<String[]> lineData = countriesReader.getLineArray();
		String[] line;
		int movieId;
		for (int i = 0; i < lineData.size(); i++) {
			line = lineData.get(i);
			if (line.length > 1) {
				movieId = Integer.parseInt(line[0]);
				// ean uparxei to country
				if (countries.containsKey(line[1])) {
					countries.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie sto country
					movies.get(movieId).addCountry(line[1]);
				} else { // den uparxei to country
					countries.put(line[1], new Country(line[1]));
					countries.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie sto country
					movies.get(movieId).addCountry(line[1]); // vazw to country sto movie
				}
			}
		}
		System.out.println("Diavasa " + countries.size() + " countries.");

		return countries.size();
	}

	@SuppressWarnings("unlikely-arg-type")
	private int linkLocations() {
		ArrayList<String[]> lineData = locationsReader.getLineArray();
		String[] line;
		int movieId;
		for (int i = 0; i < lineData.size(); i++) {
			line = lineData.get(i);
			movieId = Integer.parseInt(line[0]);
			if (line.length > 1) {
				movieId = Integer.parseInt(line[0]);
				if (movies.containsKey(line[0])) {
					for (int j = 0; j < line.length; j++) {
						movies.get(movieId).addLocation(line[j]);
					}
				}
			}
		}

		return 1;

	}

	private int linkGenres() {
		ArrayList<String[]> lineData = genresReader.getLineArray();
		String[] line;
		int movieId;
		for (int i = 0; i < lineData.size(); i++) {
			line = lineData.get(i);
			movieId = Integer.parseInt(line[0]);
			// ean uparxei o director
			if (genres.containsKey(line[1])) {
				genres.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie sto genre
				movies.get(movieId).addGenre(genres.get(line[1]));
			} else { // den uparxei o director
				genres.put(line[1], new Genre(line[1]));
				genres.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie sto genre
				movies.get(movieId).addGenre(genres.get(line[1])); // vazw to genre sto movie
			}
		}
		System.out.println("Diavasa " + genres.size() + " genres.");

		return genres.size();
	}

	private int linkActors() {
		ArrayList<String[]> lineData = actorsReader.getLineArray();
		String[] line;
		int movieId;
		for (int i = 0; i < lineData.size(); i++) {
			line = lineData.get(i);
			movieId = Integer.parseInt(line[0]);
			// ean uparxei o actor
			if (actors.containsKey(line[1])) {
				actors.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie ston actor
				movies.get(movieId).addActor(actors.get(line[1]));
			} else { // den uparxei o actor
				actors.put(line[1], new Actor(line[1], line[2], line[3]));
				actors.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie ston actor
				movies.get(movieId).addActor(actors.get(line[1])); // vazw ton actor sto movie
			}
		}
		System.out.println("Diavasa " + actors.size() + " actors.");

		return actors.size();
	}

	private int linkDirectors() {
		ArrayList<String[]> lineData = directorsReader.getLineArray();
		String[] line;
		int movieId;
		for (int i = 0; i < lineData.size(); i++) {
			line = lineData.get(i);
			movieId = Integer.parseInt(line[0]);
			// ean uparxei o director
			if (directors.containsKey(line[1])) {
				directors.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie ston director
				movies.get(movieId).addDirector(directors.get(line[1]));
			} else { // den uparxei o director
				directors.put(line[1], new Director(line[1], line[2]));
				directors.get(line[1]).addMovie(movies.get(movieId)); // vazw to movie ston director
				movies.get(movieId).addDirector(directors.get(line[1])); // vazw ton director sto movie
			}
		}
		System.out.println("Diavasa " + directors.size() + " directors.");

		return directors.size();
	}

	/**
	 * @return the movies
	 */
	public HashMap<Integer, Movie> getMovies() {
		return movies;
	}

	/**
	 * @return the actors
	 */
	public HashMap<String, Actor> getActors() {
		return actors;
	}

	/**
	 * @return the directors
	 */
	public HashMap<String, Director> getDirectors() {
		return directors;
	}

	/**
	 * @return the genres
	 */
	public HashMap<String, Genre> getGenres() {
		return genres;
	}

	/**
	 * @return the countries
	 */
	public HashMap<String, Country> getCountries() {
		return countries;
	}

	/**
	 * @return the numberOfActors
	 */
	public int getNumberOfActors() {
		return numberOfActors;
	}

	/**
	 * @return the numberOfDirectors
	 */
	public int getNumberOfDirectors() {
		return numberOfDirectors;
	}

	/**
	 * @return the numberOfGenres
	 */
	public int getNumberOfGenres() {
		return numberOfGenres;
	}

	/**
	 * @return the numberOfCountries
	 */
	public int getNumberOfCountries() {
		return numberOfCountries;
	}

	/**
	 * @return the numberOfLocations
	 */
	public int getNumberOfLocations() {
		return numberOfLocations;
	}

	/**
	 * @return the numberOfMovies
	 */
	public int getNumberOfMovies() {
		return numberOfMovies;
	}

}
