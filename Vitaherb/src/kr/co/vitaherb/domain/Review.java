package kr.co.vitaherb.domain;

//리뷰,별점 정보 테이블 
public class Review {

	// 목록 번호
	private int reviewNo;


	// 아이디 
	private String userId;

	// 상품코드 
	private int goodsCode;

	// 평점 
	private String reviewPoint;
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	// 리뷰 
	private String reviewContent;

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
