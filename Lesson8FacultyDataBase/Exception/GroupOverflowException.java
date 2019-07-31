package net.ukr.xena_reg.exception;

public class GroupOverflowException extends Exception {
	String exceptionMessage;

	public GroupOverflowException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	public GroupOverflowException() {
		super();
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMassage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
