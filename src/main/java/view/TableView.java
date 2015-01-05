package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import controller.Controller;
import model.Player;
import model.PlayerModel;

public class TableView extends JPanel {
	
	public interface RowClickListener {
		
		public void onRowClicked(int rowIndex);
		
	}
	
	private List<RowClickListener> listeners = new LinkedList<>();

	private static final long serialVersionUID = 1L;

	private Object[] columnNames = {"#Platz", "Name", "Geburtsjahr", "Land",
			"Verband", "Position", "100. Spiel", "Gegener", "Spiele (FIFA)",
			"Spiele (RSSSF)", "Von", "Bis" };
	private Object[][] data;

	private PlayerModel model;
	private JTable table;

	public TableView(PlayerModel model) {
		this.model = model;
	}
	
	public void registerRowClickListener(RowClickListener listener) {
		this.listeners.add(listener);
	}
	
	private void notifyRowListeners(int rowIndex) {
		for (RowClickListener listener : listeners) {
			listener.onRowClicked(rowIndex);
		}
	}

	public void createAndShow() {
		readData();
		initializeComponents();
		JPanel contents = layoutComponents();
		addEvents();

		add(contents);
		setVisible(true);
	}

	
	private void initializeComponents() {
		table = new JTable(data, columnNames);

	}

	private JPanel layoutComponents() {
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(table, BorderLayout.NORTH);
		return tablePanel;
	}

	private void addEvents() {
		//table.getSelectionModel().addListSelectionListener(x);
		
		
		table.addMouseListener(new TableMouseClickAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowAtPoint = table.rowAtPoint(e.getPoint());
				onRowClicked(rowAtPoint);
				notifyRowListeners(rowAtPoint);
			}
		});

	}

	private void onRowClicked(int rowAtPoint) {
		
	}

	private void readData() {
		List<Player> players = model.getAllPlayer();

		Object[][] data = new Object[players.size()][columnNames.length];

		for (int i = 0; i < players.size(); i++) {
			Object[] row = new Object[columnNames.length];
			row[0] = players.get(i).getRank();
			row[1] = players.get(i).getName();
			row[2] = players.get(i).getBirthYear();
			row[3] = players.get(i).getCountry();
			row[4] = players.get(i).getAssociation();
			row[5] = players.get(i).getPosition();
			row[6] = players.get(i).getMatch100();
			row[7] = players.get(i).getMatch100Against();
			row[8] = players.get(i).getNumberOfMatchesFIFA();
			row[9] = players.get(i).getNumberOfMatchesRSSSF();
			row[10] = players.get(i).getFirstMatch();
			row[11] = players.get(i).getLastMatch();

			data[i] = row;
		}

		this.data = data;

	}
}
