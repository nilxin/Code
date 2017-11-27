package com.cdsf.configure;

import java.util.List;

import com.cdsf.webmvc.paginator.Page;
import com.cdsf.webmvc.paginator.Pageable;

/**
 * 
 * <p>
 * 基础数据管理层接口
 * </p>
 * 
 * @author CBird
 * 
 */
public interface AbstractMapper {

	/**
	 * 分页列表
	 * 
	 * @param p
	 * @return
	 */
	<T> Page<T> list(Pageable p);

	/**
	 * 条件分页列表
	 * 
	 * @param obj
	 * @param p
	 * @return
	 */
	<T> Page<T> list(Object obj, Pageable p);

	/**
	 * 列表所有数据
	 * 
	 * @return
	 */
	<T> List<T> list();
	
	/**
     * 列表所有数据
     * 
     * @return
     */
    <T> List<T> list(Object obj);

	/**
	 * 条件统计数量
	 * 
	 * @param obj
	 * @return
	 */
	int count(Object obj);

	/**
	 * 统计所有数量
	 * 
	 * @return
	 */
	int count();

	/**
	 * 查询单个数据
	 * 
	 * @return
	 */
	<T> T find();
	

	/**
	 * 条件查询单个数据
	 * 
	 * @param obj
	 * @return
	 */
	<T> T find(Object obj);

	/**
	 * 新增记录
	 * 
	 * @param obj
	 * @return
	 */
	void add(Object obj);

	/**
	 * 修改记录
	 * 
	 * @param obj
	 * @return
	 */
	int mod(Object obj);

	/**
	 * 删除指定ID的记录
	 * 
	 * @param ids
	 * @return
	 */
	int del(Object obj);
	
}
