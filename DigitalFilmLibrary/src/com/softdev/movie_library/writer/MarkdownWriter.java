package com.softdev.movie_library.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MarkdownWriter implements Writer {
	private String path;
	private File file;
	private FileWriter fw;
	private BufferedWriter bw;

	public MarkdownWriter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void export(ArrayList<String> data, String name) {
		if (name.equals("") || name == null) {
			name = data.get(0);
		}
		path = name + ".md";
		file = new File(path);
		// If file doesn't exists, then create it
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JFrame frame= new JFrame();;
				JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't create your file.");
			}
			write(data);
		}
	}

	@Override
	public int write(ArrayList<String> data) {
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write("# " + data.get(0) + "\n");
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i).contains("@@@")) {
					String[] parts = data.get(i).split("@@@");
					bw.write("\n## " + parts[1] + "\n");
				} else {
					bw.write("- " + data.get(i) + "\n");
				}
			}
			// Close connection
			bw.close();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			JFrame frame= new JFrame();;
			JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't create your file.");
			return -1;
		}

	}

}
