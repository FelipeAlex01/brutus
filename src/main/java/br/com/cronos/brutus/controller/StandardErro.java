package br.com.cronos.brutus.controller;

import java.io.Serializable;

public class StandardErro implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String message;
	private Long timeStamp;

	public StandardErro() {
		super();
	}

	public StandardErro(Integer status, String message, Long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
