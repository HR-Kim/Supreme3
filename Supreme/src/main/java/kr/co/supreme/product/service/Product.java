package kr.co.supreme.product.service;

import kr.co.supreme.cmn.DTO;

public class Product extends DTO{

	private String p_code;
	private String	h_code;
	private String	l_code;
	private String	p_name;
	private String	p_company;
	private String	p_price;
	private String	p_image;
	private String	stock;
	private String	unit_sales;
	private String	status;
	private String	p_new;
	private String	p_best;
	private String	p_sale;
	private String	p_content;
	private String	sale_percent;
	private String	reg_dt;
	
	public Product() {}

	public Product(String p_code, String h_code, String l_code, String p_name, String p_company, String p_price,
			String p_image, String stock, String unit_sales, String status, String p_new, String p_best, String p_sale,
			String p_content, String sale_percent, String reg_dt) {
		super();
		this.p_code = p_code;
		this.h_code = h_code;
		this.l_code = l_code;
		this.p_name = p_name;
		this.p_company = p_company;
		this.p_price = p_price;
		this.p_image = p_image;
		this.stock = stock;
		this.unit_sales = unit_sales;
		this.status = status;
		this.p_new = p_new;
		this.p_best = p_best;
		this.p_sale = p_sale;
		this.p_content = p_content;
		this.sale_percent = sale_percent;
		this.reg_dt = reg_dt;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getH_code() {
		return h_code;
	}

	public void setH_code(String h_code) {
		this.h_code = h_code;
	}

	public String getL_code() {
		return l_code;
	}

	public void setL_code(String l_code) {
		this.l_code = l_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_company() {
		return p_company;
	}

	public void setP_company(String p_company) {
		this.p_company = p_company;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getUnit_sales() {
		return unit_sales;
	}

	public void setUnit_sales(String unit_sales) {
		this.unit_sales = unit_sales;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getP_new() {
		return p_new;
	}

	public void setP_new(String p_new) {
		this.p_new = p_new;
	}

	public String getP_best() {
		return p_best;
	}

	public void setP_best(String p_best) {
		this.p_best = p_best;
	}

	public String getP_sale() {
		return p_sale;
	}

	public void setP_sale(String p_sale) {
		this.p_sale = p_sale;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getSale_percent() {
		return sale_percent;
	}

	public void setSale_percent(String sale_percent) {
		this.sale_percent = sale_percent;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "Product [p_code=" + p_code + ", h_code=" + h_code + ", l_code=" + l_code + ", p_name=" + p_name
				+ ", p_company=" + p_company + ", p_price=" + p_price + ", p_image=" + p_image + ", stock=" + stock
				+ ", unit_sales=" + unit_sales + ", status=" + status + ", p_new=" + p_new + ", p_best=" + p_best
				+ ", p_sale=" + p_sale + ", p_content=" + p_content + ", sale_percent=" + sale_percent + ", reg_dt="
				+ reg_dt + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
