package views;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.BookController;

public class BookListView extends Window implements View {

	private static final Object[] TABLE_HEADERS = { "ID", "TITLE", "AUTHOR",
			"GENRE", "COPIES" };
	private JTable table;
	private JButton button;

	public BookListView() {
		button = new JButton("Show");
		DefaultTableModel model = new DefaultTableModel(TABLE_HEADERS, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(200, 100, 480, 240);
		button.setBounds(100, 60, 80, 30);
		panel.add(scroll);
		panel.add(button);
		BookController.list(this);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getButton() {
		return button;
	}

}
