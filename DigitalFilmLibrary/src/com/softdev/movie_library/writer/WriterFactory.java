package com.softdev.movie_library.writer;

public class WriterFactory {

	public Writer getWriter(String writer) {
		if (writer == null) {
			return null;
		}
		if (writer.equalsIgnoreCase("HTML")) {
			return new HTMLWriter();

		} else if (writer.equalsIgnoreCase("MARKDOWN")) {
			return new MarkdownWriter();

		} else if (writer.equalsIgnoreCase("PDF")) {
			return new PDFWriter();

		} else if (writer.equalsIgnoreCase("TEXT")) {
			return new PlainTextWriter();
		} else if (writer.equalsIgnoreCase("CONVERT")) {
			return new TextConverter();
		}else if (writer.equalsIgnoreCase("POWRPOINT")) {
			return new PowerPointWriter();
		}

		return null;
	}
}
