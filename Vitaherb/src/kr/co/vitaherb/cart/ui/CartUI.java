package kr.co.vitaherb.cart.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.co.vitaherb.BaseUI;
import common.db.MyAppSqlConfig;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;
import kr.co.vitaherb.order.ui.buyCartOrderUI;
import kr.co.vitaherb.cart.ui.ListCartUI;
import kr.co.vitaherb.cart.ui.UpdateCartUI;
import kr.co.vitaherb.cart.ui.WriteCartUI;

public class CartUI extends BaseUI {

	private CartMapper mapper;
	private OrderMapper mapperOrder;
	private Scanner sc = new Scanner(System.in);
	public static int cartNum ;
	
	public CartUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(CartMapper.class);
	}
	
	public CartUI(CartMapper mapper) {
		this.mapper = mapper;
	}
	
	public CartUI(CartMapper cm, OrderMapper om) {
		this.mapper = cm;
		this.mapperOrder = om;
	}

	public void service() {
		BaseUI ui = null;
		boolean exitCartUI = true;
		while (exitCartUI) {
			switch (menu()) {
			case 1: ui = new ListCartUI(mapper); break;
//			case 2: ui = new DetailCartUI(mapper); break;
			case 3: ui = new WriteCartUI(mapper);  break;
			case 4: ui = new UpdateCartUI(mapper); break;
			case 5: ui = new DeleteCartByNoUI(mapper); break;
			case 6: ui = new DeleteCartUI(mapper); break;
			case 7: ui = new buyCartOrderUI(mapper, mapperOrder ); break;
			// case 0: exitCartUI = false; //quit();
			case 0: exitCartUI = quit();
			}
			
			if(exitCartUI == true) ui.service();
		}
	}

	private boolean quit() {
		System.out.println("장바구니에서 나갑니다.");
		return false;
	}
	
	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. 장바구니 내용 조회");
		System.out.println("2. 장바구니 번호로 조회");
		System.out.println("3. 장바구니 등록");
		System.out.println("4. 장바구니 수정(개수 변경)");
		System.out.println("5. 장바구니 일부 비우기");
		System.out.println("6. 장바구니 전체 비우기");
		System.out.println("7. 장바구니 구매하기");
		System.out.println("0. 계속 쇼핑하기");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
