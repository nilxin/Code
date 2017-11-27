package com.cdsf.background.greenpass.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cdsf.utils.Tools;


public class WayBill {
	/**
	 * 行驶证
	 */
	private String travelCardUrl;
	/**
	 * 驾驶证
	 */
	private String driveCardUrl;
	/**
	 * 车牌号照片
	 */
	private String carPlateUrl;
	/**
	 * 物品（多张）
	 */
	private List<String> goodsList;
	/**
	 * 车前脸
	 */
	private String carFrontFaceUrl;
	/**
	 * 稽查人员工号
	 */
	private String checkJobNum;
	private String auditConclusionStatusStr;// 稽查结论状态字符串(0--补缴逃费,1--合格放行)
	/**
	 * 运货类型（字符串，多个用、分割）
	 */
	private String goodsType;
	/**
	 * 通过次数
	 */
	private int passNum;
	/**
	 * 未通过次数
	 */
	private int noPassNum;

	private String id;// 主键Id

	private String wayBillNo;// 运单编号

	private String wayBillName;// 运单名称

	private Date createTime;// 创建时间
	private String createTimeStr;// 创建时间字符串

	private Integer currentStatus;// 运单当前的状态 0--待稽查,1--稽查完成,2稽查确认

	private String greenTruckPlate;// 车牌号

	private String greenTruckType;// 绿通车类型

	private Date auditTime;// 稽查时间
	private String auditTimestr;// 稽查时间的字符串展示

	private Integer auditStation;// 稽查站点,根据数据库的码表来对应

	private Integer auditExpressWay;// 稽查高速

	private String currentDriverId;// 当次运单关联的司机的id
	private String currentDriverName;// 当前司机的姓名

	private String currentPhoneNo;// 当前司机的手机号码

	private String currentAuditorId;// 当前稽查人员的Id：t_user表主键

	// private Integer freshType;//鲜活品类型,后面计划设计成一个树形结构

	private Integer auditConclusionStatus;// 稽查结论状态(0--未通过,补缴逃费 1--放行)

	private String currentMass;// 本次载重(单位:吨)

	private String doubleCheckAuditorId;// 稽查复核人员id：t_user表主键

	private String doubleCheckEvaluate;// 稽查复核评价

	private Integer doubleCheckStatus = 0;// 稽查复核状态(0--未复核,1---复核通过,2---复核未通过)

	private String auditConclusionFlowId;// 稽查结论id

	private String firstCargos;// 一级货物分级(多选)

	private String secondCargos;// 二级货物分级(多选)

	private String driverWriteCargos;// 记录司机选中填写的货品分类(多选),这个后面可以利用大数据统计来看司机的乱填比率
	
	private String driverWriteMass;//记录司机端填写的载重

	// ====================便于具体业务简单操作:在订单中添加车牌号和车辆识别号============

	private String vehicleIdentificationNo;// 车辆识别号
	
	// =====add=============添加过期时间=============================
	private Date overDueTime;
	private String overDueTimeStr;//过期失效时间,计算得出返回字符串给用户
	
	// ======add============添加一个逻辑删除的标识===运单数据用于后期统计=======
//	private Integer deleteFlag = 0;// 0-->表示未删除     1-->表示删除
	
	// ======add========由于运单不能确定当前司机是谁,所以想添加一个运单生成人这个userId,由于存在司机不添加绿通车,不使用app的情况,
	//所以运单有可能是工作人员产生的,如果司机要看当前的运单列表的话,就有肯能查不到实际由工作人员产生的那个运单,运单是只和车进行关联了的,与人无关
	//==暂时预留===
//	private String generateUserId;
	
	//===2017.05.10 add 货品的名称用于前端直接展示名称,这儿必须要把入库的id对应的名称也入库,不然我展示列表的时候不好处理,每个都要去找对应的值然后添加上=====================
//	private String secondCargosName;//稽查人员的货物名称,不是id,多个用逗号隔开
//	private String firstCargosName;//稽查人员的货物名称
	
//	private String driverWriteCargosName;//司机填写的货物的名称,不是id,多个用逗号隔开
	
//	private String driverWriteFirstCargosName;//司机填写的一级货物的名称,根据二级id查找对应的一级id,再找出对应的名称
	
	private String displayCargoName;//司机端运单列表中展示的货品名称.规则:一级货物名称(二级货物,二级货物.)
	
	private String qrcodePath;//二维码的图片路径
	
	private String qrcodeFullPath;//二维码图片的全路径,用于给前端展示
	
	//==========6/27 add 记录车轴数======================================
	private Integer driverAxis;// 司机端填写的轴数
	
	private Integer auditorAxis;// 稽查人员端填写的轴数
	
	private String driverWriteFirstCargos;//记录司机端司机填写的1级货品,多个用逗号分开
	
	
	public String getWayBillNo() {
		return wayBillNo;
	}

	public void setWayBillNo(String wayBillNo) {
		this.wayBillNo = wayBillNo;
	}

	public String getWayBillName() {
		return wayBillName;
	}

	public void setWayBillName(String wayBillName) {
		this.wayBillName = wayBillName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getGreenTruckPlate() {
		return greenTruckPlate;
	}

	public void setGreenTruckPlate(String greenTruckPlate) {
		this.greenTruckPlate = greenTruckPlate;
	}

	public String getGreenTruckType() {
		return greenTruckType;
	}

	public void setGreenTruckType(String greenTruckType) {
		this.greenTruckType = greenTruckType;
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

	public Integer getAuditStation() {
		return auditStation;
	}

	public void setAuditStation(Integer auditStation) {
		this.auditStation = auditStation;
	}

	public Integer getAuditExpressWay() {
		return auditExpressWay;
	}

	public void setAuditExpressWay(Integer auditExpressWay) {
		this.auditExpressWay = auditExpressWay;
	}

	public String getCurrentDriverId() {
		return currentDriverId;
	}

	public void setCurrentDriverId(String currentDriverId) {
		this.currentDriverId = currentDriverId;
	}

	public String getCurrentDriverName() {
		return currentDriverName;
	}

	public void setCurrentDriverName(String currentDriverName) {
		this.currentDriverName = currentDriverName;
	}

	public String getCurrentPhoneNo() {
		return currentPhoneNo;
	}

	public void setCurrentPhoneNo(String currentPhoneNo) {
		this.currentPhoneNo = currentPhoneNo;
	}

	// public Integer getFreshType() {
	// return freshType;
	// }
	//
	// public void setFreshType(Integer freshType) {
	// this.freshType = freshType;
	// }

	public Integer getAuditConclusionStatus() {
		return auditConclusionStatus;
	}

	public void setAuditConclusionStatus(Integer auditConclusionStatus) {
		this.auditConclusionStatus = auditConclusionStatus;
	}

	public String getDoubleCheckEvaluate() {
		return doubleCheckEvaluate;
	}

	public void setDoubleCheckEvaluate(String doubleCheckEvaluate) {
		this.doubleCheckEvaluate = doubleCheckEvaluate;
	}

	public Integer getDoubleCheckStatus() {
		return doubleCheckStatus;
	}

	public void setDoubleCheckStatus(Integer doubleCheckStatus) {
		this.doubleCheckStatus = doubleCheckStatus;
	}

	public String getAuditConclusionFlowId() {
		return auditConclusionFlowId;
	}

	public void setAuditConclusionFlowId(String auditConclusionFlowId) {
		this.auditConclusionFlowId = auditConclusionFlowId;
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

	public String getVehicleIdentificationNo() {
		return vehicleIdentificationNo;
	}

	public void setVehicleIdentificationNo(String vehicleIdentificationNo) {
		this.vehicleIdentificationNo = vehicleIdentificationNo;
	}

	public String getDriverWriteCargos() {
		//这里可以直接处理成名称,不需要返回给前台id,直接拼接成指定规则:一级货物名称(二级货物,二级货物),如:新鲜蔬菜(白菜类,根菜类)
//		if(Tools.isNotNull(driverWriteCargos)){
//			String[] secondCargoIds = driverWriteCargos.split(",");
//			if(Tools.isNotEmpty(secondCargoIds)){
//				List<String> cargoNames =  greenPassDriverService.getCargosNameByIds(secondCargoIds);
//				if(!Tools.isEmpty(cargoNames)){
//					StringBuilder sb = new StringBuilder();
//					for (int i = 0; i < cargoNames.size(); i++) {
//						if(i== cargoNames.size()-1){
//							sb.append(cargoNames.get(i));
//						}else{
//							sb.append(cargoNames.get(i)).append(",");
//						}
//					}
//					driverWriteFirstCargosName = sb.toString();
//				}
//			}
//		}
//		return driverWriteFirstCargosName;
		return driverWriteCargos;
	}
	
//	@Autowired
//	private GreenPassDriverService greenPassDriverService;
	
	public void setDriverWriteCargos(String driverWriteCargos) {
//		System.out.println("xxxxx greenPassDriverService xxxxxx:" + greenPassDriverService);
//		if(Tools.isNotNull(driverWriteCargos)){
//			String[] secondCargoIds = driverWriteCargos.split(",");
//			if(Tools.isNotEmpty(secondCargoIds)){
//				List<String> cargoNames =  greenPassDriverService.getCargosNameByIds(secondCargoIds);
//				if(!Tools.isEmpty(cargoNames)){
//					StringBuilder sb = new StringBuilder();
//					for (int i = 0; i < cargoNames.size(); i++) {
//						if(i== cargoNames.size()-1){
//							sb.append(cargoNames.get(i));
//						}else{
//							sb.append(cargoNames.get(i)).append(",");
//						}
//					}
//					driverWriteFirstCargosName = sb.toString();
//				}
//			}
//		}
		this.driverWriteCargos = driverWriteCargos;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getCurrentMass() {
		return currentMass;
	}

	public void setCurrentMass(String currentMass) {
		this.currentMass = currentMass;
	}

	public String getAuditConclusionStatusStr() {
		return auditConclusionStatusStr;
	}

	public void setAuditConclusionStatusStr(String auditConclusionStatusStr) {
		this.auditConclusionStatusStr = auditConclusionStatusStr;
	}

	public String getCurrentAuditorId() {
		return currentAuditorId;
	}

	public String getDoubleCheckAuditorId() {
		return doubleCheckAuditorId;
	}

	public void setCurrentAuditorId(String currentAuditorId) {
		this.currentAuditorId = currentAuditorId;
	}

	public void setDoubleCheckAuditorId(String doubleCheckAuditorId) {
		this.doubleCheckAuditorId = doubleCheckAuditorId;
	}


	public String getDriverWriteMass() {
		return driverWriteMass;
	}

	public void setDriverWriteMass(String driverWriteMass) {
		this.driverWriteMass = driverWriteMass;
	}
	
	public String getCheckJobNum() {
		return checkJobNum;
	}

	public void setCheckJobNum(String checkJobNum) {
		this.checkJobNum = checkJobNum;
	}

	public String getTravelCardUrl() {
		return travelCardUrl;
	}

	public String getDriveCardUrl() {
		return driveCardUrl;
	}

	public String getCarPlateUrl() {
		return carPlateUrl;
	}

	public List<String> getGoodsList() {
		return goodsList;
	}

	public String getCarFrontFaceUrl() {
		return carFrontFaceUrl;
	}

	public void setTravelCardUrl(String travelCardUrl) {
		this.travelCardUrl = travelCardUrl;
	}

	public void setDriveCardUrl(String driveCardUrl) {
		this.driveCardUrl = driveCardUrl;
	}

	public void setCarPlateUrl(String carPlateUrl) {
		this.carPlateUrl = carPlateUrl;
	}

	public void setGoodsList(List<String> goodsList) {
		this.goodsList = goodsList;
	}

	public void setCarFrontFaceUrl(String carFrontFaceUrl) {
		this.carFrontFaceUrl = carFrontFaceUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOverDueTime() {
		return overDueTime;
	}

	public void setOverDueTime(Date overDueTime) {
		if(Tools.isNotNull(overDueTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			overDueTimeStr = sdf.format(overDueTime);
		}
		this.overDueTime = overDueTime;
	}

	public String getOverDueTimeStr() {
		return overDueTimeStr;
	}

	public void setOverDueTimeStr(String overDueTimeStr) {
		this.overDueTimeStr = overDueTimeStr;
	}

	@Override
	public String toString() {
		return "WayBill [travelCardUrl=" + travelCardUrl + ", driveCardUrl=" + driveCardUrl + ", carPlateUrl="
				+ carPlateUrl + ", goodsList=" + goodsList + ", carFrontFaceUrl=" + carFrontFaceUrl + ", checkJobNum="
				+ checkJobNum + ", auditConclusionStatusStr=" + auditConclusionStatusStr + ", goodsType=" + goodsType
				+ ", passNum=" + passNum + ", noPassNum=" + noPassNum + ", id=" + id + ", wayBillNo=" + wayBillNo
				+ ", wayBillName=" + wayBillName + ", createTime=" + createTime + ", createTimeStr=" + createTimeStr
				+ ", currentStatus=" + currentStatus + ", greenTruckPlate=" + greenTruckPlate + ", greenTruckType="
				+ greenTruckType + ", auditTime=" + auditTime + ", auditTimestr=" + auditTimestr + ", auditStation="
				+ auditStation + ", auditExpressWay=" + auditExpressWay + ", currentDriverId=" + currentDriverId
				+ ", currentDriverName=" + currentDriverName + ", currentPhoneNo=" + currentPhoneNo
				+ ", currentAuditorId=" + currentAuditorId + ", auditConclusionStatus=" + auditConclusionStatus
				+ ", currentMass=" + currentMass + ", doubleCheckAuditorId=" + doubleCheckAuditorId
				+ ", doubleCheckEvaluate=" + doubleCheckEvaluate + ", doubleCheckStatus=" + doubleCheckStatus
				+ ", auditConclusionFlowId=" + auditConclusionFlowId + ", firstCargos=" + firstCargos
				+ ", secondCargos=" + secondCargos + ", driverWriteCargos=" + driverWriteCargos + ", driverWriteMass="
				+ driverWriteMass + ", vehicleIdentificationNo=" + vehicleIdentificationNo + ", overDueTime="
				+ overDueTime + ", overDueTimeStr=" + overDueTimeStr + ", getWayBillNo()=" + getWayBillNo()
				+ ", getWayBillName()=" + getWayBillName() + ", getCreateTime()=" + getCreateTime()
				+ ", getCreateTimeStr()=" + getCreateTimeStr() + ", getCurrentStatus()=" + getCurrentStatus()
				+ ", getGreenTruckPlate()=" + getGreenTruckPlate() + ", getGreenTruckType()=" + getGreenTruckType()
				+ ", getAuditTime()=" + getAuditTime() + ", getAuditTimestr()=" + getAuditTimestr()
				+ ", getAuditStation()=" + getAuditStation() + ", getAuditExpressWay()=" + getAuditExpressWay()
				+ ", getCurrentDriverId()=" + getCurrentDriverId() + ", getCurrentDriverName()="
				+ getCurrentDriverName() + ", getCurrentPhoneNo()=" + getCurrentPhoneNo()
				+ ", getAuditConclusionStatus()=" + getAuditConclusionStatus() + ", getDoubleCheckEvaluate()="
				+ getDoubleCheckEvaluate() + ", getDoubleCheckStatus()=" + getDoubleCheckStatus()
				+ ", getAuditConclusionFlowId()=" + getAuditConclusionFlowId() + ", getFirstCargos()="
				+ getFirstCargos() + ", getSecondCargos()=" + getSecondCargos() + ", getVehicleIdentificationNo()="
				+ getVehicleIdentificationNo() + ", getDriverWriteCargos()=" + getDriverWriteCargos()
				+ ", getPassNum()=" + getPassNum() + ", getNoPassNum()=" + getNoPassNum() + ", getGoodsType()="
				+ getGoodsType() + ", getCurrentMass()=" + getCurrentMass() + ", getAuditConclusionStatusStr()="
				+ getAuditConclusionStatusStr() + ", getCurrentAuditorId()=" + getCurrentAuditorId()
				+ ", getDoubleCheckAuditorId()=" + getDoubleCheckAuditorId() + ", getDriverWriteMass()="
				+ getDriverWriteMass() + ", getCheckJobNum()=" + getCheckJobNum() + ", getTravelCardUrl()="
				+ getTravelCardUrl() + ", getDriveCardUrl()=" + getDriveCardUrl() + ", getCarPlateUrl()="
				+ getCarPlateUrl() + ", getGoodsList()=" + getGoodsList() + ", getCarFrontFaceUrl()="
				+ getCarFrontFaceUrl() + ", getId()=" + getId() + ", getOverDueTime()=" + getOverDueTime()
				+ ", getOverDueTimeStr()=" + getOverDueTimeStr() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getPassNum() {
		return passNum;
	}

	public int getNoPassNum() {
		return noPassNum;
	}

	public void setPassNum(int passNum) {
		this.passNum = passNum;
	}

	public void setNoPassNum(int noPassNum) {
		this.noPassNum = noPassNum;
	}

	public String getDisplayCargoName() {
		return displayCargoName;
	}

	public void setDisplayCargoName(String displayCargoName) {
		this.displayCargoName = displayCargoName;
	}

	public String getQrcodePath() {
		return qrcodePath;
	}

	public void setQrcodePath(String qrcodePath) {
		this.qrcodePath = qrcodePath;
	}

	public String getQrcodeFullPath() {
		return qrcodeFullPath;
	}

	public void setQrcodeFullPath(String qrcodeFullPath) {
		this.qrcodeFullPath = qrcodeFullPath;
	}

	public Integer getDriverAxis() {
		return driverAxis;
	}

	public void setDriverAxis(Integer driverAxis) {
		this.driverAxis = driverAxis;
	}

	public Integer getAuditorAxis() {
		return auditorAxis;
	}

	public void setAuditorAxis(Integer auditorAxis) {
		this.auditorAxis = auditorAxis;
	}

	public String getDriverWriteFirstCargos() {
		return driverWriteFirstCargos;
	}

	public void setDriverWriteFirstCargos(String driverWriteFirstCargos) {
		this.driverWriteFirstCargos = driverWriteFirstCargos;
	}
	
	
//	public void setDisplayCargoName(String displayCargoName) {
//		//优先使用稽查工作人员端填写的货物,因为完成后的订单修改都以工作人员修改后的为主,未完成的订单相当于工作人员端为空
//		if(Tools.isNotNull(firstCargosName) && Tools.isNotNull(secondCargosName)){
//			displayCargoName = firstCargosName + "(" + secondCargosName + ")";
//		}else if(Tools.isNotNull(driverWriteFirstCargosName) && Tools.isNotNull(driverWriteCargosName)){
//			displayCargoName = driverWriteFirstCargosName + "(" + driverWriteCargosName + ")";
//		}
//		this.displayCargoName = displayCargoName;
//	}

//	public Integer getDeleteFlag() {
//		return deleteFlag;
//	}
//
//	public void setDeleteFlag(Integer deleteFlag) {
//		this.deleteFlag = deleteFlag;
//	}
	
	
	

}
