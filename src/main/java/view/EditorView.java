package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Player;
import model.PlayerModel;
import net.miginfocom.swing.MigLayout;

public class EditorView extends JPanel {

	private static final long serialVersionUID = 1L;

	private PlayerModel model;

	// Labels
	private JLabel labelName;
	private JLabel labelBirth;
	private JLabel labelNationality;
	private JLabel labelPosition;
	private JLabel labelOrganisation;
	private JLabel labelGrade;
	private JLabel labelNumberOfMatchesFIFA;
	private JLabel labelNumberOfMatchesRSSSF;
	private JLabel labelMatch100;
	private JLabel labelMatch100Against;
	private JLabel labelFirstMatch;
	private JLabel labelLastMatch;

	// TextFields
	private JTextField textFieldName;
	private JTextField textFieldBirth;
	private JTextField textFieldNationality;
	private JTextField textFieldPosition;
	private JTextField textFieldOrganisation;
	private JTextField textFieldGrade;
	private JTextField textFieldNumberOfMatchesFIFA;
	private JTextField textFieldNumberOfMatchesRSSSF;
	private JTextField textFieldMatch100;
	private JTextField textFieldMatch100Against;
	private JTextField textFieldFirstMatch;
	private JTextField textFieldLastMatch;

	// SummaryBoard
	private JLabel summaryBoardLabelName;
	private JLabel summaryBoardLabelNationality;
	private JLabel summaryBoardLabelNationalityIcon;
	private JLabel summaryBoardLabelNumberOfMatches;
	private JLabel summaryBoardLabelInternationalMatches;
	private JLabel summaryBoardLabelFirstMatch;
	private JLabel summaryBoardLabelFromTo;
	private JLabel summaryBoardLabelLastMatch;
	private JLabel summaryBoardLabelOrganisationIcon;

	private JPanel summaryBoard;
	private JPanel editingBoard;

	public EditorView(PlayerModel model) {
		this.model = model;
	}

	public void createAndShow() {
		initializeComponents();
		JPanel contents = layoutComponents();
		addEvents();

		add(contents);
		setVisible(true);
	}

	private void initializeComponents() {
		// Initialize labels
		labelName = new JLabel("Name:");
		labelBirth = new JLabel("Geburtsjahr:");
		labelNationality = new JLabel("Nationalität:");
		labelPosition = new JLabel("Position:");
		labelOrganisation = new JLabel("Verband:");
		labelGrade = new JLabel("Rang:");
		labelNumberOfMatchesFIFA = new JLabel("Spiele (FIFA):");
		labelNumberOfMatchesRSSSF = new JLabel("Spiele (RSSSF):");
		labelMatch100 = new JLabel("100. Spiel am:");
		labelMatch100Against = new JLabel("gegen:");
		labelFirstMatch = new JLabel("erstes Spiel:");
		labelLastMatch = new JLabel("letztes Spiel:");

		// SummaryBoard
		summaryBoardLabelName = new JLabel("Name");
		summaryBoardLabelNationality = new JLabel("Nationalität");
		summaryBoardLabelNationalityIcon = new JLabel("Flagge");
		summaryBoardLabelNumberOfMatches = new JLabel("Spiele (FIFA)");
		summaryBoardLabelInternationalMatches = new JLabel("Länderspiele");
		summaryBoardLabelFirstMatch = new JLabel("erstes Spiel");
		summaryBoardLabelFromTo = new JLabel("von...bis");
		summaryBoardLabelLastMatch = new JLabel("letztes Spiel");
		summaryBoardLabelOrganisationIcon = new JLabel("Wappen");

		// Initialize text fields
		textFieldName = new JTextField();
		textFieldBirth = new JTextField();
		textFieldNationality = new JTextField();
		textFieldPosition = new JTextField();
		textFieldOrganisation = new JTextField();
		textFieldGrade = new JTextField();
		textFieldNumberOfMatchesFIFA = new JTextField();
		textFieldNumberOfMatchesRSSSF = new JTextField();
		textFieldMatch100 = new JTextField();
		textFieldMatch100Against = new JTextField();
		textFieldFirstMatch = new JTextField();
		textFieldLastMatch = new JTextField();

		// Boards
		summaryBoard = new JPanel();
		editingBoard = new JPanel();
	}

	private JPanel layoutComponents() {
		// SummaryBoard
		Font f1 = new Font("Arial", Font.BOLD, 20);
		summaryBoard.setFont(f1);
		summaryBoardLabelName.setFont(new Font("", Font.BOLD, 24));
		summaryBoard.setLayout(new MigLayout("wrap 4", // layout constraints
				"[][][][]", // column constraints
				"")); // row constraints
		summaryBoard.setBackground(Color.WHITE);
		summaryBoard.add(summaryBoardLabelName, "span 4");
		summaryBoard.add(summaryBoardLabelNationality);
		summaryBoard.add(summaryBoardLabelNationalityIcon, "skip 2");
		summaryBoard.add(summaryBoardLabelNumberOfMatches);
		summaryBoard.add(summaryBoardLabelInternationalMatches);
		summaryBoard.add(summaryBoardLabelOrganisationIcon, "skip, span 1 2");
		summaryBoard.add(summaryBoardLabelFirstMatch);
		summaryBoard.add(summaryBoardLabelFromTo);
		summaryBoard.add(summaryBoardLabelLastMatch);

		// Editing Board
		editingBoard.setLayout(new MigLayout("wrap 4", // layout constraints
				"[]20[grow, fill]50[]20[grow, fill]", // column constraints
				"")); // row constraints
		editingBoard.add(labelName);
		editingBoard.add(textFieldName);
		editingBoard.add(labelBirth);
		editingBoard.add(textFieldBirth);
		editingBoard.add(labelNationality);
		editingBoard.add(textFieldNationality);
		editingBoard.add(labelPosition);
		editingBoard.add(textFieldPosition);
		editingBoard.add(labelOrganisation);
		editingBoard.add(textFieldOrganisation);
		editingBoard.add(labelGrade);
		editingBoard.add(textFieldGrade);
		editingBoard.add(labelNumberOfMatchesFIFA);
		editingBoard.add(textFieldNumberOfMatchesFIFA);
		editingBoard.add(labelNumberOfMatchesRSSSF);
		editingBoard.add(textFieldNumberOfMatchesRSSSF);
		editingBoard.add(labelMatch100);
		editingBoard.add(textFieldMatch100);
		editingBoard.add(labelMatch100Against);
		editingBoard.add(textFieldMatch100Against);
		editingBoard.add(labelFirstMatch);
		editingBoard.add(textFieldFirstMatch);
		editingBoard.add(labelLastMatch);
		editingBoard.add(textFieldLastMatch);

		// Right Components together
		JPanel rightComponents = new JPanel();
		rightComponents.setLayout(new BorderLayout());
		rightComponents.setPreferredSize(new Dimension(500, 500));
		rightComponents.setMinimumSize(new Dimension(400, 0));
		rightComponents.setBorder(new EmptyBorder(10, 10, 10, 10));
		rightComponents.add(summaryBoard, BorderLayout.NORTH);
		rightComponents.add(editingBoard, BorderLayout.CENTER);

		return rightComponents;
	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}

	public void showDetails(final int rowIndex) {
		Player selectedPlayer = model.getAllPlayer().get(rowIndex);
		textFieldName.setText(selectedPlayer.getName());
		textFieldBirth.setText(selectedPlayer.getBirthYear());
		textFieldNationality.setText(selectedPlayer.getCountry());
		textFieldPosition.setText(selectedPlayer.getPosition());
		textFieldOrganisation.setText(selectedPlayer.getAssociation());
		textFieldGrade.setText(selectedPlayer.getRank());
		textFieldNumberOfMatchesFIFA.setText(selectedPlayer.getNumberOfMatchesFIFA());
		textFieldNumberOfMatchesRSSSF.setText(selectedPlayer.getNumberOfMatchesRSSSF());
		textFieldMatch100.setText(selectedPlayer.getMatch100());
		textFieldMatch100Against.setText(selectedPlayer.getMatch100Against());
		textFieldFirstMatch.setText(selectedPlayer.getFirstMatch());
		textFieldLastMatch.setText(selectedPlayer.getLastMatch());

		String countryCode = selectedPlayer.getCountry();
		String path = CountryToFlagMap.getImagePathForCountry(countryCode);
	
	}
	
//	public class ImagePanel extends JPanel {
//
//			Player selectedPlayer = model.getPlayers().get(rowIndex);
//			
//			private static final long serialVersionUID = 1L;
//			private BufferedImage image;
//
//			public ImagePanel() {
//				try {
//					image = ImageIO.read(new File(selectedPlayer.getCountry()));
//				} catch (IOException ex) {
//					// handle exception...
//				}
//			}
//
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				g.drawImage(image, 0, 0, null); // see javadoc for more info on the
//												// parameters
//			}
//
//		}
}

