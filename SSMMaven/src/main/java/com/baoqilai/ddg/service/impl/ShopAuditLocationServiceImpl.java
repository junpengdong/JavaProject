package com.baoqilai.ddg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baoqilai.ddg.mapper.ShopAuditLocationMapper;
import com.baoqilai.ddg.service.ShopAuditLocationService;

@Service
public class ShopAuditLocationServiceImpl implements ShopAuditLocationService{

	@Autowired
	private ShopAuditLocationMapper shopAuditLocationMapper;
	
	@Override
	public List<Map<String, Object>> findByAuditStatus(int page, int pageSize, String shopName, String telephone) {
		return shopAuditLocationMapper.findByAuditStatus(page, pageSize, shopName, telephone);
	}

	@Override
	public void updateAuditStatus(Integer status, int id) {
		shopAuditLocationMapper.updateAuditStatus(status, id);
	}

	@Override
	public Map<String, Object> findShopAuditInfoCount(String shopName, String mobile) {
		return shopAuditLocationMapper.findShopAuditInfoCount(shopName, mobile);
	}

}
