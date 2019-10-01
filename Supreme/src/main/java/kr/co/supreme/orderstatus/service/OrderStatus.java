package kr.co.supreme.orderstatus.service;

import kr.co.supreme.cmn.DTO;

public class OrderStatus extends DTO {
	/**주문 상태 */
	private String detail_code   ; /*주문상세번호*/
	private String od_status     ; /*주문상태*/
	private String reg_dt        ; /*등록일*/
	private String udt_dt        ; /*처리일자*/
	private String order_code    ; /*주문번호*/
	/**주문상세 */
	private String p_code        ; /*상품번호*/
	private String quantity      ; /*수량*/
	private String unit_price    ; /*단가*/
	
	public OrderStatus() {}

	
	@Override
	public String toString() {
		return "OrderStatus [detail_code=" + detail_code + ", od_status=" + od_status + ", reg_dt=" + reg_dt
				+ ", udt_dt=" + udt_dt + ", order_code=" + order_code + ", p_code=" + p_code + ", quantity=" + quantity
				+ ", unit_price=" + unit_price + ", toString()=" + super.toString() + "]";
	}


	public OrderStatus(String detail_code, String od_status, String reg_dt, String udt_dt, String order_code,
			String p_code, String quantity, String unit_price) {
		super();
		this.detail_code = detail_code;
		this.od_status = od_status;
		this.reg_dt = reg_dt;
		this.udt_dt = udt_dt;
		this.order_code = order_code;
		this.p_code = p_code;
		this.quantity = quantity;
		this.unit_price = unit_price;
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

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
	
	
}
