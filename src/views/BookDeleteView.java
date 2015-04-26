package views;

import javax.swing.JButton;
import javax.swing.JTextField;

import controllers.BookController;

public class BookDeleteView extends Window {

	private JButton delete, clear;
	private JTextField bookId;

	public BookDeleteView() {
		delete = new JButton("Delete");
		clear = new JButton("Clear");
		bookId = new JTextField();

		panel.add(delete);
		panel.add(clear);
		panel.add(bookId);

		BookController.delete(this);
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
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

}
