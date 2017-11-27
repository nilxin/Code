package com.cdsf.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cdsf.configure.IService;


public class CorrectAnnotation {

	public static void main(String[] args) throws Exception {
		String basePackage = "com/cdsf/lims";
		String sourceCodeDir = "E:/eclipse/workspace2/lims/src/main/java/";

		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
				resourcePatternResolver);
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
				+ basePackage + "/**/*.class";
		Resource[] resources = resourcePatternResolver
				.getResources(packageSearchPath);
		ClassPool pool = ClassPool.getDefault();
		for (Resource resource : resources) {
			if (resource.isReadable()) {
				try {
					MetadataReader metadataReader = metadataReaderFactory
							.getMetadataReader(resource);
					ClassMetadata metadata = metadataReader.getClassMetadata();
					String clsName = metadata.getClassName();
					if (!clsName.endsWith("Service") || !metadata.isInterface()
							|| !existClass(clsName + "Impl")) {
						continue;
					}
					CtClass interf = pool.get(clsName);
					removeTxFromInterfaceFile(sourceCodeDir
							+ clsName.replaceAll("\\.", "/") + ".java");
					CtMethod[] interfMethods = interf.getDeclaredMethods();
					Transactional clsTxAnno = (Transactional) interf
							.getAnnotation(Transactional.class);

					CtClass iServiceCls = pool.get(IService.class.getName());
					if (interf.subtypeOf(iServiceCls)) {
						if (clsTxAnno == null)
							clsTxAnno = (Transactional) iServiceCls
									.getAnnotation(Transactional.class);
						CtMethod[] iServiceClsMeds = iServiceCls
								.getDeclaredMethods();
						CtMethod[] tmp = new CtMethod[interfMethods.length
								+ iServiceClsMeds.length];
						System.arraycopy(interfMethods, 0, tmp, 0,
								interfMethods.length);
						System.arraycopy(iServiceClsMeds, 0, tmp,
								interfMethods.length, iServiceClsMeds.length);
						interfMethods = tmp;
					}

					Map<Integer, String> appendLines = new HashMap<Integer, String>();
					for (CtMethod interfMethod : interfMethods) {
						Transactional medTxAnno = (Transactional) interfMethod
								.getAnnotation(Transactional.class);
						if (medTxAnno == null && clsTxAnno == null) {
							continue;
						}

						CtClass impl = pool.get(clsName + "Impl");
						if (medTxAnno == null) {
							medTxAnno = clsTxAnno;
						}
						CtMethod implMethod = impl.getDeclaredMethod(
								interfMethod.getName(),
								interfMethod.getParameterTypes());
						int lineNumber = implMethod.getMethodInfo()
								.getLineNumber(0);
						String clsAnnoStr = buildTxAnnoLine(medTxAnno);
						appendLines.put(lineNumber, clsAnnoStr);
					}

					addTxToClassFile(
							sourceCodeDir
									+ (clsName + "Impl").replaceAll("\\.", "/")
									+ ".java", appendLines);
				} catch (Throwable ex) {
					throw new Exception(
							"Failed to read candidate component class: "
									+ resource, ex);
				}
			}
		}
	}

	public static void removeTxFromInterfaceFile(String fileName)
			throws Exception {
		FileInputStream in = null;
		List<String> lines = null;
		try {
			in = new FileInputStream(fileName);
			lines = IOUtils.readLines(in);
		} finally {
			IOUtils.closeQuietly(in);
		}

		if (lines.size() == 0)
			return;

		List<String> newLines = new ArrayList<String>();
		for (String line : lines) {
			if (line.contains("import org.springframework.transaction.annotation.Transactional;"))
				continue;
			if (line.contains("@Transactional")) {
				// line = line.replaceAll("[\\s\\t]*@Transactional\\(?.*\\)?", "");
				continue;
			}

			newLines.add(line);
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			IOUtils.writeLines(newLines, null, out);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

	public static void addTxToClassFile(String fileName,
			Map<Integer, String> appendLines) throws Exception {

		if (appendLines.size() == 0)
			return;

		FileInputStream in = null;
		List<String> lines = null;
		try {
			in = new FileInputStream(fileName);
			lines = IOUtils.readLines(in, "UTF-8");
		} finally {
			IOUtils.closeQuietly(in);
		}

		if (lines.size() == 0)
			return;

		SortedSet<Integer> keys = new TreeSet<Integer>(appendLines.keySet());
		int delta = 0;
		for (Iterator<Integer> ite = keys.iterator(); ite.hasNext();) {
			Integer key = ite.next();
			String appendLine = appendLines.get(key);
			key += delta;
			while (true) {
				key = key - 1;
				String line = lines.get(key);
				if (line.matches("[\\t\\s]+public[\\t\\s]+.*"))
					break;
			}
			lines.add(key, appendLine);
			delta++;
		}

		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).contains(
					"import org.springframework.stereotype.Service;")) {
				lines.add(i + 1,
						"import org.springframework.transaction.annotation.Transactional;");
				break;
			}
		}

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			IOUtils.writeLines(lines, null, fos);
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	public static String buildTxAnnoLine(Transactional anno) {
		StringBuilder sb = new StringBuilder("	@Transactional");
		if (anno.readOnly())
			sb.append("(readOnly = true)");
		return sb.toString();
	}

	public static boolean existClass(String clsName) {
		try {
			Class.forName(clsName);
			return true;
		} catch (ClassNotFoundException e) {
		}
		return false;
	}
}
