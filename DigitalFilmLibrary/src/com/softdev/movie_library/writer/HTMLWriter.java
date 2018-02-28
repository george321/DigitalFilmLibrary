package com.softdev.movie_library.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HTMLWriter implements Writer {
	private String path;
	private File file;
	private FileWriter fw;
	private BufferedWriter bw;

	public HTMLWriter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void export(ArrayList<String> data, String name) {
		if (name.equals("") || name == null) {
			name = data.get(0);
		}
		path = name + ".html";
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
			bw.write("<!DOCTYPE html>\n");
			bw.write("<html>\n");
			bw.write("<head>\n\t<title>" + data.get(0) + "</title>" + "\n</head>\n");
			bw.write("<body>\n");
			bw.write("<b>" + data.get(0) + "</b><br>\n");
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i).contains("@@@")) {
					String[] parts = data.get(i).split("@@@");
					bw.write("\n<br><b>" + parts[1] + "</b><br>\n");
				} else {
					bw.write(data.get(i) + "<br>\n");
				}
			}
			bw.write("</body>\n</html>");
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
