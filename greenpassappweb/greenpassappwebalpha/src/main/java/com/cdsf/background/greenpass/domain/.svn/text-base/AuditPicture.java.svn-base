package com.cdsf.background.greenpass.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.cdsf.utils.Tools;

/**
 * @author Michael
 *
 *         2017年4月26日
 * 
 *         稽查照片,这个是为了方便后期,图片比对识别,发现套牌车之类的,为后期的大数据提供一些数据采集的搜集
 * 
 */
public class AuditPicture {
	/**
	 * 文件
	 */
	private MultipartFile file;
	/**
	 * 关联的主表的主键
	 */
	private String mainId;
	private String flowId;// 主键id

	private String pictureName;// 图片名称

	private String suffixName;// 后缀名称

	private String fileDirPath;// 图片存放的文件夹的路径

	private Float filePicSize; // 图片的大小(单位kb)

	private Integer belongType;// 文件所属分类(0驾驶证,1行驶证,2车牌,3车前脸, 4货物类,5用户头相，6补交逃费现场处理照片)
	
	private Date createTime;//图片的创建时间
	
	private String createTimeStr;//图片创建时间字符串
	
	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getSuffixName() {
		return suffixName;
	}

	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	public String getFileDirPath() {
		return fileDirPath;
	}

	public void setFileDirPath(String fileDirPath) {
		this.fileDirPath = fileDirPath;
	}

	public Float getFilePicSize() {
		return filePicSize;
	}

	public void setFilePicSize(Float filePicSize) {
		this.filePicSize = filePicSize;
	}

	public Integer getBelongType() {
		return belongType;
	}

	public void setBelongType(Integer belongType) {
		this.belongType = belongType;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		if(Tools.isNotNull(createTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			createTimeStr = sdf.format(createTime);
		}
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
}
