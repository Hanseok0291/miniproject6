package kr.co.vitaherb.cart.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.Cart;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.CartMapper;

public class WriteCartUIByUser extends BaseUI {
	private CartMapper cm;

	public WriteCartUIByUser() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		this.cm = session.getMapper(CartMapper.class);
	}

	public WriteCartUIByUser(CartMapper cm) {
		this.cm = cm;
	}
	public void service() {

		CartUI.cartNum ++;
		
		Cart cartVO = new Cart();
		
		System.out.println(" ");
		cartVO.setUserId(LoginViewUI.user.getUserId()); 
		cartVO.setGoodsCode(MainServiceUI.g.getGoodsCode());
		
		int cnt = getInt("구매할 개수를 입력하세요 : ");
		cartVO.setGoodsCount(cnt);
		
		List<Cart> list = cm.selectCart(LoginViewUI.user.getUserId());
		
		if(list.size()==0) {
			cartVO.setGoodsCount(cnt);
			cartVO.setGoodsSum(cnt * MainServiceUI.g.getGoodsPrice());
		}
		
		for(Cart c : list) { 
			if(c.getGoodsCode() == MainServiceUI.g.getGoodsCode()) {
				cartVO.setGoodsCount(c.getGoodsCount()+cnt);
				cartVO.setGoodsSum((c.getGoodsCount()+cnt) * MainServiceUI.g.getGoodsPrice());
				cm.deleteCartByCode(MainServiceUI.g.getGoodsCode());
			}else{
				cartVO.setGoodsCount(cnt);
				cartVO.setGoodsSum(cnt * MainServiceUI.g.getGoodsPrice());
			}
		} 



		//cartVO.setGoodsName(goodsName); // edit here MainServiceUI.g

		cartVO.setGoodsName(MainServiceUI.g.getGoodsName());


		//		System.out.printf("User Id: %s, CartNo: %d, cnt=%d, price=%d \n", 
		//				cartVO.getUserId(), cartVO.getCartNo(), cnt, MainServiceUI.g.getGoodsPrice());
		cm.insertCart(cartVO);
		System.out.println("-----------------------");
		System.out.println("장바구니 담기가 완료되었습니다.");
		System.out.println("-----------------------");
	}
}



