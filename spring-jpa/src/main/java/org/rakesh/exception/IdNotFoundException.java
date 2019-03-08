package org.rakesh.exception;


public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public IdNotFoundException(int id) {
		this.id = id;
	}

}
