package com.viewVetApiSpring.apiRest.modelo;

public class Response {

	String status;
	String code;
	
	public Response() {
		super();
	}

	public Response(String status, String code) {
		super();
		this.status = status;
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
