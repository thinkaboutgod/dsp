package com.dsp.pojo;

import org.springframework.stereotype.Component;

@Component
public class MyResult {
	private String myresult;

	public MyResult() {
		super();
	}

	public MyResult(String myresult) {
		super();
		this.myresult = myresult;
	}

	public String getMyresult() {
		return myresult;
	}

	public void setMyresult(String myresult) {
		this.myresult = myresult;
	}
	
}
