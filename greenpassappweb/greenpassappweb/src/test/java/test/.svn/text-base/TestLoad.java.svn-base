package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestLoad {

	

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String cookies) {
		String result = "";
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			System.getProperties().setProperty("http.proxyHost", "127.0.0.1");  
			System.getProperties().setProperty("http.proxyPort", "1080"); 
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
//			connection.setRequestProperty("user-agent",
//					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586");
			connection.setRequestProperty("Cookie", cookies);
			
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
//	String cookies = "ci=59; abt=1493291368.0%7CBDF; rvct=59; _lxsdk_s=c6c7f59ae69bdd7973ebface7373%7C%7C0; "
//			+ "ttgr=184990; rvd=44246940; ppos=30.648484%2C104.059989; "
//			+ "pposn=%E9%BE%99%E9%9A%90%E9%97%A8%E7%81%AB%E9%94%85.%E8%AE%A9%E4%B8%96%E7%95%8C%E7%88%B1%"
//			+ "E4%B8%8A%E9%87%8D%E5%BA%86%E5%91%B3; _lx_utm=utm_source%3Dbaidu%26utm_medium%3Dorganic%"
//			+ "26utm_content%3Dhomepage%26utm_campaign%3Dbaidu; __mta=244692666.1493291361548.149329137"
//			+ "4441.1493291385352.3; __utma=211559370.393381547.1493291362.1493291362.1493291362.1; __utmb"
//			+ "=211559370.4.9.1493291383606; __utmc=211559370; __utmz=211559370.1493291362.1.1.utmcsr=baidu|utmcc"
//			+ "n=baidu|utmcmd=organic|utmcct=homepage; __utmv=211559370.|1=city=cd=1^3=dealtype=237=1; uuid=726b3123"
//			+ "4b7485e3d184.1493291368.0.0.0; oc=40WtkHudlzlZXMNAo9VPcKdrdhCH9ny2qkfXU5nW-lYkdZjsqilmVGIHimSA2q6j"
//			+ "LVQh_lnAb1BIFXVD68k9_5k2LOq7PtBNbPt0oX0py1F0coCSEZz2mXEXsyK-mYQ1gyDrv_HMOE50vG-orZ_PVaBnGE4HToKQeHaPh5_SxHk";
	
	String cookies = "__mta=46377368.1457521034912.1469709273682.1469740331784.19; rvct=1%2C59%2C30; ci=59; mtcdn=K; abt=1493730507.0%7CACF; _lxsdk_s=e2b22bc0ede5f739c8b3dc279631%7C%7C0; lsu=zhang_fre%40163.com; token2=VqGZu6vAWfizVSLN3OLAp5ClG78AAAAA7wMAAOZuasNAmg1yrsBaNIK5I9HVEnOAOnZLfH-H-AdVDlrbTXZpRS93ZF0Ch1DF1P7OiA; u=77157009; n=FRE777; m=zhang_fre%40163.com; lt=VqGZu6vAWfizVSLN3OLAp5ClG78AAAAA7wMAAOZuasNAmg1yrsBaNIK5I9HVEnOAOnZLfH-H-AdVDlrbTXZpRS93ZF0Ch1DF1P7OiA; em=bnVsbA; om=bnVsbA; ls=1493730536; ttgr=192314; rvd=28165377%2C44569219%2C25854055%2C29085134%2C44778171; __mta=46377368.1457521034912.1469740331784.1493731126573.20; hotel_ci=59; __utma=211559370.1801255453.1457521035.1493351247.1493730511.24; __utmb=211559370.14.9.1493731144720; __utmc=211559370; __utmz=211559370.1493730511.24.19.utmcsr=baidu|utmccn=baidu|utmcmd=organic|utmcct=homepage; __utmv=211559370.|1=city=cd=1^3=dealtype=614=1; ppos=30.981594%2C103.949157; pposn=%E8%81%9A%E6%BA%90%E5%AE%BE%E9%A6%86; vipnotice_77157009=%7B%22status%22%3Atrue%2C%22growthValue%22%3A3014%2C%22showLevel%22%3A4%2C%22noticeType%22%3A0%2C%22noticeValue%22%3A0%2C%22cityid%22%3A59%7D; __t=1493731150522.1.1493731190720.Chotelpoi.Ahotel.Bhotelfilter; uuid=04fc483917ca4a7080b0.1457521028.4.0.1; oc=p3GGD_RVYbopNmfeSmGDmwm-Sn8CfuRxHaCaMK0kNBPYOI-TCTSgf_Ls0dboxVJSRfD2pC9yCKmgSki5WDfJIyPYiHG4_uo9GzwPrieIxvJySBDmF6ibkqyu86tzIEn_92_YF6tUZ7bRvG9G47eFpkwh7LFVPUdoZH4d4b6tPu8; _lx_utm=utm_source%3Dbaidu%26utm_medium%3Dorganic%26utm_content%3Dhomepage%26utm_campaign%3Dbaidu";
	
	
	
//	String cookies = "ci=59;"
//			+ " abt=1493348747.0%7CADE; "
//			+ "_lxsdk_s=e046fdcdfb4ba579895843334abd%7C%7C0; "
//			+ "ppos=31.158322%2C103.832475; "
//			+ "pposn=%E5%85%A8%E5%8F%8B%E5%85%AC%E5%AF%93; "
//			+ "_lx_utm=; "
//			+ "__mta=255701943.1493349209719.1493349209719.1493349235204.2; "
//			+ "__utma=211559370.1334622775.1493348772.1493348772.1493349207.2; "
//			+ "__utmb=211559370.2.10.1493349207; "
//			+ "__utmc=211559370; "
//			+ "__utmz=211559370.1493349207.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); "
//			+ "__utmv=211559370.|1=city=cd=1; "
//			+ "uuid=a4e19c0c083c562c68d3.1493348747.0.0.0; "
//			+ "oc=qattKyymmIOkfUX7ZydAvwffiBiOJezlnr_06lSTk2v6-ybqrsqmCi6BxqFhmTdpRD54NHqDNlu7NOJQihvu1xiI_Ov4eM4EQS3MvNg0js2nub5i4Gr_CDMIjosXxUT3uAOufWGpbtK6XHDbwIN74MZvE8gCsi5nb95cBclnmDw";
	
	
	@Test
	public void testHttpGet() throws Exception {
		
		// 获取类别
		List<String> list = getTxtList("C:\\Users\\cdsf\\Desktop\\type.txt");
		for (int i = 0; i < list.size(); i++) {
			String resultType = "";
			int j = 0;
			String temp = list.get(i);
			String type = temp.split("@")[0];
			System.out.println("当前类别======="+type+"第"+i+"条==============");
			StringBuilder sb = new StringBuilder();
			do {
				j++;
				System.out.println("当前页数========"+j);
				String typeUrl = "http://cd.meituan.com/category/" + type +"/page"+j;
				resultType = sendGet(typeUrl, cookies);
//				System.out.println(resultType);
				//饮食正则         poiidList\\\\\":\\[(.*?)\\],\\\\\"poiData
				String typeReg = "data-map=\"(.*?)\\}\\}\">";
				//System.out.println("zhengze="+typeReg);
				Pattern pattern = Pattern.compile(typeReg);
				Matcher matcher = pattern.matcher(resultType);
				
				if(matcher.find()){
					String shopArr = matcher.group(1);
					typeReg = "hid&quot;:(.*?)\\},&quot;";
					pattern = Pattern.compile(typeReg);
					matcher = pattern.matcher(shopArr);
					while (matcher.find()) {
						String shop = matcher.group(1);
						sb.append(shop+",");
					}
				}
				if(j == 300){
					break;
				}
			} while (resultType.indexOf("未找到对应的优惠信息") == -1);
			String filePathAndName = "C:\\Users\\cdsf\\Desktop\\result\\"+temp.split("@")[1]+".txt";
			writeFile(filePathAndName, sb.toString());
		}

		// String result = sendGet(url);

		// 要验证的字符串
		// 正则表达式规则nav/category/(.*?)\">(.*?)<
		// link f3 J-mtad-link" href="

		// 取商家主页地址正则表达式：link f3 J-mtad-link\" href=\"(.*?)\" target=

		// String regEx = "summary biz-box fs-section cf\">(.*?)sp-poi-bookmark";
		// // 编译正则表达式
		// Pattern pattern = Pattern.compile(regEx);
		// Matcher matcher = pattern.matcher(result);
		// // 查找字符串中是否有匹配正则表达式的字符/字符串
		// if(matcher.find()){
		// String div = matcher.group();
		// String regEx2 =
		// "title\">(.*?)</span>.*?geo\">(.*?)</span>.*?under-title>(.*?)</p>";
		// pattern = Pattern.compile(regEx2);
		// matcher = pattern.matcher(div);
		// while (matcher.find()) {
		// System.out.println(matcher.group(1)+"@"+matcher.group(2)+"@"+matcher.group(3));
		//
		// }
		// }

	}

	@Test
	public void testShop() throws Exception {
		String filepath = "C:\\Users\\cdsf\\Desktop\\testbatch";
		List<String> filePathList = readFileList(filepath);
		for (int m = 0; m < filePathList.size(); m++) {
//			String shopList = loadFile("C:\\Users\\cdsf\\Desktop\\result\\自助餐.txt");
			String shopList = loadFile(filePathList.get(m));
			File currentFile = new File(filePathList.get(m));
			String[] shopArr = shopList.split(",");
			Set<String> hashSet = new HashSet<String>();
			for (int i = 0; i < shopArr.length; i++) {
				hashSet.add(shopArr[i]);
			}
			System.out.println("xxxxxxxx  hashSet.size()  xxxxxxx"+hashSet.size());
			int k = 0;
			for (String shopUrl : hashSet) {
				k++;
				System.out.println("xxxxx 开始采集第  "+k+" 条数据xxxxx");
				StringBuilder sb = new StringBuilder();
				String result = sendGet(shopUrl,cookies);
				String regEx = "summary biz-box fs-section cf\">(.*?)sp-poi-bookmark";
				// 编译正则表达式
				Pattern pattern = Pattern.compile(regEx);
				Matcher matcher = pattern.matcher(result);
				String temp = "";
				// 查找字符串中是否有匹配正则表达式的字符/字符串
				if(matcher.find()){
					String div = matcher.group();
					String regEx2 =
							"title\">(.*?)</span>.*?geo\">(.*?)</span>.*?under-title>(.*?)</p>";
					pattern = Pattern.compile(regEx2);
					matcher = pattern.matcher(div);
					while (matcher.find()) {
//					 temp  = shopUrl + ","+ matcher.group(1)+","+matcher.group(2)+","+matcher.group(3) + "\n";
						temp  = shopUrl + ","+ matcher.group(1)+","+matcher.group(2)+","+matcher.group(3);
					}
					System.out.println(temp);
					sb.append(temp);
					printWrite("C:\\Users\\cdsf\\Desktop\\resultInfo\\"+currentFile.getName(),sb.toString());
				}
			}
		}
	}
	
	@Test
	public void testJiudian() throws Exception {
		String filepath = "C:\\Users\\cdsf\\Desktop\\testbatch";
		List<String> filePathList = readFileList(filepath);
		for (int m = 0; m < filePathList.size(); m++) {
//			String shopList = loadFile("C:\\Users\\cdsf\\Desktop\\result\\经济型酒店.txt");
			String shopList = loadFile(filePathList.get(m));
			File currentFile = new File(filePathList.get(m));
			String[] shopArr = shopList.split(",");
			Set<String> hashSet = new HashSet<String>();
			for (int i = 0; i < shopArr.length; i++) {
				hashSet.add(shopArr[i]);
			}
			System.out.println("xxxxxxxx  hashSet.size()  xxxxxxx"+hashSet.size());
			for (String shopUrl : hashSet) {
				StringBuilder sb = new StringBuilder();
				String result = sendGet(shopUrl,cookies);
				String regName = "uix-tooltip\" title=\"(.*?)\">";
				// 编译正则表达式
				Pattern pattern = Pattern.compile(regName);
				Matcher matcher = pattern.matcher(result);
				String temp = "";
				// 查找字符串中是否有匹配正则表达式的字符/字符串
				if(matcher.find()){
					String name = matcher.group(1);
					System.out.println(name);
					String regDz = "title\" title=\"(.*?)\">";
					pattern = Pattern.compile(regDz);
					matcher = pattern.matcher(result);
					if(matcher.find()){
						String dz = matcher.group(1);
						String regDiv = "J-poi-hotelinfo poi-hotelinfo.*?rate-labelcloud";
						pattern = Pattern.compile(regDiv);
						matcher = pattern.matcher(result);
						if(matcher.find()){
							String div = matcher.group();
							String reg = "\\d*[\\d{2,}|-]\\d{5,}";
							pattern = Pattern.compile(reg);
							matcher = pattern.matcher(div);
							if(matcher.find()){
								String phoneNo = matcher.group();;
//							String regInfo = url + "," + name + "," + dz + "," + phoneNo + "\r\n";
								String regInfo = shopUrl + "," + name + "," + dz + "," + phoneNo;
								sb.append(regInfo);
								printWrite("C:\\Users\\cdsf\\Desktop\\resultInfo\\"+currentFile.getName()+".txt",sb.toString());
							}
						}
					}
				}
			}
//		for (int i = 0; i < shopArr.length; i++) {
//			StringBuilder sb = new StringBuilder();
//			String url = shopArr[i];
//			String result = sendGet(url,cookies);
//			 String regName = "uix-tooltip\" title=\"(.*?)\">";
//			 // 编译正则表达式
//			 Pattern pattern = Pattern.compile(regName);
//			 Matcher matcher = pattern.matcher(result);
//			 String temp = "";
//			 // 查找字符串中是否有匹配正则表达式的字符/字符串
//			 if(matcher.find()){
//				 String name = matcher.group(1);
//				 System.out.println(name);
//				 String regDz = "title\" title=\"(.*?)\">";
//				 pattern = Pattern.compile(regDz);
//				 matcher = pattern.matcher(result);
//				 if(matcher.find()){
//					 String dz = matcher.group(1);
//					 String regDiv = "J-poi-hotelinfo poi-hotelinfo.*?rate-labelcloud";
//					 pattern = Pattern.compile(regDiv);
//					 matcher = pattern.matcher(result);
//					 if(matcher.find()){
//						String div = matcher.group();
//						String reg = "\\d*[\\d{2,}|-]\\d{5,}";
//						pattern = Pattern.compile(reg);
//						matcher = pattern.matcher(div);
//						if(matcher.find()){
//							String phoneNo = matcher.group();;
////							String regInfo = url + "," + name + "," + dz + "," + phoneNo + "\r\n";
//							String regInfo = url + "," + name + "," + dz + "," + phoneNo;
//							sb.append(regInfo);
//							printWrite("C:\\Users\\cdsf\\Desktop\\resultInfo\\经济型酒店结果.txt",sb.toString());
//						}
//					 }
//				 }
//				 
//				 
//			 }
//		}
//		writeFile("C:\\Users\\cdsf\\Desktop\\resultInfo\\经济型酒店结果.txt",sb.toString());
		}
	}
	
	@Test
	public void testName() throws Exception {
		//028-82208228
		String result = "<dt class='col-d-1 col-l-1 col-m-1 poi-hotelinfo__title'>联系方式</dt><dd class='col-d-9 col-l-12 col-m-9 col-last'>18281700908</dd>";
		String reg = "\\d*[\\d{2,}|-]\\d{5,}";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(result);
		if(matcher.find()){
			System.out.println(matcher.group());;
		}
		//System.out.println(matcher.group(1));
		
	}

	public List<String> getTxtList(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);// 创建一个File对象
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "GBK");
			BufferedReader reader = new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public String loadFile(String path){
		String result = "";
		File file = new File(path);// 创建一个File对象
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "GBK");
			BufferedReader reader = new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null) {
				result += line;
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public static void writeFile(String filePathAndName, String fileContent) {

    	try {
    		File f = new File(filePathAndName);
    		if(!f.exists()){
    			f.createNewFile();
    		}
    	    OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f),"UTF-8");
    	    BufferedWriter writer=new BufferedWriter(write);
    	    writer.write(fileContent);
    	    writer.close();
		} catch (Exception e) {
			System.out.println("写文件出错！！！");
		}

	}
    
    
	//写文件,写入文件末尾处，而不是写入文件开始处,防止出现乱码
		private void printWrite(String file, String content){
		    PrintWriter pw = null;
		    try
		    {
		        pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, true),"UTF-8"));
		        pw.println(content);
		    }
		    catch(IOException e)
		    {
		        //写文件失败了就丢弃，什么都要做。
		    	try{
		    		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\cdsf\\Desktop\\resultInfo\\经济型酒店结果采集异常信息.txt", true),"UTF-8"));
		    		pw.println(e.getClass().getName());
		    	}catch(Exception e2){
		    		System.out.println("xxxxxxxxxx e2 xxxxxxxx"+e2.getClass().getName());
		    	}
		    	
		    }
		    finally
		    {
		        pw.close();
		    }
		}
    
		
		public List<String>  readFileList(String filepath) throws Exception {
//			String filepath = "C:\\Users\\cdsf\\Desktop\\testbatch";
			List<String> readFilePathList = new ArrayList<String>();
			File file = new File(filepath );
			 if (!file.isDirectory()) {
			         System.out.println("文件");
			         System.out.println("path=" + file.getPath());
			         System.out.println("absolutepath=" + file.getAbsolutePath());
			         System.out.println("name=" + file.getName());

			 } else if (file.isDirectory()) {
			         System.out.println("文件夹");
			         String[] filelist = file.list();
			         for (int i = 0; i < filelist.length; i++) {
			                 File readfile = new File(filepath + "\\" + filelist[i]);
			                 if (!readfile.isDirectory()) {
			                         System.out.println("path=" + readfile.getPath());
			                         System.out.println("absolutepath="
			                                         + readfile.getAbsolutePath());
			                         System.out.println("name=" + readfile.getName());
			                         readFilePathList.add(readfile.getPath());
			                 } else if (readfile.isDirectory()) {
//                                	 testFileList(filepath + "\\" + filelist[i]);
			                 }
			         }

			 }
			 return readFilePathList;
		}
		
	
    
    
    
}
