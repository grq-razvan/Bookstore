package views;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.BookController;

public class BookFindView extends Window {

	private static final Object[] TABLE_HEADERS = { "ID", "TITLE", "AUTHOR",
			"GENRE", "COPIES" };
	private JTable table;
	private JButton findId, findAuthor, findTitle, findMore, findLess,findGenre;
	private JTextField searchBox;

	public BookFindView() {
		findId = new JButton("ID");
		findAuthor = new JButton("Author");
		findTitle = new JButton("Title");
		findMore = new JButton("More copies than");
		findLess = new JButton("Less copies than");
		findGenre = new JButton("Genre");
		searchBox = new JTextField();
		DefaultTableModel model = new DefaultTableModel(TABLE_HEADERS, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(300, 100, 480, 240);
		panel.add(findId);
		panel.add(findAuthor);
		panel.add(findTitle);
		panel.add(findMore);
		panel.add(findLess);
		panel.add(findGenre);
		panel.add(searchBox);
		BookController.find(this);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getFindId() {
		return findId;
	}

	public void setFindId(JButton findId) {
		this.findId = findId;
	}

	public JButton getFindAuthor() {
		return findAuthor;
	}

	public void setFindAuthor(JButton findAuthor) {
		this.findAuthor = findAuthor;
	}

	public JButton getFindTitle() {
		return findTitle;
	}

	public void setFindTitle(JButton findTitle) {
		this.findTitle = findTitle;
	}

	public JButton getFindMore() {
		return findMore;
	}

	public void setFindMore(JButton findMore) {
		this.findMore = findMore;
	}

	public JButton getFindLess() {
		return findLess;
	}

	public void setFindLess(JButton findLess) {
		this.findLess = findLess;
	}

	public JTextField getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(JTextField searchBox) {
		this.searchBox = searchBox;
	}

	public JButton getFindGenre() {
		return findGenre;
	}

	public void setFindGenre(JButton findGenre) {
		this.findGenre = findGenre;
	}

}
