package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.PlayerModel;

public class FooterView extends JPanel {

	private static final long serialVersionUID = -4114007437087614222L;
	
	private JButton testButton;
	
	private PlayerModel model;

	public FooterView(PlayerModel model) {
		this.model = model;
	}

	public void createAndShow() {
		initializeComponents();
		JPanel contents = layoutComponents();
		add(contents);
		
		addEvents();
		setVisible(true);
	}

	private void initializeComponents() {
		testButton = new JButton("Test");
	}

	private JPanel layoutComponents() {
		testButton.setBackground(Color.GREEN);
		testButton.setSize(new Dimension(100, 40));
		
		JPanel footerPanel = new JPanel();
		footerPanel.setLayout(new GridLayout());
		footerPanel.setBackground(Color.BLACK);
		footerPanel.add(testButton);
		
		return footerPanel;
	}

	private void addEvents() {
		
	}
}
