package kr.co.vitaherb.cart.ui;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class UpdateCartUI extends BaseUI {
	private CartMapper cm;
	private GoodsMapper gm;
	private OrderMapper om;


	public UpdateCartUI(CartMapper cm, GoodsMapper gm, OrderMapper om) {
		this.cm=cm;        
		this.gm=gm;
		this.om=om;
	}


	public void service() {
		Cart cart = new Cart();

		System.out.println(" ");
		int no = getInt("수정할 제품 번호를 입력하세요 : ");
		int cNo = ListCartUI.sNo[no-1];
//		System.out.println("시퀀스"+cNo);
		cart.setCartNo(cNo);
		
		int cnt = getInt("변경할 상품의 개수를 입력하세요 : ");
//		System.out.println("출력 : "+cnt);
		cart.setGoodsCount(cnt);
		
		Cart pre = new Cart();
		pre = cm.getSnoCart(cNo);
//		System.out.println("pre"+pre);
		int price = pre.getGoodsSum() / pre.getGoodsCount();
//		System.out.println(price);
		int gs = price*cnt;
//		System.out.println(gs);
		cart.setGoodsSum(gs);
//		cart.setGoodsSum(price*cnt);
		
//		System.out.println(cm.getSnoCart(cNo).getGoodsSum());
//		System.out.println(cm.getSnoCart(cNo).getGoodsCount());
//		int price = cm.getSnoCart(cNo).getGoodsSum()/cm.getSnoCart(cNo).getGoodsCount();
//		cart.setGoodsSum(price*cnt);

		int result = cm.updateCart(cart);  
		if (result == 0) {
			System.out.println("-----------------");
			System.out.println("입력된 번호는 존재하지 않습니다.");
			System.out.println("-----------------");
		} else {
			System.out.println("-----------------");
			System.out.println("장바구니가 수정되었습니다.");
			System.out.println("-----------------");
		}

		ListCartUI ui = new ListCartUI(cm,gm,om);
		ui.service();
	}
}



