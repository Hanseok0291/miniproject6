package kr.co.vitaherb.mainservice.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import common.db.BaseUI;
import common.db.MyAppSqlConfig;
import kr.co.vitaherb.detailgoodsinfo.ui.SearchGoodsInfoUI;
import kr.co.vitaherb.domain.Goods;
import kr.co.vitaherb.goods.ui.HealthSupplementUI;
import kr.co.vitaherb.goods.ui.PetSupplementUI;
import kr.co.vitaherb.goods.ui.SuperFoodUI;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.ReviewMapper;

public class MainServiceUI {
	private Scanner sc = new Scanner(System.in);
	
	public static Goods g;
	
	
    private GoodsMapper gm;
//    private CartMapper cm;
//    private OrderMapper om;
//    private UserMapper um;
    
	public MainServiceUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		gm = session.getMapper(GoodsMapper.class);
//	    cm = session.getMapper(CartMapper.class);
//		om = session.getMapper(OrderMapper.class);
//		um = session.getMapper(UserMapper.class);
//		
	}
	
	
	public void service() {
		BaseUI ui = null;
		while(true) {
			switch(menu()) {
			case 1 : ui = new HealthSupplementUI(gm); break;
			case 2 : ui = new SuperFoodUI(gm); break;
			case 3 : ui = new PetSupplementUI(gm); break;
			case 4 : ui = new SearchGoodsInfoUI(gm); break;
//			case 5 : ui = new CartUI(cm, gm); break;
//			case 6 : ui = new OrderHistoryUI(om, gm); break;
			case 0 : quit();
			}
			ui.service();
		}
	}
	
  private void quit() {
	  System.out.println("이용해주셔서 감사합니다.");
	  System.exit(0);
  }
	
	
  private int menu() {
	  
	  System.out.println(" ");
	  System.out.println("************************");
	  System.out.println("Vitaherb에 오신 것을 환영합니다.");
	  System.out.println("************************");
	  System.out.println("1. 건강보조식품");
	  System.out.println("2. 슈퍼푸드");
	  System.out.println("3. 반려동물제품");
	  System.out.println("4. 상품 검색");
	  System.out.println("5. 장바구니");
	  System.out.println("6. 주문조회");
	  System.out.println("0. 로그아웃");
	  System.out.println("************************");
	  System.out.print("조회하고싶은 항목을 선택하세요 : ");
	  return Integer.parseInt(sc.nextLine());
	  
  }

}
