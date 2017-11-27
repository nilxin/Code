package com.cdsf.background.privilege.domain;

import java.util.Date;

/**
 * 
 * @author Michael
 *
 * 2017年6月1日
 *
 */
public class User {

	private String flowId;//主键id
	private String loginName;//登录名
	private String passWrod;//登录密码
	private String trueName;//真实姓名
	private Integer gender;//性别
	private Integer age;//年龄
	private Date hireDate;//入职日期
	private String workNo;//工号
	private Integer stationId;//所属站点
	private Integer expressWayId;//所属高速
	private Integer groupId;//所属班级:ABCD
	
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassWrod() {
		return passWrod;
	}
	public void setPassWrod(String passWrod) {
		this.passWrod = passWrod;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public Integer getExpressWayId() {
		return expressWayId;
	}
	public void setExpressWayId(Integer expressWayId) {
		this.expressWayId = expressWayId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
}
