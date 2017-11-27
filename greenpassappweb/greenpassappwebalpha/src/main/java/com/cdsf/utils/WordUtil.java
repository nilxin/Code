package com.cdsf.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @author Administrator
 * 
 */
public class WordUtil {


	/**
	 *@description:
	 *@author: ChenLei
	 *@date:2015-1-9下午3:11:03
	 *
	 *@param dataMap
	 *@param templateName
	 *@param filePath 文件输出路径
	 *@param fileName
	 *@param tempDir 模版路径 如:/D:/
	 *@return
	 *
	 */
	public static String createWord(Object dataMap, String templateName, String filePath, String fileName,String tempDir) {
		Writer out = null;
		try {/*
			// 创建配置实例
			Configuration configuration = new Configuration();

			// 设置编码
			configuration.setDefaultEncoding("UTF-8");

			//configuration.setClassForTemplateLoading(WordUtil.class, "/com/cdsf/freemarker/template");
			configuration.setDirectoryForTemplateLoading(new File(tempDir));
			// 获取模板
			Template template = configuration.getTemplate(templateName); 
             //
			String acceptCode = ((Report)dataMap).getAcceptCode();
			String fileRealPath =null;
			if (acceptCode==null) {
				//文件输出地址
				 fileRealPath =filePath + File.separator + fileName.replaceAll(".doc", "")+".doc";
			}else {
				//文件输出地址
				 fileRealPath =filePath + File.separator + acceptCode+fileName.replaceAll(".doc", "")+".doc";
			}
			
			// 输出文件
			File outFile = new File(fileRealPath);

			// 如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			// 将模板和数据模型合并生成文件
//			Report reportResult = new Report();
//			AccptInfo accptInfo = ((Report)dataMap).getAccptInfo();
//			List<ItemInfo> itemInfos = ((Report)dataMap).getItemInfos();
//			ReportCode reportCode = ((Report)dataMap).getReportCode();
//			List<SampleInfo> sampleInfos = ((Report)dataMap).getSampleInfos();
//			List<TestAcceptEntrustInfo> testAcceptEntrustInfo = ((Report)dataMap).getTestAcceptEntrustInfo();
//			reportResult.setAccptInfo(accptInfo);
//			reportResult.setItemInfos(itemInfos);
//			reportResult.setReportCode(reportCode);
//			reportResult.setSampleInfos(sampleInfos);
//			reportResult.setTestAcceptEntrustInfo(testAcceptEntrustInfo);
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			// 生成文件
			template.process(dataMap, out);

			// 关闭流
			out.flush();
			return fileRealPath;
		*/} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ERROR";
	}
	
	/**
	 *@description: 将html内容转为word
	 *@author: Yiwei
	 *@date:2015年4月20日
	 *
	 *@param fileName 文件名
	 *@param htmlContent html内容
	 *@return  filePath 生成的word文件全路径
	 *
	 */
	public static String HtmlToWordFile(String fileName,String htmlContent) {  
        String path = Constants.UPLOADING_FILE_TEMP_ADDRESS;  
        String fileUrl = path;  
        try {  
            if (!"".equals(path)) {  
                // 检查目录是否存在  
                File fileDir = new File(path);
    			if (!fileDir.exists()) {
    				fileDir.mkdirs();
    			}
                    // 生成临时文件名称  
                    fileUrl = path+"/"+ fileName;  
                    byte b[] = htmlContent.getBytes();  
                    ByteArrayInputStream bais = new ByteArrayInputStream(b);  
                    POIFSFileSystem poifs = new POIFSFileSystem();  
                    DirectoryEntry directory = poifs.getRoot();  
                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);  
                    FileOutputStream ostream = new FileOutputStream(fileUrl);  
                    poifs.writeFilesystem(ostream);  
                    bais.close();  
                    ostream.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
      }  
      return fileUrl;  
    } 
}
