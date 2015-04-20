package models

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

class XmlReport extends AbstractReport {

	private List<Book> rows

	void createReportFile(){

		def builder = new StreamingMarkupBuilder()
		builder.encoding="UTF-8"
		def books = builder.bind {
			mkp.xmlDeclaration()
			books(count:rows.size()){
				for(Book book : rows){
					book(
							id: String.valueOf(book.id),
							title: book.title,
							author: book.author
							)
				}
			}
		}
		XmlUtil.serialize(books)
	}
	public void addData(Book book){
		rows.add(book)
	}
}


