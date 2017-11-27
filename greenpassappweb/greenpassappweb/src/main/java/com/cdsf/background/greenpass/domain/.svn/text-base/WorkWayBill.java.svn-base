package com.cdsf.background.greenpass.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * 工作人员端：运单对象
 * 
 * @author Administrator
 *
 */
public class WorkWayBill extends WayBill {
	private BigDecimal receivables;// 应收金额(单位:人民币 元)

	private BigDecimal punishableAccount;// 应罚金额(单位:人民币 元)

	private String conclusionContent;// 结论语
	/**
	 * 现场处理图片
	 */
	private List<String> auditConclusionUrlList;
	/**
	 * 运单的图片
	 */
	private List<AuditPicture> picList;
	/**
	 * 稽查结论
	 */
	private AuditConclusion auditConclusion;
	
	/**
	 * 员工工号和姓名展示   xxx名字(xxx工号) trueName+(loginName)
	 */
	private String displayName;
	
	/**
	 * 工作人员的登录名称
	 */
	private String workLoginName;
	
	/**
	 * 工作人员真实名称
	 */
	private String workTrueName;
	
	public List<AuditPicture> getPicList() {
		return picList;
	}

	public void setPicList(List<AuditPicture> picList) {
		this.picList = picList;
	}

	public AuditConclusion getAuditConclusion() {
		return auditConclusion;
	}

	public void setAuditConclusion(AuditConclusion auditConclusion) {
		this.auditConclusion = auditConclusion;
	}

	public BigDecimal getReceivables() {
		return receivables;
	}

	public BigDecimal getPunishableAccount() {
		return punishableAccount;
	}

	public List<String> getAuditConclusionUrlList() {
		return auditConclusionUrlList;
	}

	public void setReceivables(BigDecimal receivables) {
		this.receivables = receivables;
	}

	public void setPunishableAccount(BigDecimal punishableAccount) {
		this.punishableAccount = punishableAccount;
	}

	public void setAuditConclusionUrlList(List<String> auditConclusionUrlList) {
		this.auditConclusionUrlList = auditConclusionUrlList;
	}

	public String getConclusionContent() {
		return conclusionContent;
	}

	public void setConclusionContent(String conclusionContent) {
		this.conclusionContent = conclusionContent;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getWorkLoginName() {
		return workLoginName;
	}

	public void setWorkLoginName(String workLoginName) {
		this.workLoginName = workLoginName;
	}

	public String getWorkTrueName() {
		return workTrueName;
	}

	public void setWorkTrueName(String workTrueName) {
		this.workTrueName = workTrueName;
	}
	
	
}
