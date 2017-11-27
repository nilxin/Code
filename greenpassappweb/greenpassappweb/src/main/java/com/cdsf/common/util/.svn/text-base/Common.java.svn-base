package com.cdsf.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @Title: Common
 * @Description: 公共类
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年7月26日
 */
public class Common {
	/**
	 * 
	 */
	private static String time = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 
	 */
	private static String dates = "yyyy-MM-dd";

	/**
	 * 
	 * @Title: getTimeStr
	 * @Description: 返回time
	 * @param date
	 *            时间
	 * @return time
	 */
	public static String getTimeStr(Date date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat(time);
		return timeFormat.format(date);
	}

	/**
	 * 
	 * @Title: getTimeStr
	 * @Description: 返回time
	 * @param date
	 *            时间
	 * @return time
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dates);
		return dateFormat.format(date);
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String getProjectName() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getContextPath();
	}

	public static String getServerPort() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getServerPort() + "";
	}

	public static boolean validateData(String data, String regex) {
		if (regex.contains("大于>")) {
			regex = regex.replace("大于>", "");
			long dataTem = 0;
			try {
				dataTem = Long.parseLong(data);
			} catch (Exception e) {
				return false;
			}
			long regexTem = Long.parseLong(regex);
			return dataTem > regexTem;
		} else if (regex.contains("小于<")) {
			regex = regex.replace("小于<", "");
			long dataTem = 0;
			try {
				dataTem = Long.parseLong(data);
			} catch (Exception e) {
				return false;
			}
			long regexTem = Long.parseLong(regex);
			return dataTem < regexTem;
		} else {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(data);
			return matcher.find();
		}
	}

	/**
	 * 
	 * @Title: installFilePath
	 * @Description: 组装图片地址
	 * @return 地址
	 */
	public static String installFilePath() {

		String realPath = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getServletContext().getRealPath("/");
		String basePath = realPath + "photo";

		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR) + "";
		String month = (calendar.get(Calendar.MONTH) + 1) + "";
		String day = calendar.get(Calendar.DATE) + "";
		basePath = basePath + File.separator + year + File.separator + month
				+ File.separator + day;
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdirs();
		}

		return basePath;
	}

}
