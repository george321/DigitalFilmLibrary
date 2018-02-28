package com.softdev.movie_library.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	private ArrayList<String[]> lineData = new ArrayList<String[]>();
	private FileReader fileReader;
	protected BufferedReader bufferreader;

	private String path = "data/";

	public Reader(String fileName) {
		initFileReader(fileName);

	}

	private int initFileReader(String fileName) {
		try {
			fileReader = new FileReader(path + fileName);
			bufferreader = new BufferedReader(fileReader);
			return 1; // file ok
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio");
			return -1; // file not ok
		}
	}

	public int readFile() {
		String line;
		int lines = 0;
		try {
			bufferreader.readLine();
			while ((line = bufferreader.readLine()) != null) {
				String data[] = line.split("\t");
				getLineArray().add(data);
				lines++;
			}

			return lines;
		} catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
	}

	public ArrayList<String[]> getLineArray() {
		return lineData;
	}


}
