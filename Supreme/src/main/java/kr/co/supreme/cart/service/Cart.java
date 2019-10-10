package kr.co.supreme.cart.service;

import kr.co.supreme.cmn.DTO;

public class Cart extends DTO{
	
	private int cartCode  ;    //장바구니번호
	private int pCode     ;    //상품번호
	private int quantity  ;    //수량
	private int unitPrice ;    //단가
	private String id     ;    //회원아이디
	
	public Cart() {};
	
	public int getCartCode() {
		return cartCode;
	}
	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}
	public int getpCode() {
		return pCode;
	}
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cart [cartCode=" + cartCode + ", pCode=" + pCode + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", id=" + id + ", toString()=" + super.toString() + "]";
	}
	public Cart(int cartCode, int pCode, int quantity, int unitPrice, String id) {
		super();
		this.cartCode = cartCode;
		this.pCode = pCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pCode;
		result = prime * result + quantity;
		result = prime * result + unitPrice;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartCode != other.cartCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pCode != other.pCode)
			return false;
		if (quantity != other.quantity)
			return false;
		if (unitPrice != other.unitPrice)
			return false;
		return true;
	}
	
	
	
}
