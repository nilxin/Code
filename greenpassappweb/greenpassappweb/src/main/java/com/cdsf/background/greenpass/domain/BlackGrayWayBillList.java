package com.cdsf.background.greenpass.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cdsf.utils.Tools;

/**
 * 黑名单数据问题
 * 
 * @author Michael
 *
 * 2017年6月27日
 *
 */
public class BlackGrayWayBillList {
	
	private String flowId;//主键id
	private String truckPlate;//车牌号
	private Date illegalTime;//假冒通行时间
	private String illegalTimeStr;//假冒通行时间字符串
	private BigDecimal illegalMoney;//增收金额  (应收 + 追缴)
	private BigDecimal receivableMoney;//应收金额
	private BigDecimal pursueMoney;//追缴金额
	private Integer axis;//轴数
	private String auditorId;//稽查人员
	private Integer auditStation;// 稽查站点,根据数据库的码表来对应 
	private String doubleCheckAuditorId;//复核人员id
	private String wayBillId;//运单id
	private Date joinTime;//加入黑名单时间
	private String joinTimeStr;//加入黑名单时间字符串
	
	// 车型,颜色,常规线路,逃费方式,汽车品牌,查处情况  暂时不添加,因为是针对绿通车,很多数据收集不了,黑名单车辆的画像后续处理
	
	
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
	public Date getIllegalTime() {
		return illegalTime;
	}
	public void setIllegalTime(Date illegalTime) {
		if(Tools.isNotNull(illegalTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			illegalTimeStr = sdf.format(illegalTime);
		}
		this.illegalTime = illegalTime;
	}
	public BigDecimal getIllegalMoney() {
		return illegalMoney;
	}
	public void setIllegalMoney(BigDecimal illegalMoney) {
		this.illegalMoney = illegalMoney;
	}
	public BigDecimal getReceivableMoney() {
		return receivableMoney;
	}
	public void setReceivableMoney(BigDecimal receivableMoney) {
		this.receivableMoney = receivableMoney;
	}
	public BigDecimal getPursueMoney() {
		return pursueMoney;
	}
	public void setPursueMoney(BigDecimal pursueMoney) {
		this.pursueMoney = pursueMoney;
	}
	public Integer getAxis() {
		return axis;
	}
	public void setAxis(Integer axis) {
		this.axis = axis;
	}
	public String getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	public Integer getAuditStation() {
		return auditStation;
	}
	public void setAuditStation(Integer auditStation) {
		this.auditStation = auditStation;
	}
	public String getDoubleCheckAuditorId() {
		return doubleCheckAuditorId;
	}
	public void setDoubleCheckAuditorId(String doubleCheckAuditorId) {
		this.doubleCheckAuditorId = doubleCheckAuditorId;
	}
	public String getWayBillId() {
		return wayBillId;
	}
	public void setWayBillId(String wayBillId) {
		this.wayBillId = wayBillId;
	}
	public String getIllegalTimeStr() {
		return illegalTimeStr;
	}
	public void setIllegalTimeStr(String illegalTimeStr) {
		this.illegalTimeStr = illegalTimeStr;
	}
	public Date getJionTime() {
		return joinTime;
	}
	public void setJionTime(Date joinTime) {
		if(Tools.isNotNull(joinTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			joinTimeStr = sdf.format(joinTime);
		}
		this.joinTime = joinTime;
	}
	public String getJionTimeStr() {
		return joinTimeStr;
	}
	public void setJionTimeStr(String joinTimeStr) {
		this.joinTimeStr = joinTimeStr;
	}
	@Override
	public String toString() {
		return "BlackGrayWayBillList [flowId=" + flowId + ", truckPlate=" + truckPlate + ", illegalTime=" + illegalTime
				+ ", illegalMoney=" + illegalMoney + ", receivableMoney=" + receivableMoney + ", pursueMoney="
				+ pursueMoney + ", axis=" + axis + ", auditorId=" + auditorId + ", auditStation=" + auditStation + "]";
	}
	
}
