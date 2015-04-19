package services

import java.util.List;

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

	def append(List<String> properties){
		users = new XmlSlurper().parse(usersXmlFile)
		users.appendNode{
			user( id : properties.get(0),
			password : properties.get(1),
			role : properties.get(2),
			username : properties.get(3)
			)
		}
		def writer = new FileWriter(PATH_TO_USERS)
		XmlUtil.serialize(users, writer)
	}

	def append(User user){
		append([user.id.toString(), user.password, user.role.toString(), user.username])
	}

	def delete(Integer userId){
		users = new XmlParser().parse(usersXmlFile)
		def usersChildren = users.children()
		def usersNode = usersChildren.find { it.@id.toInteger() == userId.intValue() }
		usersChildren.remove(usersNode)
		def writer = new FileWriter(PATH_TO_USERS)
		XmlUtil.serialize(users, writer)
	}

	def delete(User user){
		delete(user.id)
	}

	def modify(Integer originalUserId,List<String> alteredProperties){
		delete(originalUserId)
		append(alteredProperties)
	}

	def modify(User originalUser, User modifiedUser){
		delete(originalUser)
		append(modifiedUser)
	}

	User match(String user,String pass){
		users = new XmlParser().parse(usersXmlFile)
		def userNode = users.user.find{it.@username==user && it.@password==pass}
		if(userNode==null)
			return null
		else{
			new User(
					id: userNode.@id.toInteger(),
					role: userNode.@role.toInteger(),
					username: userNode.@username,
					password: userNode.@password)
		}
	}


	def isAdmin(User user){
		def matcher = match(user.username,user.password)
		matcher.role==1?true:false
	}
}
