package kr.co.vitaherb.goods.ui;

import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.detailgoodsinfo.ui.DetailGoodsInfoUI;
import kr.co.vitaherb.domain.Goods;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.ReviewMapper;

public class SuperFoodUI extends BaseUI {
	
	Goods g;
	private ReviewMapper rm;
	private GoodsMapper gm;
	
	public SuperFoodUI(GoodsMapper gm) {
		this.gm = gm;
	}
	public void service() {
		List<Goods> list = gm.selectSuperFood();
		System.out.println("*********************");
		System.out.println("2. 슈퍼푸드");
		System.out.println("*********************");
		System.out.println("상품번호\t상품명\t가격");
		
		for (Goods g : list) {
			System.out.printf(
				"%d\t%s\t%d\n", 
				g.getGoodsNo(), g.getGoodsName(), g.getGoodsPrice() 
			);
		}
		
		int gNo = getInt("상세조회할 상품번호를 선택하세요 : ");
MainServiceUI.g = gm.getDetailGoods2(gNo);
		
DetailGoodsInfoUI ui = new DetailGoodsInfoUI();
ui.service();
	}
}
