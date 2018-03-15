package kr.co.vitaherb.goods.ui;

import common.db.BaseUI;
import kr.co.vitaherb.mapper.GoodsMapper;

public class PetSupplementUI extends BaseUI  {
	
	private GoodsMapper gm;
	
	public PetSupplementUI(GoodsMapper gm) {
		this.gm = gm;
	}
	public void service() {
		System.out.println("2. 반려동물영양제");
		System.out.println("*********************");
		System.out.println("상품번호\t상품명\t가격");
		
		getInt("상세조회할 상품번호를 선택하세요 : ");
}
}
