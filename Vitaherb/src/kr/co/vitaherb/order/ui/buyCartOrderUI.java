package kr.co.vitaherb.order.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.cart.ui.CartUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.domain.Order;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class buyCartOrderUI extends BaseUI {
	private CartMapper mapperCart;
	private OrderMapper mapperOrder;

	public buyCartOrderUI(OrderMapper mapper) {
		this.mapperOrder = mapper;
	}
	public buyCartOrderUI(CartMapper cm, OrderMapper om) {
		this.mapperCart = cm;
		this.mapperOrder = om;
	}
	public void service() {
	
		List<Cart> list = mapperCart.selectCart();
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("------------------------------------------------");
		System.out.println("번호\t이름\t상품\t개수\t금액");
		System.out.println("------------------------------------------------");

		Date curDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd"
		);
		
		int i = 0;
		for (Cart ca : list) {
			System.out.printf(
				"%d\t%s\t%s\t%s\t%d\t%d\n", 
				ca.getCartNo(), 
				ca.getUserId(), 
				ca.getGoodsCode(),  
				ca.getGoodsName(),
				ca.getGoodsCount(), 
				ca.getGoodsSum()
			);
			
			System.out.println("******* name "+ ca.getGoodsName());
			
			Order order = new Order();
			//order.setOrderId(i); 
			order.setUserId(ca.getUserId()); 
			order.setOrderDate(curDate);
			order.setGoodsCode(ca.getGoodsCode());
			order.setGoodsName(ca.getGoodsName());
			order.setGoodsCount(ca.getGoodsCount());
			order.setGoodsSum(ca.getGoodsSum());
			
			// System.currentTimeMillis();
			i++;
			//order.setOrderId(orderId);
			//order.setOrderId(orderId);
			System.out.println("Order @: " + order);
			System.out.printf(
					" UserId = %s, orderNumber = %d, Goods Code = %d,"
					+ " name = %s, count = %d, sum = %d, date = %s  \n"
					  , order.getUserId(), order.getOrderId(), order.getGoodsCode(), 
					  order.getGoodsName(), order.getGoodsCount(), order.getGoodsSum(), order.getOrderDate());
			
			
			mapperOrder.insertOrder(order); 

			CartUI.cartNum ++;


			System.out.println("주문 등록이 완료되었습니다.");
		}
	}
}


