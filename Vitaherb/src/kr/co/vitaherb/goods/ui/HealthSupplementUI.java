package kr.co.vitaherb.goods.ui;

import java.util.List;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.detailgoodsinfo.ui.DetailGoodsInfoUI;
import kr.co.vitaherb.domain.Goods;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.GoodsMapper;
import kr.co.vitaherb.mapper.ReviewMapper;

public class HealthSupplementUI extends BaseUI {

	private ReviewMapper rm;
	private GoodsMapper gm;
	
	public HealthSupplementUI(GoodsMapper gm) {
		this.gm = gm;
	}
	
	public void service() {
		List<Goods> list = gm.selectHealthSup();
		
		System.out.println("*********************");
		System.out.println("1. 건강보조식품");
		System.out.println("*********************");
		System.out.println("상품번호\t상품명\t가격");
		
		for (Goods goods : list) {
			System.out.printf(
				"%d\t%s\t%d\n", 
				goods.getGoodsNo(), goods.getGoodsName(), goods.getGoodsPrice() 
			);
		}
		
		int gNo = getInt("상세조회할 상품번호를 선택하세요 : ");
		
		MainServiceUI.g = gm.getDetailGoods1(gNo);

		
		DetailGoodsInfoUI ui = new DetailGoodsInfoUI();
		ui.service();
		
	}
	
}
