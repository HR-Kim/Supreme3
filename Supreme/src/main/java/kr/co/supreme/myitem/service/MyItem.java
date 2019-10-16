package kr.co.supreme.myitem.service;

import kr.co.supreme.cmn.DTO;

public class MyItem extends DTO {
	
	private int fSeq;
	private String id;
	private int pCode;
	private String regDt;
	private String pImage;
	private String pName;
	private int price;
	
	public MyItem() {}

	public int getfSeq() {
		return fSeq;
	}

	public void setfSeq(int fSeq) {
		this.fSeq = fSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MyItem(int fSeq, String id, int pCode, String regDt, String pImage, String pName, int price) {
		super();
		this.fSeq = fSeq;
		this.id = id;
		this.pCode = pCode;
		this.regDt = regDt;
		this.pImage = pImage;
		this.pName = pName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "MyItem [fSeq=" + fSeq + ", id=" + id + ", pCode=" + pCode + ", regDt=" + regDt + ", pImage=" + pImage
				+ ", pName=" + pName + ", price=" + price + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fSeq;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pCode;
		result = prime * result + ((pImage == null) ? 0 : pImage.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + price;
		result = prime * result + ((regDt == null) ? 0 : regDt.hashCode());
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
		MyItem other = (MyItem) obj;
		if (fSeq != other.fSeq)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pCode != other.pCode)
			return false;
		if (pImage == null) {
			if (other.pImage != null)
				return false;
		} else if (!pImage.equals(other.pImage))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (price != other.price)
			return false;
		if (regDt == null) {
			if (other.regDt != null)
				return false;
		} else if (!regDt.equals(other.regDt))
			return false;
		return true;
	}

	
	
		
}
