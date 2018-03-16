package kr.co.vitaherb.mapper;

import java.util.List;

import kr.co.vitaherb.domain.Order;

public interface OrderMapper {
	
	List<Order> selectOrder();
	Order selectOrderByNo(int no);
	void insertOrder(Order order);

}
