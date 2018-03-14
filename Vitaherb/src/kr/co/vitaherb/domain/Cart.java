package kr.co.vitaherb.domain;

//장바구니 정보 테이블 
public class Cart {

	// 장바구니번호 
	private Integer cartNo;

	// 아이디 
	private String userId;

	// 상품코드 
	private Integer goodsCode;

	// 개수 
	private Integer goodsCount;

	// 소계 
	private Integer goodsSum;

	public Integer getCartNo() {
		return cartNo;
	}

	public void setCartNo(Integer cartNo) {
		this.cartNo = cartNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(Integer goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Integer getGoodsSum() {
		return goodsSum;
	}

	public void setGoodsSum(Integer goodsSum) {
		this.goodsSum = goodsSum;
	}

}
