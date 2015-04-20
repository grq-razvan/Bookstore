package services


class UserLoginService {

	UserService userService
	
	def getLoginRole(String user,String pass){
		userService = new UserService()
		def usr = userService.match(user,pass)
		usr.@role
	}
	
}
