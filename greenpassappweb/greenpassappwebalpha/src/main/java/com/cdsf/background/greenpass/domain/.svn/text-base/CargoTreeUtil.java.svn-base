package com.cdsf.background.greenpass.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cdsf.utils.Tools;


/**
 * @author Michael
 *
 * 2017年4月27日
 *
 * 货品树工具
 */
public class CargoTreeUtil {

	public static List<CargoTree> toParentAndSort(List<CargoTree> cargoTrees) throws Exception{
		if(cargoTrees!=null && !cargoTrees.isEmpty()){
			List<CargoTree> result = new ArrayList<CargoTree>();
			Map<Object,CargoTree> map = new HashMap<Object,CargoTree>();
			for (CargoTree tree : cargoTrees) {
				if(tree.getId() !=null && tree.getId() instanceof Long){
					result.add(tree);
				}
				map.put(tree.getId(), tree);
			}
			for (CargoTree tree : cargoTrees) {
				CargoTree parent = map.get(tree.getParentId());
				if(parent!=null){
					if(parent.getChildren() == null){
						parent.setChildren(new ArrayList<CargoTree>());
					}
					parent.getChildren().add(tree);
				}
			}
			if(!Tools.isEmpty(result)){
				toSort(result);
			}
			return result;
			
		}
		return null;
	}
	
	
	private static void toSort(List<CargoTree> trees) throws Exception{
		if(!Tools.isEmpty(trees)){
			Collections.sort(trees,new CargoTreeSort());
			for (CargoTree cargoTree : trees) {
				List<CargoTree> lists = cargoTree.getChildren();
				if(!Tools.isEmpty(lists)){
					toSort(lists);
				}
			}
		}
	}
	
	
	
	public static class CargoTreeSort implements Comparator<CargoTree>{

		@Override
		public int compare(CargoTree o1, CargoTree o2) {
			//根据id来进行排序  由小到大来排列
			if(o1.getId() instanceof Long && o2.getId() instanceof Long){
				if(o1.getId() > o2.getId()){
					return 1;
				}else if(o1.getId() < o2.getId()){
					return -1;
				}else{
					return 0;
				}
			}
			return 0;
		}
		
	}
	
	//把所有的层级关系挂靠在一起
	public static List<CargoTree> toTreeModel(List<CargoTree> cargoTrees) throws Exception{
		//保存结果的result
		List<CargoTree> result = new ArrayList<CargoTree>();
		//把所有的对象都先放入Map中,map的查找效率很高
		Map<Object,CargoTree> map = new HashMap<Object,CargoTree>();
		//判断父集,递归查找,找到该元素就删除不再次遍历该元素
		
		//1.放入Map集合中
		for (CargoTree cargoTree : cargoTrees) {
			if(cargoTree.getId()!=null && cargoTree.getId() instanceof Long){
				map.put(cargoTree.getId(), cargoTree);
			}
		}
		
		//2.确立父子关系
		for (CargoTree cargoTree : cargoTrees) {
			CargoTree parent = map.get(cargoTree.getParentId());
			if(parent !=null){
				if(Tools.isEmpty(parent.getChildren())){
					parent.setChildren(new ArrayList<CargoTree>());
				}
				parent.getChildren().add(cargoTree);
 			}
		}
		
		//3.存放结果,只需要放入最顶层的数据即可
		for (CargoTree cargoTree : cargoTrees) {
			if(cargoTree.getParentId() instanceof Long && cargoTree.getParentId().intValue() == -1 ){
				result.add(cargoTree);
			}
		}
		
		//4.排序
		if(!Tools.isEmpty(result)){
			toSort(result);
		}
		
//		for(Iterator<CargoTree> it = trees.iterator();it.hasNext();){
//		}
		return result;
	}
}
