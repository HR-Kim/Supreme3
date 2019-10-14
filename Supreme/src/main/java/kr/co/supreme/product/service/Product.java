package kr.co.supreme.product.service;

import kr.co.supreme.cmn.DTO;

public class Product extends DTO{

	private int pCode        ; 
	private String hCode        ;
	private String lCode        ;
	private String pName        ;
	private String pCompany     ; 
	private int pPrice       ; 
	private String pImage       ; 
	private int stock         ; 
	private int unitSales    ; 
	private String status        ; 
	private String pNew         ;
	private String pBest        ;
	private String pSale        ;
	private String pContent     ; 
	private int salePercent  ; 
	private String regDt        ;
	
	public Product() {}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String gethCode() {
		return hCode;
	}

	public void sethCode(String hCode) {
		this.hCode = hCode;
	}

	public String getlCode() {
		return lCode;
	}

	public void setlCode(String lCode) {
		this.lCode = lCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCompany() {
		return pCompany;
	}

	public void setpCompany(String pCompany) {
		this.pCompany = pCompany;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getUnitSales() {
		return unitSales;
	}

	public void setUnitSales(int unitSales) {
		this.unitSales = unitSales;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getpNew() {
		return pNew;
	}

	public void setpNew(String pNew) {
		this.pNew = pNew;
	}

	public String getpBest() {
		return pBest;
	}

	public void setpBest(String pBest) {
		this.pBest = pBest;
	}

	public String getpSale() {
		return pSale;
	}

	public void setpSale(String pSale) {
		this.pSale = pSale;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public int getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(int salePercent) {
		this.salePercent = salePercent;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "Product [pCode=" + pCode + ", hCode=" + hCode + ", lCode=" + lCode + ", pName=" + pName + ", pCompany="
				+ pCompany + ", pPrice=" + pPrice + ", pImage=" + pImage + ", stock=" + stock + ", unitSales="
				+ unitSales + ", status=" + status + ", pNew=" + pNew + ", pBest=" + pBest + ", pSale=" + pSale
				+ ", pContent=" + pContent + ", salePercent=" + salePercent + ", regDt=" + regDt + "]";
	}

	public Product(int pCode, String hCode, String lCode, String pName, String pCompany, int pPrice, String pImage,
			int stock, int unitSales, String status, String pNew, String pBest, String pSale, String pContent,
			int salePercent, String regDt) {
		super();
		this.pCode = pCode;
		this.hCode = hCode;
		this.lCode = lCode;
		this.pName = pName;
		this.pCompany = pCompany;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.stock = stock;
		this.unitSales = unitSales;
		this.status = status;
		this.pNew = pNew;
		this.pBest = pBest;
		this.pSale = pSale;
		this.pContent = pContent;
		this.salePercent = salePercent;
		this.regDt = regDt;
	}

	
}
