package com.cdsf.background.greenpass.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.cdsf.utils.FileUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 打逃信息
 * @author Michael
 *
 * 2017年6月13日
 *
 */
public class FightEscapeInfo extends WorkWayBill{
	
	private String flowId; 
	private BigDecimal fightEscapCost; //打逃金额
	private Long fightEscapeTimes;//打逃次数
	private String auditWorkNo; //稽查工号
	private String auditorId;//稽查人员id
	private String auditorName;//稽查人员姓名
	private String cargos;//货品类
	private String conclusionContentStr;//稽查结论语,这里不拼成加百分比
	private String conclusionContent;//数据库查出的结论语是key值,多个用逗号分开的
	private String auditConclusionFlowId;//稽查结论的主键id
	private String displayCargosName;//拼接的名字展示
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getAuditWorkNo() {
		return auditWorkNo;
	}
	public void setAuditWorkNo(String auditWorkNo) {
		this.auditWorkNo = auditWorkNo;
	}
	public BigDecimal getFightEscapCost() {
		return fightEscapCost;
	}
	public void setFightEscapCost(BigDecimal fightEscapCost) {
		this.fightEscapCost = fightEscapCost;
	}
	public Long getFightEscapeTimes() {
		return fightEscapeTimes;
	}
	public void setFightEscapeTimes(Long fightEscapeTimes) {
		this.fightEscapeTimes = fightEscapeTimes;
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
	public String getConclusionContentStr() {
		return conclusionContentStr;
	}
	public void setConclusionContentStr(String conclusionContentStr) {
		this.conclusionContentStr = conclusionContentStr;
	}
	public String getConclusionContent() {
		return conclusionContent;
	}
	public void setConclusionContent(String conclusionContent) {
		String jsonStr = FileUtil.getJsonStr("conclusionType.json");
		JSONArray fromObjectArr = JSONArray.fromObject(jsonStr);
		Map<String,Object> res = new HashMap<String, Object>();
		for (int i = 0; i < fromObjectArr.size(); i++) {
			JSONObject jsonObj = JSONObject.fromObject(fromObjectArr.get(i));
			res.put(jsonObj.getString("id"), jsonObj.getString("text"));
		}
		if("1".equals(conclusionContent)){
			conclusionContentStr = res.get("1").toString();
		}else if("2".equals(conclusionContent)){
			conclusionContentStr = res.get("2").toString();
		}else if("3".equals(conclusionContent)){
			conclusionContentStr = res.get("3").toString();
		}else{
			conclusionContentStr ="";
		}
		this.conclusionContent = conclusionContent;
	}
	public String getAuditConclusionFlowId() {
		return auditConclusionFlowId;
	}
	public void setAuditConclusionFlowId(String auditConclusionFlowId) {
		this.auditConclusionFlowId = auditConclusionFlowId;
	}
	public String getCargos() {
		return cargos;
	}
	public void setCargos(String cargos) {
		this.cargos = cargos;
	}
	public String getDisplayCargosName() {
		return displayCargosName;
	}
	public void setDisplayCargosName(String displayCargosName) {
		this.displayCargosName = displayCargosName;
	}
	@Override
	public String toString() {
		return "FightEscapeInfo [flowId=" + flowId + ", auditWorkNo=" + auditWorkNo + ", fightEscapCost="
				+ fightEscapCost + ", fightEscapeTimes=" + fightEscapeTimes + ", auditorId=" + auditorId
				+ ", auditorName=" + auditorName + "]";
	}
	
}
