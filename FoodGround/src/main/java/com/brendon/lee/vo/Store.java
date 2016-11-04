package com.brendon.lee.vo;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

public class Store {
	private int id;

	@Length(min=1, message="내용을 입력해주세요.")
	private String name;

	@Length(min=1, message="내용을 입력해주세요.")
	private String category;
	
	private int sectionId;
	
	@Length(min=1, message="주소를 입력해주세요.")
	private String mainAddress;
	
	private String subAddress;
	
	private String zipcode;
	
	private String coordinates;
	
	@Length(min=9, message="전화번호를 입력해주세요.")
	@Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}$", message="형식에 맞지 않습니다.")
	private String mainTelephone;

	@Pattern(regexp="^(\\d{3}-\\d{3,4}-\\d{4})*$", message="형식에 맞지 않습니다.")
	private String subTelephone;
	
	private String firstImage;
	
	private String secondImage;
	
	@URL(message="형식에 맞지 않습니다.")
	private String url;
	
	@Length(min=1, message="내용을 입력해주세요.")
	@Pattern(regexp="^([가-힣\\ \\w])+|([가-힣\\ \\w]+ ?(, ?[가-힣\\ \\w]+ ?))*$", message="형식에 맞지 않습니다.")
	private String tagKeyword;

	@Length(min=1, message="내용을 입력해주세요.")
	@Pattern(regexp="^([가-힣\\ \\w])+|([가-힣\\ \\w]+ ?(, ?[가-힣\\ \\w]+ ?))*$", message="형식에 맞지 않습니다.")
	private String tagMenu;
	
	@Pattern(regexp="^([가-힣\\ \\w])+|([가-힣\\ \\w]+ ?(, ?[가-힣\\ \\w]+ ?))*$", message="형식에 맞지 않습니다.")
	private String tagService;
	
	private char open;
	
	private String nickName;
	
	private Date registerDate;
	
	private Date changeDate;
	
	private char toggle;
	
	private MultipartFile file1;
	private MultipartFile file2;

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public char getToggle() {
		return toggle;
	}

	public void setToggle(char toggle) {
		this.toggle = toggle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getMainTelephone() {
		return mainTelephone;
	}

	public void setMainTelephone(String mainTelephone) {
		this.mainTelephone = mainTelephone;
	}

	public String getSubTelephone() {
		return subTelephone;
	}

	public void setSubTelephone(String subTelephone) {
		this.subTelephone = subTelephone;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getSecondImage() {
		return secondImage;
	}

	public void setSecondImage(String secondImage) {
		this.secondImage = secondImage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTagKeyword() {
		return tagKeyword;
	}

	public void setTagKeyword(String tagKeyword) {
		this.tagKeyword = tagKeyword;
	}

	public String getTagMenu() {
		return tagMenu;
	}

	public void setTagMenu(String tagMenu) {
		this.tagMenu = tagMenu;
	}

	public String getTagService() {
		return tagService;
	}

	public void setTagService(String tagService) {
		this.tagService = tagService;
	}

	public char getOpen() {
		return open;
	}

	public void setOpen(char open) {
		this.open = open;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", category=" + category + ", sectionId=" + sectionId
				+ ", mainAddress=" + mainAddress + ", subAddress=" + subAddress + ", zipcode=" + zipcode
				+ ", coordinates=" + coordinates + ", mainTelephone=" + mainTelephone + ", subTelephone=" + subTelephone
				+ ", firstImage=" + firstImage + ", secondImage=" + secondImage + ", url=" + url + ", tagKeyword="
				+ tagKeyword + ", tagMenu=" + tagMenu + ", tagService=" + tagService + ", open=" + open + ", nickName="
				+ nickName + ", registerDate=" + registerDate + ", changeDate=" + changeDate + ", toggle=" + toggle
				+ "]";
	}
}