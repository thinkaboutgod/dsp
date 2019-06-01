package com.dsp.pojo;

import org.springframework.stereotype.Component;

@Component
public class FileType {

	private Integer tid;
	private String tname;
	private Integer tscore;

	public FileType() {
		super();
	}

	public FileType(Integer tid, String tname, Integer tscore) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tscore = tscore;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getTscore() {
		return tscore;
	}

	public void setTscore(Integer tscore) {
		this.tscore = tscore;
	}

	

}
