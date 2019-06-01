package com.dsp.pojo;

public class Log {
	private int lid;
	private int cuid;
	private String ltime;
	private String meters;

	public Log() {
		super();
	}

	public Log(int cuid, String meters) {
		super();
		this.cuid = cuid;
		this.meters = meters;
	}

	public Log(int lid, int cuid, String ltime, String meters) {
		super();
		this.lid = lid;
		this.cuid = cuid;
		this.ltime = ltime;
		this.meters = meters;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public String getMeters() {
		return meters;
	}

	public void setMeters(String meters) {
		this.meters = meters;
	}

}
