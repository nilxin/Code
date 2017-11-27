/**
 * @Title: SystemCache.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年11月17日
 * @version 2.0
 */
package com.cdsf.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * @Title: SystemCache
 * @Description:
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年11月17日
 */
public class SystemCache {
	/**
	 * 系统缓存
	 */
	protected static Map<Object, Object> globalCache = new ConcurrentHashMap<Object, Object>();
	protected static Map<Object, Object> userCache = new ConcurrentHashMap<Object, Object>();

	/**
	 * 
	 * @Title: getKey
	 * @Description: 得到数据（根据结果类型）
	 * @param object
	 *            key
	 * @param t
	 *            得到的数据类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getGlobalKey(Object object, Class<T> t) {
		if (t != null) {
			if (globalCache.containsKey(object)) {
				return ((T) ConvertUtils.convert(globalCache.get(object), t));
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: getKey
	 * @Description: 得到数据
	 * @param key
	 *            键
	 * @return 值
	 */
	public static Object getGlobalKey(Object key) {
		return globalCache.get(key);
	}

	/**
	 * 
	 * @Title: updateData
	 * @Description:根据键值对更新数据，如果缓存里面没有这个键，将不会处理。
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public static void updateglobalCache(Object key, Object value) {
		if (globalCache.containsKey(key)) {
			globalCache.put(key, value);
		}
	}
}
