package com.cdsf.background.greenpass.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cdsf.background.greenpass.domain.AuditPicture;
import com.cdsf.background.greenpass.domain.BlackGrayWayBillList;
import com.cdsf.background.greenpass.domain.CargoTree;
import com.cdsf.background.greenpass.domain.PageTest;
import com.cdsf.background.greenpass.domain.ViolationTruckInfo;
import com.cdsf.background.greenpass.domain.WayBill;
import com.cdsf.background.greenpass.domain.WorkWayBill;
import com.cdsf.configure.AbstractMapper;
import com.cdsf.webmvc.paginator.Page;
import com.cdsf.webmvc.paginator.Pageable;


@Repository
public interface GreenPassWebMapper extends AbstractMapper {

	List<PageTest> testPage1(@Param("map")Map<String, Object> map);

	List<WayBill> queryAuditDoubleCheck(@Param("parmMap") Map<String, Object> parmMap);

	List<Map<Object, Object>> queryStationStatistics(@Param("parmMap") Map<String, Object> parmMap);

	List<?> queryBlackGrayListData(Map<String, Object> map, Pageable page);

	List<PageTest> testPage2(Map<String, Object> map, Pageable page);

	Page<WayBill> queryAllDoneWayBill(Map<String, Object> map, Pageable page);

	WayBill queryWayBillById(String waybillId);

	List<CargoTree> getCargoTreeData();

	List<AuditPicture> queryAuditPictureByWaybillId(String waybillId);

	void updateDoubleCheckStatus(@Param("billId")String billId, @Param("doubleCheckStatus")String doubleCheckStatus,@Param("currentUserWorkNo")String currentUserWorkNo);

	List<?> queryViolationTruckPlate(Map<String, Object> map, Pageable page);

	List<?> queryCheckTimeStatistics(Map<String, Object> map, Pageable page);
	
	List<?> queryCheckTimeStatisticsByHours(Map<String, Object> map, Pageable page);
	
	List<?> queryStrikeCashStatistics(Map<String, Object> map, Pageable page);

	List<?> queryStrikeCashDetailByAuditorId(Map<String, Object> map, Pageable page);

	List<?> queryCargoStatistic(Map<String, Object> map, Pageable page);

	List<?> queryStationStatistics2(Map<String, Object> map, Pageable page);

	BlackGrayWayBillList getBlackGrayWayBillListByWayBillId(@Param("wayBillId") String wayBillId);

	Integer queryInBlackGrayListByBillId(@Param("wayBillId")String waybillId);

	void addDataToBlackGrayList(BlackGrayWayBillList blackGrayWayBillList);

	void deleteAuditPictureDataByWayBillId(@Param("wayBillId") String wayBillId);

	void deleteAuditConclusionDataByWayBillId(@Param("wayBillId") String wayBillId);

	void deleteWayBillDataByWayBillId(@Param("wayBillId") String wayBillId);

	BlackGrayWayBillList encapBlackGrayWayBillListByWayBillId(@Param("wayBillId") String wayBillId);

	Integer judgeRobotBlink();

	
}
