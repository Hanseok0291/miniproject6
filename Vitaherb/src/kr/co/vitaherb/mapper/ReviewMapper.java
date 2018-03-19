package kr.co.vitaherb.mapper;

import java.util.List;

import kr.co.vitaherb.domain.Review;

public interface ReviewMapper {

	void insertReview(Review review);

	List<Review> detailGoodsReview(int goodsCode);
	void insertReviewPoint(int review);
	void updateReviewContent(String review);

}
