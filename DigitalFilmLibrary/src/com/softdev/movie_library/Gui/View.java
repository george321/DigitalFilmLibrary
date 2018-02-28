package com.softdev.movie_library.Gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.softdev.movie_library.data.DataManager;
import com.softdev.movie_library.reader.DataReader;
import com.softdev.movie_library.writer.WriterFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	private DataReader dataReader;
	private DataManager dataManager;

	private JLabel moviesInfoLabel;
	private JLabel actorsInfoLabel;
	private JLabel genresInfoLabel;
	private JLabel directorsInfoLabel;
	private JLabel countiresInfoLabel;

	private WriterFactory writerFactory = new WriterFactory();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLoadMovieData = new JButton("Load Data");
		btnLoadMovieData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadMoviesData();
			}

		});
		btnLoadMovieData.setBounds(33, 100, 111, 23);
		frame.getContentPane().add(btnLoadMovieData);

		JLabel lblClickHereTo = new JLabel("<html>Click here to load the <br>data for the movies</html>");
		lblClickHereTo.setBounds(33, 53, 120, 36);
		frame.getContentPane().add(lblClickHereTo);

		JLabel lblSelectYourQuestion = new JLabel("<html>Select your question here</html>");
		lblSelectYourQuestion.setBounds(288, 65, 152, 32);
		frame.getContentPane().add(lblSelectYourQuestion);

		JButton btnNewButton = new JButton("Search for a movies's description");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateMovieDesc();
			}

		});
		btnNewButton.setBounds(238, 110, 234, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnSearchByA = new JButton("Search by a Genre");
		btnSearchByA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateGenreAnswer();
			}
		});
		btnSearchByA.setBounds(238, 140, 234, 23);
		frame.getContentPane().add(btnSearchByA);

		JButton btnSearchByA_1 = new JButton("Search by a Country");
		btnSearchByA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateCountryAnswer();
			}
		});
		btnSearchByA_1.setBounds(238, 170, 234, 23);
		frame.getContentPane().add(btnSearchByA_1);

		JButton btnSearchByAn = new JButton("Search by an Actor");
		btnSearchByAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateActorAnswer();
			}
		});
		btnSearchByAn.setBounds(238, 200, 234, 23);
		frame.getContentPane().add(btnSearchByAn);

		JButton btnSearchByA_2 = new JButton("Search by a Director");
		btnSearchByA_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateDirectorAnswer();
			}
		});
		btnSearchByA_2.setBounds(238, 230, 234, 23);
		frame.getContentPane().add(btnSearchByA_2);

		moviesInfoLabel = new JLabel("");
		moviesInfoLabel.setBounds(33, 170, 78, 14);
		frame.getContentPane().add(moviesInfoLabel);

		actorsInfoLabel = new JLabel("");
		actorsInfoLabel.setBounds(33, 190, 78, 14);
		frame.getContentPane().add(actorsInfoLabel);

		genresInfoLabel = new JLabel(" ");
		genresInfoLabel.setBounds(33, 210, 78, 14);
		frame.getContentPane().add(genresInfoLabel);

		directorsInfoLabel = new JLabel(" ");
		directorsInfoLabel.setBounds(33, 230, 100, 14);
		frame.getContentPane().add(directorsInfoLabel);

		countiresInfoLabel = new JLabel(" ");
		countiresInfoLabel.setBounds(33, 250, 100, 14);
		frame.getContentPane().add(countiresInfoLabel);

	}

	private void generateMovieDesc() {
		getIdOrName();
	}

	private int generateGenreAnswer() {
		String genreName = getNamePanel(" Genre");
		ArrayList<String> dataToWrite = dataManager.findGenreMovies(genreName);
		if (dataToWrite != null) {
			selectFormat(dataToWrite);
			return 1;
		} else {
			JOptionPane.showMessageDialog(frame,
					"I am sorry but i couldn't find " + genreName + " Genre. Please try again.");
			return -1;
		}

	}

	private int generateCountryAnswer() {
		String countryName = getNamePanel(" Country");
		ArrayList<String> dataToWrite = dataManager.findCountryMovies(countryName);
		if (dataToWrite != null) {
			selectFormat(dataToWrite);
			return 1;
		} else {
			JOptionPane.showMessageDialog(frame,
					"I am sorry but i couldn't find " + countryName + " in Countries. Please try again.");
			return -1;
		}
	}

	private int generateActorAnswer() {
		String actorName = getNamePanel(" Actor's Name");
		ArrayList<String> dataToWrite = dataManager.findActorMovies(actorName);
		if (dataToWrite != null) {
			selectFormat(dataToWrite);
			return 1;
		} else {
			JOptionPane.showMessageDialog(frame,
					"I am sorry but i couldn't find " + actorName + " in Actors. Please try again.");
			return -1;
		}
	}

	private int generateDirectorAnswer() {
		String directorName = getNamePanel(" Director's Name");
		ArrayList<String> dataToWrite = dataManager.findDirectorMovies(directorName);
		if (dataToWrite != null) {
			selectFormat(dataToWrite);
			return 1;
		} else {
			JOptionPane.showMessageDialog(frame,
					"I am sorry but i couldn't find " + directorName + " in Directors list. Please try again.");
			return -1;
		}
	}

	private String getNamePanel(String infoMessage) {
		JTextField nameTextField;
		JPanel getNamePanel = new JPanel();
		getNamePanel.setBounds(0, 0, 420, 250);
		getNamePanel.setPreferredSize(new Dimension(420, 250));
		getNamePanel.setLayout(null);

		JLabel lblLoadActivityInfo = new JLabel("Please insert" + infoMessage);
		lblLoadActivityInfo.setBounds(100, 55, 229, 14);
		getNamePanel.add(lblLoadActivityInfo);

		JLabel lblNewLabel = new JLabel(infoMessage);
		lblNewLabel.setBounds(54, 108, 82, 14);
		getNamePanel.add(lblNewLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(162, 105, 86, 20);
		getNamePanel.add(nameTextField);
		nameTextField.setColumns(10);
		JOptionPane.showConfirmDialog(null, getNamePanel, "Get " + infoMessage, JOptionPane.PLAIN_MESSAGE);
		// System.out.println(nameTextField.getText());
		return nameTextField.getText();
	}

	private void loadMoviesData() {
		dataReader = new DataReader();
		dataManager = new DataManager();
		dataManager.setActors(dataReader.getActors());
		dataManager.setMovies(dataReader.getMovies());
		dataManager.setCountries(dataReader.getCountries());
		dataManager.setGenres(dataReader.getGenres());
		dataManager.setDirectors(dataReader.getDirectors());
		showLoadInfo();
		setDataInfo();
	}

	private void setDataInfo() {
		moviesInfoLabel.setText(dataReader.getMovies().size() + " Movies");
		actorsInfoLabel.setText(dataReader.getActors().size() + " Actors");
		genresInfoLabel.setText(dataReader.getGenres().size() + " Genres");
		directorsInfoLabel.setText(dataReader.getDirectors().size() + " Directors");
		countiresInfoLabel.setText(dataReader.getCountries().size() + " Countries");
	}

	public void selectFormat(ArrayList<String> data) {
		JPanel selectFormat = new JPanel();
		selectFormat.setBounds(0, 0, 420, 250);
		selectFormat.setPreferredSize(new Dimension(420, 250));
		selectFormat.setLayout(null);

		JLabel lblLoadActivityInfo = new JLabel("Choose the format you want to save");
		lblLoadActivityInfo.setBounds(100, 55, 229, 14);
		selectFormat.add(lblLoadActivityInfo);

		JButton btnPlainText = new JButton("Plain Text");
		btnPlainText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				writerFactory.getWriter("TEXT").export(data, getNamePanel(" file's Name"));
			}
		});

		btnPlainText.setBounds(130, 80, 100, 23);
		selectFormat.add(btnPlainText);

		JButton btnHtmlFile = new JButton("HTML File");
		btnHtmlFile.setBounds(130, 110, 100, 23);
		btnHtmlFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writerFactory.getWriter("HTML").export(data, getNamePanel(" file's Name"));
			}
		});
		selectFormat.add(btnHtmlFile);

		JButton btnMarkdown = new JButton("Markdown");
		btnMarkdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writerFactory.getWriter("MARKDOWN").export(data, getNamePanel(" file's Name or press OK"));
			}
		});
		btnMarkdown.setBounds(130, 140, 100, 23);
		selectFormat.add(btnMarkdown);

		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writerFactory.getWriter("PDF").export(data, getNamePanel(" file's Name"));
			}
		});
		btnPdf.setBounds(130, 170, 100, 23);
		selectFormat.add(btnPdf);

		JButton btnTxtToPdf = new JButton("txt To PDF");
		btnTxtToPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writerFactory.getWriter("CONVERT").export(data, getNamePanel(" file's Name"));
			}
		});
		btnTxtToPdf.setBounds(130, 200, 100, 23);
		selectFormat.add(btnTxtToPdf);

		JOptionPane.showConfirmDialog(null, selectFormat, "Select Format", JOptionPane.PLAIN_MESSAGE);

	}

	public int getIdOrName() {
		JTextField idTextField;
		JTextField movieNameTextField;
		JPanel getNameOrIdPanel = new JPanel();
		getNameOrIdPanel.setBounds(0, 0, 420, 250);
		getNameOrIdPanel.setPreferredSize(new Dimension(420, 250));
		getNameOrIdPanel.setLayout(null);

		JLabel lblLoadActivityInfo = new JLabel("Please insert movie's ID or Name..");
		lblLoadActivityInfo.setBounds(100, 55, 229, 14);
		getNameOrIdPanel.add(lblLoadActivityInfo);
		JLabel lblNewLabel = new JLabel("Movie's ID:");
		lblNewLabel.setBounds(54, 108, 82, 14);
		getNameOrIdPanel.add(lblNewLabel);

		idTextField = new JTextField();
		idTextField.setBounds(162, 105, 86, 20);
		getNameOrIdPanel.add(idTextField);
		idTextField.setColumns(10);

		JLabel lblMoviesName = new JLabel("Movie's Name:");
		lblMoviesName.setBounds(54, 148, 95, 14);
		getNameOrIdPanel.add(lblMoviesName);

		movieNameTextField = new JTextField();
		movieNameTextField.setBounds(162, 145, 86, 20);
		getNameOrIdPanel.add(movieNameTextField);
		movieNameTextField.setColumns(10);

		JOptionPane.showConfirmDialog(null, getNameOrIdPanel, "System Message", JOptionPane.PLAIN_MESSAGE);
		if (!idTextField.getText().equals("")) {
			if (dataManager.findMovieWithId(Integer.parseInt(idTextField.getText())) != null) {
				selectFormat(dataManager.findMovieWithId(Integer.parseInt(idTextField.getText())));
			} else {
				JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't find that movie. Please try again.");
				return -1;
			}
			return 1;
		} else if (!movieNameTextField.getText().equals("") && movieNameTextField.getText() != null) {
			if (dataManager.findMovieWithName(movieNameTextField.getText()) != null) {
				selectFormat(dataManager.findMovieWithName(movieNameTextField.getText()));
			} else {
				JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't find that movie. Please try again.");
				return -1;
			}

			return 1;
		} else {
			JOptionPane.showMessageDialog(frame, "I am sorry but i couldn't find that movie. Please try again.");
			return -1;
		}

	}

	public void showLoadInfo() {
		JPanel loadDataMessage = new JPanel();
		loadDataMessage.setBounds(0, 0, 420, 250);
		loadDataMessage.setPreferredSize(new Dimension(420, 250));
		loadDataMessage.setLayout(null);

		JLabel lblLoadActivityInfo = new JLabel("Load Activity Info");
		lblLoadActivityInfo.setBounds(130, 30, 229, 14);
		loadDataMessage.add(lblLoadActivityInfo);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(dataReader.getNumberOfMovies() + " Movies Loaded");
		lblNewLabel.setBounds(110, 100, 150, 14);
		loadDataMessage.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(dataReader.getNumberOfActors() + " Actors Loaded");
		lblNewLabel_1.setBounds(110, 130, 150, 14);
		loadDataMessage.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(dataReader.getNumberOfGenres() + " Genres Loaded");
		lblNewLabel_2.setBounds(110, 160, 150, 14);
		loadDataMessage.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(dataReader.getNumberOfCountries() + " Countries Loaded");
		lblNewLabel_3.setBounds(110, 190, 150, 14);
		loadDataMessage.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(dataReader.getNumberOfDirectors() + " Directors Loaded");
		lblNewLabel_4.setBounds(110, 220, 150, 14);
		loadDataMessage.add(lblNewLabel_4);

		JOptionPane.showConfirmDialog(null, loadDataMessage, "System Message", JOptionPane.PLAIN_MESSAGE);

	}
}
