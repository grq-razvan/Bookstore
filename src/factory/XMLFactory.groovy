package factory

import models.AbstractReport
import models.Book
import models.XmlReport
import services.BookService

class XMLFactory extends AbstractFactory {

	public static XmlReport build(){
		XmlReport report= generateXmlReport()
		return report
	}
	private static XmlReport generateXMLReport(){
		BookService xmlParser = new BookService()
		AbstractReport report = new XmlReport()
		String path = "resources/"+this.getClass().getSimpleName()+this.hashCode()+".xml"
		for(Book book : xmlParser.getBooksOutOfStock()){
			report.addData(book)
		}
		return report
	};
}
