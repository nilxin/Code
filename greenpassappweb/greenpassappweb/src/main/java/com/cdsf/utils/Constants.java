/**
 * @Title: Constants.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author huchao
 * @date 2014年8月28日
 * @version 2.0
 */
package com.cdsf.utils;

import com.cdsf.common.util.PropertiesUtil;

/**
 * @Title: Constants
 * @Description:
 * @Company: cdsf
 * @author huchao
 * @date 2014年8月28日
 */
public class Constants {
	
	
	
	
	
	
	public static final String PARAM_VIN_NULL = "汽车唯一标识参数不能为空！";
	public static final String PARAM_TP_NULL = "车牌号不能为空！";
	public static final String PARAM_UID_NULL = "用户名id不能为空！";
	public static final String BIND_TRUCK_EXCEPTION = "你已绑定了该车";
	public static final String QR_CODE_DIR_PATH = "qrcode.dir";
	public static final String QR_CODE_LOCAL_TEST_DIR_PATH = "qrcode.localtest.dir";
	public static final String FILE_SUFFIX = ".jpg";
	
	
	/**
	 * 验证成功
	 */
	public static final String VERIFY_SUCCESS = "验证成功！";
	
	
	/**
	 * 登录成功
	 */
	public static final String LOGIN_SUCCESS = "登录成功！";
	
	/**
	 * 用户名不能为空
	 */
	public static final String USERNAME_NULL = "用户名不能为空！";
	
	
	/**
	 * 用户名错误
	 */
	public static final String USERNAME_WRONG = "用户名错误！";
	
	/**
	 * 密码不能为空
	 */
	public static final String PASSWORD_NULL = "密码不能为空！";
	
	/**
	 * 密码错误
	 */
	public static final String PASSWORD_WRONG = "密码错误！";
	
	/**
	 * 验证失败
	 */
	public static final String VERIFY_FAILURE = "验证失败！";
	
	
	/**
	 * 绕过前台不输入验证码直接后台请求
	 */
	public static final String VERIFY_NULL = "验证码为空";
	
	
	/**
	 * 绕过前台,切不带id的提交时,后台消息
	 */
	public static final String ID_RECEIVE_FAILURE = "后台接收ID为空！";
	
	
	/**
	 * 添加到人工审核流程
	 */
	public static final String ADD_AUDIT_FLOW = "进入人工审核中！";
	
	
	/**
	 * 审核通过
	 */
	public static final String AUDIT_PASS = "审核通过";
	
	
	/**
	 * 审核中
	 */
	public static final String AUDIT_ING = "审核中";
	
	
	/**
	 * 审核不通过
	 */
	public static final String AUDIT_FAILURE = "审核不通过";
	
	
	/**
	 * 审核对象为空
	 */
	public static final String AUDIT_NULL = "审核对象为空";
	
	/**
	 *申请人工审核成功
	 */
	public static final String ADD_MANUAL_AUDIT_SUCCESS = "申请人工审核成功！";
	
	
	/**
	 * 审核通过没有将数据保存到亮照数据表中
	 */
	public static final String DATA_EXCEPTION = "数据异常,审核通过没有将数据保存到亮照数据表中";
	
	
	/**
	 * 服务器内部错误,添加人工审核失败
	 */
	public static final String SERVER_EXCEPTION = "服务器内部错误,添加人工审核失败";
	
	
	/**
	 * 服务器内部错误,操作失败
	 */
	public static final String SERVER_ERROR = "服务器内部错误,操作失败";
	
	
	/**
	 * id问题的处理,防止在地址栏上修改ID而出现数据库查询未空
	 */
	public static final String ID_PARAM_FAILURE = "公司注册号错误！";
	
	//====================================================================

	/**
	 * 常用结论名称重复提示
	 */
	public static final String CONCLUSIONMSG = "常用结论名称已存在！";
	
	/**
	 * 更新成功
	 */
	public static final String UPDATE_SUCCESS = "更新成功！";
	/**
	 * 添加成功
	 */
	public static final String ADD_SUCCESS = "添加成功！";

	public static final String ERROR = "操作失败！";
	public static final String SUCCESS = "操作成功！";
	// 模块名称-样品类别管理
	public static final String MODEL_NAME_SAMPLE_TYPE = "样品类别管理";
	// 模块名称-检验标准管理
	public static final String MODEL_NAME_TEST_EVIDENCE = "检验标准管理";
	// 模块名称-检验项目管理
	public static final String MODEL_NAME_INDEXPROJ = "检验项目管理";
	public static final String MODEL_NAME_DICTIONARY = "数据字典";
	public static final String MODEL_NAME_DICTIONARY_TYPE = "数据字典";
	// 分包商
	public static final String MODEL_NAME_TSUBCON = "分包商管理";
	// 单位换算
	public static final String MODEL_NAME_UNITSCONVERT = "单位换算管理";
	// 报告期限规则
	public static final String MODEL_NAME_REPORTEXPIRES = "报告期限规则";
	// 项目结果配置
	public static final String MODEL_NAME_ITEMRESULT = "项目结果配置";
	// 模块名称-检验方法管理
	public static final String MODEL_NAME_METHOD = "检验方法管理";
	// 模块名称-客户管理
	public static final String MODEL_NAME_UNIT = "客户管理";
	// 模块名称-模版类别管理
	public static final String MODEL_NAME_TEMPLATE_TYPE = "模板类别";
	// 模块名称-模版管理
	public static final String MODEL_NAME_TEMPLATE = "模板管理";
	// 模块名称-仪器设备管理
	public static final String MODEL_NAME_EQUIPMENT = "仪器设备管理";
	// 模块名称-仪器设备管理
	public static final String MODEL_NAME_EQUIPMENT_REPAIR = "仪器设备维护";
	// 模块名称-仪器设备管理
	public static final String MODEL_NAME_EQUIPMENT_PRESERVE = "仪器设备保养维护";
	// 模块名称-设备说明书
	public static final String MODEL_NAME_EQUINSTRUCTION = "设备说明书";
	// 模块名称-配套设备
	public static final String MODEL_NAME_EQUMATCHING = "配套设备";
	// 模块名称-科室管理
	public static final String MODEL_NAME_DEPARTMENT = "科室管理";
	// 模块名称-用户管理
	public static final String MODEL_NAME_MEMBER = "用户管理";
	// 模块名称-权限管理
	public static final String MODEL_NAME_PERMISSION = "权限管理";
	// 模块名称-收费管理
	public static final String MODEL_NAME_FEE = "收费管理";
	// 模块名称-附加费用
	public static final String MODEL_NAME_ATTACHFEE = "附加费用";
	// 模块名称-项目费用
	public static final String MODEL_NAME_INDEXPROJFEE = "项目费用";
	// 受理登记
	// 模块名称-受理信息
	public static final String MODEL_NAME_ACCPTINFO = "受理信息";
	// 模块名称-样品信息
	public static final String MODEL_NAME_SAMPLEINFO = "样品信息";
	// 模块名称-样品库房管理
	public static final String MODEL_NAME_SAMPLEDEPOT = "样品库房";
	// 模块名称-设备使用管理
	public static final String MODEL_NAME_EQUUSAGE = "设备使用管理";
	// 模块名称-留样入库管理
	public static final String MODEL_NAME_SAMPLESTOCKIN = "留样入库";
	// 模块名称-留样领用管理
	public static final String MODEL_NAME_SAMPLERECEPTION = "留样领用";
	// 模块名称-方法价格配置
	public static final String MODEL_NAME_METHODPRICE = "方法价格配置";
	// 模块名称-留样归还管理
	public static final String MODEL_NAME_SAMPLERETURN = "留样归还";
	// 模块名称-留样处理管理
	public static final String MODEL_NAME_SAMPLEPROCESS = "留样处理";
	// 模块名称-留样查询
	public static final String MODEL_NAME_SAMPLEQUERY = "留样查询";
	// 模块名称-样品接收
	public static final String MODEL_NAME_SAMPLERECEIVE = "样品接收";
	// 留样管理
	public static final String MODEL_NAME_SAMPLERESERVED = "留样管理";
	// 模块名称-项目信息
	public static final String MODEL_NAME_ITEMINFO = "项目信息";
	// 模块名称-项目模板
	public static final String MODEL_NAME_ITEMTEMPLATE = "项目模板";
	// 模块名称-项目费用
	public static final String MODEL_NAME_RESULTINPUT = "结果录入";
	// 模块名称-项目费用
	public static final String MODEL_NAME_RECORDAUDIT = "记录审核";
	// 模块名称-报告领用
	public static final String MODEL_NAME_RECEIVEREPORT = "报告领用";
	// 查询
	// 模块名称-受理信息查询
	public static final String MODEL_NAME_QUERY_ACCEPTINFO = "受理信息查询";
	// 模块名称-自定义编码查询
	public static final String MODEL_NAME_CODERULE = "自定义编码查询";
	// 模块名称-收费管理
	public static final String MODEL_NAME_FEE_MGT = "收费管理查询";
	// 模块名称-报告编制
	public static final String MODEL_NAME_REPORTCOMPILE = "报告";
	// 模块名称-评价编写
	public static final String MODEL_NAME_EVALUATE = "评价";
	// 模块名称-评价编写
	public static final String MODEL_NAME_EVALUATEGENERATE = "评价生成";
	// 模块名称-报告生成
	public static final String MODEL_NAME_REPORTCOMPILE_GENERATE = "报告生成";
	// 模块名称-表单管理
	public static final String MODEL_NAME_FORM_MANAGEMENT = "表单管理";
	// 模块名称-节点回退
	public static final String MODEL_NAME_ROLLBACK = "节点回退";
	// 模块名称-流程管理
	public static final String MODEL_NAME_PROCESS_MANAGE = "流程管理";
	// 模块名称-易耗品类型管理
	public static final String MODEL_NAME_CONSUMABLETYPE = "易耗品类型";
	// 模块名称-盘点
	public static final String MODEL_NAME_STOCKCOUNT = "盘点";
	// 模块名称-盘点明细
	public static final String MODEL_NAME_STOCKCOUNTDETAIL = "盘点明细";
	// 模块名称-入库
	public static final String MODEL_NAME_STOCKIN = "入库";
	// 模块名称-入库明细
	public static final String MODEL_NAME_STOCKINDETAIL = "入库明细";
	// 模块名称-计量单位
	public static final String MODEL_NAME_UNITOFMEASURE = "计量单位管理";
	// 模块名称-库房明细
	public static final String MODEL_NAME_DEPOT = "库房管理";
	// 模块名称-库房使用人明细
	public static final String MODEL_NAME_DEPOTUSER = "库房使用人管理";
	// 模块名称-供应商管理
	public static final String MODEL_NAME_SUPPLIER = "供应商";
	// 模块名称-易耗品管理
	public static final String MODEL_NAME_CONSUMABLE = "易耗品";
	// 模块名称-易耗品管理
	public static final String MODEL_NAME_GOODSMOVE = "移库管理";
	// 模块名称-易耗品管理
	public static final String MODEL_NAME_GOODSOUTIN = "出库退库";
	// 模块名称-易耗品管理
	public static final String MODEL_NAME_INVENTORY = "库存管理";
	// 模块名称-库存查询
	public static final String MODEL_NAME_STOCKLIST = "库存查询";
	// 模块名称-业务单据查询
	public static final String MODEL_NAME_BUSINESSLIST = "业务单据查询";
	// 模块名称-预警管理
	public static final String MODEL_NAME_WARNING = "预警管理";
	// 模块名称-预警查询
	public static final String MODEL_NAME_WARNINGSELECT = "预警查询";
	// 模块名称-纸质文件受控管理
	public static final String MODEL_NAME_PAPER = "纸质文件受控管理";
	// 模块名称-纸质文件明细受控管理
	public static final String MODEL_NAME_PAPERDETAIL = "纸质文件明细受控管理";
	//模块名称-常用结论管理
	public static final String MODEL_NAME_ELECTRONIC = "常用结论维护";
	// 模块名称-评价管理
	public static final String MODEL_NAME_EVALUATIONREPORT = "评价管理";
	// 操作类型-添加
	public static final String OPERATE_TYPE_ADD = "添加";
	// 操作类型-保存
	public static final String OPERATE_TYPE_SAVE = "保存";
	// 操作类型-删除
	public static final String OPERATE_TYPE_DELETE = "删除";
	// 操作类型-发布流程
	public static final String OPERATE_TYPE_PUBULISH = "发布流程";
	// 操作类型-禁用流程
	public static final String OPERATE_TYPE_UNENABLE = "禁用流程";
	// 操作类型-启用流程
	public static final String OPERATE_TYPE_ENABLE = "启用流程";
	// 操作类型-变更流程
	public static final String OPERATE_TYPE_CHANAGE = "变更流程";

	// 操作类型-修改
	public static final String OPERATE_TYPE_MODIFY = "修改";
	// 操作类型-查询
	public static final String OPERATE_TYPE_QUERY = "查询";
	// 操作类型-上传
	public static final String OPERATE_TYPE_UPLOADING = "上传";
	// 操作类型-下载
	public static final String OPERATE_TYPE_DOWNLOAD = "下载";
	public static final String OPERATE_TYPE_SUBMIT = "提交";
	// 操作类型-打印
	public static final String OPERATE_TYPE_PRINT = "打印";
	
	// 操作结果-成功
	public static final int OPERATE_STATUS_SUCCESS = 1;
	// 操作结果-失败
	public static final int OPERATE_STATUS_FAIL = 2;

	// 上传文件临时存放地址
	public static final String UPLOADING_FILE_TEMP_ADDRESS = PropertiesUtil
			.getProperties("sys.upload.temp.dir", "");
	// 上传文件存放地址
	public static final String UPLOADING_FILE_ADDRESS = PropertiesUtil
			.getProperties("sys.upload.dir", "");
	// 模版输出地址
	public static final String TEMPLATE_RESULT_OUTPUT = PropertiesUtil
			.getProperties("sys.template.result.dir", "");

	/**
	 * 任务状态
	 */
	public static final int TASK_STATUS_TEMPORARY = 0;// 暂存
	public static final int TASK_STATUS_DEAL = 1;// 处理中
	public static final int TASK_STATUS_COMPLETE = 2;// 完成
	public static final String TASK_STATUS_TEMPORARY_TXT = "草稿";
	public static final String TASK_STATUS_DEAL_TXT = "处理中";
	public static final String TASK_STATUS_COMPLETE_TXT = "办结";

	/*
	 * 操作
	 */
	public static final int OPERATE_BACK = 3;
	// 委托
	public static final int OPERATE_ENTRUST = 6;
	// 保留意见
	public static final int OPERATE_RESERVATIONS = 5;
	public static final int OPERATE_SUBMIT = -1;
	public static final int OPERATE_STOP = 1;
	public static final int OPERATE_CANCEL = 2;
	public static final int OPERATE_DEAL = 0;// 正在办理

	// 业务类型
	public static final String BUSINESS_CP = "产品检验";

	// 规则启用
	public static final String RULE_SUCC = "1";
	// 规则禁用
	public static final String RULE_FAIL = "0";
	// 编码区域类型
	public static final String CODE_GD = "固定";
	public static final String CODE_RQ = "日期";
	public static final String CODE_SX = "顺序";

	// 样品分配业务类型 1.检测 2.审核
	public static final int BUSINESS_CHECK = 1;
	public static final int BUSINESS_AUDI = 2;
	public static final String BUSINESS_NOCHOICE = "0";

	// 派发目标类型 1.部门，2用户，3.角色

	public static final int DIS_DEPT = 1;
	public static final int DIS_USER = 2;
	public static final int DIS_ROLE = 3;
	// 易耗品操作类型
	public static final int IN = 1;// 入库
	public static final int OUT = 2;// 出库
	public static final int MOVE = 3;// 移库
	public static final int REFUND = 4;// 退库
	public static final int RETURN_GOODS = 5;// 退货

	/** 审核通过1.审核不通过0 */
	public static final int AUDI_PASS = 1;
	public static final int AUDI_NOPASS = 0;

	/** 标准曲线常量 */
	public static final String METHOD_EQUATION_Y = "y";
	public static final String METHOD_EQUATION_X = "x";

	/**
	 * 
	 * @Title: deleteMessage
	 * @Description: 删除成功消息
	 * @param size
	 *            条数
	 * @return 结果
	 */
	public static String deleteMessage(int size) {
		return "删除成功,一共删除" + size + "条！";
	}
	
	/**
	 * 
	 * @Title: copyMessage
	 * @Description: 复制成功消息
	 * @param size
	 *            条数
	 * @return 结果
	 */
	public static String copyMessage(int size) {
		return "复制成功,一共复制" + size + "条！";
	}

	// 易耗品管理 出入库类型
	public static final String STORE_IN_OUT_TYPE_MOVE = "移库";
	/**
	 * 从memcached中取部门的key前缀
	 */
	public static final String DEPART_PREFIX = "depart_";
	/**
	 * 从memcached中取人员的key前缀
	 */
	public static final String USER_PREFIX = "user_";
	/**
	 * 从memcached中取所有的人员
	 */
	public static final String ALL_USERS = "allUser";
	/**
	 * 从memcached中取所有的部门
	 */
	public static final String ALL_DEPART = "allDepart";
	/**
	 * 从memcached中取某一个部门的所有人员,后面跟部门的id
	 */
	public static final String USER_BY_DEPART_PREFIX = "usersBydepart_";
	/**
	 * 从memcached中取所有的角色
	 */
	public static final String ALL_ROLES = "allRoles";

	/**
	 * 从memcached中取角色的key前缀
	 */
	public static final String ROLE_PREFIX = "role_";

	/**
	 * 从memcached中取某一个角色的所有人员,后面跟部门的id
	 */
	public static final String USER_BY_ROLE_PREFIX = "usersByRole_";

	/**
	 * 文档管理 文档文件上传路径
	 */
	public static final String SYS_UPLOAD_DOCFILE = "sys.upload.docfile";

	/** Constant <code>SYS_UPLOAD_DIR="sys.upload.dir"</code> */
	public static final String SYS_UPLOAD_DIR = "sys.upload.dir";
	/**
	 * 文件上传临时文件夹
	 */
	public static final String SYS_UPLOAD_TEM_DIR = "sys.upload.temp.dir";
	/**
	 * 报告签章地址
	 */
	public static final String SYS_UPLOAD_REPORT_INIT = "sys.uploda.reportInit";
	
	/**
	 * 收费类型
	 */
	public static final String CHARGE_TYPE = "检测收费";
	public static final String MSG_DEL_NULL = "请选择需要删除的数据!";

	
	
}
