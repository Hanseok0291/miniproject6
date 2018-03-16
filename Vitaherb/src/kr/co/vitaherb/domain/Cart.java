package kr.co.vitaherb.domain;

//장바구니 정보 테이블 
public class Cart {

	// 장바구니번호 
	private int cartNo;

	// 아이디 
	private String userId;

	// 상품코드 
	private int goodsCode;

	// 개수 
	private int goodsCount;

	// 소계 
	private int goodsSum;

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public int getGoodsSum() {
		return goodsSum;
	}

	public void setGoodsSum(int goodsSum) {
		this.goodsSum = goodsSum;
	}

}
