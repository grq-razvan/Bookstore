package controllers

import services.BookService

class BookController {

	private BookService bookService
	private GenerateBookReportService

	def show(){
		bookService = new BookService()
		bookService.parse()
	}
}
