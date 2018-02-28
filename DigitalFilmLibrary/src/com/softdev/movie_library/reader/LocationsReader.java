package com.softdev.movie_library.reader;

public class LocationsReader extends Reader {

	public LocationsReader(String fileName) {
		super(fileName);
		readFile();
	}
}
