package kr.co.vitaherb.review.ui;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Review;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.ReviewMapper;

public class ReviewUI extends BaseUI {
	private ReviewMapper rm;
	public ReviewUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		rm = session.getMapper(ReviewMapper.class);
	}

	public void service() {

		Review r = new Review();

		r.setGoodsCode(MainServiceUI.g.getGoodsCode());
		r.setUserId(LoginViewUI.user.getUserId());
		System.out.println(" ");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("[리뷰 작성]");
		System.out.println("---------------------------");
		String point = getStr("평점(5점만점) : ");
		r.setReviewPoint(point);
		String content = getStr("상품평 : ");
		r.setReviewContent(content);

		rm.insertReview(r);

	}

}
