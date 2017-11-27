package com.cdsf.background.greenpass.domain;

import java.math.BigDecimal;
import java.util.List;

import com.cdsf.utils.Tools;

/**
 * @author Michael
 *
 *         2017年4月25日
 * 
 *         稽查结论
 */
public class AuditConclusion {

	private Integer currentStatus;// 运单当前的状态 0--待稽查,1--稽查完成,2稽查确认
	/**
	 * 运单主键
	 */
	private String waybillId;
	/**
	 * 结论语(存的是是key,多个用逗号分割)
	 */
	private String conclusionContentStr;
	/**
	 * 现场处理图片
	 */
	private List<AuditPicture> picList;

	private String flowId;// 主键id,UUID

	private List<String> conclusionContent;// 结论语

	private Integer conclusionType;// 结论状态(0---稽查不通过, 1---稽查通过);

	/*
	 * private String travelLicensePicPath;//保存行驶证的照片路径
	 * 
	 * private String drivingLicensePicPath;//保存驾驶证的照片路径
	 * 
	 * private String truckPlatePicPath;//车牌照片路径
	 * 
	 * private String truckFrontFacePicPath;//车前脸照片路径
	 * 
	 * private List<String> cargoPicPath;//货物图片路径,多张
	 * 
	 * private String picDirPath;//运单的图片文件夹路径,这个一般放在配置文件中
	 * //有个问题:是根据用户账号还是根据运单来生成图片文件夹的路径?
	 */
	private BigDecimal receivables;// 应收金额(单位:人民币 元)

	private BigDecimal punishableAccount;// 应罚金额(单位:人民币 元)

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public List<String> getConclusionContent() {
		return conclusionContent;
	}

	public void setConclusionContent(List<String> conclusionContent) {
		if(!Tools.isEmpty(conclusionContent)){
			StringBuilder sb= new StringBuilder();
			for(String cc:conclusionContent){
				if(Tools.isNotNull(sb.toString()))
				{
					sb.append(ConstansType.SPLIT_COMMA);
				}
				sb.append(cc);
			}
			this.conclusionContentStr=sb.toString();
		}
		this.conclusionContent = conclusionContent;
	}

	public Integer getConclusionType() {
		return conclusionType;
	}

	public void setConclusionType(Integer conclusionType) {
		this.conclusionType = conclusionType;
	}

	public BigDecimal getReceivables() {
		return receivables;
	}

	public void setReceivables(BigDecimal receivables) {
		this.receivables = receivables;
	}

	public BigDecimal getPunishableAccount() {
		return punishableAccount;
	}

	public void setPunishableAccount(BigDecimal punishableAccount) {
		this.punishableAccount = punishableAccount;
	}

	public List<AuditPicture> getPicList() {
		return picList;
	}

	public void setPicList(List<AuditPicture> picList) {
		this.picList = picList;
	}

	public String getConclusionContentStr() {
		return conclusionContentStr;
	}

	public void setConclusionContentStr(String conclusionContentStr) {
		this.conclusionContentStr = conclusionContentStr;
	}

	public String getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(String waybillId) {
		this.waybillId = waybillId;
	}

	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}

}
