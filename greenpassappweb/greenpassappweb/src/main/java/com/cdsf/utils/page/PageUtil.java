package com.cdsf.utils.page;

/**
 * 
 * 简单的分页对象
 *
 */
public class PageUtil {
	/** 页数 */
	protected int index = -1;
	/** 分页大小 */
	protected int rows = Integer.MAX_VALUE;
	
	public PageUtil(int index, int rows) {
		super();
		setIndex(index);
		setRows(rows);
	}
	public PageUtil() {
		super();
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		if(index <= 0){
			index = 1;
		}
		this.index = index;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		if(rows <= 0){
			rows = Integer.MAX_VALUE;
		}
		this.rows = rows;
	}
	
	public int getOffset() {
		return (index - 1) * rows;
	}
	
	@Override
	public String toString() {
		return "PageUtil [index=" + index + ", rows=" + rows + "]";
	}
	
	
}
