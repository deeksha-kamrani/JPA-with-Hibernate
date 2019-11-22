package com.ustglobal.Assignment2.dto;

import javax.persistence.*;

@Entity
@Table(name="employee")

public class EmployeeInfo {
	
	@Id
	@Column
	private int eid;
	@Column
	private String ename;
	@Column
	private int mobile;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
}
