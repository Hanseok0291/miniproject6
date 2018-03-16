package kr.co.vitaherb.detailgoodsinfo.ui;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.cart.ui.WriteCartUIByUser;
import kr.co.vitaherb.domain.Review;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.ReviewMapper;
import kr.co.vitaherb.review.ui.ReviewUI;

public class DetailGoodsInfoUI extends BaseUI{
	
	private ReviewMapper rm;
	
	public DetailGoodsInfoUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		rm = session.getMapper(ReviewMapper.class);
	}
	
	public void service() {
		System.out.println("*********************");
		System.out.println("상품코드\t상품명\t가격");	


		System.out.println(MainServiceUI.g.getGoodsCode() +"\t"+ MainServiceUI.g.getGoodsName() +"\t"+ MainServiceUI.g.getGoodsPrice());
		System.out.println("--------------------------");
		System.out.println("*상품설명*");
		System.out.println(MainServiceUI.g.getGoodsDescription());
		System.out.println("*********************");
		System.out.println("평점\t리뷰\t아이디");
		
		List<Review> list = rm.detailGoodsReview(MainServiceUI.g.getGoodsCode());

		for (Review r : list) {
			System.out.printf(
				"%s\t%s\t%s\n", 
				r.getReviewPoint(), r.getReviewContent(), r.getUserId()
			);
		}
		
		System.out.println("--------------------------");
		int detailNo = getInt("1.장바구니에 담기"+"\n"+"2.쇼핑 계속하기"+"\n"+"3.리뷰쓰기");
		
		switch(detailNo) {
		case 1 : WriteCartUIByUser ui1 = new WriteCartUIByUser(); 
				 ui1.service(); break;
		case 2 : MainServiceUI ui2 = new MainServiceUI();
		         ui2.service(); break;
		case 3 : ReviewUI ui3 = new ReviewUI();
		         ui3.service(); break;
		}
		
		
		
		
		
	}
	

}
