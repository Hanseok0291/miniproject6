package kr.co.vitaherb.orderhistory.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.co.vitaherb.BaseUI;
import common.db.MyAppSqlConfig;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;
import kr.co.vitaherb.order.ui.ListOrderUI;
import kr.co.vitaherb.cart.ui.ListCartUI;


public class OrderHistoryUI extends BaseUI {

	private OrderMapper mapperOrder;
	private GoodsMapper mapperGoods;
	private Scanner sc = new Scanner(System.in);
	public static int orderNum ;

	public OrderHistoryUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapperOrder = session.getMapper(OrderMapper.class);
	}
	
	public OrderHistoryUI(OrderMapper mapper) {
		this.mapperOrder = mapper;
	}
	
	public OrderHistoryUI(OrderMapper om, GoodsMapper gm) {
		this.mapperOrder = om;
		this.mapperGoods = gm;
	}
	
	public void service() {
		
//		BaseUI ui = new ListOrderUI(mapperOrder); 
		BaseUI ui2 = new ListOrderUI(mapperOrder, mapperGoods); 
		ui2.service(); 
		System.out.println("주문조회에서 나갑니다.");
	
	}

}
