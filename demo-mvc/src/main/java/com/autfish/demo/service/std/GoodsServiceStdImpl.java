package com.autfish.demo.service.std;

import java.util.List;

import com.autfish.demo.dao.DaoFactory;
import com.autfish.demo.domain.Goods;
import com.autfish.demo.service.GoodsService;
import com.autfish.demo.support.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsServiceStdImpl implements GoodsService {

	@Autowired
	private DaoFactory daoFactory;
	
	@Override
	@Transactional(readOnly=true)
	public Goods getGoodsById(int goodsId) {
		return this.daoFactory.getGoodsDao().getGoodsById(goodsId);
	}

	@Override
	@Transactional(readOnly=true)
	public PagingList<Goods> findGoods(int goodsId, String goodsName,
									   float fromPrice, float toPrice, int pageIndex, int pageSize) {
		int total = daoFactory.getGoodsDao().matches(goodsId, goodsName, fromPrice, toPrice);
		int pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		if(pageIndex > pageCount)
			pageIndex = pageCount;
		int fetchIndex = (pageIndex - 1) * pageSize;
		int fetchCount = fetchIndex + pageSize > total ? (total - fetchIndex) : pageSize;
		List<Goods> list = this.daoFactory.getGoodsDao().findGoods(goodsId, goodsName, fromPrice, toPrice, fetchIndex, fetchCount);
		PagingList<Goods> paging = new PagingList<Goods>();
		paging.setItemCount(total);
		paging.setPageCount(pageCount);
		paging.setPageIndex(pageIndex);
		paging.setPageSize(pageSize);
		paging.setItems(list);
		return paging;
	}

	@Override
	public int addGoods(Goods goods) {
		return this.daoFactory.getGoodsDao().addGoods(goods);
	}

	@Override
	public int updateGoods(Goods goods) {
		return this.daoFactory.getGoodsDao().updateGoods(goods);
	}

	@Override
	public int deleteGoods(int goodsId) {
		return this.daoFactory.getGoodsDao().deleteGoods(goodsId);
	}
}
