package controllers

import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import javax.swing.JButton
import javax.swing.JTable
import javax.swing.JTextField
import javax.swing.table.DefaultTableModel

import models.Book
import services.BookService
import services.GenerateBookReportService
import views.BookAddView
import views.BookDeleteView
import views.BookFindView
import views.BookListView
import views.BookRestockView
import views.BookSellView
import views.BookUpdateView


class BookController {

	private static BookService bookService

	public static void add(BookAddView bookView){
		JButton submit = bookView.getSubmit()
		JButton clear = bookView.getClear()
		JTextField id=bookView.bookId
		JTextField title=bookView.bookTitle
		JTextField author=bookView.bookAuthor
		JTextField genre=bookView.bookGenre
		JTextField copies=bookView.bookCopies

		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
						title.setText("")
						author.setText('')
						genre.setText('')
						copies.setText('')
					}
				})

		submit.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookService = new BookService();
						List<String> properties = [id.getText(), title.getText(), author.getText(), genre.getText(), copies.getText()]
						bookService.append(properties)
						id.setText("")
						title.setText("")
						author.setText('')
						genre.setText('')
						copies.setText('')
					}
				})
	}

	public static void list(BookListView bookView){
		JButton button = bookView.getButton();
		boolean processed = false;
		button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(processed==false){
							bookService = new BookService();
							List<Book> booksToList = bookService.getBooks();
							JTable table = bookView.getTable();
							DefaultTableModel model = (DefaultTableModel) table.getModel()
							for(Book book in booksToList){
								Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
								model.addRow(row);
								processed=true;
							}
						}
					}
				})
	}

	public static void update(BookUpdateView bookView){
		JButton update = bookView.getUpdate()
		JButton clear = bookView.getClear()
		JTextField id=bookView.bookId
		JTextField title=bookView.bookTitle
		JTextField author=bookView.bookAuthor
		JTextField genre=bookView.bookGenre
		JTextField copies=bookView.bookCopies

		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
						title.setText("")
						author.setText('')
						genre.setText('')
						copies.setText('')
					}
				})

		update.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookService = new BookService();
						List<String> properties = [id.getText(), title.getText(), author.getText(), genre.getText(), copies.getText()]
						bookService.modify(Integer.valueOf(id.getText()),properties)
						id.setText("")
						title.setText("")
						author.setText('')
						genre.setText('')
						copies.setText('')
					}
				})
	}

	public static void delete(BookDeleteView bookView){
		JButton delete = bookView.getDelete()
		JButton clear = bookView.getClear()
		JTextField id=bookView.bookId


		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
					}
				})

		delete.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookService = new BookService();
						bookService.delete(Integer.valueOf(id.getText()))
						id.setText("")
					}
				})
	}

	public static void restock(BookRestockView bookView){
		JButton restock = bookView.getRestock()
		JButton clear = bookView.getClear()
		JTextField id=bookView.bookId
		JTextField amount = bookView.amount
		JButton restockAll = bookView.getRestockAll()
		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
					}
				})

		restock.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookService = new BookService();
						bookService.restockBook(Integer.valueOf(id.getText()), Integer.valueOf(amount.getText()))
						id.setText("")
						amount.setText("")
					}
				})
		restockAll.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookService = new BookService();
						bookService.restock(Integer.valueOf(amount.getText()))
						amount.setText("")
					}
				})
	}

	public static void sell(BookSellView bookView){
		JButton sell = bookView.sell
		JButton clear = bookView.clear
		JTextField id=bookView.bookId
		JTextField amount = bookView.amount
		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
						amount.setText("")
					}
				})

		sell.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookService = new BookService();
						bookService.sellMultipleCopies(Integer.valueOf(id.getText()), Integer.valueOf(amount.getText()))
						id.setText("")
						amount.setText("")
					}
				})
	}

	public static void find(BookFindView bookView){
		JButton id = bookView.findId
		JButton author = bookView.findAuthor
		JButton title = bookView.findTitle
		JButton genre = bookView.findGenre
		JButton less = bookView.findLess
		JButton clear = bookView.clear
		JButton more = bookView.findMore
		JTextField search = bookView.searchBox


		id.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable();
						DefaultTableModel model = (DefaultTableModel) table.getModel()

						bookService = new BookService();
						List<Book> booksToList = bookService.findById(search.getText());

						for(Book book in booksToList){
							Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
							model.addRow(row);
						}
						table.repaint()
						table.revalidate()
					}
				})

		title.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable();
						DefaultTableModel model = (DefaultTableModel) table.getModel()

						bookService = new BookService();
						List<Book> booksToList = bookService.findAllByTitle(search.getText());

						for(Book book in booksToList){
							Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
							model.addRow(row);
						}
						table.repaint()
						table.revalidate()
					}
				})


		genre.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable();
						DefaultTableModel model = (DefaultTableModel) table.getModel()

						bookService = new BookService();
						List<Book> booksToList = bookService.findAllByGenre(search.getText());

						for(Book book in booksToList){
							Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
							model.addRow(row);
						}
						table.repaint()
						table.revalidate()
					}
				})

		less.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable();
						DefaultTableModel model = (DefaultTableModel) table.getModel()

						bookService = new BookService();
						List<Book> booksToList = bookService.findAllWithLessCopiesThan(search.getText());

						for(Book book in booksToList){
							Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
							model.addRow(row);
						}
						table.repaint()
						table.revalidate()
					}
				})

		more.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable();
						DefaultTableModel model = (DefaultTableModel) table.getModel()

						bookService = new BookService();
						List<Book> booksToList = bookService.findAllWithMoreCopiesThan(search.getText());

						for(Book book in booksToList){
							Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
							model.addRow(row);
						}
						table.repaint()
						table.revalidate()
					}
				})


		author.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable();
						DefaultTableModel model = (DefaultTableModel) table.getModel()

						bookService = new BookService();
						List<Book> booksToList = bookService.findAllByAuthor(search.getText());
						for(Book book in booksToList){
							Object[] row = [book.id.toString(), book.title, book.author, book.genre, book.availableCopies.toString()]
							model.addRow(row);
						}
						table.repaint()
						table.revalidate()
					}
				})

		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JTable table = bookView.getTable()
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.getDataVector().clear()
						table.revalidate()
						table.repaint()
					}
				});
	}
}
