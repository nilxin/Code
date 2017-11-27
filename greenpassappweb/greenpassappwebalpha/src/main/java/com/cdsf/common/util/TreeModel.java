/**
 * @Title: TreeModel.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年12月5日
 * @version 2.0
 */
package com.cdsf.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: TreeModel
 * @Description:
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年12月5日
 */
public class TreeModel {
	private Object id;
	private Object parent;
	private Object sort;
	private List<TreeModel> children;

	/**
	 * 
	 * @return id
	 */
	public Object getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * 
	 * @return parent
	 */
	public Object getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Object parent) {
		this.parent = parent;
	}

	/**
	 * 
	 * @return sort
	 */
	public Object getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(Object sort) {
		this.sort = sort;
	}

	/**
	 * 
	 * @return children
	 */
	public List<TreeModel> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public static void main(String[] args) throws Exception {
		List<TreeModel> list = new ArrayList<TreeModel>();
		TreeModel treeModel = new TreeModel();
		treeModel.setId(1);
		treeModel.setSort(1);

		TreeModel treeModel1 = new TreeModel();
		treeModel1.setId(2);
		treeModel1.setSort(2);

		TreeModel treeModel2 = new TreeModel();
		treeModel2.setId(3);
		treeModel2.setSort(3);

		TreeModel treeModel4 = new TreeModel();
		treeModel4.setId(5);
		treeModel4.setParent(2);
		treeModel4.setSort(1);

		TreeModel treeModel6 = new TreeModel();
		treeModel6.setId(6);
		treeModel6.setParent(5);
		treeModel6.setSort(1);

		TreeModel treeModel7 = new TreeModel();
		treeModel7.setId(7);
		treeModel7.setParent(5);
		treeModel7.setSort(2);

		list.add(treeModel);
		list.add(treeModel1);
		list.add(treeModel2);
		list.add(treeModel4);
		list.add(treeModel6);
		list.add(treeModel7);
		List<TreeModel> models = TreeUtils.toParentAndSort(list);
		System.out.println(models);

		// treeModel.setParent(parent);
	}
}
