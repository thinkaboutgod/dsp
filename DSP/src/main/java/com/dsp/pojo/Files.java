package com.dsp.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Files {

	private Integer fid;
	private Integer cuid;
	private String fname;
	private String uptime;
	private Integer dscore;
	private Integer dtimes;
	private FileType fileType;
	private Fstate fstate;
	private User user;
	private String path;
	
	public Files() {
		super();
	}

	public Files(Integer fid, User user, String fname, String uptime, Integer dscore, Integer dtimes, FileType fileType,
			Fstate fstate, String path) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.uptime = uptime;
		this.dscore = dscore;
		this.dtimes = dtimes;
		this.fileType = fileType;
		this.fstate = fstate;
		this.user = user;
		this.path = path;
	}
	
	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getDscore() {
		return dscore;
	}

	public void setDscore(int dscore) {
		this.dscore = dscore;
	}

	public int getDtimes() {
		return dtimes;
	}

	public void setDtimes(int dtimes) {
		this.dtimes = dtimes;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public Fstate getFstate() {
		return fstate;
	}

	public void setFstate(Fstate fstate) {
		this.fstate = fstate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
