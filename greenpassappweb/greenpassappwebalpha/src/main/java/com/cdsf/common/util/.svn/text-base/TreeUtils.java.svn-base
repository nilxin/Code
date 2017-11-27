/**
 * @Title: TreeUtils.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年12月5日
 * @version 2.0
 */
package com.cdsf.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: TreeUtils
 * @Description:
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年12月5日
 */
public class TreeUtils {
	/**
	 * 
	 * @Title: toParentAndSort
	 * @Description: 进行递归查询并排序
	 * @param treeModels
	 *            需要进行递归排序的集合
	 * @return 排序结果
	 * @throws Exception
	 */
	public static List<TreeModel> toParentAndSort(List<TreeModel> treeModels)
			throws Exception {
		if (treeModels != null && !treeModels.isEmpty()) {
			List<TreeModel> result = new ArrayList<TreeModel>();
			Map<Object, TreeModel> map = new HashMap<Object, TreeModel>();
			// 1.得到所有的一级目录
			for (TreeModel data : treeModels) {
				if (data.getId() != null) {
					if (data.getId() instanceof String) {
						if (data.getParent() == null) {
							result.add(data);
						}
					} else if (data.getId() instanceof Integer) {
						if (data.getParent() == null
								|| ((Integer) data.getParent()).intValue() == 0) {
							result.add(data);
						}
					} else if (data.getId() instanceof Long) {
						if (data.getParent() == null
								|| ((Long) data.getParent()).intValue() == 0) {
							result.add(data);
						}
					} else {
						throw new Exception("树形结构的主键不是String或者Integer或者Long");
					}

					map.put(data.getId(), data);
				} else {
					throw new Exception("树形结构的主键值为空");
				}
			}
			for (TreeModel data : treeModels) {
				TreeModel parent = map.get(data.getParent());
				if (parent != null) {
					if (parent.getChildren() == null) {
						parent.setChildren(new ArrayList<TreeModel>());
					}
					parent.getChildren().add(data);

				}
			}
			if (result != null && !result.isEmpty()) {
				toSort(result);
			}
			return result;
		}
		return null;
	}

	/**
	 * 
	 * @Title: toSort
	 * @Description: 递归排序
	 * @param treeModels
	 *            拍完许的结果
	 */
	private static void toSort(List<TreeModel> treeModels) {
		if (treeModels != null && !treeModels.isEmpty()) {
			Collections.sort(treeModels, new TreeModelSort());
			for (TreeModel treeModel : treeModels) {
				List<TreeModel> chilren = treeModel.getChildren();
				if (chilren != null && !chilren.isEmpty()) {
					toSort(chilren);
				}
			}
		}
	}

	public static class TreeModelSort implements Comparator<TreeModel> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(TreeModel o1, TreeModel o2) {

			if (o1.getSort() != null && o2.getSort() != null) {
				if ((o1.getSort() instanceof String)
						&& (o2.getSort() instanceof String)) {
					if (((String) o1.getSort()).compareTo(((String) o2
							.getSort())) > 0) {
						return 1;
					} else if (((String) o1.getSort()).compareTo(((String) o2
							.getSort())) < 0) {
						return -1;
					} else {
						return 0;
					}

				} else if ((o1.getSort() instanceof Integer)
						&& (o2.getSort() instanceof Integer)) {
					if (((Integer) o1.getSort()) > ((Integer) o2.getSort())) {
						return 1;
					} else if (((Integer) o1.getSort()) < ((Integer) o2
							.getSort())) {
						return -1;
					} else {
						return 0;
					}
				} else if ((o1.getSort() instanceof Long)
						&& (o2.getSort() instanceof Long)) {
					if (((Long) o1.getSort()) > ((Long) o2.getSort())) {
						return 1;
					} else if (((Long) o1.getSort()) < ((Long) o2.getSort())) {
						return -1;
					} else {
						return 0;
					}
				}
			}
			return 0;
		}
	}
}
