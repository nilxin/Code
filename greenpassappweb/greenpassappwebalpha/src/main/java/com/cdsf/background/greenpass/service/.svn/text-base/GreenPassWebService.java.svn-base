package com.cdsf.background.greenpass.service;

import java.util.List;
import java.util.Map;

import com.cdsf.background.greenpass.domain.AuditPicture;
import com.cdsf.background.greenpass.domain.BlackGrayWayBillList;
import com.cdsf.background.greenpass.domain.CargoTree;
import com.cdsf.background.greenpass.domain.PageTest;
import com.cdsf.background.greenpass.domain.WayBill;
import com.cdsf.webmvc.paginator.Page;
import com.cdsf.webmvc.paginator.Pageable;

public interface GreenPassWebService {

	List<PageTest> testPage1(Map<String, Object> map);

	List<WayBill> queryAuditDoubleCheck(Map<String, Object> parmMap);

	List<Map<Object,Object>> queryStationStatistics(Map<String, Object> parmMap);

	List<?> queryBlackGrayListData(Map<String, Object> map, Pageable page);

	List<PageTest> testPage2(Map<String, Object> map, Pageable page);

	Page<WayBill> queryAllDoneWayBill(Map<String, Object> map, Pageable page);

	WayBill queryWayBillById(String waybillId);

	List<CargoTree> getCargoTreeData();

	List<AuditPicture> queryAuditPictureByWaybillId(String waybillId);

	void updateDoubleCheckStatus(String billId, String doubleCheckStatus);

	List<?> queryViolationTruckPlate(Map<String, Object> map, Pageable page);

	List<?> queryCheckTimeStatistics(Map<String, Object> map, Pageable page);

	List<?> queryStrikeCashStatistics(Map<String, Object> map, Pageable page);

	List<?> queryStrikeCashDetailByAuditorId(Map<String, Object> map, Pageable page);

	List<?> queryCargoStatistic(Map<String, Object> map, Pageable page);

	List<?> queryStationStatistics2(Map<String, Object> map, Pageable page);

	BlackGrayWayBillList getBlackGrayWayBillListByWayBillId(String wayBillId);

	Integer queryInBlackGrayListByBillId(String waybillId);

	void addDataToBlackGrayList(BlackGrayWayBillList blackGrayWayBillList);

	void deleteWayBillDataByWayBillId(String wayBillId);

	void deleteAuditConclusionDataByWayBillId(String wayBillId);

	void deleteAuditPictureDataByWayBillId(String wayBillId);

	BlackGrayWayBillList encapBlackGrayWayBillListByWayBillId(String wayBillId);

	Integer judgeRobotBlink();


}
