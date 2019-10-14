package kr.co.supreme.order.service;

import kr.co.supreme.cmn.DTO;

public class Order extends DTO{

	private int orderCode;        //주문번호
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
	
	
	public Order() {}
	
	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", id=" + id + ", rName=" + rName + ", rPostcode=" + rPostcode
				+ ", rAddress1=" + rAddress1 + ", rAddress2=" + rAddress2 + ", rTel=" + rTel + ", request=" + request
				+ ", payMethod=" + payMethod + ", bank=" + bank + ", depositName=" + depositName + ", depositDate="
				+ depositDate + ", orderDate=" + orderDate + ", toString()=" + super.toString() + "]";
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
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

	public Order(int orderCode, String id, String rName, String rPostcode, String rAddress1, String rAddress2,
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
	
	
	
}
