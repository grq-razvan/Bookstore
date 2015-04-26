package views;

import javax.swing.JButton;
import javax.swing.JTextField;

import controllers.BookController;

public class BookUpdateView extends Window {
	private JButton update, clear;
	private JTextField bookId, bookTitle, bookAuthor, bookGenre, bookCopies;

	public BookUpdateView() {
		update = new JButton("Submit");
		clear = new JButton("Clear");
		bookId = new JTextField();
		bookTitle = new JTextField();
		bookAuthor = new JTextField();
		bookGenre = new JTextField();
		bookCopies = new JTextField();

		panel.add(update);
		panel.add(clear);
		panel.add(bookId);
		panel.add(bookTitle);
		panel.add(bookAuthor);
		panel.add(bookCopies);
		panel.add(bookGenre);

		BookController.update(this);
	}

	public JButton getUpdate() {
		return update;
	}

	public void setUpdate(JButton update) {
		this.update = update;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JTextField getBookId() {
		return bookId;
	}

	public void setBookId(JTextField bookId) {
		this.bookId = bookId;
	}

	public JTextField getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(JTextField bookTitle) {
		this.bookTitle = bookTitle;
	}

	public JTextField getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(JTextField bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public JTextField getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(JTextField bookGenre) {
		this.bookGenre = bookGenre;
	}

	public JTextField getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(JTextField bookCopies) {
		this.bookCopies = bookCopies;
	}

}
