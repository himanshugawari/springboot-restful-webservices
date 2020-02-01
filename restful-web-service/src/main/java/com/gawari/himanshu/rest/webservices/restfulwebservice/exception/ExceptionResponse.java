package com.gawari.himanshu.rest.webservices.restfulwebservice.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timeStamp;
	private String message;
	private String dtails;

	public ExceptionResponse(Date timeStamp, String message, String dtails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.dtails = dtails;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDtails() {
		return dtails;
	}

	public void setDtails(String dtails) {
		this.dtails = dtails;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", message=" + message + ", dtails=" + dtails + "]";
	}

}
