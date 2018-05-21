package com.autfish.demo.service;


import com.autfish.demo.domain.Goods;
import com.autfish.demo.support.PagingList;

public interface GoodsService {

	Goods getGoodsById(int goodsId);
	
	PagingList<Goods> findGoods(int goodsId, String goodsName, float fromPrice, float toPrice, int pageIndex, int pageSize);
	
	int addGoods(Goods goods);
	
	int updateGoods(Goods goods);
	
	int deleteGoods(int goodsId);
}
