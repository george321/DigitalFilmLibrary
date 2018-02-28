package com.softdev.movie_library.writer;

import java.util.ArrayList;

public interface Writer {

	int write(ArrayList<String> data);

	void export(ArrayList<String> data, String name);

}
