package models

import groovy.transform.Canonical

@Canonical
class Book {

	private String author,title,genre
	private Integer id,availableCopies
		
	@Override
	String toString(){
		//"BID:${id}\nTitle:${title}\nAuthor:${author}\nGenre:${genre}\nCopies:${availableCopies}\n"
		"${id}\t${title}\t${author}"
	}
}
