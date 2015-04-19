package controllers

import services.UserService

class UserController {

	UserService userService
	
	void show(){
		userService = new UserService()
		userService.parse()
	}
}
