package kr.co.supreme.orderstatus.service;

import kr.co.supreme.cmn.DTO;

public class OrderStatus extends DTO {
	/**주문 상태 */
	private String detail_code   ; /*주문상세번호*/
	private String od_status     ; /*주문상태*/
	private String reg_dt        ; /*등록일*/
	private String udt_dt        ; /*처리일자*/
	
	/**주문 상세*/
	private String order_code    ; /*주문번호*/
	private String quantitiy	 ; /*주문 수량*/
	private String unit_price    ; /*상품 단가*/
	
	/**상품 목록*/
	private String p_name		 ; /*상품명*/
	private String p_content	 ; /*상품설명*/
	private String p_image		 ; /*상품이미지*/
	
	
	public OrderStatus() {}
	public OrderStatus(String detail_code, String od_status, String reg_dt, String udt_dt, String order_code,
			String quantitiy, String unit_price, String p_name, String p_content, String p_image) {
		super();
		this.detail_code = detail_code;
		this.od_status = od_status;
		this.reg_dt = reg_dt;
		this.udt_dt = udt_dt;
		this.order_code = order_code;
		this.quantitiy = quantitiy;
		this.unit_price = unit_price;
		this.p_name = p_name;
		this.p_content = p_content;
		this.p_image = p_image;
	}

	@Override
	public String toString() {
		return "OrderStatus [detail_code=" + detail_code + ", od_status=" + od_status + ", reg_dt=" + reg_dt
				+ ", udt_dt=" + udt_dt + ", order_code=" + order_code + ", quantitiy=" + quantitiy + ", unit_price="
				+ unit_price + ", p_name=" + p_name + ", p_content=" + p_content + ", p_image=" + p_image
				+ ", toString()=" + super.toString() + "]";
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

	public String getOrder_code() {
		return order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
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

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}


	
}