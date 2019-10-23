package kr.co.supreme.orderstatus.service;

import kr.co.supreme.cmn.DTO;

public class OrderSearch extends DTO {
	/** 페이지 사이즈 */
	private int pageSize   ; 	
	/** 페이지 번호 */
	private int pageNum    ;	
	/** 검색조건 */
	private String searchDiv  ;
	/** 검색어 */
	private String searchWord ;
	/** 주문상태*/
	private String orderStatus;
	
	public OrderSearch() { }

	@Override
	public String toString() {
		return "OrderSearch [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchDiv=" + searchDiv
				+ ", searchWord=" + searchWord + ", orderStatus=" + orderStatus + ", toString()=" + super.toString()
				+ "]";
	}

	public OrderSearch(int pageSize, int pageNum, String searchDiv, String searchWord, String orderStatus) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.orderStatus = orderStatus;
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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
}
