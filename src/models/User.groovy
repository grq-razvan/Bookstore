package models
import groovy.transform.Canonical

@Canonical
class User {

	private Integer id,role
	private String username,password
	
	@Override
	String toString(){
		"UID:${id}\nRole:${role}\nUsername:${username}\nPassword:${password}\n"
	}
}
