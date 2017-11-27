<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page
	import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.util.UUID"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="org.springframework.web.multipart.MultipartFile"%>
<%@ page import="com.cdsf.egov.common.mongo.MongoUtil"%>
<%
	//构造一个文件上传处理对象 

	Object file = request.getParameter("file");
	System.out.println(file);
	Object test = request.getParameter("test");
	System.out.println(test);
	Map<String, String> par = new HashMap<String, String>();
	String id = request.getParameter("id");
	par.put("fileName", "我的测试文件");
	par.put("uuid", id);
	//取得上传文件以后的存储路径
	ServletInputStream stream = request.getInputStream();
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);//检查输入请求是否为multipart表单数据。
	if (isMultipart) {
		//构造一个文件上传处理对象 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		System.out.println(items.size());
		for (FileItem item : items) {
			if (!item.isFormField()) {
				System.out.println(item.getName());
				//取出上传文件的文件名称
				String name = new String(item.getName().getBytes(
						"iso-8859-1"), "UTF-8");
				if (name == null || "".equals(name.trim())) {
					continue;
				}

			}
		}
	}

	byte[] bytes = new byte[1024];
	int len;
	len = stream.read(bytes);
	System.out.println(len);
	System.out.println(bytes.length);
	MongoUtil.addFile(par, request.getInputStream());
%>