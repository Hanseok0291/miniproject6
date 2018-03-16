package kr.co.vitaherb.detailgoodsinfo.ui;

import common.db.BaseUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.ReviewMapper;

public class SearchGoodsInfoUI extends BaseUI {
	
    private GoodsMapper gm;
	
	public SearchGoodsInfoUI(GoodsMapper gm) {
		this.gm = gm;
	}

	public void service() {
		System.out.println("*************************");
		String goods = getStr("검색할 제품을 입력하세요 : ");
		
		MainServiceUI.g = gm.searchGoods(goods);
		
		DetailGoodsInfoUI ui = new DetailGoodsInfoUI();
		ui.service();
		
		
		
	}
}
