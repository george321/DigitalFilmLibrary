package com.softdev.movie_library.data;

import java.util.ArrayList;
import java.util.HashSet;

public class Movie {

	private String[] movieData;
	private int id;
	private String title;
	private String country;
	private HashSet<Actor> actorsOfMovie = new HashSet<Actor>();
	private HashSet<Director> directorsOfMovie = new HashSet<Director>();
	private HashSet<Genre> genresOfMovie = new HashSet<Genre>();
	private HashSet<String> locationsOfMovie = new HashSet<String>();

	public Movie(String[] data) {
		movieData = data;
		id = Integer.parseInt(data[0]);
		title = data[1];
	}

	public int addActor(Actor object) {
		actorsOfMovie.add(object);
		return 1;
	}

	public int addDirector(Director object) {
		directorsOfMovie.add(object);
		return 1;
	}

	public int addGenre(Genre object) {
		genresOfMovie.add(object);
		return 1;
	}

	public void addCountry(String country) {
		this.country = country;
	}

	public int addLocation(String object) {
		locationsOfMovie.add(object);
		return 1;
	}

	public ArrayList<String> getMovieInfo() {
		ArrayList<String> movieInfo = new ArrayList<String>();
		movieInfo.add(title);
		movieInfo.add("id: " + movieData[0]);
		movieInfo.add("title: " + movieData[1]);
		movieInfo.add("imdbID: " + movieData[2]);
		movieInfo.add("spanishTitle: " + movieData[3]);
		movieInfo.add("imdbPictureURL: " + movieData[4]);
		movieInfo.add("year: " + movieData[5]);
		movieInfo.add("rtID: " + movieData[6]);
		movieInfo.add("rtAllCriticsRating: " + movieData[7]);
		movieInfo.add("rtAllCriticsNumReviews: " + movieData[8]);
		movieInfo.add("rtAllCriticsNumFresh: " + movieData[9]);
		movieInfo.add("rtAllCriticsNumRotten: " + movieData[10]);
		movieInfo.add("rtAllCriticsScore: " + movieData[11]);
		movieInfo.add("rtTopCriticsRating: " + movieData[12]);
		movieInfo.add("rtTopCriticsNumReviews: " + movieData[13]);
		movieInfo.add("rtTopCriticsNumFresh: " + movieData[14]);
		movieInfo.add("rtTopCriticsNumRotten: " + movieData[15]);
		movieInfo.add("rtTopCriticsScore: " + movieData[16]);
		movieInfo.add("rtAudienceRating: " + movieData[17]);
		movieInfo.add("rtAudienceNumRatings: " + movieData[18]);
		movieInfo.add("rtAudienceScore	rtPictureURL: " + movieData[19]);

		movieInfo.add("-@@@" + "Genres List");
		for (Genre genre : genresOfMovie) {
			movieInfo.add(genre.getGenre());
		}
		movieInfo.add("-@@@" + "Countries List");
		movieInfo.add(country);
		movieInfo.add("-@@@" + "Locations List");
		for (String location : locationsOfMovie) {
			movieInfo.add(location);
		}
		movieInfo.add("-@@@" + "Actors List");
		for (Actor actor : actorsOfMovie) {
			movieInfo.add(actor.getActorName());
		}
		movieInfo.add("-@@@" + "Directors List");
		for (Director director : directorsOfMovie) {
			movieInfo.add(director.getDirectorName());
		}

		return movieInfo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the movieData
	 */
	public String[] getMovieData() {
		return movieData;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the actorsOfMovie
	 */
	public HashSet<Actor> getActorsOfMovie() {
		return actorsOfMovie;
	}

	/**
	 * @return the directorsOfMovie
	 */
	public HashSet<Director> getDirectorsOfMovie() {
		return directorsOfMovie;
	}

	public String getDirectorsToString() {
		String directorsString = "";
		for (Director director : directorsOfMovie) {
			directorsString += director.getDirectorName() + " ";
		}
		return directorsString;
	}

	/**
	 * @return the genresOfMovie
	 */
	public HashSet<Genre> getGenresOfMovie() {
		return genresOfMovie;
	}

	/**
	 * @return the locationsOfMovie
	 */
	public HashSet<String> getLocationsOfMovie() {
		return locationsOfMovie;
	}

}
