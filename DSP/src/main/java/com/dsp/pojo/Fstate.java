package com.dsp.pojo;

import org.springframework.stereotype.Component;

@Component
public class Fstate {

	private int sid;
	private String sname;

	public Fstate() {
		super();
	}

	public Fstate(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
