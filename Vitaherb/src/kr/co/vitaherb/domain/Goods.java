package kr.co.vitaherb.domain;

//상품 정보 테이블 
public class Goods {

	// 목록번호 
	private Integer goodsNo;

	// 상품코드 
	private Integer goodsCode;

	// 상품이름 
	private String goodsName;

	// 상품가격 
	private Integer goodsPrice;

	// 상품설명 
	private String goodsDescription;

	// 상품분류 
	private String goodsCategory;

	public Integer getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(Integer goodsNo) {
		this.goodsNo = goodsNo;
	}

	public Integer getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(Integer goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}


}
