package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.PlayerModel;
import controller.Controller;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5211981006355160891L;
	
	private TitleView titleView;
	private TableView tableView;
	private EditorView editorView;
	private FooterView footerView;
	private SplitView splitView;
	
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 900;
	
	private PlayerModel model;
	private Controller controller;
	
	public MainFrame(Controller controller, PlayerModel model) {
		super("Football Player App");
		this.model = model;
		this.controller = controller;
	}
	
	public void createAndShow() {
		initializeComponents();
		JPanel contents = layoutComponents(model);
		add(contents);
		addEvents();
		controller.registerListeners();

		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initializeComponents(){
		titleView = new TitleView(model);
		titleView.createAndShow();
		
		tableView = new TableView(model);
		tableView.createAndShow();
		
		footerView = new FooterView(model);
		footerView.createAndShow();
		
		editorView = new EditorView(model);
		editorView.createAndShow();
		
		splitView = new SplitView(tableView, editorView);
		splitView.createAndShow();
	}
	
	private JPanel layoutComponents(PlayerModel model){
		setSize(WIDTH, HEIGHT);
		setMinimumSize(new Dimension(800, 400));
				
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(titleView, BorderLayout.NORTH);
		mainPanel.add(splitView, BorderLayout.CENTER);
		mainPanel.add(footerView, BorderLayout.SOUTH);
		
		return mainPanel;
	}
	
	private void addEvents() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(
						MainFrame.this,
						"Wollen Sie das Programm wirklich beenden?",
						"Programm beenden",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE
				);
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	public TitleView getTitleView() {
		return titleView;
	}

	public TableView getTableView() {
		return tableView;
	}

	public EditorView getEditorView() {
		return editorView;
	}

	public FooterView getFooterView() {
		return footerView;
	}
	
	
	
}
