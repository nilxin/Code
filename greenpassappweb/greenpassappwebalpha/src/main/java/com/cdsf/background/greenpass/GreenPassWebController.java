package com.cdsf.background.greenpass;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdsf.background.greenpass.domain.AuditPicture;
import com.cdsf.background.greenpass.domain.BlackGrayWayBillList;
import com.cdsf.background.greenpass.domain.CargoStatisticInfo;
import com.cdsf.background.greenpass.domain.CargoTree;
import com.cdsf.background.greenpass.domain.FightEscapeInfo;
import com.cdsf.background.greenpass.domain.PageTest;
import com.cdsf.background.greenpass.domain.WayBill;
import com.cdsf.background.greenpass.service.GreenPassWebService;
import com.cdsf.background.privilege.domain.User;
import com.cdsf.background.privilege.service.UserService;
import com.cdsf.common.MessageConstants;
import com.cdsf.configure.AbstractController;
import com.cdsf.utils.FileUtil;
import com.cdsf.utils.Tools;
import com.cdsf.webmvc.annotation.RequestModel;
import com.cdsf.webmvc.paginator.Page;
import com.cdsf.webmvc.paginator.Pageable;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Michael
 *
 *         2017年4月24日
 * 
 *         司机端app的接口controller
 */
@Controller
@RequestMapping("/webstatistics")
public class GreenPassWebController extends AbstractController {

	@Autowired
	private GreenPassWebService greenPassWebService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 稽查复核统计接口
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/auditdoublecheck")
	public Map<String, Object> auditDoubleCheckStatistics(Integer currentPage,Integer rows,Integer auditStation,String beginTimeStr,String endTimeStr) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("currentPage", currentPage);
		parmMap.put("rows", rows);
		parmMap.put("auditStation", auditStation);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(Tools.isNotNull(beginTimeStr)){
			Date beginTime = sdf.parse(beginTimeStr);
			parmMap.put("beginTime", beginTime);
		}
		if(Tools.isNotNull(endTimeStr)){
			Date endTime = sdf.parse(endTimeStr);
			parmMap.put("endTime", endTime);
		}
		List<WayBill> res = new ArrayList<WayBill>();
		res = greenPassWebService.queryAuditDoubleCheck(parmMap);
		result.put("status", 1);
		result.put("content", res);
		result.put("message", MessageConstants.SUCCESS);
		return result;
	}
	
	/**
	 * 前后端配合的分页处理:
	 * 方案一:请求该接口返回一个分页对象给前端,分页对象包含当前页,总页数,每页记录的条数(这个是前端决定的,可以给默认值),查询出来的内容;底层原理都是SQL查询的时候分页
	 * 方案二:前端直接封装一个分页对象,分页对象只包含当前页,每页记录数,然后后台接收后拼装对应的SQL进行查询返回
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/testpage1")
	public Map<String, Object> testPage1(@Param("currentPage")String currentPage,@Param("rows")String rows,Integer cc) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", 2);
		map.put("rows", 10);
		Integer offset = (Integer.parseInt(currentPage)-1)*(Integer.parseInt(rows));
		map.put("offset", offset);
		
		List<PageTest> pagelist = greenPassWebService.testPage1(map);
		System.out.println(pagelist);
		
		return result;
	}
	
	
	@RequestMapping("/testpage2")
	public Map<String, Object> testPage2(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<PageTest> pagelist = greenPassWebService.testPage2(map,page);
		System.out.println(map.get("beginTime"));
		System.out.println(map.get("endTime"));
		result.put("status", 1);
		result.put("content", pagelist);
		result.put("message", MessageConstants.SUCCESS);
		return result;
	}
	

	/**
	 * 站点统计
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/auditstation")
	public Map<String, Object> auditStationStatistics(Integer currentPage,Integer rows,Integer auditStation,String beginTimeStr,String endTimeStr) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("currentPage", currentPage);
		parmMap.put("rows", rows);
		parmMap.put("auditStation", auditStation);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(Tools.isNotNull(beginTimeStr)){
			Date beginTime = sdf.parse(beginTimeStr);
			parmMap.put("beginTime", beginTime);
		}
		if(Tools.isNotNull(endTimeStr)){
			Date endTime = sdf.parse(endTimeStr);
			parmMap.put("endTime", endTime);
		}
		List<Map<Object,Object>>  list =  greenPassWebService.queryStationStatistics(parmMap);
		System.out.println(list);
		System.out.println(list.size());
		result.put("status", 1);
		result.put("content", list);
		result.put("message", MessageConstants.SUCCESS);
		return result;
	}
	
	/**
	 * 站点统计
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/auditstation2")
	public Map<String, Object> auditStationStatistics2(@RequestModel("map") Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if (Tools.isNotNull(map.get("startTime"))) {
			String startTime = map.get("startTime").toString() + " 00:00:00";
			map.put("startTime", Tools.formateStrToDate(0, startTime));
		}
		if (Tools.isNotNull(map.get("endTime"))) {
			String endTime = map.get("endTime").toString() + " 23:59:59";
			map.put("endTime", Tools.formateStrToDate(0, endTime));
		}
		try{
			List<?>  stationInfoList =  greenPassWebService.queryStationStatistics2(map,page);
			result.put("status", 1);
			result.put("content", stationInfoList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	/**
	 * 黑灰名单统计
	 * 根据运单表统计累违规次数,累积违规金额
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/blackgraylist")
	public Map<String, Object> blackGrayListStatistics(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		dealTimeCondition(map);
		try{
			List<?> blackGrayList = greenPassWebService.queryBlackGrayListData(map,page);
			result.put("status", 1);
			result.put("content", blackGrayList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	/**
	 * 处理高级查询的时间条件
	 * @param map 前端封装的map条件
	 * @throws ParseException
	 */
	
	private void dealTimeCondition(Map<String, Object> map) throws ParseException {
		if (Tools.isNotNull(map.get("startTime"))) {
			String startTime = map.get("startTime").toString() + " 00:00:00";
			map.put("startTime", Tools.formateStrToDate(0, startTime));
		}else{
			map.put("startTime",null);
		}
		if (Tools.isNotNull(map.get("endTime"))) {
			String endTime = map.get("endTime").toString() + " 23:59:59";
			map.put("endTime", Tools.formateStrToDate(0, endTime));
		}else{
			map.put("endTime",null);
		}
	}
	
	/**
	 * 稽查复核的时候添加数据进入黑名单,根据运单id来查询填充对应的数据
	 * @param wayBillId  运单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/putdatatoblacklist")
	public Map<String, Object> addToBlackGrayList(String wayBillId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if(Tools.isNull(wayBillId) || "undefined".equals(wayBillId)){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.PARAM_NULL);
			return result;
		}
		try{
			BlackGrayWayBillList  blackGrayWayBillList = greenPassWebService.getBlackGrayWayBillListByWayBillId(wayBillId);
			if(Tools.isNull(blackGrayWayBillList)){
				//把运单的相关信息set进去
				blackGrayWayBillList = greenPassWebService.encapBlackGrayWayBillListByWayBillId(wayBillId);
			}
			blackGrayWayBillList.setFlowId(Tools.createUUID());
			blackGrayWayBillList.setJionTime(new Date());
			greenPassWebService.addDataToBlackGrayList(blackGrayWayBillList);
			result.put("status", 1);
			result.put("content", "");
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	

	/**
	 * 打逃金额统计
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/strikecash")
	public Map<String, Object> strikeCashStatistics(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(Tools.isNotNull(map.get("startIllegalTimes"))){
			map.put("startIllegalTimes", map.get("startIllegalTimes"));
		}else{
			map.put("startIllegalTimes", 0);
		}
		if(Tools.isNotNull(map.get("endIllegalTimes"))){
			map.put("endIllegalTimes", map.get("endIllegalTimes"));
		}else{
			map.put("endIllegalTimes", null);
		}
		if(Tools.isNotNull(map.get("auditWorkNo"))){
			map.put("auditWorkNo", map.get("auditWorkNo").toString());
		}else{
			map.put("auditWorkNo", "");
		}
		try{
			List<?> fightEscapeInfoList = greenPassWebService.queryStrikeCashStatistics(map,page);
			result.put("status", 1);
			result.put("content", fightEscapeInfoList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		
		return result;
	}
	
	/**
	 * 打逃金额详情接口
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/strikecashdetail")
	public Map<String, Object> strikeCashDetail(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			if(Tools.isNull(map.get("auditorId"))){
				Object auditorId = null;
				map.put("auditorId", auditorId);
			}
			List<?> fightEscapeDetailInfoList = greenPassWebService.queryStrikeCashDetailByAuditorId(map,page);
			for (Object object : fightEscapeDetailInfoList) {
				FightEscapeInfo fightEscapeInfo = (FightEscapeInfo)object;
				String displayCargosName = assemblyDisplayName3(fightEscapeInfo.getCargos());
				fightEscapeInfo.setDisplayCargosName(displayCargosName);
			}
			result.put("status", 1);
			result.put("content", fightEscapeDetailInfoList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	/**
	 * 鲜活货品统计
	 * @param map 查询条件
	 * @param page 分页条件
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cargostatistic")
	public Map<String, Object> cargoStatistic(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<?> cargoStatisticList = greenPassWebService.queryCargoStatistic(map,page);
			System.out.println("xxx cargoStatisticList  xx"+cargoStatisticList.size());
			
			for (Object object : cargoStatisticList) {
				if(object instanceof CargoStatisticInfo){
					CargoStatisticInfo cargoStatisticInfo = (CargoStatisticInfo)object;
					String displayCargosName = assemblyDisplayName3(cargoStatisticInfo.getSecondCargos());
					cargoStatisticInfo.setDisplayCargosName(displayCargosName);
				}
			}
			result.put("status", 1);
			result.put("content", cargoStatisticList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	
	
	@RequestMapping("/testjson")
	public Map<String, Object> testJson(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String jsonStr = FileUtil.getJsonStr("conclusionType.json");
		JSONArray fromObjectArr = JSONArray.fromObject(jsonStr);
		fromObjectArr.get(0);
		fromObjectArr.get(1);
		fromObjectArr.get(2);
		Map<String,Object> res = new HashMap<String, Object>();
		for (int i = 0; i < fromObjectArr.size(); i++) {
			JSONObject jsonObj = JSONObject.fromObject(fromObjectArr.get(i));
			res.put(jsonObj.getString("id"), jsonObj.getString("text"));
		}
		System.out.println("----res-----"+res);
		System.out.println("fromObjectArr.get(0):"+fromObjectArr.get(0));
		System.out.println("fromObjectArr.get(1):"+fromObjectArr.get(1));
		System.out.println("fromObjectArr.get(2):"+fromObjectArr.get(2));
		JSONObject jsonObj = JSONObject.fromObject(fromObjectArr.get(0));
		jsonObj.get("1");
		jsonObj.get("2");
		jsonObj.get("3");
		result.put("test", jsonObj);
		return result;
	}
	
	/**
	 * 违规车牌统计
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/violationtruckplate")
	public Map<String, Object> violationTruckPlateStatistics(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(Tools.isNotNull(map.get("startIllegalTimes"))){
			map.put("startIllegalTimes", map.get("startIllegalTimes"));
		}else{
			map.put("startIllegalTimes", 0);
		}
		if(Tools.isNotNull(map.get("endIllegalTimes"))){
			map.put("endIllegalTimes", map.get("endIllegalTimes"));
		}else{
			map.put("endIllegalTimes", null);
		}
		if(Tools.isNotNull(map.get("searchKeyWords"))){
			map.put("searchKeyWords", map.get("searchKeyWords").toString());
		}else{
			map.put("searchKeyWords", "");
		}
		try{
			List<?> violationTruckPlateList = greenPassWebService.queryViolationTruckPlate(map,page);
			result.put("status", 1);
			result.put("content", violationTruckPlateList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	/**
	 * 稽查时段统计
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checktime")
	public Map<String, Object> checkTimeStatistics(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<?> violationTruckPlateList = greenPassWebService.queryCheckTimeStatistics(map,page);
			result.put("status", 1);
			result.put("content", violationTruckPlateList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	/**
	 * 复核详情接口
	 * @param map
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doublecheckdetail")
	public Map<String, Object> doubleCheckDetailStatistics(String waybillId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if(Tools.isNull(waybillId) || "undefined".equals(waybillId)){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.PARAM_NULL);
			result.put("inBlackGrayList", false);
			return result;
		}
		try{
			WayBill wayBill =  greenPassWebService.queryWayBillById(waybillId);
			String displayCargoName = dealDisplayCargoName(wayBill,1);
			wayBill.setDisplayCargoName(displayCargoName);
			Integer count = greenPassWebService.queryInBlackGrayListByBillId(waybillId);
			Boolean inBlackGrayFlag = null;
			if(count > 0){
				inBlackGrayFlag = true;
			}else{
				inBlackGrayFlag = false;
			}
			//获取取证图片信息
			List<AuditPicture> auditPictureList =  greenPassWebService.queryAuditPictureByWaybillId(waybillId);
			result.put("status", 1);
			result.put("content", wayBill);
			result.put("pictureInfo", auditPictureList);
			result.put("message", MessageConstants.SUCCESS);
			result.put("inBlackGrayList", inBlackGrayFlag);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("pictureInfo", "");
			result.put("message", MessageConstants.FAILURE);
			result.put("inBlackGrayList", false);
		}
		return result;
	}
	
	/**
	 * 复核结论状态接口,根据运单id 修改稽查状态 double_check_status
	 * @param billId
	 * @param double_check_status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doublecheck")
	public Map<String, Object> doubleCheckStatus(String billId,String doubleCheckStatus) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			greenPassWebService.updateDoubleCheckStatus(billId,doubleCheckStatus);
			result.put("status", 1);
			result.put("content", "");
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			result.put("status", 1);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	/**
	 * 查询获取所有稽查完成的稽查订单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getallwaybill")
	public Map<String, Object> queryAllDoneWayBill(@RequestModel Map<String, Object> map,@RequestModel("page") Pageable page) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		dealTimeCondition(map);
		if(Tools.isNotNull(map.get("doubleAuditStatus")) &&  map.get("doubleAuditStatus").equals("-1")){
			map.put("doubleAuditStatus", null);
		}else if(Tools.isNotNull(map.get("doubleAuditStatus")) &&  map.get("doubleAuditStatus").equals("0")){
			map.put("doubleAuditStatus", 0);
		}else if(Tools.isNotNull(map.get("doubleAuditStatus")) &&  map.get("doubleAuditStatus").equals("1")){
			map.put("doubleAuditStatus", 1);
		}else if(Tools.isNotNull(map.get("doubleAuditStatus")) &&  map.get("doubleAuditStatus").equals("2")){
			map.put("doubleAuditStatus", 2);
		}
		try{
			Page<WayBill> auditDoneWayBillList = greenPassWebService.queryAllDoneWayBill(map,page);
			result.put("status", 1);
			result.put("content", auditDoneWayBillList);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
	/**
	 * 删除脏数据接口
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> deleteDirtyData(String wayBillId) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			//清除运单数据t_waybill   
			greenPassWebService.deleteWayBillDataByWayBillId(wayBillId);
			//清除稽查结论表数据t_audit_conclusion
			greenPassWebService.deleteAuditConclusionDataByWayBillId(wayBillId);
			//清除稽查取证图片表数据t_audit_picture
			greenPassWebService.deleteAuditPictureDataByWayBillId(wayBillId);
			
			result.put("status", 1);
			result.put("content", "");
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		
		return result;
	}
	
	
	
	
	
	
	/**
	 * 登录接口
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public Map<String, Object> checkLogin(@RequestModel Map<String, Object> map) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(Tools.isNull(map.get("loginName"))){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.USERNAME_NULL);
			return result;
		}
		if(Tools.isNull(map.get("password"))){
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.PASSWORD_NULL);
			return result;
		}
		
		if(Tools.isNotNull(map.get("loginName")) && Tools.isNotNull(map.get("password"))){
			List<User> users = userService.checkLogin(map);
			if(!Tools.isEmpty(users)){
				result.put("status", 1);
				result.put("content", users.get(0));
				result.put("message", MessageConstants.SUCCESS);
				return result;
			}else{
				result.put("status", 0);
				result.put("content", "");
				result.put("message", MessageConstants.ACCOUNT_PASSWORD_WRONG);
			}
		}
		return result;
	}
	
	
	/**
	 * 处理运单的显示货品名称,拼装,规则:一级货物名称(二级货物,二级货物.) 如 新鲜蔬菜(大白菜,小白菜)
	 * @param wayBill  运单
	 * @param status 状态  1-->完成   0-->未完成
	 * @return
	 */
	private String dealDisplayCargoName(WayBill wayBill, int status) throws Exception{
		String result = "";
		if(status == 1){
			result = assemblyDisplayName3(wayBill.getSecondCargos());
		}else if(status == 0){
			result = assemblyDisplayName3(wayBill.getDriverWriteCargos());
		}
		return result;
	}
	
	
	/**
	 * 用最简单最粗暴的方法来处理;试设计一个Map,货品对象在map中去找,而不去读数据库,map的查找效率很高
	 * @param cargoIds
	 * @return
	 * @throws Exception 
	 */
	private String assemblyDisplayName3(String cargoIds) throws Exception{
		String result = "";
		if(Tools.isNotNull(cargoIds)){
			String[] secondCargoIds = cargoIds.split(",");
			Set<Long> secondIds = new HashSet<Long>();
			for (int i = 0; i < secondCargoIds.length; i++) {
				secondIds.add(Long.parseLong(secondCargoIds[i]));
			}
			if(!Tools.isEmpty(secondIds)){
				//例外一种思路,1.找出所有的一级大类,以及大类下面的子类 2.在将当前类归为所属的大类中    3.再进行拼装
				List<CargoTree> allCargos = greenPassWebService.getCargoTreeData();
				Map<Object,CargoTree> map = new HashMap<Object, CargoTree>();
				List<Long> firstLevelCategory = new ArrayList<Long>();
				for (CargoTree firstLevelCargo : allCargos) {
					map.put(firstLevelCargo.getId(), firstLevelCargo);
					if(firstLevelCargo.getParentId().equals(-1L)){
						firstLevelCategory.add(firstLevelCargo.getId());
					}
				}
				List<List<Long>> everyLevelIdTree = new ArrayList<List<Long>>();
				for (Long firstLevelParentId : firstLevelCategory) {
					List<CargoTree>  firstLevelTree = sortCargoTreesByParent(allCargos,firstLevelParentId);
					List<Long> firstLevelIdTree = new ArrayList<Long>();
					firstLevelIdTree.add(firstLevelParentId);
					for (CargoTree cargoTree : firstLevelTree) {
						firstLevelIdTree.add(cargoTree.getId());
					}
					everyLevelIdTree.add(firstLevelIdTree);
				}
				List<List<Long>> dealIdTree = new ArrayList<List<Long>>();
				for (List<Long> Idlist : everyLevelIdTree) {
					List<Long> sortIdTree = new ArrayList<Long>();
					for (Long inputCargoId : secondIds) {
						if(Idlist.contains(inputCargoId)){
							sortIdTree.add(inputCargoId);
						}
					}
					if(sortIdTree.size()>0){
						dealIdTree.add(sortIdTree);
					}
				}
//				System.out.println(dealIdTree);
				//拼装  [[1,1001,1002],[2002,2003],[5]]
				StringBuilder resultCargoName = new StringBuilder();
				for (List<Long> cargoSortIds : dealIdTree) {
					StringBuilder sbParent = new StringBuilder();
					StringBuilder sbChildName = new StringBuilder();
					for (int j=0;j< cargoSortIds.size();j++) {
						String parentName = "";
						String childName = "";
						String defaultParentName = "";//默认的父集名称是顶层下面的一级目录
						//递归找到默认的顶层的一级目录的名称
						if(map.get(cargoSortIds.get(j)).getParentId().intValue() == -1){
							parentName = map.get(cargoSortIds.get(j)).getCargoName();
						}else{
							childName = map.get(cargoSortIds.get(j)).getCargoName();
							sbChildName.append(childName);
							sbChildName.append("、");
						}
						if(j == cargoSortIds.size() -1){
							if(parentName.equals("")){
								defaultParentName = getDefaultParentName(map,cargoSortIds.get(j));
								sbParent.append(defaultParentName);
							}else{
								sbParent.append(parentName);
							}
						}
					}
					String dealChildName = sbChildName.toString();
					if(Tools.isNotNull(dealChildName)){
						dealChildName = dealChildName.substring(0, dealChildName.length()-1);
					}
					resultCargoName.append(sbParent);
					if(Tools.isNotNull(dealChildName)){
						resultCargoName.append("(");
						resultCargoName.append(dealChildName);
						resultCargoName.append(")");
					}
					resultCargoName.append(",");
				}
				if(resultCargoName.toString().length()>1){
					result = resultCargoName.toString().substring(0,resultCargoName.length()-1);
				}
			}
		}	
		return result;
	}
	
	/**
	 * 把每颗树按照指定的分支分类
	 * @param cargoTrees
	 * @return
	 */
	private List<CargoTree> sortCargoTreesByParent(List<CargoTree> cargoTrees,Long parentId) {
		List<CargoTree> nodeTrees = new ArrayList<CargoTree>();
		if(!Tools.isEmpty(cargoTrees)){
			nodeTrees = getCargoTreesByAssignNode(cargoTrees,parentId);
		}
		return nodeTrees;
	}
	
	/**
	 * 根据指定的某个节点id,查询出所有的子类
	 * @param cargoTrees
	 * @param parentId
	 * @return
	 */
	private List<CargoTree> getCargoTreesByAssignNode(List<CargoTree> cargoTrees, Long parentId) {
		List<CargoTree> result = new ArrayList<CargoTree>();
		if(!Tools.isEmpty(cargoTrees)){
			for (CargoTree cargoTree : cargoTrees) {
				if(cargoTree.getParentId().equals(parentId)){
					//遍历该节点下的所有子节点
					getCargoTreesByAssignNode(cargoTree.getChildren(),cargoTree.getId());
					result.add(cargoTree);
				}
			}
		}
		return result;
	}

	/**
	 * 已知是同一颗树了     所以只需要任意一个id  递归找到该顶层下面的货品名称
	 * @param map
	 * @param cargoSortId
	 * @return
	 */
	private String getDefaultParentName(Map<Object,CargoTree> map,Long cargoSortId){
		if(map.get(cargoSortId).getParentId().intValue() == -1){
			return map.get(cargoSortId).getCargoName();
		}
		return getDefaultParentName(map,map.get(cargoSortId).getParentId());
	}
	
	
	/**
	 * 查询获取所有稽查完成的稽查订单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/judgerobot")
	public Map<String, Object> queryAllDoneWayBill() throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Integer count = greenPassWebService.judgeRobotBlink();
			Boolean flag = null;
 			if(count > 0){
 				flag = true;
			}else{
				flag = false;
			}
			result.put("status", 1);
			result.put("content", flag);
			result.put("message", MessageConstants.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", 0);
			result.put("content", "");
			result.put("message", MessageConstants.FAILURE);
		}
		return result;
	}
	
	
}
