package kr.co.vitaherb.mapper;

import java.util.List;

import kr.co.vitaherb.domain.Cart;

public interface CartMapper {
	
	
	
	Cart getSnoCart(int sNo);
	
	
	
	
	List<Cart> selectCart(String id);
	Cart selectCartByNo(int no);
	void insertCart(Cart cart);
	int updateCart(Cart cart);
	int deleteCartByNo(int no);
	int deleteCart();
	int deleteCartByCode(int code);
}
