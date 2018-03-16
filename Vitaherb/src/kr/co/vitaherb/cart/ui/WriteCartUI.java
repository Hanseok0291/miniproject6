package kr.co.vitaherb.cart.ui;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.mapper.CartMapper;

public class WriteCartUI extends BaseUI {
	private CartMapper mapper;

	public WriteCartUI(CartMapper mapper) {
		this.mapper = mapper;
	}
	public void service() {
	
		CartUI.cartNum ++;
		Cart cartVO = new Cart();
		//cartVO.setCartNo(getInt("장바구니 번호를 입력하세요(숫자로) : ")); 
		cartVO.setCartNo(CartUI.cartNum); 
		cartVO.setUserId(getStr("User ID를 입력하세요(문자로) : "));
		cartVO.setGoodsCode(getInt("상품코드를 입력하세요(숫자로) : "));
		//cartVO.setGoodsName(goodsName); // edit here
		cartVO.setGoodsName("apple");
		cartVO.setGoodsCount(getInt("구매한 갯수를 입력하세요(숫자로) : "));
		cartVO.setGoodsSum(getInt("합계 금액을 입력하세요(숫자로) : "));
		
		System.out.println("User Id + Cart Number : "+cartVO.getUserId()+cartVO.getCartNo());
		mapper.insertCart(cartVO);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
}



