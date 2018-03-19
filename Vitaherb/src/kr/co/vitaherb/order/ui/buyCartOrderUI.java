package kr.co.vitaherb.order.ui;

import java.util.Date;
import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.cart.ui.CartUI;
import kr.co.vitaherb.cart.ui.DeleteCartUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.domain.Order;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class buyCartOrderUI extends BaseUI {
	private CartMapper cm;
	private GoodsMapper gm;
	private OrderMapper om;

	//	public buyCartOrderUI(OrderMapper om) {
	//		this.om = om;
	//	}
	public buyCartOrderUI(CartMapper cm, OrderMapper om) {
		this.cm = cm;
		this.om = om;
	}

	public void service() {

		List<Cart> list = cm.selectCart(LoginViewUI.user.getUserId());

		if(list.size() == 0){
			System.out.println("-------------------");
			System.out.printf("구매할 물품이 없습니다.\n"); 
			System.out.println("-------------------");
			return;
		}

		System.out.printf("전체 %d개\n", list.size());

		System.out.println("------------------------------------");
		System.out.println("번호\t상품\t개수\t금액");
		System.out.println("------------------------------------");

		Date curDate = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat(
//				"yyyy-MM-dd"
//				);

		for (Cart ca : list) {
			System.out.printf(
					"%d\t%s\t%s\t%d\t%d\n", 
					ca.getCartNo(), 
					ca.getGoodsCode(),  
					ca.getGoodsName(),
					ca.getGoodsCount(), 
					ca.getGoodsSum()
					);

			Order order = new Order();
			//order.setOrderId(i); 
			order.setUserId(ca.getUserId()); 
			order.setOrderDate(curDate);
			order.setGoodsCode(ca.getGoodsCode());
			order.setGoodsName(ca.getGoodsName());
			order.setGoodsCount(ca.getGoodsCount());
			order.setGoodsSum(ca.getGoodsSum());

			//order.setOrderId(orderId);
			//			System.out.printf(
			//					" UserId = %s, orderNumber = %d, Goods Code = %d,"
			//					+ " name = %s, count = %d, sum = %d, date = %s  \n"
			//					  , order.getUserId(), order.getOrderId(), order.getGoodsCode(), 
			//					  order.getGoodsName(), order.getGoodsCount(), order.getGoodsSum(), order.getOrderDate());

			om.insertOrder(order); 

			CartUI.cartNum ++;
		}
		System.out.println("-----------------");
		System.out.println("주문 등록이 완료되었습니다.");
		System.out.println("-----------------");
		DeleteCartUI ui = new DeleteCartUI(cm,gm,om);
		ui.service();
	}
}



