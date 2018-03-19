package kr.co.vitaherb.cart.ui;

import java.util.Scanner;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;
import kr.co.vitaherb.order.ui.buyCartOrderUI;

public class CartUI extends BaseUI {

	private CartMapper cm;
	private GoodsMapper gm;
	private OrderMapper om;
	private Scanner sc = new Scanner(System.in);

	public static int cartNum ;
//
//	public CartUI() {
//		SqlSession session = MyAppSqlConfig.getSqlSession();
//		cm = session.getMapper(CartMapper.class);
//	}
//
//	public CartUI(CartMapper mapper) {
//		this.cm = mapper;
//	}

	public CartUI(CartMapper cm, OrderMapper om, GoodsMapper gm) {
		this.cm = cm;
		this.om = om;
		this.gm = gm;
	}

	public void service() {
		BaseUI ui = null;
		while (true) {
			switch (menu()) {
			case 1: ui = new UpdateCartUI(cm,gm,om); break;
			case 2: ui = new DeleteCartByNoUI(cm,gm,om); break;
			case 3: ui = new DeleteCartUI(cm,gm,om); break;
			case 4: ui = new buyCartOrderUI(cm, om ); break;
			case 0: quit();
			} ui.service();
		}
	}
	private void quit() {
		System.out.println("장바구니에서 나갑니다.");
		MainServiceUI ui2 = new MainServiceUI();
		ui2.service();
	}

	private int menu() {
		System.out.println("****************");
		System.out.println("1. 수정(개수 변경)");
		System.out.println("2. 일부 비우기");
		System.out.println("3. 전체 비우기");
		System.out.println("4. 구매하기");
		System.out.println("0. 계속 쇼핑하기");
		System.out.println("****************");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
