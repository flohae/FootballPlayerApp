package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import view.TableView.TeamAdapter;
import controller.Controller;
import model.PlayerModel;

public class TitleView extends JToolBar {
	
	private static final long serialVersionUID = 2793140044547518228L;
	
	private JButton btn_saveButton;
	private JButton btn_undoButton;
	private JButton btn_redoButton;
	private JButton btn_plusButton;
	private JButton btn_minusButton;
	private JButton btn_footerButton;
	
	private JTextField txt_searchField;

	private PlayerModel model;
	private Controller controller;
	private TableView table;
	private TeamAdapter tableAdapter;
	
	public TitleView(PlayerModel model) {
		this.model = model;
	}
	
	public void createAndShow() {
		initializeComponents();
		layoutComponents();
		addEvents();
		
		setVisible(true);
	}

	private void initializeComponents(){
		
	    btn_saveButton = new JButton(new ImageIcon(TitleView.class.getResource("Save.png")));
	    btn_plusButton = new JButton(new ImageIcon(TitleView.class.getResource("Plus.png")));
	    btn_minusButton = new JButton(new ImageIcon(TitleView.class.getResource("Minus.png")));
	    btn_undoButton = new JButton(new ImageIcon(TitleView.class.getResource("Undo.png")));
	    btn_redoButton = new JButton(new ImageIcon(TitleView.class.getResource("Redo.png")));
	    btn_footerButton = new JButton(new ImageIcon(TitleView.class.getResource("ShowFooter.png")));
	    txt_searchField = new JTextField();
	    
	}
	
	private void layoutComponents(){
//		setLayout(new BorderLayout());
		txt_searchField.setPreferredSize(new Dimension(200, 25));
	    txt_searchField.setMaximumSize(new Dimension(200, 25));
	    btn_saveButton.setEnabled(true);
	  
	    addSeparator();
	    add(btn_saveButton);
	    addSeparator();
	    add(btn_plusButton);
	    add(btn_minusButton);
	    addSeparator();
	    add(btn_undoButton);
	    add(btn_redoButton);
	    addSeparator();
	    add(btn_footerButton);
	    addSeparator(new Dimension(200, 0));
	    add(txt_searchField, BorderLayout.EAST);
	    addSeparator();
	  
	}
	
	private void addEvents() {
		txt_searchField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				txt_searchField.setText("");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		btn_saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.saveData();
			}
		});
		
		btn_plusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setNewPlayer();
				table.updateUI();
//				table.setRowSelectionInterval(0, model.getAllPlayer().size() -1);
//				table.scrollRectToVisible(new Rectangle(table.getCellRect(model.getAllPlayer().size() -1, 0, true)));
			}
		});
		
		btn_minusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int rowIndex = table.getSelectedRow();
//				int rowCount = tableAdapter.getRowCount();
//				if (rowIndex == rowCount - 1) {
//					controller.removeCurrentPlayer();
//					controller.setCurrentPlayer(rowIndex - 1);
//					table.setRowSelectionInterval(0, model.getAllPlayer().size() -1);
//				} else {
//					controller.removeCurrentPlayer();
//					controller.setCurrentPlayer(rowIndex);
//				}
//				table.updateUI();
			}
		});
	
	}
}