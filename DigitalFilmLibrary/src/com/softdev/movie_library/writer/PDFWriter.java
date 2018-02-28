package com.softdev.movie_library.writer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriter implements Writer {
	private Document document;
	private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	private static Font titlelFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);

	public PDFWriter() {
		super();
	}

	@Override
	public void export(ArrayList<String> data, String name) {
		document = new Document();
		if (name.equals("") || name == null) {
			name = data.get(0);
		}
		try {
			PdfWriter.getInstance(document, new FileOutputStream(name + ".pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't create your file.");
		}
		write(data);

	}

	@Override
	public int write(ArrayList<String> data) {
		Paragraph paragraph1 = new Paragraph();
		Paragraph paragraph2 = new Paragraph();
		document.open();
		document.addTitle(data.get(0));
		try {
			paragraph1 = new Paragraph(data.get(0) + "\n\n", titlelFont);
			paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1);
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i).contains("@@@")) {
					String[] parts = data.get(i).split("@@@");
					paragraph1 = new Paragraph("\n" + parts[1] + "\n", titlelFont);
					document.add(paragraph1);
				} else {
					paragraph2 = new Paragraph(data.get(i) + "\n", normalFont);
					document.add(paragraph2);
				}

			}
			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
			JFrame frame = new JFrame();
			;
			JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't create your file.");
			return -1;
		}

		return 1;
	}

}
