package kr.co.vitaherb.mainservice.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import common.db.BaseUI;
import common.db.MyAppSqlConfig;
import kr.co.vitaherb.cart.ui.CartUI;
import kr.co.vitaherb.detailgoodsinfo.ui.DetailGoodsInfoUI;
import kr.co.vitaherb.goods.ui.HealthSupplementUI;
import kr.co.vitaherb.goods.ui.PetSupplementUI;
import kr.co.vitaherb.goods.ui.SuperFoodUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;
import kr.co.vitaherb.mapper.ReviewMapper;
import kr.co.vitaherb.mapper.UserMapper;
import kr.co.vitaherb.orderhistory.ui.OrderHistoryUI;

public class MainServiceUI {
	
	private Scanner sc = new Scanner(System.in);
    private GoodsMapper goodsmap;
    private CartMapper cartmap;
    private OrderMapper ordermap;
    private ReviewMapper reviewmap;
    private UserMapper usermap;
    
	public MainServiceUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		usermap = session.getMapper(UserMapper.class);
	}
	
	
	public void service() {
		while(true) {
			BaseUI ui = null;
			switch(menu()) {
			case 1 : ui = new HealthSupplementUI(goodsmap); break;
			case 2 : ui = new SuperFoodUI(goodsmap); break;
			case 3 : ui = new PetSupplementUI(goodsmap); break;
			case 4 : ui = new DetailGoodsInfoUI(goodsmap, reviewmap); break;
			case 5 : ui = new CartUI(goodsmap); break;
			case 6 : ui = new OrderHistoryUI(ordermap, goodsmap); break;
			}
			ui.service();
		}
	}
	
	
  private int menu() {
	  
	  System.out.println("Vitaherb에 오신 것을 환영합니다.");
	  System.out.println("************************");
	  System.out.println("1. 건강보조식품");
	  System.out.println("2. 슈퍼푸드");
	  System.out.println("3. 반려동물영양제");
	  System.out.println("4. 상품 검색");
	  System.out.println("5. 장바구니");
	  System.out.println("6. 주문조회");
	  System.out.println("************************");
	  System.out.print("조회하고싶은 항목을 선택하세요 : ");
	  return Integer.parseInt(sc.nextLine());
	  
  }

}
