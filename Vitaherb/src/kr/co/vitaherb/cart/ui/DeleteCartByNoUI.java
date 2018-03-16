package kr.co.vitaherb.cart.ui;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.mapper.CartMapper;

public class DeleteCartByNoUI extends kr.co.vitaherb.BaseUI {
	private CartMapper mapper;

	public DeleteCartByNoUI(CartMapper mapper) {
		this.mapper = mapper;
	}
	
	public void service() {
		int no = getInt("삭제할 번호를 입력하세요 : ");
		int result = mapper.deleteCartByNo(no);
		
		if (result == 0) {
			System.out.println(
				"입력하신 번호에 해당하는 장바구니 번호가 없습니다.");
			return;
		}
		System.out.println("해당하는 장바구니가 삭제되었습니다.");
	}
}



