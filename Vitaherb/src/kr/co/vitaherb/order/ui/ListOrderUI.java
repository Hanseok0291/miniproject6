package kr.co.vitaherb.order.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Order;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class ListOrderUI extends BaseUI {
	private OrderMapper om;
	public ListOrderUI(OrderMapper om) {
		this.om = om;
	}

	public ListOrderUI(OrderMapper om, GoodsMapper gm) {
		this.om = om;		
	}

	public void service() {
		List<Order> list = om.selectOrder(); 
		//System.out.printf("전체 %d개\n", list.size());
		System.out.println(" ");
		System.out.println("------------------------------------------------------");
		System.out.println("목록번호\t주문날짜\t\t주문상품\t\t주문개수\t주문금액");
		System.out.println("------------------------------------------------------");
		// 2018-02-28
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd"
				);
		int sumOfOrder = 0;
		int i = 0;
		for (Order b : list) {
			++i;
			//			if(b.getUserId().equalsIgnoreCase(userId)){
			//			if(b.getUserId().equalsIgnoreCase("kim1")){
			if(b.getUserId().equalsIgnoreCase(LoginViewUI.user.getUserId())){
				System.out.printf(
						"%d\t%s\t%s\t\t%s\t%d\n", 
//						b.getOrderId(), 
						i,
						sdf.format(b.getOrderDate()),
						b.getGoodsName(),
						b.getGoodsCount(),
						b.getGoodsSum()
						);
				sumOfOrder += b.getGoodsSum();
			}
		}

		if (list.isEmpty()) {
			System.out.println("주문 내역이 존재하지 않습니다.");
		}
		System.out.println("------------------------------------------------------");
		System.out.printf("\t\t 현재 구매 총액은 %d 입니다.\n", sumOfOrder);
		System.out.println("------------------------------------------------------");
	}
}



