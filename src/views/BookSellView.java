package views;

import javax.swing.JButton;
import javax.swing.JTextField;

import controllers.BookController;

public class BookSellView extends Window {
	private JButton sell, clear;
	private JTextField bookId, amount;

	public BookSellView() {
		sell = new JButton("Sell");
		clear = new JButton("Clear");
		bookId = new JTextField();
		amount = new JTextField();

		panel.add(sell);
		panel.add(amount);
		panel.add(clear);
		panel.add(bookId);

		BookController.sell(this);
	}

	public JButton getSell() {
		return sell;
	}

	public void setSell(JButton sell) {
		this.sell = sell;
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
