package kr.co.vitaherb.domain;

//리뷰,별점 정보 테이블 
public class Review {

	// 아이디 
	private String userId;

	// 상품코드 
	private Integer goodsCode;

	// 평점 
	private String reviewPoint;

	// 리뷰 
	private String reviewContent;

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

	public String getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(String reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

}