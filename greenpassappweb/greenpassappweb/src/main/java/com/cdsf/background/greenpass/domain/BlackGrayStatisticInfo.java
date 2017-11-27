package com.cdsf.background.greenpass.domain;

import java.math.BigDecimal;

/**
 * 黑灰名单统计信息
 * 
 * @author Michael
 *
 * 2017年6月30日
 *
 */
public class BlackGrayStatisticInfo {
	
	private Integer illegalTimes;//违规次数
	private BigDecimal illegalMoney;//违规金额
	private String truckPlate;//车牌号
	public Integer getIllegalTimes() {
		return illegalTimes;
	}
	public void setIllegalTimes(Integer illegalTimes) {
		this.illegalTimes = illegalTimes;
	}
	public BigDecimal getIllegalMoney() {
		return illegalMoney;
	}
	public void setIllegalMoney(BigDecimal illegalMoney) {
		this.illegalMoney = illegalMoney;
	}
	public String getTruckPlate() {
		return truckPlate;
	}
	public void setTruckPlate(String truckPlate) {
		this.truckPlate = truckPlate;
	}
	@Override
	public String toString() {
		return "BlackGrayStatisticInfo [illegalTimes=" + illegalTimes + ", illegalMoney=" + illegalMoney
				+ ", truckPlate=" + truckPlate + "]";
	}
	
}
