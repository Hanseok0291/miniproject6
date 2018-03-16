package kr.co.vitaherb.cart.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.mapper.CartMapper;

public class ListCartUI extends BaseUI {
	private CartMapper mapper;

	public ListCartUI(CartMapper mapper) {
		this.mapper = mapper;
	}
	
	public void service() {
		List<Cart> list = mapper.selectCart();
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("-------------------------");
		System.out.println("번호\t이름\t상품\t개수\t금액");
		System.out.println("-------------------------");
		// 2018-02-28
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd"
		);
		for (Cart b : list) {
			System.out.printf(
				"%d\t%s\t%s\t%s\t%d\n", 
				b.getCartNo(), b.getUserId(), b.getGoodsName(), b.getGoodsCount(), b.getGoodsSum()
			);
		}
		if (list.isEmpty()) {
			System.out.println("장바구니에 내용이 존재하지 않습니다.");
		}
		System.out.println("-------------------------");
	}
}



