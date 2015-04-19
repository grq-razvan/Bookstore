package services

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil
import models.Book

class BookService {

	private static final PATH_TO_BOOKS = 'resources/books.xml'
	private def books
	private def bookList
	private def bookXMLFile
	private def booksWithNoCopies

	BookService(){
		bookXMLFile = new FileInputStream(PATH_TO_BOOKS)
		booksWithNoCopies = new HashSet<Book>()
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
		bookList.each { println it }
		return bookList;
	}

	def append(List<String> properties){
		books = new XmlSlurper().parse(bookXMLFile)
		books.appendNode{
			book(
					author: properties.get(3),
					availableCopies:properties.get(1),
					genre: properties.get(4),
					id: properties.get(0),
					title:properties.get(2))
		}
		def writer = new FileWriter(PATH_TO_BOOKS)
		XmlUtil.serialize(books, writer)
	}

	def delete(Integer bookId){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find { it.@id.toInteger() == bookId.intValue() }
		bookChildren.remove(bookNode)
		def writer = new FileWriter(PATH_TO_BOOKS)
		XmlUtil.serialize(books, writer)
	}

	def modify(Integer originalBookId,List<String> alteredProperties){
		delete(originalBookId)
		append(alteredProperties)
	}

	def sellOneCopy(Integer bookId){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find { it.@id.toInteger() == bookId.intValue() }
		def currentAvailableCopies = bookNode.@availableCopies.toInteger()
		currentAvailableCopies--
		bookNode.@availableCopies = String.valueOf(currentAvailableCopies)
		if(currentAvailableCopies<0){
			bookNode.@availableCopies = "0"
		}
		if(bookNode.@availableCopies.toInteger()==0){
			Book newEntry = new Book()
			newEntry.id = bookNode.@id.toInteger()
			newEntry.availableCopies=0
			newEntry.author = bookNode.@author
			newEntry.title = bookNode.@title
			newEntry.genre = bookNode.@genre
			booksWithNoCopies.add(newEntry)
		}
		def writer = new FileWriter(PATH_TO_BOOKS)
		XmlUtil.serialize(books, writer)
	}

	def sellMultipleCopies(Integer bookId, Integer amount){
		books = new XmlParser().parse(bookXMLFile)
		def bookChildren = books.children()
		def bookNode = bookChildren.find { it.@id.toInteger() == bookId.intValue() }
		def currentAvailableCopies = bookNode.@availableCopies.toInteger()
		currentAvailableCopies-=amount

		bookNode.@availableCopies = String.valueOf(currentAvailableCopies)
		if(currentAvailableCopies<0){
			bookNode.@availableCopies = "0"
		}
		if(bookNode.@availableCopies.toInteger()==0){
			booksWithNoCopies.add(new Book(id:bookNode.@id.toInteger(),
			availableCopies:currentAvailableCopies,
			author:bookNode.@author,
			title:bookNode.@title,
			genre:bookNode.@genre)
			)
		}
		def writer = new FileWriter(PATH_TO_BOOKS)
		XmlUtil.serialize(books, writer)
	}

	def restockBook(Integer bookId, Integer amount){
		books = new XmlParser().parse(bookXMLFile)
		def bookNode = books.book.find{it.@id.toInteger() == bookId.intValue()}
		bookNode.@availableCopies = String.valueOf(amount)
		def writer = new FileWriter(PATH_TO_BOOKS)
		XmlUtil.serialize(books, writer)
	}

	def restock(Integer amount){
		books = new XmlParser().parse(bookXMLFile)
		def bookList = parse()
		for(Book b: bookList){
			b.availableCopies+=amount
			delete(b.id)
			append([String.valueOf(b.id), String.valueOf(b.availableCopies), b.genre, b.author, b.title])
		}
		def writer = new FileWriter(PATH_TO_BOOKS)
		XmlUtil.serialize(books, writer)
	}

	private boolean isValidNumberOfCopies(Integer bookId){
		bookXMLFile = new FileInputStream(PATH_TO_BOOKS)
		books = new XmlParser().parse(bookXMLFile)

		def nodeToChange = books.book.find{
			it.@id.toInteger()==bookId.intValue()
		}
		return nodeToChange.@availableCopies.toInteger()>0
	}
}
