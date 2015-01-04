package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.Dimension;
import java.awt.ScrollPane;
import javax.swing.JSplitPane;

public class SplitView extends JSplitPane {

	private static final long serialVersionUID = -7356274287723923160L;

	private TableView tableView;
	private EditorView editorView;
	private ScrollPane scrollPane;
	
	public SplitView(TableView tableView, EditorView editorView) {
		this.tableView = tableView;
		this.editorView = editorView;
	}

	public void createAndShow() {
		initializeComponents();
		layoutComponents();
		addEvents();

		setVisible(true);
	}

	private void initializeComponents() {
		scrollPane = new ScrollPane();
	}

	private void layoutComponents() {	
		scrollPane.add(tableView);
		scrollPane.setMinimumSize(new Dimension(400, 300));
		scrollPane.setPreferredSize(new Dimension(700, 800));
		setContinuousLayout(true);
		setLeftComponent(scrollPane);
		setRightComponent(editorView);
		
	}

	private void addEvents() {

	}
	
}
