package com.softdev.movie_library.writer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TextConverter implements Writer {
	private Document document;
	private BufferedReader br;
	private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	private static Font titlelFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);

	@Override
	public void export(ArrayList<String> data, String name) {
		if (name.equals("") || name == null) {
			name = data.get(0);
		}
		document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(name + ".pdf"));
			br = new BufferedReader(new FileReader(name + ".txt"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't convert your file.");
		}
		document.open();
		write(data);

	}

	@Override
	public int write(ArrayList<String> data) {
		String line;
		Paragraph p;
		try {
			p = new Paragraph(data.get(0), titlelFont);
			document.add(p);
			while ((line = br.readLine()) != null) {
				p = new Paragraph(line, normalFont);
				document.add(p);
			}
			document.close();
			br.close();
			return 1;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't convert your file.");
			return -1;
		}

	}

}
