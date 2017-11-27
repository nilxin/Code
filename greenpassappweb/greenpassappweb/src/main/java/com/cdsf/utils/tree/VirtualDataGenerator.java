package com.cdsf.utils.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Michael
 *
 * 2017年4月27日
 * 
 * 模拟生成数据,用于测试
 */
public class VirtualDataGenerator {
	// 构造无序的结果集列表，实际应用中，该数据应该从数据库中查询获得；  
	 public static List getVirtualResult() {      
	  List dataList = new ArrayList();  
	    
	  HashMap dataRecord1 = new HashMap();  
	  dataRecord1.put("id", "112000");  
	  dataRecord1.put("text", "茄果类");  
	  dataRecord1.put("parentId", "110000");  
	    
	  HashMap dataRecord2 = new HashMap();  
	  dataRecord2.put("id", "112200");  
	  dataRecord2.put("text", "茄子");  
	  dataRecord2.put("parentId", "112000");  
	    
	  HashMap dataRecord3 = new HashMap();  
	  dataRecord3.put("id", "112100");  
	  dataRecord3.put("text", "青椒");  
	  dataRecord3.put("parentId", "112000");  
	        
	  HashMap dataRecord4 = new HashMap();  
	  dataRecord4.put("id", "113000");  
	  dataRecord4.put("text", "豆类");  
	  dataRecord4.put("parentId", "110000");  
	        
	  HashMap dataRecord5 = new HashMap();  
	  dataRecord5.put("id", "100000");  
	  dataRecord5.put("text", "绿通车鲜活产品目录");  
	  dataRecord5.put("parentId", "");  
	    
	  HashMap dataRecord6 = new HashMap();  
	  dataRecord6.put("id", "110000");  
	  dataRecord6.put("text", "新鲜蔬菜");  
	  dataRecord6.put("parentId", "100000");  
	    
	  HashMap dataRecord7 = new HashMap();  
	  dataRecord7.put("id", "111000");  
	  dataRecord7.put("text", "瓜类");  
	  dataRecord7.put("parentId", "110000");    
	  
	  HashMap dataRecord8 = new HashMap();  
	  dataRecord8.put("id", "120000");  
	  dataRecord8.put("text", "新鲜水果");  
	  dataRecord8.put("parentId", "100000");
	  
	  HashMap dataRecord9 = new HashMap();  
	  dataRecord9.put("id", "121000");  
	  dataRecord9.put("text", "仁果类");  
	  dataRecord9.put("parentId", "120000");
	  
	  HashMap dataRecord10 = new HashMap();  
	  dataRecord10.put("id", "121100");  
	  dataRecord10.put("text", "苹果");  
	  dataRecord10.put("parentId", "121000");
	  
	  HashMap dataRecord11 = new HashMap();  
	  dataRecord11.put("id", "121200");  
	  dataRecord11.put("text", "梨");  
	  dataRecord11.put("parentId", "121000");
	  
	  dataList.add(dataRecord1);  
	  dataList.add(dataRecord2);  
	  dataList.add(dataRecord3);  
	  dataList.add(dataRecord4);  
	  dataList.add(dataRecord5);  
	  dataList.add(dataRecord6);  
	  dataList.add(dataRecord7);  
	  dataList.add(dataRecord8);  
	  dataList.add(dataRecord9);  
	  dataList.add(dataRecord10);  
	  dataList.add(dataRecord11);  
	    
	  return dataList;  
	 }   
}
