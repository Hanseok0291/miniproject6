package kr.co.vitaherb.cart.ui;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.CartMapper;

public class WriteCartUI extends BaseUI {
	private CartMapper cm;

	public WriteCartUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		cm = session.getMapper(CartMapper.class);
	}
	public void service() {

		CartUI.cartNum ++;
		Cart cartVO = new Cart();
		// cartVO.setCartNo(getInt("장바구니 번호를 입력하세요(숫자로) : ")); 
		// cartVO.setCartNo(CartUI.cartNum);  // nextval 자동으로 입력 
		cartVO.setCartNo(CartUI.cartNum); 
		// cartVO.setUserId(getStr("User ID를 입력하세요(문자로) : "));
		cartVO.setUserId(LoginViewUI.user.getUserId()); 

		cartVO.setGoodsCode(getInt("상품번호를 입력하세요(숫자로) : "));
		//cartVO.setGoodsName(goodsName); // edit here MainServiceUI.g
		cartVO.setGoodsName(MainServiceUI.g.getGoodsName());
		cartVO.setGoodsCount(getInt("구매한 갯수를 입력하세요(숫자로) : "));
		cartVO.setGoodsSum(getInt("합계 금액을 입력하세요(숫자로) : "));

		System.out.println("User Id + Cart Number : "+cartVO.getUserId()+cartVO.getCartNo());
		cm.insertCart(cartVO);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
}



