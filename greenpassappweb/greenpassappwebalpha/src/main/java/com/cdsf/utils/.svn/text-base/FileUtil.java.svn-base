/**
 * @Title: FileUtil.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年11月17日
 * @version 2.0
 */
package com.cdsf.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;

import com.cdsf.configure.AbstractBaseAll;
import com.cdsf.utils.jspsmart.SmartUpload;
import com.cdsf.webmvc.RuntimeContext;

/**
 * @Title: FileUtil
 * @Description:
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年11月17日
 */
public class FileUtil {

	/**
	 * 遍历文件夹中文件
	 * 
	 * @param filepath
	 * @return 返回file［］数组
	 */
	public static File[] getFileList(String filepath) {
		File d = null;
		File list[] = null;
		// 建立当前目录中文件的File对象
		try {
			d = new File(filepath);
			if (d.exists()) {
				list = d.listFiles();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 取得代表目录中所有文件的File对象数组

		return list;
	}

	/**
	 * 读取文本文件内容
	 * 
	 * @param filePathAndName
	 *            带有完整绝对路径的文件名
	 * @param encoding
	 *            文本文件打开的编码方式
	 * @return 返回文本文件的内容
	 */
	public static String readTxt(String filePathAndName, String encoding)
			throws IOException {
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";
		try {
			FileInputStream fs = new FileInputStream(filePathAndName);
			InputStreamReader isr;
			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			BufferedReader br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					str.append(data);
				}
			} catch (Exception e) {
				str.append(e.toString());
			}
			st = str.toString();
			if (st != null && st.length() > 1)
				st = st.substring(0, st.length() - 1);
		} catch (IOException es) {
			st = "";
		}
		return st;
	}

	/**
	 * 多级目录创建
	 * 
	 * @param folderPath
	 *            准备要在本级目录下创建新目录的目录路径例如 c:myf
	 * @param paths
	 *            无限级目录参数，各级目录以单数线区分 例如 a|b|c
	 * @return 返回创建文件后的路径
	 */
	public static String createFolders(String folderPath, String paths) {
		String txts = folderPath;
		try {
			String txt;
			txts = folderPath;
			StringTokenizer st = new StringTokenizer(paths, "|");
			for (int i = 0; st.hasMoreTokens(); i++) {
				txt = st.nextToken().trim();
				if (txts.lastIndexOf("/") != -1) {
					txts = createFolder(txts + txt);
				} else {
					txts = createFolder(txts + txt + "/");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txts;
	}

	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @return
	 */
	public static void createFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
			resultFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 有编码方式的文件创建
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8
	 * @return
	 */
	public static void createFile(String filePathAndName, String fileContent,
			String encoding) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @return Boolean 成功删除返回true遭遇异常返回false
	 */
	public static boolean delFile(String filePathAndName) {
		boolean bea = false;
		try {
			String filePath = filePathAndName;
			File myDelFile = new File(filePath);
			if (myDelFile.exists()) {
				myDelFile.delete();
				bea = true;
			} else {
				bea = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bea;
	}

	/**
	 * 删除文件
	 * 
	 * @param folderPath
	 *            文件夹完整绝对路径
	 * @return
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) {
			return bea;
		}
		if (!file.isDirectory()) {
			return bea;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新绝对路径带文件名
	 * @return
	 */
	public static void copyFile(String oldPathFile, String newPathFile) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) { // 文件存在
				InputStream inStream = new FileInputStream(oldPathFile); // 读入源文件
				FileOutputStream fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节 文件大小
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用文件通道的方式复制文件
	 * 
	 * @param s
	 *            源文件
	 * @param t
	 *            复制到的新文件
	 */
	public static boolean fileChannelCopy(File s, File t) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (fi != null) {
					fi.close();
				}
				if (in != null) {
					in.close();
				}
				if (fo != null) {
					fo.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 复制整个文件夹的内容
	 * 
	 * @param oldPath
	 *            准备拷贝的目录
	 * @param newPath
	 *            指定绝对路径的新目录
	 * @return
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			new File(newPath).mkdirs(); // 如果文件夹不存在 则建立新文件
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 移动文件
	 * 
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动目录
	 * 
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}

	/**
	 * 建立一个可以追加的bufferedwriter
	 * 
	 * @param fileDir
	 * @param fileName
	 * @return
	 */
	public static BufferedWriter getWriter(String fileDir, String fileName) {
		try {
			File f1 = new File(fileDir);
			if (!f1.exists()) {
				f1.mkdirs();
			}
			f1 = new File(fileDir, fileName);
			if (!f1.exists()) {
				f1.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f1.getPath(),
					true));
			return bw;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 得到一个bufferedreader
	 * 
	 * @param fileDir
	 * @param fileName
	 * @param encoding
	 * @return
	 */
	public static BufferedReader getReader(String fileDir, String fileName,
			String encoding) {
		try {
			File file = new File(fileDir, fileName);
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);
			BufferedReader br = new BufferedReader(read);
			return br;

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 得到服务器所在的物理位置 例如 C:\Program Files\Apache Software Foundation\Tomcat //
	 * 6.0\webapps\****
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param session
	 *            httpsession
	 * @return 服务器物理地址
	 */
	public static String getFile(HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		if ((path.length() > 0) && (path.endsWith("/") || path.endsWith("\\"))) {
			path = path.substring(0, path.length() - 1);
		}
		return path;

	}

	/**
	 * 根据路径创建目录
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param path
	 *            径 路
	 * @return 操作结果码
	 */
	public static String createFolder(String path) {
		if (path == null) {
			return null;
		}
		File folder = new File(path);
		if (!folder.isFile() && !folder.exists()) {
			boolean sucess = folder.mkdirs();
			if (!sucess) {
				System.out.println("文件创建错误");
			}
		}
		String pp = null;
		pp = folder.getAbsolutePath();
		return pp;
	}

	/**
	 * 删除文件夹
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param path
	 *            当文件夹下还有文件时，
	 * @param deleteAll
	 *            为true，删除文件夹下所有文件，文件中如包含文件夹， 则采用递归的方式删除所有文件和目录；
	 *            为false，当文件夹下还有文件时，不执行删除文件夹操作.
	 * @return 是否删除成功
	 */
	public static boolean delete(String path, boolean deleteAll) {
		if (path == null || "".equals(path)) {
			return false;
		}
		File dir = new File(path);

		if (dir.isFile() || !dir.exists()) {
			return false;
		}
		File[] allFiles = dir.listFiles();
		// 判断此目录下是否还有文件或文件夹
		if (allFiles.length != 0) {
			if (deleteAll) {
				for (File f : allFiles) {
					if (f.isFile()) {
						boolean success = f.delete();
						if (!success) {
							System.out.println("文件删除错误");
						}
					} else {
						// 递归调用
						delete(f.getAbsolutePath(), true);
					}
				}
			} else {
				return false;
			}
		}
		return dir.delete();
	}

	/**
	 * 方法描述：把文件或者文件夹压缩为ZIP格式
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param zipName
	 *            文件名称
	 * @param zipPath
	 *            压缩后保存的路径
	 * @param fileSrc
	 *            要压缩的文件或文件夹的路径
	 * @return 成功返回true 失败返回false
	 */
	public static boolean fileZip(String zipName, String zipPath, String fileSrc) {
		boolean success = true; // 压缩成功标志
		File srcpath = new File(fileSrc);
		ZipOutputStream out = null;
		FileOutputStream outputStream = null;
		File zipSrcFile = null;
		try {
			zipSrcFile = new File(zipPath);
			// 判断是否有文件夹
			if (!zipSrcFile.isDirectory()) {
				success = zipSrcFile.mkdir();
			}
			if (!success) {
				System.out.println("文件压缩错误，没有文件");
			}
			StringBuffer stringBuffer = new StringBuffer(100);
			stringBuffer.append(zipPath);
			stringBuffer.append(File.separator);
			stringBuffer.append(zipName);
			outputStream = new FileOutputStream(stringBuffer.toString());
			out = new ZipOutputStream(outputStream); // 创建压缩输出流
			compress(srcpath, out, ""); // 开始压缩
		} catch (Exception e) {
			System.out.println(e);
			success = false;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// ex2.printStackTrace();
					System.out.println(e);
				}
			}
		}
		return success;
	}

	/**
	 * 方法描述：压缩文件的处理方法，fileZip掉用的方法
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param srcpath
	 * @param out
	 * @param base
	 * @throws Exception
	 */
	private static void compress(File srcpath, ZipOutputStream out, String base)
			throws Exception {
		// 如果是目录
		if (srcpath.isDirectory()) {
			File[] files = srcpath.listFiles(); // 列举出目录中所有的内容
			if ("".equals(base.trim()) || base.length() == 0) {
				// 什么都不做
				System.out.println("base is empty");
			} else {
				out.putNextEntry(new ZipEntry(base + File.separator)); // 放入zip对应的路径目录
			}

			// 循环压缩文本文件到ZIP格式文件
			for (int i = 0; i < files.length; i++) {

				if (!files[i].isDirectory()) {
					compress(files[i], out, files[i].getName());// 压缩文本文件
				}
			}

		} else { // 如果是文件
			if ("".equals(base)) {
				out.putNextEntry(new ZipEntry(base + File.separator));
				base = srcpath.getName();
			}
			FileInputStream in = null;
			try {
				out.putNextEntry(new ZipEntry(base));
				in = new FileInputStream(srcpath);
				byte[] data = new byte[2048];
				int b;
				while ((b = in.read(data)) != -1) {
					out.write(data, 0, b);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (null != in) {
					try {
						in.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}

		}
	}

	/**
	 * 判断指定路径是否是目录
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param path
	 *            路径
	 * @return 操作结果
	 */
	public boolean isFolder(String path) {
		if (path == null || "".equals(path)) {
			return false;
		}
		return new File(path).isDirectory();
	}

	/**
	 * 判断指定目录是否存在
	 * 
	 * @author zhangdalong
	 * @creaetime 2014-12-8
	 * @param path
	 *            目录路径
	 * @return 操作结果
	 */
	public static boolean isExist(String path) {
		if (path == null || "".equals(path)) {
			return false;
		}
		return new File(path).exists();
	}

	/**
	 * 修改文件路径中的分隔符
	 * 
	 * @param path
	 *            String
	 * @return String
	 */
	public static String cleanPath(String path) {
		if (path != null) {
			path = path.replace('/', File.separatorChar);
		}
		return path;
	}

	/**
	 * 下载文件
	 * 
	 * @param url
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 */
	public static void download(String url, String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int index = 0;
		String ext = null;

		if (url != null && url.trim().length() != 0) {
			index = url.lastIndexOf(".");
			ext = url.substring(index + 1);
		}
		if (fileName == null) {
			fileName = new File(url).getName();
		}
		// 组件初始化；
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(request.getSession().getServletContext(),
				request, response);
		if (ext != null && !"".equals(ext)) {
			if (!("gd|gw".indexOf(ext) != -1)) {
				smartUpload.setContentDisposition(null);// 防止浏览器直接打开
			}
		}
		smartUpload.downloadFile(cleanPath(url), ext,
				new String(fileName.getBytes("UTF-8"), "iso8859-1"));
	}

	/**
	 * 下载 (使用默认的文件名)
	 * 
	 * @param url
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void download(String url, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		download(url, null, request, response);
	}

	/**
	 * 将文件中的特殊符号（%）替换为空
	 * 
	 * @param fName
	 *            文件名称
	 * @return 替换后的文件名称
	 */
	public static String replaceFileName(String fName) {
		if (Tools.isNotNull(fName)) {
			fName = fName.replaceAll("%", "");
		}
		return fName;
	}

	public static void saveFile(MultipartFile file,
			Map<Object, Object> saveMap, int belongType) throws IOException {
		String fName = FileUtil.replaceFileName(file.getOriginalFilename());
		String posfix = fName.substring(fName.lastIndexOf('.'));
		String fileName = saveMap.get("fileNamePrefix") + posfix;
		String filePath = File.separator + belongType;
		String basePath = RuntimeContext.get(Constants.SYS_UPLOAD_DIR,
				String.class, RuntimeContext.SCOPE_CONFIG);
		File projectDir = AbstractBaseAll.getDir(basePath + filePath);
		File fp = new File(projectDir, fileName);
		if (fp.isFile() && fp.exists()) {
			fp.delete();
		}
		fp.createNewFile();
		file.transferTo(fp);
		long size = file.getSize();
		String fileUrl = filePath + File.separator + fileName;
		saveMap.put("fileDirPath", fileUrl);// 资源文件路径
		saveMap.put("pictureName", fName);// 名称
		saveMap.put("suffixName", posfix.substring(1));// 附件类型
		saveMap.put("filePicSize", size);
	}

	/**
	 * 获取json字符串
	 * 
	 * @return 
	 */
	public static String getJsonStr(String fileName) {
		StringBuilder sb = new StringBuilder();
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			is = new FileInputStream(getDir(RuntimeContext.PROJECT_BASEDIR,
					"/WEB-INF/conf/" + fileName));
			isr = new InputStreamReader(is, "UTF-8");
			char[] buf = new char[1024];
			int len = 0;
			while ((len = isr.read(buf)) != -1) {
				sb.append(new String(buf, 0, len));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	private static File getDir(String key, String dir) {
		String parentDir = RuntimeContext.get(key, String.class,
				RuntimeContext.SCOPE_GLOBAL);
		File file = new File(parentDir + File.separator + dir);
		if (!file.exists() || file.isFile())
			file.mkdirs();
		return file;
	}
}
