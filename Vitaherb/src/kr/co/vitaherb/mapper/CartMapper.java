package kr.co.vitaherb.mapper;

import java.util.List;

import kr.co.vitaherb.domain.Cart;

public interface CartMapper {
	List<Cart> selectCart();
	Cart selectCartByNo(int no);
	void insertCart(Cart cart);
	int updateCart(Cart cart);
	int deleteCartByNo(int no);
	int deleteCart();
}
