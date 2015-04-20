package factory

import models.AbstractReport
import models.Book
import models.TextReport
import services.BookService

class TextFactory extends AbstractFactory {

	public static TextReport build(){
		TextReport result = generateTextReport()
		return result
	}

	private static TextReport generateTextReport(){
		BookService xmlParser = new BookService()
		AbstractReport report = new TextReport()
		for(Book book in xmlParser.getBooksOutOfStock()) {
			report.addData(book.toString())
		}
		return report
	};
}
