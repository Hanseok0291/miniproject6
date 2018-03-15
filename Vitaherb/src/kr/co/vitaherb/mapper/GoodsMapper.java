package kr.co.vitaherb.mapper;

import java.util.List;
import kr.co.vitaherb.domain.Goods;

public interface GoodsMapper {
	
	List<Goods> selectHealthSup();
	List<Goods> selectSuperFood();
	List<Goods> selectselectPetSup();
}
