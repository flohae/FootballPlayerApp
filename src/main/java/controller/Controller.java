package controller;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import model.PlayerModel;
import view.EditorView;
import view.MainFrame;
import view.TableView.RowClickListener;

public class Controller {

	private final PlayerModel model;
	private MainFrame mainFrame;
	
	//Undo und Redo Funktionen aus Beispiel Couter V
	
	//private final Deque<ICommand> undoStack = new ArrayDeque<>();
	//private final Deque<ICommand> redoStack = new ArrayDeque<>();
	
	public Controller(PlayerModel model) {
		this.model = model;
		
	}
	
	public static void setLookAndFeel() {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void initializeView() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				mainFrame = new MainFrame(Controller.this, Controller.this.model);
				mainFrame.createAndShow();
			}
		});
	}

	public void registerListeners() {
		mainFrame.getTableView().registerRowClickListener(new RowClickListener() {
			
			@Override
			public void onRowClicked(int rowIndex) {
				EditorView editorView = mainFrame.getEditorView();
				editorView.showDetails(rowIndex);
			}
			
		});
	}
	
}
