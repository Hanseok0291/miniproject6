package kr.co.vitaherb.orderhistory.ui;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.OrderMapper;
import kr.co.vitaherb.order.ui.ListOrderUI;


public class OrderHistoryUI extends BaseUI {

	private OrderMapper mapperOrder;
	private GoodsMapper mapperGoods;
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
		int menu = getInt("0.쇼핑계속하기");
		if(menu==1) {
			System.out.println("주문조회에서 나갑니다.");
			MainServiceUI ui = new MainServiceUI();
			ui.service();
		}

	}

}
