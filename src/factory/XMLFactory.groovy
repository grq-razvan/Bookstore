package factory

import models.AbstractReport
import models.Book
import models.XmlReport
import services.BookService

class XMLFactory extends AbstractFactory {

	public static XmlReport build(){
		XmlReport report = generateXMLReport()
		return report
	}
	private static XmlReport generateXMLReport(){
		BookService xmlParser = new BookService()
		AbstractReport report = new XmlReport()
		for(Book book in xmlParser.getBooksOutOfStock()){
			report.addData(book)
		}
		return report
	}
}
