package services

import groovy.xml.XmlUtil
import models.Book

class BookService {

	private static final PATH_TO_BOOKS = 'resources/books.xml'
	private def books
	private def bookList
	private def bookXMLFile
	private def writer

	private static final Integer EMPTY_STOCK = 0

	private static final Integer BOOK_ID=0
	private static final Integer BOOK_COPIES=4
	private static final Integer BOOK_TITLE=1
	private static final Integer BOOK_AUTHOR=2
	private static final Integer BOOK_GENRE=3

	BookService(){
		bookXMLFile = new FileInputStream(PATH_TO_BOOKS)
	}

	def parse(){
		bookList = new ArrayList<Book>()
		books = new XmlSlurper().parse(bookXMLFile)
		books.book.each { node ->
			def book = new Book()
			book.id = node.@id.toInteger()
			book.availableCopies = node.@availableCopies.toInteger()
			book.title=node.@title
			book.author=node.@author
			book.genre=node.@genre
			bookList.add(book)
		}

		return bookList;
	}

	def append(List<String> properties){
		books = new XmlSlurper().parse(bookXMLFile)
		books.appendNode{
			book(
					author: properties.get(BOOK_AUTHOR),
					availableCopies:properties.get(BOOK_COPIES),
					genre: properties.get(BOOK_GENRE),
					id: properties.get(BOOK_ID),
					title:properties.get(BOOK_TITLE))
		}
		String result = XmlUtil.serialize(books)
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def append(Book book){
		append([book.id.toString(), book.availableCopies.toString(), book.title, book.author, book.genre])
	}

	def delete(Integer bookId){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find {
			it.@id.toInteger() == bookId.intValue()
		}
		bookChildren.remove(bookNode)
		String result = XmlUtil.serialize(books)
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def delete(Book book){
		delete(book.id)
	}

	def modify(Integer originalBookId,List<String> properties){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find {
			it.@id.toInteger() == originalBookId.intValue()
		}
		bookChildren.remove(bookNode)
		def newBook = new Node(books,'book',
				[
					id			   :properties.get(BOOK_ID),
					author		   :properties.get(BOOK_AUTHOR),
					title		   :properties.get(BOOK_TITLE),
					genre		   :properties.get(BOOK_GENRE),
					availableCopies:properties.get(BOOK_COPIES)
				]
				)
		String result = XmlUtil.serialize(books)
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def modify(Book originalBook, Book modifiedBook){
		delete(originalBook)
		append(modifiedBook)
	}

	def sellOneCopy(Integer bookId){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find {
			it.@id.toInteger() == bookId.intValue()
		}
		def currentAvailableCopies = bookNode.@availableCopies.toInteger()
		currentAvailableCopies--
		if(currentAvailableCopies<=EMPTY_STOCK){
			bookNode.@availableCopies = String.valueOf(EMPTY_STOCK)
		}
		bookNode.@availableCopies = String.valueOf(currentAvailableCopies)
		String result = XmlUtil.serialize(books)
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def sellOneCopy(Book book){
		sellOneCopy(book.id)
	}

	def sellMultipleCopies(Integer bookId, Integer amount){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find {
			it.@id.toInteger() == bookId.intValue()
		}
		def currentAvailableCopies = bookNode.@availableCopies.toInteger()
		currentAvailableCopies-=amount
		if(currentAvailableCopies<=EMPTY_STOCK){
			bookNode.@availableCopies = String.valueOf(EMPTY_STOCK)
		}
		bookNode.@availableCopies = String.valueOf(currentAvailableCopies)
		String result = XmlUtil.serialize(books)
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def sellMultipleCopies(Book book, Integer amount){
		sellMultipleCopies(book.id,amount)
	}

	def restockBook(Integer bookId, Integer amount){
		books = new XmlParser().parse(bookXMLFile)
		def bookNode = books.book.find{
			it.@id.toInteger() == bookId.intValue()
		}
		bookNode.@availableCopies = String.valueOf(amount)
		String result = XmlUtil.serialize(books)
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def restockBook(Book book, Integer amount){
		restockBook(book.id,amount)
	}

	def restock(Integer amount){
		books = new XmlSlurper().parse(bookXMLFile)
		books.book.each { node ->
			Integer copies = node.@availableCopies.toInteger() + amount;
			node.@availableCopies = String.valueOf(copies)
		}
		String result = XmlUtil.serialize(books)
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(PATH_TO_BOOKS), "utf-8"));
			writer.write(result);
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				//ignore}
			}
		}
	}

	def restockBooksWithNoCopies(Integer amount){
		def bookList = parse()
		for(Book b in bookList){
			if(b.availableCopies==EMPTY_STOCK){
				modify(b.id,[String.valueOf(b.id), String.valueOf(b.availableCopies), b.genre, b.author, b.title])
			}
		}
	}

	def getBooksOutOfStock(){
		def bookList = parse()
		List<Book> outOfStockBooks = new ArrayList<Book>()
		for(Book b in bookList){
			if(b.availableCopies==EMPTY_STOCK){
				outOfStockBooks.add(b)
			}
		}
		return outOfStockBooks
	}

	def getBooks(){
		parse()
	}

	private boolean isValidNumberOfCopies(Integer bookId){
		bookXMLFile = new FileInputStream(PATH_TO_BOOKS)
		books = new XmlParser().parse(bookXMLFile)

		def nodeToChange = books.book.find{
			it.@id.toInteger()==bookId.intValue()
		}
		return nodeToChange.@availableCopies.toInteger()>0
	}

	def findById(String inputId){
		def list = parse()
		for(Book book : list){
			if(book.id.intValue()==Integer.valueOf(inputId)){
				return [book]
			}
		}
	}

	def findAllByGenre(String genre){
		def list = parse()
		def returnList = new ArrayList<Book>()
		for(Book book : list){
			if(book.genre==genre){
				returnList.add(book)
			}
		}
		return returnList
	}

	def findAllByTitle(String title){
		def list = parse()
		def returnList = new ArrayList<>()
		for(Book book in list){
			if(book.title==title){
				returnList.add(book)
			}
		}
		return returnList
	}

	def findAllByAuthor(String author){
		def list = parse()
		def returnList = new ArrayList<>()
		for(Book book in list){
			if(book.author==author){
				returnList.add(book)
			}
		}
		return returnList
	}

	def findAllWithMoreCopiesThan(String numberOfCopies){
		def list = parse()
		def returnList = new ArrayList<>()
		for(Book book in list){
			if(book.availableCopies.intValue()>=Integer.valueOf(numberOfCopies){
				returnList.add(book)
			}
		}
		return returnList
	}
	def findAllWithLessCopiesThan(String numberOfCopies){
		def list = parse()
		def returnList = new ArrayList<>()
		for(Book book in list){
			if(book.availableCopies.intValue()<Integer.valueOf(numberOfCopies){
				returnList.add(book)
			}
		}
		return returnList
	}
}
