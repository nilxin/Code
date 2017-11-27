package com.cdsf.background.greenpass.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 *
 * 2017年4月26日
 * 
 * CargoTree 货品树
 */
public class CargoTree implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long id;//主键id
	
	private String  cargoName; //货品名称
	
	private Long parentId; //父id 
	
	private List<CargoTree> children; // 子节点
	
	private Long sortKey;// 指定的排序号 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<CargoTree> getChildren() {
		return children;
	}

	public void setChildren(List<CargoTree> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getSortKey() {
		return sortKey;
	}

	public void setSortKey(Long sortKey) {
		this.sortKey = sortKey;
	}

	@Override
	public String toString() {
		return "CargoTree [id=" + id + ", cargoName=" + cargoName + ", parentId=" + parentId + ", children=" + children
				+ "]";
	}

	// Test 
	public static void main(String[] args) throws Exception {
		CargoTree cargoTree = new CargoTree();
		cargoTree.setId(1L);
		cargoTree.setCargoName("A");
		cargoTree.setParentId(null);
		List<CargoTree> childrens = new ArrayList<CargoTree>();
		CargoTree cargoTree1 = new CargoTree();
		cargoTree1.setId(2L);
		cargoTree1.setCargoName("A1");
		cargoTree1.setParentId(1L);
		CargoTree cargoTree2 = new CargoTree();
		cargoTree2.setId(3L);
		cargoTree2.setCargoName("A2");
		cargoTree2.setParentId(1L);
		childrens.add(cargoTree2);
		childrens.add(cargoTree1);
		cargoTree.setChildren(childrens);
		CargoTree cargoTree3 = new CargoTree();
		cargoTree3.setId(4L);
		cargoTree3.setCargoName("B");
		cargoTree3.setParentId(null);
		List<CargoTree> list = new ArrayList<CargoTree>();
		list.add(cargoTree);
		list.add(cargoTree3);
		System.out.println("xxxxxxx sort before xxxxxxx");
		System.out.println(list);
		System.out.println("xxxxxxx sort ago| xxxxxxx");
		System.out.println(CargoTreeUtil.toParentAndSort(list));
		
		System.out.println(System.getProperty("user.dir"));
	}
	
}
