package com.softdev.movie_library.tests;

import java.util.ArrayList;
import java.util.HashMap;

import com.softdev.movie_library.data.Actor;
import com.softdev.movie_library.data.Country;
import com.softdev.movie_library.data.Director;
import com.softdev.movie_library.data.Genre;
import com.softdev.movie_library.data.Movie;
import com.softdev.movie_library.reader.ActorsReader;
import com.softdev.movie_library.reader.CountriesReader;
import com.softdev.movie_library.reader.DirectorsReader;
import com.softdev.movie_library.reader.GenresReader;
import com.softdev.movie_library.reader.LocationsReader;
import com.softdev.movie_library.reader.MoviesReader;

import junit.framework.TestCase;

public class Test extends TestCase {

	private MoviesReader moviesReader;
	private ActorsReader actorsReader;
	private DirectorsReader directorsReader;
	private GenresReader genresReader;
	private CountriesReader countriesReader;
	private LocationsReader locationsReader;

	private int numberOfMovies = 0;
	private int numberOfActors = 0;
	private int numberOfDirectors = 0;
	private int numberOfGenres = 0;
	private int numberOfCountries = 0;
	private int numberOfLocations = 0;

	private HashMap<Integer, Movie> movies = new HashMap<Integer, Movie>();
	private HashMap<String, Actor> actors = new HashMap<String, Actor>();

	protected void setUp() throws Exception {
		super.setUp();
		moviesReader = new MoviesReader("movies.dat");
		movies = moviesReader.getData();
		numberOfMovies = movies.size();
		actorsReader = new ActorsReader("movie_actors.dat");
		numberOfActors = linkActors();
	}

	public int getNumberOfMovies() {
		return numberOfMovies;
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

		return actors.size();
	}

	public Movie getObj1() {
		int movieId = 1;
		Movie obj1 = null;
		obj1 = movies.get(movieId);
		return obj1;
	}

	public void testMovieObject() {
		assertEquals("Objects are equal", getObj1(), getObj2());
	}

	private Object getObj2() {
		int movieId = 1;
		String actorID = "annie_potts";
		Movie obj2 = null;
		for (Movie movie : actors.get(actorID).getMoviesOfActor())
			if (movie.getId() == movieId) {
				obj2 = movie;
				System.out.println("OK");
				return obj2;
			}
		return obj2;
	}

	public int getNumberOfActors() {
		return numberOfActors;
	}

	public void testReturn() {

		assertEquals(movies.size(), getNumberOfMovies());
		assertEquals(numberOfActors, getNumberOfActors());
	}

	public void testNotNul() {
		assertNotNull("No null succes!", actors.get("annie_potts").getInfo());
	}

	public void testFailedReturn() {
		int total = 10;
		assertNotSame(getNumberOfMovies(), total);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
