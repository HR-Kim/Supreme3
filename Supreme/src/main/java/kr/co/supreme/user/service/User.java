package kr.co.supreme.user.service;

import kr.co.supreme.cmn.DTO;

public class User extends DTO {
	private String id      ;   /*아이디*/
	private String pass    ;   /*비밀번호*/
	private String name    ;   /*이름*/
	private String lvl     ;   /*회원등급*/
	private String nickname;   /*닉네임*/
	private String email   ;   /*이메일*/
	private String postcode;   /*우편번호*/
	private String address1;   /*주소1*/
	private String address2;   /*주소2*/
	private String tel     ;   /*전화번호*/
	private String image   ;   /*이미지*/
	private String regDt   ;   /*등록일*/
	
	public User() {}
	
	public User(String id, String pass, String name, String lvl, String nickname, String email, String postcode,
			String address1, String address2, String tel, String image, String regDt) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.lvl = lvl;
		this.nickname = nickname;
		this.email = email;
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
		this.tel = tel;
		this.image = image;
		this.regDt = regDt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", lvl=" + lvl + ", nickname=" + nickname
				+ ", email=" + email + ", postcode=" + postcode + ", address1=" + address1 + ", address2=" + address2
				+ ", tel=" + tel + ", image=" + image + ", regDt=" + regDt + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
