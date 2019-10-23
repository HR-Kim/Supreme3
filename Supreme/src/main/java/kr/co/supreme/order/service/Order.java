package kr.co.supreme.order.service;

import kr.co.supreme.cmn.DTO;

public class Order extends DTO{

	private String orderCode;     //주문번호
	private String id;            //아이디
	private String rName;         //수령자이름
	private String rPostcode;     //수령자우편번호
	private String rAddress1;     //수령자주소1
	private String rAddress2;     //수령자주소2
	private String rTel;          //수령자전화번호
	private String request;       //요청사항
	private String payMethod;     //결제구분
	private String bank;          //은행명
	private String depositName;   //입금인명
	private String depositDate;   //입금날짜
	private String orderDate;     //주문날짜
	
	private String detail_code   ; /*주문상세번호*/
	private String od_status     ; /*주문상태*/
	private String reg_dt        ; /*등록일*/
	private String udt_dt        ; /*처리일자*/
	
	private String p_code		 ; /*상품번호*/	
	private String quantitiy	 ; /*주문 수량*/
	private String unit_price    ; /*상품 단가*/
	
	private String check; //장바구니,단일결제 구분
	
	public Order() {}
	
	//주문 테이블
	public Order(String orderCode, String id, String rName, String rPostcode, String rAddress1, String rAddress2,
			String rTel, String request, String payMethod, String bank, String depositName, String depositDate,
			String orderDate) {
		super();
		this.orderCode = orderCode;
		this.id = id;
		this.rName = rName;
		this.rPostcode = rPostcode;
		this.rAddress1 = rAddress1;
		this.rAddress2 = rAddress2;
		this.rTel = rTel;
		this.request = request;
		this.payMethod = payMethod;
		this.bank = bank;
		this.depositName = depositName;
		this.depositDate = depositDate;
		this.orderDate = orderDate;
	}
	
	//주문상세 테이블
	public Order(String orderCode, String detail_code, String p_code, String quantitiy, String unit_price) {
		super();
		this.orderCode = orderCode;
		this.detail_code = detail_code;
		this.p_code = p_code;
		this.quantitiy = quantitiy;
		this.unit_price = unit_price;
	}

	
	//주문 상세 테이블
	public Order(String detail_code, String od_status, String reg_dt, String udt_dt) {
		super();
		this.detail_code = detail_code;
		this.od_status = od_status;
		this.reg_dt = reg_dt;
		this.udt_dt = udt_dt;
	}

	

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrPostcode() {
		return rPostcode;
	}

	public void setrPostcode(String rPostcode) {
		this.rPostcode = rPostcode;
	}

	public String getrAddress1() {
		return rAddress1;
	}

	public void setrAddress1(String rAddress1) {
		this.rAddress1 = rAddress1;
	}

	public String getrAddress2() {
		return rAddress2;
	}

	public void setrAddress2(String rAddress2) {
		this.rAddress2 = rAddress2;
	}

	public String getrTel() {
		return rTel;
	}

	public void setrTel(String rTel) {
		this.rTel = rTel;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getDepositName() {
		return depositName;
	}

	public void setDepositName(String depositName) {
		this.depositName = depositName;
	}

	public String getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDetail_code() {
		return detail_code;
	}

	public void setDetail_code(String detail_code) {
		this.detail_code = detail_code;
	}

	public String getOd_status() {
		return od_status;
	}

	public void setOd_status(String od_status) {
		this.od_status = od_status;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUdt_dt() {
		return udt_dt;
	}

	public void setUdt_dt(String udt_dt) {
		this.udt_dt = udt_dt;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(String quantitiy) {
		this.quantitiy = quantitiy;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", id=" + id + ", rName=" + rName + ", rPostcode=" + rPostcode
				+ ", rAddress1=" + rAddress1 + ", rAddress2=" + rAddress2 + ", rTel=" + rTel + ", request=" + request
				+ ", payMethod=" + payMethod + ", bank=" + bank + ", depositName=" + depositName + ", depositDate="
				+ depositDate + ", orderDate=" + orderDate + ", detail_code=" + detail_code + ", od_status=" + od_status
				+ ", reg_dt=" + reg_dt + ", udt_dt=" + udt_dt + ", p_code=" + p_code + ", quantitiy=" + quantitiy
				+ ", unit_price=" + unit_price + ", check=" + check + "]";
	}

	



	

	


	
	
}
