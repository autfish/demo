package com.autfish.demo.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.validation.Valid;

import com.autfish.demo.domain.Goods;
import com.autfish.demo.service.GoodsService;
import com.autfish.demo.support.PagingList;
import com.autfish.demo.web.model.ErrorModel;
import com.autfish.demo.web.model.GoodsSearchModel;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 一个完整的增删改查示例
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="/list")
	public String listGoods(Model model, @ModelAttribute("goodsSearchModel") GoodsSearchModel formModel,
			@RequestParam(value=PagingList.PAGE_INDEX_NAME, defaultValue="1") int pageIndex,
			@RequestParam(value=PagingList.PAGE_SIZE_NAME, defaultValue="20") int pageSize) {

		int goodsId = 0;
		String goodsName = "";
		float fromPrice = -1;
		float toPrice = -1;
		if(formModel != null) {
			goodsId = NumberUtils.toInt(formModel.getId(), 0);
			goodsName = formModel.getName();
			fromPrice = NumberUtils.toFloat(formModel.getFromPrice(), -1);
			toPrice = NumberUtils.toFloat(formModel.getToPrice(), -1);
		}
		model.addAttribute("goodsSearchModel", formModel);
		PagingList<Goods> contentModel = this.goodsService.findGoods(goodsId, goodsName, fromPrice, toPrice, pageIndex, pageSize);
		model.addAttribute("contentModel", contentModel);

		return "goods/list";
	}
	
	@RequestMapping(value="/addOrUpdate", method = {RequestMethod.GET})
	public String toAddOrUpdate(Model model, @RequestParam(value="id", defaultValue="0") int goodsId) {
		
		if(goodsId > 0) {
			Goods goods = this.goodsService.getGoodsById(goodsId);
			if(goods != null) {
				model.addAttribute("goodsModel", goods);
			} else {
				ErrorModel errorModel = new ErrorModel();
				errorModel.setMessage("商品不存在或已下架");
				Hashtable<String, String> pages = new Hashtable<String, String>();
				pages.put("返回上一页", "javascript:history.back();");
				errorModel.setPages(pages);
				model.addAttribute("errorModel", errorModel);
				return "comm/error";
			}
		} else {
			model.addAttribute("goodsModel", new Goods());
		}
		return "goods/addOrUpdate";
	}
	
	@RequestMapping(value="/addOrUpdate", method = {RequestMethod.POST})
	public String addOrUpdate(Model model, @Valid @ModelAttribute("goodsModel") Goods goodsModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "goods/addOrUpdate";
		}
		
		int goodsId = goodsModel.getId();
		int result = 0;
		if(goodsId > 0) {
			result = this.goodsService.updateGoods(goodsModel);
		} else {
			result = this.goodsService.addGoods(goodsModel);
		}
		if(result > 0) {
			return listGoods(model, new GoodsSearchModel(), PagingList.DEFAULT_PAGE_INDEX, PagingList.DEFAULT_PAGE_SIZE);
		} else {
			ErrorModel errorModel = new ErrorModel();
			errorModel.setMessage("添加或修改失败");
			errorModel.setPage("返回上一页", "javascript:history.back();");
			errorModel.setPage("返回商品列表", "list");
			model.addAttribute("errorModel", errorModel);
			return "comm/error";
		}
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, String> delete(@RequestParam(value="id") int goodsId) throws IOException {
		int result = this.goodsService.deleteGoods(goodsId);
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("code", String.valueOf(result));
	    return map;
	}
	

}
