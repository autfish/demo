package com.autfish.demo.dao;

import com.autfish.demo.domain.Goods;

import java.util.List;

public interface GoodsDao {

	int matches(int goodsId, String goodsName, float fromPrice, float toPrice);
	
	Goods getGoodsById(int goodsId);
	
	List<Goods> findGoods(int goodsId, String goodsName, float fromPrice, float toPrice, int fetchIndex, int fetchCount);
	
	int addGoods(Goods goods);
	
	int updateGoods(Goods goods);
	
	int deleteGoods(int goodsId);
	
	//for test
	void createTable();
	
	//for test
	void dropTable();
	
	//for test
	void createIdTable();
	
	//for test
	void addRandomGoods();
	
	//for test
	void deleteAll();
}
