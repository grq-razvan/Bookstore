package services


class BookService {

	private static final PATH_TO_BOOKS = "resources/books.xml"
	private XmlSlurper slurper
	
	def parse(){
		def xmlData = slurper.parse (new FileInputStream(PATH_TO_BOOKS))
		

		}
	
	
	
	
}
