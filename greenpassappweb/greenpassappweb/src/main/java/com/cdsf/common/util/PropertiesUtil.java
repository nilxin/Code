/**
 * @Title: PropertiesUtil.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年8月2日
 * @version 2.0
 */
package com.cdsf.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Title: PropertiesUtil
 * @Description:
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年8月2日
 */
public class PropertiesUtil {
	/**
	 * 日志
	 */
	protected static Logger logger = LoggerFactory
			.getLogger(PropertiesUtil.class);
	/**
	 * 静态属性
	 */
	private static Properties properties = new Properties();
	/**
	 * 静态块
	 */
	static {
		init();
	}

	/**
	 * 
	 * @Title: init
	 * @Description:静态初始化方法
	 */
	private static void init() {

		String path = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getRealPath("")
				+ File.separator + "WEB-INF" + File.separator + "conf";
		File directory = new File(path);
		if (directory.isDirectory()) {
			File[] files = directory.listFiles();
			if (files != null && files.length > 0) {
				for (File file : files) {
					if (file.getName().endsWith(".properties")) {
						loadFile(file);
					}
				}
			}
		}

	}

	// private static void loadFile(String path) {
	// try {
	// properties.load(new FileInputStream(path));
	// } catch (FileNotFoundException e) {
	// logger.error("没有找到文件：" + path, e);
	// } catch (IOException e) {
	// logger.error("文件读写错误", e);
	// }
	// }

	private static void loadFile(File path) {
		try {
			properties.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			logger.error("没有找到文件：" + path, e);
		} catch (IOException e) {
			logger.error("文件读写错误", e);
		}
	}

	/**
	 * 
	 * @Title: getProperties
	 * @Description: 得到属性
	 * @param key
	 *            key
	 * @param defaultValue
	 *            没有找到后 默认值
	 * @return 返回值
	 */
	public static String getProperties(String key, String defaultValue) {
		String value = properties.getProperty(key, defaultValue);
		return value;

	}
}
