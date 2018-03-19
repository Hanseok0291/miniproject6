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
		System.out.println(" ");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("상품코드\t상품명\t가격");	
		System.out.println("---------------------------");
		System.out.println(MainServiceUI.g.getGoodsCode() +"\t"+ MainServiceUI.g.getGoodsName() +"\t"+ MainServiceUI.g.getGoodsPrice());
		System.out.println("---------------------------");
		System.out.println("상세정보 : "+MainServiceUI.g.getGoodsDescription());
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println(" ");
		System.out.println("[리뷰]");
		System.out.println("목록번호\t평점\t상품평\t아이디");
		System.out.println("----------------------------");

		List<Review> list = rm.detailGoodsReview(MainServiceUI.g.getGoodsCode());

		int i = 1;
		for (Review r : list) {
			//			System.out.printf(
			//					"%d\t%s\t%s\t%s\n", 
			//					i++, r.getReviewPoint()+"점", r.getReviewContent(), r.getUserId()
			//					);
			System.out.print(i++ + "\t");
			for(int s = 1; s <= Integer.parseInt(r.getReviewPoint()); s++) {
				System.out.print("★"); }
			System.out.print("\t"+r.getReviewContent()+"\t" + r.getUserId()+"\n");
		}
		System.out.println("----------------------------");
		int detailNo = getInt("1.장바구니에 담기"+"\n"+"2.리뷰쓰기"+"\n"+"0.쇼핑계속하기");

		switch(detailNo) {
		case 1 :          
			WriteCartUIByUser ui = new WriteCartUIByUser();
			ui.service(); break;
		case 2 : ReviewUI ui3 = new ReviewUI();
		ui3.service(); break;
		case 0 : MainServiceUI ui2 = new MainServiceUI();
		ui2.service(); break;
		}





	}


}
