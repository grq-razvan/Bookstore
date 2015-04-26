package views;

import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

import models.Book

class BookListView {
	private static String BOOK_ID = "ID";
	private static String BOOK_AUTHOR = "Author";
	private static String BOOK_TITLE = "Title";
	private static String BOOK_GENRE = "Genre";
	private static String BOOK_COPIES = "Available Copies";

	private static Object[] TABLE_HEADERS = [BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, BOOK_GENRE, BOOK_COPIES];

	private List<Book> books
	private JTable table
	private JPanel panel

	public BookListView(List<Book> books){
		this.books=books
		table = new JTable(new DefaultTableModel(TABLE_HEADERS, TABLE_HEADERS.length))
		addData(this.books,table)
		panel = new JPanel()
		panel.add(table)
	
	}

	private void addData(List<Book> books, JTable table){
		def model = (DefaultTableModel) table.getModel();
		for(Book book in books){
			Object[] rowData = [
				book.id.toString(),
				book.title,
				book.author,
				book.genre,
				book.availableCopies.toString()
			]
			model.addRow(rowData)
		}
	}
}
