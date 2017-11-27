package com.cdsf.configure;

import java.io.File;
import java.util.List;

import com.cdsf.common.GrantedUser;
import com.cdsf.utils.Constants;
import com.cdsf.webmvc.RuntimeContext;

public class AbstractBaseAll extends com.cdsf.webmvc.AbstractBase {

	protected GrantedUser currentUser() {
		GrantedUser user = new GrantedUser() {

			@Override
			public String password() {
				return "59d29c7c753af52a8dfd210d0fd38f88";
			}

			@Override
			public String name() {
				return "系统管理员	";
			}

			@Override
			public <T> T id() {
				return null;
			}

			@Override
			public String clientId() {
				return null;
			}

			@Override
			public String account() {
				return "系统管理员";
			}

			@Override
			public String roles() {
				return "-1";
			}

			@Override
			public String deptName() {
				return null;
			}

			@Override
			public String deptId() {
				return "-1";
			}

			@Override
			public String areaName() {
				return "地区（缺省）";
			}

			@Override
			public String areaId() {
				return "-1";
			}
		};
		return user;
	}

	/**
	 * 
	 * @Title: validateString
	 * @Description: 验证字符串
	 * @param data 数据
	 * @param length 最大长度
	 * @param message 对象名称
	 * @param isRequire 是否必填
	 */
	protected void validateString(String data, int length, String message, boolean isRequire) {
		if (isRequire) {
			assertNotBlank(data, "操作失败：" + message + "不能为空");
			assertIsFalse(data.length() > length, "操作失败：" + message + "超过最大长度" + length);
		} else {
			if (data != null) {
				assertIsFalse(data.length() > length, "操作失败：" + message + "超过最大长度" + length);
			}
		}
	}

	/**
	 * 
	 * @Title: validateObject
	 * @Description: 验证
	 * @param data
	 * @param isRequire
	 * @param message
	 */
	protected void validateObject(Object data, boolean isRequire, String message) {
		if (isRequire) {
			if (data instanceof List) {
				assertNotEmpty((List) data, "操作失败：" + message + "不能为空");
			} else {
				assertNotNull(data, "操作失败：" + message + "不能为空");
			}
		}
	}

	protected File getUploadDir() {
		File file = RuntimeContext.get(Constants.SYS_UPLOAD_DIR, File.class, RuntimeContext.SCOPE_CONFIG);
		if (!file.exists() || file.isFile())
			file.mkdirs();
		return file;
	}
	public static File getDir(String dir) {
		File file = new File(dir);
		if (!file.exists() || file.isFile())
			file.mkdirs();
		return file;
	}

}
