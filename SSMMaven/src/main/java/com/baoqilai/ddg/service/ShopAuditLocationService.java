package com.baoqilai.ddg.service;

import java.util.List;
import java.util.Map;

public interface ShopAuditLocationService {

	public List<Map<String, Object>> findByAuditStatus(int page, int pageSize, String shopName, String telephone);
	
	public Map<String, Object> findShopAuditInfoCount(String shopName, String mobile);
	
	public void updateAuditStatus(Integer status, int id);
}
