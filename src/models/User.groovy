package models
import groovy.transform.Canonical

@Canonical
class User {

	private Integer id,role
	private String name,username,password
}
