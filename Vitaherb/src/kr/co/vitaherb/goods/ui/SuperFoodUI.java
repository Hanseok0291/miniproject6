package kr.co.vitaherb.goods.ui;

import common.db.BaseUI;
import kr.co.vitaherb.mapper.GoodsMapper;

public class SuperFoodUI extends BaseUI {
	
	private GoodsMapper gm;
	
	public SuperFoodUI(GoodsMapper gm) {
		this.gm = gm;
	}
	public void service() {
		System.out.println("2. 슈퍼푸드");
		System.out.println("*********************");
		System.out.println("상품번호\t상품명\t가격");
		
		getInt("상세조회할 상품번호를 선택하세요 : ");
	}
}
