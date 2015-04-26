package services

import models.User

class UserValidator {

	static List<?> users = new UserService().list

	public static boolean isUserValid(String username, char[] password){
		if(!isUserNameValid(username)||!isPasswordValid(password)){
			return false;
		}
		else{
			StringBuilder pass = new StringBuilder();
			for(char c : password){
				pass.append(c);
			}
			for(User user in users){
				if(user.username.equals(username) && user.password.equals(pass.toString())){
					return true
				}
			}
			return false
		}
	}

	public static boolean isUserAdmin(String username, char[] password){
		StringBuilder pass = new StringBuilder()
		for(char c in password){
			pass.append(c);
		}
		for(User user in users){
			if(user.username.equals(username) && user.password.equals(pass.toString())){
				if(user.role.intValue()==1){
					return true
				}else{
					return false
				}
			}else{
				return false
			}
		}
	}

	private static boolean isUserNameValid(String username){
		boolean isSizeGood = username.length() > 4 ? true : false;
		boolean containsIllegalChars = username.matches('[ \\t\\n\\:\\{\\}\\[\\]\\(\\)\\^\\%\\&\\#\\~]')
		return !containsIllegalChars && isSizeGood
	}

	private static boolean isPasswordValid(char[] password){
		boolean isSizeGood = password.length > 4 ? true : false;
		StringBuilder builder = new StringBuilder()
		for(char c in password){
			builder.append(c);
		}
		boolean containsIllegalChars = builder.toString().matches('[ \\t\\n\\:\\{\\}\\[\\]\\(\\)\\^\\%\\&\\#\\~]')
		return !containsIllegalChars && isSizeGood
	}
}
