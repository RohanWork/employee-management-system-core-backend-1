package com.rohan.employee.exception;

public class EmployeeExceptionEntity {

	private int code;
	private String message;
	private String timeStamp;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public EmployeeExceptionEntity() {
		super();
	}
	
	public EmployeeExceptionEntity(int code, String message, String timeStamp) {
		super();
		this.code = code;
		this.message = message;
		this.timeStamp = timeStamp;
	}
}
