package com.baoqilai.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_discount")
public class Discount {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime; 
	
	@Column(name = "discount_type")
	private Integer discountType;

	@Column(name = "discount_location")
	private Long discountLocation;

	@Column(name = "couponConfig_id")
	private Long couponConfigId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getDiscountLocation() {
		return discountLocation;
	}

	public void setDiscountLocation(Long discountLocation) {
		this.discountLocation = discountLocation;
	}

	public Integer getDiscountType() {
		return discountType;
	}

	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}

	public Long getCouponConfigId() {
		return couponConfigId;
	}

	public void setCouponConfigId(Long couponConfigId) {
		this.couponConfigId = couponConfigId;
	}
}
