/*
 * @(#) egov-powerlist Tools.java Jun 16, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.cdsf.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.cdsf.webmvc.exception.BusinessException;

/**
 * <p>
 * Title: Tools.java
 * </p>
 * <p>
 * Description: 工具类
 * </p>
 * <p>
 * Copyright:Copyright(c)2014
 * </p>
 * <p>
 * Company: 成都四方
 * </p>
 * <p>
 * CreateTime:Jun 16, 2014 2:28:00 PM
 * </p>
 * 
 * @author wangshuang
 * @version 1.0
 **/
public abstract class Tools {

	/**
	 * 判断参数是否为空，不为空返回false, 为空返回true
	 * 
	 * @author wangshuang
	 * @creaetime Jun 16, 2014 2:29:06 PM
	 * @param obj
	 *            判断参数
	 * @return 不为空返回false, 为空返回true
	 */
	public static boolean isNotNull(Object obj) {
		return obj != null && !"null".equals(obj) && !"".equals(obj);
	}

	public static boolean isNull(String str) {
		return str == null || "".equals(str.trim());
	}

	public static boolean isNotNull(String str) {
		return str != null && !"".equals(str.trim());
	}

	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	public static boolean isNotEmpty(Object[] array) {
		return array != null && array.length > 0;
	}

	public static boolean isEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(Set<?> set) {
		if (set == null || set.isEmpty()) {
			return true;
		}
		return false;
	}


	/**
	 * 判断参数是否为空，为空返回ture, 不为空返回false
	 * 
	 * @author wangshuang
	 * @creaetime Jun 23, 2014 9:10:23 AM
	 * @param obj
	 *            待判断参数
	 * @return 为空返回true, 不为空返回false
	 */
	public static boolean isNull(Object obj) {
		return obj == null || "null".equals(obj);
	}

	/**
	 * 方法描述：格式化时间为字符串
	 * 
	 * @creator ZhengQiu
	 * @param Type
	 * @param time
	 * @return
	 */
	public static String formatDateToStr(int type, Date time) {
		if (time == null) {
			return "";
		}
		String format = getPattern(type);
		return new SimpleDateFormat(format)
				.format(Long.valueOf(time.getTime()));
	}

	/**
	 * 格式化字符串为时间
	 * 
	 * @param type
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date formateStrToDate(int type, String time)
			throws ParseException {
		if (Tools.isNull(time)) {
			return null;
		}
		String format = getPattern(type);
		return new SimpleDateFormat(format).parse(time);
	}

	public static String getPattern(int formatIndex) {
		String format = null;
		switch (formatIndex) {
			case -2:
				format = "HH:mm:ss.S";
				break;
			case -1:
				format = "yyyy-MM-dd HH:mm:ss.S";
				break;
			case 0:
				format = "yyyy-MM-dd HH:mm:ss";
				break;
			case 1:
				format = "yyyy-MM-dd 00:00:00";
				break;
			case 2:
				format = "yyyy-MM-dd 23:59:59";
				break;
			case 3:
				format = "yyyy-MM-dd";
				break;
			case 4:
				format = "yyyy-MM";
				break;
			case 5:
				format = "yyyy-MM-dd HH:mm:ss";
				break;
			case 6:
				format = "yyyy-01-01 00:00:00";
				break;
			case 7:
				format = "yyyy-12-31 23:59:59";
				break;
			case 8:
				format = "yyyy-MM-01 00:00:00";
				break;
			case 10:
				format = "yyyyMMddHHmmss";
				break;
			case 11:
				format = "yyyyMMddHHmmssS";
				break;
			case 12:
				format = "yyyy年MM月dd日";
				break;
			case 13:
				format = "yyyyMMdd-HHmmssS";
				break;
			case 14:
				format = "yyyyMMdd";
				break;
			default:
				format = "yyyy-MM-dd HH:mm:ss";
		}
		return format;
	}

	// /**
	// * 拼装删除字符串
	// * @author wangshuang
	// * @creaetime Jul 1, 2014 3:33:29 PM
	// * @param object
	// * @return
	// */
	// public static List<String> getFlowIds(Object object){
	// String flowIds = String.valueOf(object);
	// String[] split = flowIds.split(Constants.COMMA);
	// return Arrays.asList(split);
	// }
	//
	/**
	 * 创建uuid
	 * 
	 * @author wangshuang
	 * @creaetime Jul 2, 2014 6:12:50 PM
	 * @return
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取通用格式时间对象
	 * 
	 * @author CodingBoy
	 * @creaetime 2014年7月18日 上午9:18:29
	 * @return
	 * @throws ParseException
	 */
	public static Date getCommonDate() throws ParseException {
		return Tools.formateStrToDate(0, Tools.formatDateToStr(0, new Date()));
	}

	/**
	 * 
	 * @author wangshuang
	 * @creaetime Aug 4, 2014 3:50:04 PM
	 * @param type
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static boolean startTimeLowerThanEndTime(int type, String startDate,
			String endDate) throws ParseException {
		Date startD = Tools.formateStrToDate(type, startDate);
		Date endD = Tools.formateStrToDate(type, endDate);
		if (startD.getTime() > endD.getTime()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: deepcopy
	 * @Description: list进行克隆
	 * @param src
	 *            源
	 * @return 克隆实体
	 * @throws IOException
	 *             IOException
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException
	 */
	public static List deepcopy(List src) throws IOException,
			ClassNotFoundException {

		ByteArrayOutputStream byteout = new ByteArrayOutputStream();

		ObjectOutputStream out = new ObjectOutputStream(byteout);

		out.writeObject(src);

		ByteArrayInputStream bytein = new ByteArrayInputStream(
				byteout.toByteArray());

		ObjectInputStream in = new ObjectInputStream(bytein);

		List dest = (List) in.readObject();

		return dest;

	}

	/**
	 * 根据编码规则自动生成规则条件
	 * 
	 * @Title: testgetRulePos
	 * @Description:
	 * @param map
	 * @return
	 */
	public static List<Object> testgetRulePos(Map<String, String> map) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());

		SimpleDateFormat dateyear = new SimpleDateFormat("yy");
		String yYear = dateyear.format(new Date());

		String type = map.get("type");
		String codeType = map.get("codeType");
		String[] types = type.split("-");
		String[] codeTypes = codeType.split("-");
		List<String> rulePos = new ArrayList<String>();

		for (int i = 0; i < types.length; i++) {
			String pos = "";
			if ("日期".equals(types[i])) {
				String dateType = codeTypes[i];
				if ("yyyyMMdd".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						for (int k = 1; k < 32; k++) {
							String jd = k + "";
							if (k < 10) {
								jd = 0 + "" + k;
							}
							String dates = year + jm + jd;
							rulePos.add(dates);
						}

					}
				} else if ("yyyyMM".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						String dates = year + jm;
						rulePos.add(dates);
					}
				} else if ("MMdd".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						for (int k = 1; k < 32; k++) {
							String jd = k + "";
							if (k < 10) {
								jd = 0 + "" + k;
							}
							String dates = jm + jd;
							rulePos.add(dates);
						}
					}
				} else if ("yyMMdd".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						for (int k = 1; k < 32; k++) {
							String jd = k + "";
							if (k < 10) {
								jd = 0 + "" + k;
							}
							String dates = yYear + jm + jd;
							rulePos.add(dates);
						}

					}
				} else if ("yyMM".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						String dates = yYear + jm;
						rulePos.add(dates);
					}
				}

				else if ("MMyyyy".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						String dates = jm + year;
						rulePos.add(dates);
					}
				}

				if ("ddMMyyyy".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						for (int k = 1; k < 32; k++) {
							String jd = k + "";
							if (k < 10) {
								jd = 0 + "" + k;
							}
							String dates = jd + jm + year;
							rulePos.add(dates);
						}

					}
				}

				else if ("MMyy".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						String dates = jm + yYear;
						rulePos.add(dates);
					}
				}

				else if ("ddMMyy".equals(dateType)) {
					for (int j = 1; j < 13; j++) {
						String jm = j + "";
						if (j < 10) {
							jm = 0 + "" + j;
						}
						for (int k = 1; k < 32; k++) {
							String jd = k + "";
							if (k < 10) {
								jd = 0 + "" + k;
							}
							String dates = jd + jm + yYear;
							rulePos.add(dates);
						}

					}
				} else if ("yyyy".equals(dateType)) {

					String dates = year;
					rulePos.add(dates);
				} else if ("yy".equals(dateType)) {
					String dates = yYear;
					rulePos.add(dates);
				}

			}

		}

		return null;
	}

	/**
	 * 根据编码规则自动生成规则条件
	 * 
	 * @Title: getRulePos
	 * @Description:
	 * @param map
	 * @return
	 */
	public static Map<String, Object> getRulePos(Map<String, List<String>> map) {
		Map<String, Object> codeMap = new HashMap<String, Object>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());

		SimpleDateFormat dateyear = new SimpleDateFormat("yy");
		String yYear = dateyear.format(new Date());

		SimpleDateFormat simmonth = new SimpleDateFormat("MM");
		String month = simmonth.format(new Date());

		SimpleDateFormat simday = new SimpleDateFormat("dd");
		String day = simday.format(new Date());

		List<String> types = map.get("type");
		List<String> codeTypes = map.get("codeType");
		// List<String> rulePos = new ArrayList<String>();
		String ruleYear = "";
		String demoYear = "";
		String pos = "";
		String demoCode = "";
		if ((!Tools.isEmpty(types)) && (!Tools.isEmpty(codeTypes))) {
			for (int i = 0; i < types.size(); i++) {

				if ("日期".equals(types.get(i))) {
					String dateType = codeTypes.get(i);
					if ("yyyyMMdd".equals(dateType)) {
						ruleYear = year + "____";
						demoYear = year + month + day;
					} else if ("yyyyMM".equals(dateType)) {
						ruleYear = year + "__";
						demoYear = year + month;
					} else if ("yyMMdd".equals(dateType)) {
						ruleYear = yYear + "____";
						demoYear = yYear + month + day;
					} else if ("yyMM".equals(dateType)) {
						ruleYear = yYear + "__";
						demoYear = yYear + month;
					}

					else if ("MMyyyy".equals(dateType)) {
						ruleYear = "__" + year;
						demoYear = month + year;
					}

					else if ("ddMMyyyy".equals(dateType)) {
						ruleYear = "____" + year;
						demoYear = day + month + year;
					}

					else if ("ddMMyy".equals(dateType)) {
						ruleYear = "____" + yYear;
						demoYear = day + month + yYear;

					} else if ("MMyy".equals(dateType)) {
						ruleYear = "__" + yYear;
						demoYear = month + yYear;

					} else if ("yyyy".equals(dateType)) {
						ruleYear = year;
						demoYear = year;
					} else if ("yy".equals(dateType)) {
						ruleYear = yYear;
						demoYear = yYear;
					} else {
						ruleYear = year;
						demoYear = year;
					}
					demoCode = demoCode + demoYear;
					// if (i != 0) {
					// pos = pos + "-" + ruleYear;
					// demoCode = demoCode + "-" + demoYear;
					// } else {
					// pos += ruleYear;
					// demoCode += demoYear;
					// }

				} else if ("固定".equals(types.get(i))) {
					demoCode = demoCode + codeTypes.get(i);
					// if (i != 0) {
					// pos = pos + "-" + codeTypes[i];
					// demoCode = demoCode + "-" + codeTypes[i];
					// } else {
					// pos += codeTypes[i];
					// demoCode += codeTypes[i];
					// }
				} else if ("顺序".equals(types.get(i))) {
					int index = Integer.parseInt(codeTypes.get(i));
					String ind = "";
					String line = "";
					for (int y = 0; y < index; y++) {
						if (y != index - 1) {
							ind += "0";
						} else {
							ind += "1";
						}
						
					}
					demoCode = demoCode + ind;
					// if (i != 0) {
					// pos = pos + "-" + line;
					// demoCode = demoCode + "-" + ind;
					// } else {
					// pos += line;
					// demoCode += ind;
					// }
				}
			}
		}
		// 自定义编码长度不能超过50
		if (demoCode.length() > 50) {
			throw new BusinessException("编码长度不能超过50");
		}
		codeMap.put("demoCode", demoCode);
		codeMap.put("posCode", pos);
		codeMap.put("type", types);
		codeMap.put("codeType", codeTypes);
		codeMap.put("id", map.get("id"));
		return codeMap;
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", "日期-顺序-固定");
		map.put("codeType", "yyyyMMdd-4-QWE");
		map.put("codeValue", "20140505-0034-QWE");
		String acceptCode = "KKMM-2015-007";
		String maxSampleCode = "KKMM-2015-007_003";
		String indexValue = maxSampleCode.substring(
				maxSampleCode.lastIndexOf("_") + 1, maxSampleCode.length());
		int num = Integer.parseInt(indexValue);
		String value = (num + 1) + "";
		if (value.length() == 1) {
			value = "00" + value;
		} else if (value.length() == 2) {
			value = "0" + value;
		}
		String sampleCode = acceptCode + "_" + value;
	}

	
	/**
	* 判断字符串数组中是否包含某字符串元素
	*
	* @param substring 某字符串
	* @param source 源字符串数组
	* @return 包含则返回true，否则返回false
	*/
	public static boolean isIn(String substring, String[] source) {
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}
}
