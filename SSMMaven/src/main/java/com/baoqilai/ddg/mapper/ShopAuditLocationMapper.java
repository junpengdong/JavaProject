package com.baoqilai.ddg.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopAuditLocationMapper {

	@Select(
			"<script>"+
			"SELECT s.id, s.shop_name shopName, s.mobile, s.old_location oldLocation, s.shop_old_address shopOldAddress, s.location, s.shop_address shopAddress, s.update_time updateTime FROM t_shop s"+
			" WHERE "+
			"s.location_audit_status=1"+
			"<if test='shopName != null'>AND `shop_name` like concat('%',#{shopName},'%')</if>"+
			"<if test='mobile != null'>AND `mobile` like concat('%',#{mobile},'%')</if>"+
			" limit #{page},#{pagesize}"+
			"</script>"
	)
	List<Map<String, Object>> findByAuditStatus(@Param("page") int page, @Param("pagesize") int pagesize, @Param("shopName") String shopName, @Param("mobile") String mobile);

	@Select(
			"<script>"+
			"SELECT count(*) sum FROM t_shop s"+
			" WHERE "+
			"s.location_audit_status=1"+
			"<if test='shopName != null'>AND `shop_name` like concat('%',#{shopName},'%')</if>"+
			"<if test='mobile != null'>AND `mobile` like concat('%',#{mobile},'%')</if>"+
			"</script>"
	)
	Map<String, Object> findShopAuditInfoCount(@Param("shopName")String shopName, @Param("mobile")String mobile);

	@Update("UPDATE t_shop SET location_audit_status=#{status} WHERE id=#{id}")
	void updateAuditStatus(@Param("status") Integer status, @Param("id") int id);

}
