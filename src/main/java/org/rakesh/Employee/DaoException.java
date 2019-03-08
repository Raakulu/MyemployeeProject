package org.rakesh.Employee;

public class DaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382660860611085294L;
	private String msg;
	public DaoException(String msg) {
		this.msg = msg;
		
	}
	
	public String toString() {
		return msg;
	}

}
