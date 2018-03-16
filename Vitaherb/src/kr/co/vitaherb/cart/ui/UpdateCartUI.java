package kr.co.vitaherb.cart.ui;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.mapper.CartMapper;

public class UpdateCartUI extends BaseUI {
	private CartMapper mapper;

	public UpdateCartUI(CartMapper mapper) {
		this.mapper = mapper;
	}
	
	public void service() {
		Cart cart = new Cart();
		cart.setCartNo(getInt("수정할 장바구니 번호를 입력하세요 : "));
		cart.setGoodsCount(getInt("변경할 상품의 갯수를 입력하세요 : "));

		int result = mapper.updateCart(cart);  
		if (result == 0) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.println("장바구니가 수정되었습니다.");
		}
	}
}



