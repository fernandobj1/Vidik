package service;

public class UserNotFoundExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundExcption(String message) {
		super(message);
	}
}
