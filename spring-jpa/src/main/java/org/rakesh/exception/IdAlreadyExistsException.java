package org.rakesh.exception;

public class IdAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public IdAlreadyExistsException(int id) {
		this.id = id;
	}

}
