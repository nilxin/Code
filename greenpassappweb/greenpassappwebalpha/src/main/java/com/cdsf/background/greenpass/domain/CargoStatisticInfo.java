package com.cdsf.background.greenpass.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cdsf.utils.Tools;

/**
 * 货品统计信息
 * @author Michael
 *
 * 2017年6月21日
 * 
 */
public class CargoStatisticInfo {
	
	private String flowId;//主键id
	private String wayBillNo;//运单号
	private Date auditTime;//稽查时间
	private String auditTimeStr;//稽查时间字符串显示
	private Integer auditExpressWay;//稽查高速线路
	private Integer auditStation;//稽查站点
	private String auditWorkNo;//稽查工号
	private String auditorId;//稽查人员id
	private String auditorName;//稽查人员姓名
	private String firstCargos;//货品的第一类
	private String secondCargos;//货品的第二类
	private String displayCargosName;//拼接的名字展示
	
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getWayBillNo() {
		return wayBillNo;
	}
	public void setWayBillNo(String wayBillNo) {
		this.wayBillNo = wayBillNo;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		if(Tools.isNotNull(auditTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			auditTimeStr = sdf.format(auditTime);
		}
		this.auditTime = auditTime;
	}
	public String getAuditTimeStr() {
		return auditTimeStr;
	}
	public void setAuditTimeStr(String auditTimeStr) {
		this.auditTimeStr = auditTimeStr;
	}
	public Integer getAuditExpressWay() {
		return auditExpressWay;
	}
	public void setAuditExpressWay(Integer auditExpressWay) {
		this.auditExpressWay = auditExpressWay;
	}
	public Integer getAuditStation() {
		return auditStation;
	}
	public void setAuditStation(Integer auditStation) {
		this.auditStation = auditStation;
	}
	public String getAuditWorkNo() {
		return auditWorkNo;
	}
	public void setAuditWorkNo(String auditWorkNo) {
		this.auditWorkNo = auditWorkNo;
	}
	public String getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public String getFirstCargos() {
		return firstCargos;
	}
	public void setFirstCargos(String firstCargos) {
		this.firstCargos = firstCargos;
	}
	public String getSecondCargos() {
		return secondCargos;
	}
	public void setSecondCargos(String secondCargos) {
		this.secondCargos = secondCargos;
	}
	public String getDisplayCargosName() {
		return displayCargosName;
	}
	public void setDisplayCargosName(String displayCargosName) {
		this.displayCargosName = displayCargosName;
	}
	@Override
	public String toString() {
		return "CargoStatisticInfo [flowId=" + flowId + ", wayBillNo=" + wayBillNo + ", auditTime=" + auditTime
				+ ", auditTimeStr=" + auditTimeStr + ", auditExpressWay=" + auditExpressWay + ", auditStation="
				+ auditStation + ", auditWorkNo=" + auditWorkNo + ", auditorId=" + auditorId + ", auditorName="
				+ auditorName + ", firstCargos=" + firstCargos + ", secondCargos=" + secondCargos
				+ ", displayCargosName=" + displayCargosName + "]";
	}
	
	
}
