package factory

import models.AbstractReport
import models.Book
import services.BookService

class TextFactory extends AbstractFactory {

		AbstractReport build(){
			return null; 
		};
		
		private String generateTextReport(){
			BookService xmlParser = new BookService()
			ArrayList<Book> books = xmlParser.getBooksOutOfStock()
			StringBuilder result = new StringBuilder("ID\t\tTITLE\t\t\t\tAUTHOR\t\t\t\n")
			for(Book book in books){
					String bookData = book.id.intValue() + "\t\t" + book.title +"\t"+ book.author
					result.append(bookData+"\n")
			}
			return result.toString()
		};
}
