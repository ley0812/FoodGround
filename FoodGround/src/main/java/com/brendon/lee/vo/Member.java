package com.brendon.lee.vo;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Member {
	private int id;
	private int sectionId;
	
	@Length(min=3, max=10, message="3~10자 사이의 값만 가능합니다.")
	@Pattern(regexp="^([A-Z]*[a-z]+[0-9A-Za-z]*[0-9]+|[A-Z]*[0-9]+[0-9A-Za-z]*[a-z]+)[0-9A-Za-z]*$", message="형식에 맞지 않습니다.")
	private String nickName;
	
	@Length(min=6, max=10, message="6~10자 사이의 값만 가능합니다.")
	@Pattern(regexp="^([A-Z]*[a-z]+[0-9A-Za-z]*[0-9]+|[A-Z]*[0-9]+[0-9A-Za-z]*[a-z]+)[0-9A-Za-z]*$", message="형식에 맞지 않습니다.")
	private String password;
	
	@Pattern(regexp="(^[\\w]+@[a-z]+(\\.[a-z]+)$)?", message="형식에 맞지 않습니다.")
	private String email;
	
	private String ip;
	private Date registerDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", sectionId=" + sectionId + ", nickName=" + nickName + ", password=" + password
				+ ", email=" + email + ", ip=" + ip + ", registerDate=" + registerDate + "]";
	}
}