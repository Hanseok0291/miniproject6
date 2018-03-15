package kr.co.vitaherb.goods.ui;

import common.db.BaseUI;
import kr.co.vitaherb.mapper.GoodsMapper;

public class HealthSupplementUI extends BaseUI {

	private GoodsMapper gm;
	
	public HealthSupplementUI(GoodsMapper goodsmap) {
		this.gm = gm;
	}
	
	public void service() {
		
		System.out.println("1. 건강보조식품");
		System.out.println("*********************");
		System.out.println("상품번호\t상품명\t가격");
		
		getInt("상세조회할 상품번호를 선택하세요 : ");
		
	}
	
}
