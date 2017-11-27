package com.cdsf.background.greenpass.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cdsf.utils.Tools;

/**
 * 违规车信息
 * 
 * @author Michael
 *
 * 2017年6月12日
 *
 */
public class ViolationTruckInfo {
	
	private String flowId;//主键id
	private String truckPlate;//车牌号码
	private String illegalTime;//违规次数,这里用String类型居然这个框架会自动将数据库中返回的count值封装成String类型
	private Date auditTime;// 稽查时间
	private String auditTimestr;// 稽查时间的字符串展示
	private Long checkTimes;//稽查次数
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getTruckPlate() {
		return truckPlate;
	}
	public void setTruckPlate(String truckPlate) {
		this.truckPlate = truckPlate;
	}
	public String getIllegalTime() {
		return illegalTime;
	}
	public void setIllegalTime(String illegalTime) {
		this.illegalTime = illegalTime;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		if(Tools.isNotNull(auditTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			auditTimestr = sdf.format(auditTime);
		}
		this.auditTime = auditTime;
	}

	public String getAuditTimestr() {
		return auditTimestr;
	}

	public void setAuditTimestr(String auditTimestr) {
		
		this.auditTimestr = auditTimestr;
	}
	
	public Long getCheckTimes() {
		return checkTimes;
	}
	public void setCheckTimes(Long checkTimes) {
		this.checkTimes = checkTimes;
	}
	@Override
	public String toString() {
		return "ViolationTruckInfo [flowId=" + flowId + ", truckPlate=" + truckPlate + ", illegalTime=" + illegalTime
				+ ", auditTime=" + auditTime + ", auditTimestr=" + auditTimestr + ", checkTimes=" + checkTimes + "]";
	}
	
}
