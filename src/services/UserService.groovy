package services

import models.User

class UserService {

	private static final PATH_TO_USERS = "resources/users.xml"
	def users
	def usersXmlFile
	
	UserService(){
			usersXmlFile = new FileInputStream(PATH_TO_USERS)
		}
	
		def parse(){
			users = new XmlSlurper().parse(usersXmlFile)
			def userList = new ArrayList<User>()
			users.user.each { node ->
				def user = new User()
				user.id = node.@id.toInteger()
				user.role = node.@role.toInteger()
				user.username=node.@username
				user.password=node.@password
				userList.add(user)
			}
			userList.each { println it }
			return userList;
		}
}
