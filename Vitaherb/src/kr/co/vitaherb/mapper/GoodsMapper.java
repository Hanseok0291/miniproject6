package kr.co.vitaherb.mapper;

import java.util.List;

import kr.co.vitaherb.domain.Goods;

public interface GoodsMapper {

	List<Goods> selectHealthSup();
	List<Goods> selectSuperFood();
	List<Goods> selectPetSup();

	Goods SearchDetailGoods(String goods);

	Goods toDetailGoods(int gNo);

	Goods getDetailGoods1(int gNo);
	Goods getDetailGoods2(int gNo);
	Goods getDetailGoods3(int gNo);

	Goods searchGoods(String goods);
}
