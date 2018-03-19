package kr.co.vitaherb.cart.ui;

import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class DeleteCartByNoUI extends kr.co.vitaherb.BaseUI {
	private CartMapper cm;
	private GoodsMapper gm;
	private OrderMapper om;


	public DeleteCartByNoUI(CartMapper cm, GoodsMapper gm, OrderMapper om) {
		this.cm=cm;
		this.gm=gm;
		this.om=om;
	}

	public void service() {
		System.out.println(" ");
		int no = getInt("삭제할 번호를 입력하세요 : ");
		int cNo = ListCartUI.sNo[no-1];

		int result = cm.deleteCartByNo(cNo);

		if (result == 0) {
			System.out.println("-------------------");
			System.out.println(
					"입력하신 번호에 해당하는 상품이 없습니다.");
			System.out.println("-------------------");
			ListCartUI ui = new ListCartUI(cm,gm,om);
			ui.service();
			return;
		} else {
			System.out.println("-------------------");
			System.out.println("해당하는 상품이 삭제되었습니다.");
			System.out.println("-------------------");
			ListCartUI ui = new ListCartUI(cm,gm,om);
			ui.service();
		}

	}

}



