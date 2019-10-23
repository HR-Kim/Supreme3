package kr.co.supreme.board.service;

import kr.co.supreme.cmn.DTO;

public class BoardSearch extends DTO {
	/** 페이지 사이즈 */
	private int pageSize   ; 	
	/** 페이지 번호 */
	private int pageNum    ;	
	/** 검색조건 */
	private String searchDiv  ;
	/** 검색어 */
	private String searchWord ;
	/** 게시판 코드*/
	private String boardCode;
	
	public BoardSearch() {}
	
	public BoardSearch(int pageSize, int pageNum, String searchDiv, String searchWord, String boardCode) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.boardCode = boardCode;
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

	public String getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}

	@Override
	public String toString() {
		return "BoardSearch [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchDiv=" + searchDiv
				+ ", searchWord=" + searchWord + ", boardCode=" + boardCode + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
