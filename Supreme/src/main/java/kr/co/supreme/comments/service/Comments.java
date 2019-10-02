package kr.co.supreme.comments.service;

import kr.co.supreme.cmn.DTO;

public class Comments extends DTO{
	
	private int cSeq        ;
	private int bodSeq      ;
	private String id        ;
	private String content   ;
	private String regDt    ;
	private String udtUser  ;
	private String udtDt    ;
	
	public Comments() {}
	
	public int getcSeq() {
		return cSeq;
	}
	public void setcSeq(int cSeq) {
		this.cSeq = cSeq;
	}
	public int getBodSeq() {
		return bodSeq;
	}
	public void setBodSeq(int bodSeq) {
		this.bodSeq = bodSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getUdtUser() {
		return udtUser;
	}
	public void setUdtUser(String udtUser) {
		this.udtUser = udtUser;
	}
	public String getUdtDt() {
		return udtDt;
	}
	public void setUdtDt(String udtDt) {
		this.udtDt = udtDt;
	}
	public Comments(int cSeq, int bodSeq, String id, String content, String regDt, String udtUser, String udtDt) {
		super();
		this.cSeq = cSeq;
		this.bodSeq = bodSeq;
		this.id = id;
		this.content = content;
		this.regDt = regDt;
		this.udtUser = udtUser;
		this.udtDt = udtDt;
	}
	@Override
	public String toString() {
		return "Comment [cSeq=" + cSeq + ", bodSeq=" + bodSeq + ", id=" + id + ", content=" + content + ", regDt="
				+ regDt + ", udtUser=" + udtUser + ", udtDt=" + udtDt + ", toString()=" + super.toString() + "]";
	}
	
	
}
