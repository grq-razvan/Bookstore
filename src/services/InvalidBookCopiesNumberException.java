package services;

public class InvalidBookCopiesNumberException extends Exception {

	private static final String EXCEPTION_MESSGE = "You have 0 or less books. "
			+ "You cannot sell until more are bought. "
			+ "Contact provider/administrator for more information.";
	/**
	 * 
	 */
	private static final long serialVersionUID = 3266132891414615333L;

	public InvalidBookCopiesNumberException() {
		// TODO Auto-generated constructor stub
		super(EXCEPTION_MESSGE);
		printStackTrace();
	}

}
