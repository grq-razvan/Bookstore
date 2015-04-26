package views;

import javax.swing.JButton;
import javax.swing.JTextField;

import controllers.BookController;

public class BookRestockView extends Window {
	private JButton restock, restockAll, clear;
	private JTextField bookId,amount;

	public BookRestockView() {
		restock = new JButton("Restock");
		restockAll = new JButton("Restock all");
		clear = new JButton("Clear");
		bookId = new JTextField();
		amount = new JTextField();

		panel.add(restock);
		panel.add(restockAll);
		panel.add(amount);
		panel.add(clear);
		panel.add(bookId);

		BookController.restock(this);
	}

	public JButton getRestock() {
		return restock;
	}

	public void setRestock(JButton restock) {
		this.restock = restock;
	}

	public JButton getRestockAll() {
		return restockAll;
	}

	public void setRestockAll(JButton restockAll) {
		this.restockAll = restockAll;
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

	public JTextField getAmount() {
		return amount;
	}

	public void setAmount(JTextField amount) {
		this.amount = amount;
	}
}
