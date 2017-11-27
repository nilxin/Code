package com.cdsf.configure;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdsf.webmvc.paginator.Pageable;

@Transactional
public interface IService {

	/**
	 * 列表查询
	 * 
	 * @param f
	 * @param p
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	List<?> list(Map<String, Object> map, Pageable p) throws Exception;

	/**
	 * 添加
	 * 
	 * @param obj
	 * @throws Exception
	 */
	void add(Object obj) throws Exception;

	/**
	 * 修改
	 * 
	 * @param obj
	 * @throws Exception
	 */
	void mod(Object obj) throws Exception;

	/**
	 * 删除
	 * 
	 * @param delForm
	 * @return
	 * @throws Exception
	 */
	String del(List<String> ids) throws Exception;

}
