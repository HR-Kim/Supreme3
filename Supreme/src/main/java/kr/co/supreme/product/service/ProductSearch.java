package kr.co.supreme.product.service;

import kr.co.supreme.cmn.DTO;

public class ProductSearch extends DTO {
	/** 페이지 사이즈 */
	private int pageSize   ; 	
	/** 페이지 번호 */
	private int pageNum    ;	
	/** 검색조건 */
	private String searchDiv  ;
	/** 검색어 */
	private String searchWord ;
	/** 대분류 카테고리*/
	private String hCodeCat;
	/** 소분류 카테고리*/
	private String lCodeCat;
	/** 상태*/
	private String status;
	
	public ProductSearch() {}
	
	public ProductSearch(int pageSize, int pageNum, String searchDiv, String searchWord, String hCodeCat,
			String lCodeCat, String status) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.hCodeCat = hCodeCat;
		this.lCodeCat = lCodeCat;
		this.status = status;
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

	public String gethCodeCat() {
		return hCodeCat;
	}

	public void sethCodeCat(String hCodeCat) {
		this.hCodeCat = hCodeCat;
	}

	public String getlCodeCat() {
		return lCodeCat;
	}

	public void setlCodeCat(String lCodeCat) {
		this.lCodeCat = lCodeCat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductSearch [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchDiv=" + searchDiv
				+ ", searchWord=" + searchWord + ", hCodeCat=" + hCodeCat + ", lCodeCat=" + lCodeCat + ", status="
				+ status + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
