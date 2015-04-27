package factory

import models.AbstractReport
import models.Book
import models.XmlReport
import services.BookService

class XMLFactory extends AbstractFactory {

    public static AbstractReport build() {
        return generateXMLReport() as XmlReport
    }

    private static XmlReport generateXMLReport() {
        BookService xmlParser = new BookService()
        AbstractReport report = new XmlReport()
        for (Book book in xmlParser.getBooksOutOfStock()) {
            report.addData(book)
        }

        return report
    }
}
