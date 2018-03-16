package kr.co.vitaherb.cart.ui;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.OrderMapper;

public class WriteCartUIByUser extends BaseUI {
	private CartMapper mapper;

	public WriteCartUIByUser() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		this.mapper = session.getMapper(CartMapper.class);
	}
	
	public WriteCartUIByUser(CartMapper mapper) {
		this.mapper = mapper;
	}
	public void service() {
	
		CartUI.cartNum ++;
		Cart cartVO = new Cart();

		cartVO.setUserId(LoginViewUI.user.getUserId()); 
		cartVO.setGoodsCode(MainServiceUI.g.getGoodsCode());
		//cartVO.setGoodsName(goodsName); // edit here MainServiceUI.g
		cartVO.setGoodsName(MainServiceUI.g.getGoodsName());
		
		int cnt = getInt("구매할 갯수를 입력하세요(숫자로) : ");
		//cartVO.setGoodsCount(getInt("구매할 갯수를 입력하세요(숫자로) : "));
		cartVO.setGoodsCount(cnt);
		cartVO.setGoodsSum(cnt * MainServiceUI.g.getGoodsPrice());
		
//		System.out.printf("User Id: %s, CartNo: %d, cnt=%d, price=%d \n", 
//				cartVO.getUserId(), cartVO.getCartNo(), cnt, MainServiceUI.g.getGoodsPrice());
		mapper.insertCart(cartVO);
		System.out.println("장바구니 담기가 완료되었습니다.");
	}
}



