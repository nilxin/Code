<%@page language="java" contentType="application/x-download; charset=UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.cdsf.egov.common.mongo.BaseResult"%>
<%@page import="com.cdsf.egov.common.mongo.MongoUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.lang.String"%>
<%@page import="com.mongodb.gridfs.GridFSDBFile"%>
<%

	String uuid = request.getParameter("id");
	if (uuid == null) {
		return;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("uuid", uuid);
	BaseResult result = MongoUtil.findFile(map);
	if (result.isSucc()) {
		if (result.getObjectList().size() > 0) {
			GridFSDBFile file = (GridFSDBFile) result.getObjectList().get(0);
			String filedisplay = (String) file.get("fileName");
			response.setHeader("Content-Disposition", 
					"attachment; filename="+ new String(filedisplay.getBytes("GBK"),
							"iso8859-1"));
			file.writeTo(response.getOutputStream());
		}
	}
%>