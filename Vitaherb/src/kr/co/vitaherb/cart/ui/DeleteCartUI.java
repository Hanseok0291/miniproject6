package kr.co.vitaherb.cart.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.mapper.CartMapper;

public class DeleteCartUI extends kr.co.vitaherb.BaseUI {
	private CartMapper mapper;

	public DeleteCartUI(CartMapper mapper) {
		this.mapper = mapper;
	}
	
	public void service() {
		int no = getInt("삭제할 번호를 입력하세요 : ");
		int result = mapper.deleteCart(no);
		if (result == 0) {
			System.out.println(
				"장바구니에 아무것도 없습니다.");
			return;
		}
		System.out.println("장바구니를 비웠습니다.");
		System.out.println("-------------------------");
		
		
	}
}



