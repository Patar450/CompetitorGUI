package guiCode;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import competitors.*;

import fileIO.*;

public class GuiCompetitor implements ActionListener {

	Manager man = new Manager();
	JFrame searchAndEdit = new JFrame();
	JFrame filterBySubclass = new JFrame();
	JFrame SearchAndView = new JFrame();
	JPanel panelNorth, panelSouth, panelCenter, subClassPanelNorth, subClassPanelSouth, subClassPanelCenter,
			searchPanelNorth, searchPanelCenter, searchPanelSouth;
	JLabel lblSearchCN, lblCNumber, lblFirstName, lblSurname, lblAge, lblLevel, lblExtraAttribute, lblScores,
			lblOverallScores, lblSubclass, lblCNumberView, lblCompetitorFullDetails, lblCompetitorShortDetails;
	JTextField txtCNumberSearch, txtCNumber, txtFirstName, txtSurname, txtAge, txtLevel, txtExtraAttribute, txtScores1,
			txtScores2, txtScores3, txtScores4, txtScores5, txtOverallScores, txtSubclass, txtCNumberSearchViews,
			txtCShortDetails;
	JButton btnClose, btnClose2, btnClose3, btnSubmitChanges, btnSearch, btnFilterByClass, btnSearchViews;
	JTextArea txtAreaCompetitorDetails, txtCFullDetails;

	public void init() {

		// Gets details of the competitors from the external file
		man.readFile("Dance.txt");
		man.readFile("Swim.txt");
		man.readFile("Cycling.txt");
		// -----------------------------------------Start of Panel
		// 1--------------------------------------
		searchAndEdit.setTitle("Search for Competitor and edit the score to see the OverallScores.");
		searchAndEdit.setBounds(50, 50, 600, 500);

		filterBySubclass.setTitle("Filter by Subclass");
		filterBySubclass.setBounds(50, 50, 600, 600);

		SearchAndView.setTitle("Search and view details");
		SearchAndView.setBounds(50, 50, 450, 400);

		panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(0, 2));

		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(20, 0));

		panelSouth = new JPanel();

		lblSearchCN = new JLabel("Enter CN number");
		txtCNumberSearch = new JTextField(20);

		lblCNumber = new JLabel("CN");
		txtCNumber = new JTextField(20);
		txtCNumber.setEditable(false);

		lblFirstName = new JLabel("First Name");
		txtFirstName = new JTextField(20);
		txtFirstName.setEditable(false);

		lblSurname = new JLabel("Last Name");
		txtSurname = new JTextField(20);
		txtSurname.setEditable(false);

		lblAge = new JLabel("Age");
		txtAge = new JTextField(3);
		txtAge.setEditable(false);

		lblLevel = new JLabel("Level");
		txtLevel = new JTextField(10);
		txtLevel.setEditable(false);

		lblExtraAttribute = new JLabel("Extra Attribute(Stroke,Time or MOA)");
		txtExtraAttribute = new JTextField(2);

		lblScores = new JLabel("Scores");
		txtScores1 = new JTextField(1);
		txtScores2 = new JTextField(1);
		txtScores3 = new JTextField(1);
		txtScores4 = new JTextField(1);
		txtScores5 = new JTextField(1);

		lblOverallScores = new JLabel("Over Scores");
		txtOverallScores = new JTextField(10);
		txtOverallScores.setEditable(false);

		btnClose = new JButton("Close");
		btnClose.addActionListener(this);

		btnSubmitChanges = new JButton("Update Scores");
		btnSubmitChanges.addActionListener(this);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);

		panelNorth.add(lblSearchCN);
		panelNorth.add(txtCNumberSearch);

		panelCenter.add(lblCNumber);
		panelCenter.add(txtCNumber);

		panelCenter.add(lblFirstName);
		panelCenter.add(txtFirstName);

		panelCenter.add(lblSurname);
		panelCenter.add(txtSurname);

		panelCenter.add(lblAge);
		panelCenter.add(txtAge);

		panelCenter.add(lblLevel);
		panelCenter.add(txtLevel);

		panelCenter.add(lblExtraAttribute);
		panelCenter.add(txtExtraAttribute);

		panelCenter.add(lblScores);
		panelCenter.add(txtScores1);
		panelCenter.add(txtScores2);
		panelCenter.add(txtScores3);
		panelCenter.add(txtScores4);
		panelCenter.add(txtScores5);

		panelCenter.add(lblOverallScores);
		panelCenter.add(txtOverallScores);

		panelSouth.add(btnSearch);
		panelSouth.add(btnClose);
		panelSouth.add(btnSubmitChanges);

		searchAndEdit.getContentPane().add(panelNorth, BorderLayout.NORTH);
		searchAndEdit.getContentPane().add(panelCenter, BorderLayout.CENTER);
		searchAndEdit.getContentPane().add(panelSouth, BorderLayout.SOUTH);
//---------------------------------------End of Panel 1-------------------------------------

		// Set visibility of all 3 panels to true
		searchAndEdit.setVisible(true);
		filterBySubclass.setVisible(true);
		SearchAndView.setVisible(true);

		// ---------------------------------Start of Panel
		// 2---------------------------------------
		subClassPanelNorth = new JPanel();
		subClassPanelNorth.setLayout(new GridLayout(2, 0));

		subClassPanelCenter = new JPanel();
		subClassPanelCenter.setLayout(new GridLayout(1, 0));

		subClassPanelSouth = new JPanel();
		subClassPanelSouth.setLayout(new GridLayout(1, 1));

		lblSubclass = new JLabel("Enter the name of the Competition(Dancing, Swimming & Cycling):");
		txtSubclass = new JTextField(10);

		btnFilterByClass = new JButton("Filter by Subclass");
		btnFilterByClass.addActionListener(this);

		btnClose2 = new JButton("Close");
		btnClose2.addActionListener(this);

		txtAreaCompetitorDetails = new JTextArea();

		subClassPanelNorth.add(lblSubclass);
		subClassPanelNorth.add(txtSubclass);

		subClassPanelCenter.add(txtAreaCompetitorDetails);

		subClassPanelSouth.add(btnFilterByClass);
		subClassPanelSouth.add(btnClose2);

		filterBySubclass.getContentPane().add(subClassPanelNorth, BorderLayout.NORTH);
		filterBySubclass.getContentPane().add(subClassPanelCenter, BorderLayout.CENTER);
		filterBySubclass.getContentPane().add(subClassPanelSouth, BorderLayout.SOUTH);
//-----------------------------------------End of Panel 2---------------------------------------------
		// -----------------------------------------------Start of Panel
		// 3----------------------------------
		searchPanelNorth = new JPanel();
		searchPanelNorth.setLayout(new GridLayout(2, 1));

		searchPanelCenter = new JPanel();
		searchPanelCenter.setLayout(new GridLayout(4, 0));

		searchPanelSouth = new JPanel();
		searchPanelSouth.setLayout(new GridLayout(1, 2));

		lblCNumberView = new JLabel("Search via Competitor Number:");
		txtCNumberSearchViews = new JTextField(3);

		btnSearchViews = new JButton("Search");
		btnSearchViews.addActionListener(this);

		lblCompetitorShortDetails = new JLabel("Short Details of the Searched Competitor Number");
		txtCShortDetails = new JTextField(20);

		lblCompetitorFullDetails = new JLabel("Full details of the Searched Competitor");
		txtCFullDetails = new JTextArea();

		btnClose3 = new JButton("Close");
		btnClose3.addActionListener(this);

		searchPanelNorth.add(lblCNumberView);
		searchPanelNorth.add(txtCNumberSearchViews);

		searchPanelCenter.add(lblCompetitorShortDetails);
		searchPanelCenter.add(txtCShortDetails);
		searchPanelCenter.add(lblCompetitorFullDetails);
		searchPanelCenter.add(txtCFullDetails);

		searchPanelSouth.add(btnSearchViews);
		searchPanelSouth.add(btnClose3);

		SearchAndView.getContentPane().add(searchPanelNorth, BorderLayout.NORTH);
		SearchAndView.getContentPane().add(searchPanelCenter, BorderLayout.CENTER);
		SearchAndView.getContentPane().add(searchPanelSouth, BorderLayout.SOUTH);
		// ------------------------------------------End of Panel
		// 3-----------------------------------
	}

	public void actionPerformed(ActionEvent e) {

		Competitor c;

		if (e.getSource() == btnClose || e.getSource() == btnClose2 || e.getSource() == btnClose3) {
			man.writeReport("Report.txt");
			System.exit(0);
		}

		if (e.getSource() == btnSearch) {
			String CnPlaceholder = txtCNumberSearch.getText();
			if (CnPlaceholder.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ensure the CompetitorNumber Search box is not empty!");
			} else {
				int competitorNumber = Integer.parseInt(txtCNumberSearch.getText());
				c = man.competitorSearch(competitorNumber);
				if (c != null) {
					txtCNumber.setText(Integer.toString(c.getCompetitorNumber()));
					txtFirstName.setText(c.getName().getFirstName());
					txtSurname.setText(c.getName().getLastName());
					txtAge.setText(Integer.toString(c.getAge()));
					txtLevel.setText(c.getLevel());

					if (c instanceof DancingCompetitor) {
						DancingCompetitor dancer = (DancingCompetitor) c;
						txtExtraAttribute.setText(Double.toString(dancer.getMinutesOfApplause()));
					} else if (c instanceof CyclingCompetitor) {
						CyclingCompetitor cycler = (CyclingCompetitor) c;
						txtExtraAttribute.setText(Double.toString(cycler.getTime()));
					} else if (c instanceof SwimmingCompetitor) {
						SwimmingCompetitor swimmer = (SwimmingCompetitor) c;
						txtExtraAttribute.setText(Double.toString(swimmer.getStrokes()));
					}

					int[] scorePlaceholder = c.getScoreArray();
					txtScores1.setText(Integer.toString(scorePlaceholder[0]));
					txtScores2.setText(Integer.toString(scorePlaceholder[1]));
					txtScores3.setText(Integer.toString(scorePlaceholder[2]));
					txtScores4.setText(Integer.toString(scorePlaceholder[3]));
					txtScores5.setText(Integer.toString(scorePlaceholder[4]));

					txtOverallScores.setText(Double.toString(c.getOverallScore()));

				} else if (c == null) {
					JOptionPane.showMessageDialog(null, "Competitor Number not found! Please, try again.");
				}
			}
		}
		if (e.getSource() == btnSubmitChanges) {
			int competitorNumber = Integer.parseInt(txtCNumberSearch.getText());
			c = man.competitorSearch(competitorNumber);
			int[] scorePlaceHolders = { Integer.parseInt(txtScores1.getText()), Integer.parseInt(txtScores2.getText()),
					Integer.parseInt(txtScores3.getText()), Integer.parseInt(txtScores4.getText()),
					Integer.parseInt(txtScores5.getText()) };
			if (c instanceof DancingCompetitor) {
				DancingCompetitor dancer = (DancingCompetitor) c;
				dancer.setScores(scorePlaceHolders);
				dancer.setMinutesOfApplause(Double.parseDouble(txtExtraAttribute.getText()));
				txtOverallScores.setText(Double.toString(dancer.getOverallScore()));
			} else if (c instanceof CyclingCompetitor) {
				CyclingCompetitor cycler = (CyclingCompetitor) c;
				cycler.setScores(scorePlaceHolders);
				cycler.setTime(Double.parseDouble(txtExtraAttribute.getText()));
				txtOverallScores.setText(Double.toString(cycler.getOverallScore()));
			} else if (c instanceof SwimmingCompetitor) {
				SwimmingCompetitor swimmer = (SwimmingCompetitor) c;
				swimmer.setScores(scorePlaceHolders);
				swimmer.setStrokes(Double.parseDouble(txtExtraAttribute.getText()));
				txtOverallScores.setText(Double.toString(swimmer.getOverallScore()));
			}

		}
		if (e.getSource() == btnFilterByClass) {
			String subclass = txtSubclass.getText();
			ArrayList<Competitor> competitors = man.getCompetitorList().searchCompetitorBySubclass(subclass);
			String details = "";
			for (Competitor competitor : competitors) {
				details += competitor.getFullDetails();
			}
			txtAreaCompetitorDetails.setText(details);
		}
		if (e.getSource() == btnSearchViews) {
			{
				String CnPlaceholder = txtCNumberSearchViews.getText();
				if (CnPlaceholder.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ensure the CompetitorNumber Search box is not empty!");
				} else {
					int competitorNumber = Integer.parseInt(txtCNumberSearchViews.getText());
					c = man.competitorSearch(competitorNumber);
					if (c != null) {
						if (c instanceof DancingCompetitor) {
							DancingCompetitor dancer = (DancingCompetitor) c;
							txtCShortDetails.setText(dancer.getShortDetails());
							txtCFullDetails.setText(dancer.getFullDetails());
						} else if (c instanceof CyclingCompetitor) {
							CyclingCompetitor cycler = (CyclingCompetitor) c;
							txtCShortDetails.setText(cycler.getShortDetails());
							txtCFullDetails.setText(cycler.getFullDetails());
						} else if (c instanceof SwimmingCompetitor) {
							SwimmingCompetitor swimmer = (SwimmingCompetitor) c;
							txtCShortDetails.setText(swimmer.getShortDetails());
							txtCFullDetails.setText(swimmer.getFullDetails());
						}

					} else if (c == null) {
						JOptionPane.showMessageDialog(null, "Competitor Number not found! Please, try again.");
					}
				}
			}
		}

	}
}
