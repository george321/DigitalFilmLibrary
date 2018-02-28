package com.softdev.movie_library.data;

import java.util.ArrayList;
import java.util.HashSet;

public class Actor {

	private String actorId;
	private String actorName;
	private String ranking;
	private HashSet<Movie> moviesOfActor = new HashSet<Movie>();

	public Actor(String id, String name, String ranking) {
		actorId = id;
		actorName = name;
		this.ranking = ranking;

	}

	public int addMovie(Movie movieObject) {
		moviesOfActor.add(movieObject);
		return 1;
	}

	public ArrayList<String> getInfo() {
		ArrayList<String> data = new ArrayList<String>();
		data.add(actorName);
		data.add("Our collection has " + moviesOfActor.size() + " movies with the actor " + actorName);
		data.add("-@@@List of " + actorName + "'s Movies");
		for (Movie movie : moviesOfActor) {
			data.add(movie.getTitle() + "|" + movie.getMovieData()[5] + "|" + movie.getDirectorsToString());
		}
		return data;
	}

	/**
	 * @return the moviesOfActor
	 */
	public HashSet<Movie> getMoviesOfActor() {
		return moviesOfActor;
	}

	/**
	 * @return the actorId
	 */
	public String getActorId() {
		return actorId;
	}

	/**
	 * @return the actorName
	 */
	public String getActorName() {
		return actorName;
	}

	/**
	 * @return the ranking
	 */
	public String getRanking() {
		return ranking;
	}

}
