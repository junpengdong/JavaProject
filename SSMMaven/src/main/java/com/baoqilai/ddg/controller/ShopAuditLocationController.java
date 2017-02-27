package com.baoqilai.ddg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoqilai.ddg.service.ShopAuditLocationService;
import com.baoqilai.utils.APIUtil;

/**
 * 商家地址修改审核
 * @author dongjunpeng
 * 2017-02-22 下午：15:47
 */
@Controller
@RequestMapping("/shopaudit")
public class ShopAuditLocationController {

	@Autowired
	private ShopAuditLocationService shopAuditLocationService;

	/**
	 * 获取商家列表信息
	 * @param page(页数)
	 * @param pagesize(每页显示数量)
	 * @param shopName(店铺名称)
	 * @param mobile(商家手机号)
	 * @return
	 */
	@RequestMapping(value = { "/infolist" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getData(@RequestParam("page") int page, @RequestParam("pagesize") int pagesize,
			@RequestParam(required = false, value = "shopName") String shopName,
			@RequestParam(required = false, value = "mobile") String mobile) {
		
		if (page == 1 || page == 0) {
			page = 0;
		} else {
			page = (page - 1) * pagesize;
		}
		Map<String, Object> countMap = shopAuditLocationService.findShopAuditInfoCount(shopName,mobile);
		List<Map<String, Object>> shopInfoList = shopAuditLocationService.findByAuditStatus(page, pagesize, shopName, mobile);
		return APIUtil.toMap("00200", true,shopInfoList, countMap);
	}

	/**
	 * 商家审核状态修改
	 * @param status(审核状态码)
	 * @param id(商家ID)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/audit" }, method = RequestMethod.POST)
	public Map<String, Object> shopAudit(@RequestParam("status")int status, @RequestParam("id")int id) {
		shopAuditLocationService.updateAuditStatus(status, id);
		return APIUtil.toMap("00200", true);
	}
}
