package kr.co.supreme.board.service;

import kr.co.supreme.cmn.DTO;
/**
 * Board DTO
 * @author sist
 *
 */
public class Board extends DTO {
	private int bSeq           ; //고유번호
	private String bTitle      ; //제목
	private String bContents   ; //내용
	private String Id           ; //작성자
	private int readCnt        ; //조회수
	private String regDt       ; //등록일
	private String udtUser     ; //수정자
	private String udtDt       ; //수정일
	private int bCode          ; //게시판번호
	private int pCode          ; //상품번호
	
	
	public Board() {}


	public Board(int bSeq, String bTitle, String bContents, String id, int readCnt, String regDt, String udtUser,
			String udtDt, int bCode, int pCode) {
		super();
		this.bSeq = bSeq;
		this.bTitle = bTitle;
		this.bContents = bContents;
		this.Id = id;
		this.readCnt = readCnt;
		this.regDt = regDt;
		this.udtUser = udtUser;
		this.udtDt = udtDt;
		this.bCode = bCode;
		this.pCode = pCode;
	}


	public int getbSeq() {
		return bSeq;
	}


	public void setbSeq(int bSeq) {
		this.bSeq = bSeq;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public String getbContents() {
		return bContents;
	}


	public void setbContents(String bContents) {
		this.bContents = bContents;
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public int getReadCnt() {
		return readCnt;
	}


	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
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


	public int getbCode() {
		return bCode;
	}


	public void setbCode(int bCode) {
		this.bCode = bCode;
	}


	public int getpCode() {
		return pCode;
	}


	public void setpCode(int pCode) {
		this.pCode = pCode;
	}


	@Override
	public String toString() {
		return "Board [bSeq=" + bSeq + ", bTitle=" + bTitle + ", bContents=" + bContents + ", Id=" + Id + ", readCnt="
				+ readCnt + ", regDt=" + regDt + ", udtUser=" + udtUser + ", udtDt=" + udtDt + ", bCode=" + bCode
				+ ", pCode=" + pCode + ", toString()=" + super.toString() + "]";
	}


	



	
}
