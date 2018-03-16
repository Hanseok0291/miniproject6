package kr.co.vitaherb.domain;

import java.util.Date;

//주문,결제 정보 테이블 
public class Order {

	// 주문번호 
	private int orderId;

	// 주문날짜 
	private Date orderDate;

	// 아이디 
	private String userId;

	// 상품코드 
	private int goodsCode;

	// 상품이름 
	private String goodsName;

	// 개수 
	private int goodsCount;

	// 소계 
	private int goodsSum;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
