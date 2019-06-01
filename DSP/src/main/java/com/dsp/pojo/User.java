package com.dsp.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {

	public Integer cuid;
	private String account;
	private String name;
	private String education;
	private String pwd;
	private String job;
	private String phone;
	private Integer score;
	private String state;
	private String type;
	private String regtime;
	private Integer dnum;
	private String sex;
	private List<Files> lFiles;
	private String begintime;
	private String endtime;
	
	public User() {
		super();
	}

	public User(Integer cuid, String account, String name, String education, String pwd, String job, String phone,
			Integer score, String state, String type, String regtime, Integer dnum, String sex, List<Files> lFiles,
			String begintime, String endtime) {
		super();
		this.cuid = cuid;
		this.account = account;
		this.name = name;
		this.education = education;
		this.pwd = pwd;
		this.job = job;
		this.phone = phone;
		this.score = score;
		this.state = state;
		this.type = type;
		this.regtime = regtime;
		this.dnum = dnum;
		this.sex = sex;
		this.lFiles = lFiles;
		this.begintime = begintime;
		this.endtime = endtime;
	}

	public Integer getCuid() {
		return cuid;
	}

	public void setCuid(Integer cuid) {
		this.cuid = cuid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public Integer getDnum() {
		return dnum;
	}

	public void setDnum(Integer dnum) {
		this.dnum = dnum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Files> getlFiles() {
		return lFiles;
	}

	public void setlFiles(List<Files> lFiles) {
		this.lFiles = lFiles;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", begintime=" + begintime + ", cuid=" + cuid + ", dnum=" + dnum
				+ ", education=" + education + ", endtime=" + endtime + ", job=" + job + ", lFiles=" + lFiles
				+ ", name=" + name + ", phone=" + phone + ", pwd=" + pwd + ", regtime=" + regtime + ", score=" + score
				+ ", sex=" + sex + ", state=" + state + ", type=" + type + "]";
	}

	
	
	
}
