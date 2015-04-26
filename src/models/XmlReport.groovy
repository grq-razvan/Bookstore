package models

import groovy.xml.MarkupBuilder


class XmlReport extends AbstractReport {

	private List<Book> rows

	XmlReport(){
		rows = new ArrayList<>()
	}

	void createReportFile(){

		def sw = new StringWriter()
		def builder = new MarkupBuilder(sw)
		builder.books(type: "soldOut"){
			(0..rows.size()-1).each{ n->
				book(
						id: String.valueOf(rows.get(n).id),
						title: rows.get(n).title,
						author: rows.get(n).author)
			}
		}

		PrintWriter pw = new PrintWriter(new File('resources/'+this.getClass().getSimpleName()+"-"+this.hashCode()+".xml"))
		pw.write(sw.toString())
		pw.close()
	}
	public void addData(Book book){
		rows.add(book)
	}
}


