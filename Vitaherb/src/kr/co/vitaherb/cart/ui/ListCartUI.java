package kr.co.vitaherb.cart.ui;

import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class ListCartUI extends BaseUI {
	private CartMapper cm;
	private GoodsMapper gm;
	private OrderMapper om;

	public static int[] sNo;

	public ListCartUI(CartMapper cm, GoodsMapper gm, OrderMapper om) {
		this.cm=cm;
		this.gm=gm;
		this.om=om;
	}

	public void service() {

		List<Cart> list = cm.selectCart(LoginViewUI.user.getUserId());

		sNo = new int[list.size()];
		for(int i = 0; i<list.size(); i++) {
			//			글넘버가 i+1일 때
			//			시퀀스는 n임
			int n = list.get(i).getCartNo();
			sNo[i] = n;
		}
		
		System.out.println(" ");
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("------------------------------");
		System.out.println("번호\t상품\t개수\t금액");
		System.out.println("------------------------------");
			

		if (list.isEmpty()) {
			System.out.println("장바구니가 비었습니다.");
		} else {
//			SimpleDateFormat sdf = new SimpleDateFormat(
//					"yyyy-MM-dd"
//					);
			
			int k = 1;
			for (Cart b : list) {
				System.out.printf(
						"%d\t%s\t%s\t%d\n", 
						k++,  
						b.getGoodsName(), 
						b.getGoodsCount(), 
						b.getGoodsSum()
						);
			}

		}


		System.out.println("------------------------------");

		

			

		CartUI ui = new CartUI(cm,om,gm);
		ui.service();

	
	}
} 



