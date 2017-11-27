package com.cdsf.configure;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ognl.OgnlContext;
import ognl.OgnlRuntime;
import org.springframework.util.StringUtils;
import com.cdsf.utils.Constants;
import com.cdsf.webmvc.RuntimeContext;
import com.cdsf.webmvc.exception.BusinessException;

/**
 * <p>
 * 控制器基类，封装所有控制器的公共方法和属性
 * </p>
 * 
 * @author CBird
 * 
 */
public abstract class AbstractController extends AbstractBaseAll {

	/**
	 * 批量执行操作
	 * 
	 * @param service
	 *            服务实例
	 * @param methodName
	 *            调用方法名
	 * @param operation
	 *            操作名称
	 * @param collection
	 *            迭代集合
	 * @param args
	 *            调用除迭代集合中元素外的其他参数
	 * @throws Exception
	 */
	protected void batch(Object service, String methodName, String operation,
			Collection<?> collection, Object... args) throws Exception {
		List<String> errors = new ArrayList<String>();
		Iterator<?> ite = collection.iterator();
		while (ite.hasNext()) {
			Object obj = ite.next();
			Object[] actualArgs = new Object[args.length + 1];
			actualArgs[0] = obj;
			System.arraycopy(args, 0, actualArgs, 1, args.length);
			String err = null;
			try {
				OgnlRuntime.callMethod(new OgnlContext(), service, methodName,
						actualArgs);
			} catch (Exception e) {
				while (e.getCause() != null) {
					e = (Exception) e.getCause();
				}
				if (e instanceof BusinessException) {
					err = e.getMessage();
				} else {
					throw e;
				}
			}
			if (StringUtils.hasText(err))
				errors.add(err);
		}
		int count = errors.size();
		if (count == 1) {
			throw new BusinessException(errors.get(0));
		} else if (count > 1) {
			throw new BusinessException(String.format("%s处理完成，成功[%s]，失败[%s]",
					operation, collection.size() - count, count),
					StringUtils.collectionToDelimitedString(errors, "\n"));
		}
	}

	/**
	 * 获取上传文件路径
	 * 
	 * @return
	 */
	public File getUploadDir() {
		File dir = RuntimeContext.get(Constants.SYS_UPLOAD_DIR, File.class,
				RuntimeContext.SCOPE_CONFIG);
		if (!dir.exists() || dir.isFile()) {
			dir.mkdirs();
		}
		return dir;
	}

	/**
	 * 获取上传文件路径
	 * 
	 * @return 
	 */
	public File getUploadTemDir() {
		File dir = RuntimeContext.get(Constants.SYS_UPLOAD_TEM_DIR, File.class,
				RuntimeContext.SCOPE_CONFIG);
		if (!dir.exists() || dir.isFile()) {
			dir.mkdirs();
		}
		return dir;
	}

}
