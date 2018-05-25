package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

/**
 * 商品查询
 * @author miping
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper mItemMapper;

	@Override
	public TbItem getItemById(Long itemId) {
		// TODO Auto-generated method stub
		TbItemExample example = new TbItemExample();
		Criteria criteria =example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = mItemMapper.selectByExample(example);
		//判断list中是否为空
		TbItem item = null;
		if (list!= null&& list.size()>0) {
			item = list.get(0);
		}
		return item;
	}

}
