package models

import groovy.transform.Canonical

@Canonical
class Book {

	private String author,title,genre
	private Integer id,availableCopies
}
