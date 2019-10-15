package kr.co.supreme.user.service;

import kr.co.supreme.cmn.DTO;

public class UserSearch extends DTO  {
	/** 페이지 사이즈 */
	private int pageSize   ; 	
	/** 페이지 번호 */
	private int pageNum    ;	
	/** 검색조건 */
	private String searchDiv  ;
	/** 검색어 */
	private String searchWord ;
	/** 유저등급*/
	private String userLvl;
	
	public UserSearch() {}

	public UserSearch(int pageSize, int pageNum, String searchDiv, String searchWord, String userLvl) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.userLvl = userLvl;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getUserLvl() {
		return userLvl;
	}

	public void setUserLvl(String userLvl) {
		this.userLvl = userLvl;
	}

	@Override
	public String toString() {
		return "UserSearch [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchDiv=" + searchDiv
				+ ", searchWord=" + searchWord + ", userLvl=" + userLvl + ", toString()=" + super.toString() + "]";
	}
	
	
}
