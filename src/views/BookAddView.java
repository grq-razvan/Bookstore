package views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.BookController;

public class BookAddView extends Window {

	private JButton submit, clear;
	private JTextField bookId, bookTitle, bookAuthor, bookGenre, bookCopies;

	public BookAddView() {
		submit = new JButton("Submit");
		clear = new JButton("Clear");
		bookId = new JTextField();
		bookTitle = new JTextField();
		bookAuthor = new JTextField();
		bookGenre = new JTextField();
		bookCopies = new JTextField();

		JLabel idLabel = new JLabel("ID: ");
		JLabel titleLabel = new JLabel("Title: ");
		JLabel authorLabel = new JLabel("Author: ");
		JLabel genreLabel = new JLabel("Genre: ");
		JLabel copiesLabel = new JLabel("Copies: ");
		JLabel operation = new JLabel("<html><font size=5 color='white'>Add book</font></html>");
		
		idLabel.setBounds(390, 160, 50, 30);
		idLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(390, 200, 50, 30);
		titleLabel.setForeground(Color.WHITE);
		authorLabel.setBounds(390, 240, 50, 30);
		authorLabel.setForeground(Color.WHITE);
		genreLabel.setBounds(390, 280, 50, 30);
		genreLabel.setForeground(Color.WHITE);
		copiesLabel.setBounds(390, 320, 50, 30);
		copiesLabel.setForeground(Color.WHITE);
		bookId.setBounds(460, 160, 160, 30);
		bookTitle.setBounds(460, 200, 160, 30);
		bookAuthor.setBounds(460, 240, 160, 30);
		bookGenre.setBounds(460, 280, 160, 30);
		bookCopies.setBounds(460, 320, 160, 30);
		operation.setBounds(460,90,140,50);
		
		submit.setBounds(430, 380, 80, 30);
		clear.setBounds(530, 380, 80, 30);

		panel.add(submit);
		panel.add(clear);
		panel.add(bookId);
		panel.add(bookTitle);
		panel.add(bookAuthor);
		panel.add(bookCopies);
		panel.add(bookGenre);
		panel.add(idLabel);
		panel.add(titleLabel);
		panel.add(authorLabel);
		panel.add(genreLabel);
		panel.add(copiesLabel);
		panel.add(operation);

		BookController.add(this);
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
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
