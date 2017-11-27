package com.cdsf.background.greenpass.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsf.background.greenpass.domain.AuditPicture;
import com.cdsf.background.greenpass.domain.BlackGrayWayBillList;
import com.cdsf.background.greenpass.domain.CargoTree;
import com.cdsf.background.greenpass.domain.PageTest;
import com.cdsf.background.greenpass.domain.ViolationTruckInfo;
import com.cdsf.background.greenpass.domain.WayBill;
import com.cdsf.background.greenpass.domain.WorkWayBill;
import com.cdsf.background.greenpass.mapper.GreenPassWebMapper;
import com.cdsf.configure.AbstractService;
import com.cdsf.webmvc.paginator.Page;
import com.cdsf.webmvc.paginator.Pageable;


@Service
public class GreenPassWebServiceImpl extends AbstractService implements GreenPassWebService {
	
	@Autowired
	private GreenPassWebMapper greenPassDriverMapper;

	@Override
	@Transactional(readOnly = true)
	public List<PageTest> testPage1(Map<String, Object> map) {
		return greenPassDriverMapper.testPage1(map);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WayBill> queryAuditDoubleCheck(Map<String, Object> parmMap) {
		return greenPassDriverMapper.queryAuditDoubleCheck(parmMap);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<Object, Object>> queryStationStatistics(Map<String, Object> parmMap) {
		
		return greenPassDriverMapper.queryStationStatistics(parmMap);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryBlackGrayListData(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryBlackGrayListData(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PageTest> testPage2(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.testPage2(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<WayBill> queryAllDoneWayBill(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryAllDoneWayBill(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public WayBill queryWayBillById(String waybillId) {
		return greenPassDriverMapper.queryWayBillById(waybillId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CargoTree> getCargoTreeData() {
		return greenPassDriverMapper.getCargoTreeData();
	}

	@Override
	@Transactional(readOnly = true)
	public List<AuditPicture> queryAuditPictureByWaybillId(String waybillId) {
		return greenPassDriverMapper.queryAuditPictureByWaybillId(waybillId);
	}

	@Override
	@Transactional
	public void updateDoubleCheckStatus(String billId, String doubleCheckStatus) {
		greenPassDriverMapper.updateDoubleCheckStatus(billId,doubleCheckStatus);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryViolationTruckPlate(Map<String, Object> map, Pageable page) {
		
		return greenPassDriverMapper.queryViolationTruckPlate(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryCheckTimeStatistics(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryCheckTimeStatistics(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryStrikeCashStatistics(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryStrikeCashStatistics(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryStrikeCashDetailByAuditorId(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryStrikeCashDetailByAuditorId(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryCargoStatistic(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryCargoStatistic(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> queryStationStatistics2(Map<String, Object> map, Pageable page) {
		return greenPassDriverMapper.queryStationStatistics2(map,page);
	}

	@Override
	@Transactional(readOnly = true)
	public BlackGrayWayBillList getBlackGrayWayBillListByWayBillId(String wayBillId) {
		return greenPassDriverMapper.getBlackGrayWayBillListByWayBillId(wayBillId);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer queryInBlackGrayListByBillId(String waybillId) {
		return greenPassDriverMapper.queryInBlackGrayListByBillId(waybillId);
	}

	@Override
	@Transactional
	public void addDataToBlackGrayList(BlackGrayWayBillList blackGrayWayBillList) {
		greenPassDriverMapper.addDataToBlackGrayList(blackGrayWayBillList);
	}

	@Override
	@Transactional
	public void deleteWayBillDataByWayBillId(String wayBillId) {
		greenPassDriverMapper.deleteWayBillDataByWayBillId(wayBillId);
	}

	@Override
	@Transactional
	public void deleteAuditConclusionDataByWayBillId(String wayBillId) {
		greenPassDriverMapper.deleteAuditConclusionDataByWayBillId(wayBillId);
	}

	@Override
	@Transactional
	public void deleteAuditPictureDataByWayBillId(String wayBillId) {
		greenPassDriverMapper.deleteAuditPictureDataByWayBillId(wayBillId);
	}

	@Override
	@Transactional(readOnly = true)
	public BlackGrayWayBillList encapBlackGrayWayBillListByWayBillId(String wayBillId) {
		return greenPassDriverMapper.encapBlackGrayWayBillListByWayBillId(wayBillId);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer judgeRobotBlink() {
		return greenPassDriverMapper.judgeRobotBlink();
	}


}
