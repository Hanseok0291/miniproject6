package kr.co.vitaherb.cart.ui;

import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class DeleteCartUI extends kr.co.vitaherb.BaseUI {
	private CartMapper cm;
	private GoodsMapper gm;
	private OrderMapper om;


	public DeleteCartUI(CartMapper cm, GoodsMapper gm, OrderMapper om) {
		this.cm=cm;
		this.gm=gm;
		this.om=om;
	}

	public void service() {
		int result = cm.deleteCart();
		if (result == 0) {
			System.out.println("-----------------");
			System.out.println(
					"장바구니에 아무것도 없습니다.");
			System.out.println("-----------------");
			return;
		}
		else {

			//			ListCartUI ui = new ListCartUI(cm);
			//			ui.service();
			System.out.println("-----------------");
			System.out.println("장바구니를 비웠습니다.");
			System.out.println("-----------------");
		}

		ListCartUI ui = new ListCartUI(cm,gm,om);
		ui.service();
	}
}



