package kr.co.vitaherb.domain;

import java.util.Date;

//주문,결제 정보 테이블 
public class Order {

	// 주문번호 
	private Integer orderId;

	// 주문날짜 
	private Date orderDate;

	// 아이디 
	private String userId;

	// 상품코드 
	private Integer goodsCode;

	// 개수 
	private Integer goodsCount;

	// 소계 
	private Integer goodsSum;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
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
