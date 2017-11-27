package com.cdsf.background.greenpass.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cdsf.utils.Tools;

/**
 * 稽查时段的统计信息
 * 
 * @author Michael
 *
 * 2017年7月5日
 *
 */
public class AuditTimeStatisticInfo {
	
	private Date auditTime;//稽查时间
	private String auditTimeStr;//稽查时间字符串
	private Integer passTimes;//稽查通行次数
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		if(Tools.isNotNull(auditTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
	public Integer getPassTimes() {
		return passTimes;
	}
	public void setPassTimes(Integer passTimes) {
		this.passTimes = passTimes;
	}
	@Override
	public String toString() {
		return "AuditTimeStatisticInfo [auditTime=" + auditTime + ", auditTimeStr=" + auditTimeStr + ", passTimes="
				+ passTimes + "]";
	}
	
}
