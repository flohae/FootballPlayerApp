package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.Controller;
import model.Player;
import model.PlayerModel;

public class TableView extends JPanel {

	public interface RowClickListener {

		public void onRowClicked(int rowIndex);

	}

	private List<RowClickListener> listeners = new LinkedList<>();

	private static final long serialVersionUID = 1L;

	private Object[] columnNames = { "#Platz", "Name", "Geburtsjahr", "Land", "Verband", "Position", "100. Spiel",
			"Gegener", "Spiele (FIFA)", "Spiele (RSSSF)", "Von", "Bis" };
	private Object[][] data;

	private PlayerModel model;

	private Controller controller;
	private EditorView view;

	// table
	private JTable table;
	private JScrollPane jScrollPane;
	TableRowSorter<TableModel> sorter;

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
		final TableModel model = new TeamAdapter();
		table = new JTable(model);
		//table = new JTable(data, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		jScrollPane = new JScrollPane(table);

		// Set an auto resizing for columns
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int column = 0; column < table.getColumnCount(); column++) {
			TableColumn tableColumn = table.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
				Component c = table.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);

				// We've exceeded the maximum width, no need to check other rows

				if (preferredWidth >= maxWidth) {
					preferredWidth = maxWidth;
					break;
				}
			}
			tableColumn.setPreferredWidth(preferredWidth);
		}
		setLayout(new BorderLayout());

	}

	private JPanel layoutComponents() {
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(table, BorderLayout.NORTH);
		return tablePanel;
	}

	private void addEvents() {

		table.addMouseListener(new TableMouseClickAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowAtPoint = table.rowAtPoint(e.getPoint());
				onRowClicked(rowAtPoint);
				notifyRowListeners(rowAtPoint);
			}
		});

	// Selection Listener
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				// boolean isAdjusting = e.getValueIsAdjusting();
				// if (isAdjusting == false) {
				int rowIndex = lsm.getMinSelectionIndex();
				// int rowIndexView = lsm.getMinSelectionIndex();
				// int rowIndexModel;
				// if (rowIndexView != -1) {
				// rowIndexModel = table.convertRowIndexToModel(rowIndexView);
				// } else {
				// rowIndexModel = -1;
				// }
				// System.out.println("Clicked on line " + rowIndexModel);
				// controller.setCurrentPlayer(rowIndexView);
				//controller.setCurrentPlayer(rowIndex);
				// AppView.this.setPlayerEditorPanel(((AppTableAdapter) table.getModel()).getValue(rowIndexModel));
				//view.this.setEditingBoard(((TeamAdapter) table.getModel()).getValue(rowIndex));
				//view.this.setSummaryBoard(((TeamAdapter) table.getModel()).getValue(rowIndex));
				// }
			}
		});

		// Set the selection of the first row after start
		table.setRowSelectionInterval(0, 0);

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

	class TeamAdapter extends AbstractTableModel {

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		public Player getValue(int rowIndexModel) {
			return model.getPlayer(rowIndexModel);
		}

		@Override
		public void setValueAt(Object o, int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				controller.setName(o.toString());
				break;
			}
			fireTableCellUpdated(rowIndex, columnIndex);
		}

		@Override
		public int getRowCount() {
			return model.getAllPlayer().size();
		}

		@Override
		public int getColumnCount() {
			return 11;
		}

		@Override
		public String getColumnName(int column) {
			String columnName = "";

			switch (column) {
			case 0:
				columnName = "Rang";
				break;
			case 1:
				columnName = "Rang";
				break;
			case 2:
				columnName = "Rang";
				break;
			case 3:
				columnName = "Rang";
				break;
			case 4:
				columnName = "Rang";
				break;
			case 5:
				columnName = "Rang";
				break;
			case 6:
				columnName = "Rang";
				break;
			case 7:
				columnName = "Rang";
				break;
			case 8:
				columnName = "Rang";
				break;
			case 9:
				columnName = "Rang";
				break;
			case 10:
				columnName = "Rang";
				break;
			case 11:
				columnName = "Rang";
				break;
			}
			return columnName;
		}

		@Override
		public Object getValueAt(int row, int column) {
			String value = "";

			switch (column) {
			case 0:
				value = model.getAllPlayer().get(row).getRank();
				break;
			case 1:
				value = model.getAllPlayer().get(row).getName();
				break;
			case 2:
				value = model.getAllPlayer().get(row).getBirthYear();
				break;
			case 3:
				value = model.getAllPlayer().get(row).getCountry();
				break;
			case 4:
				value = model.getAllPlayer().get(row).getAssociation();
				break;
			case 5:
				value = model.getAllPlayer().get(row).getPosition();
				break;
			case 6:
				value = model.getAllPlayer().get(row).getMatch100();
				break;
			case 7:
				value = model.getAllPlayer().get(row).getMatch100Against();
				break;
			case 8:
				value = model.getAllPlayer().get(row).getNumberOfMatchesFIFA();
				break;
			case 9:
				value = model.getAllPlayer().get(row).getNumberOfMatchesRSSSF();
				break;
			case 10:
				value = model.getAllPlayer().get(row).getFirstMatch();
				break;
			case 11:
				value = model.getAllPlayer().get(row).getLastMatch();
				break;
			}
			return value;
		}
	}
}
