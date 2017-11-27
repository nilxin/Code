package com.cdsf.configure.storage;

import java.io.File;
import java.io.InputStream;

public interface FileStorage {
	void saveFile(String fsName, String fileName, String filePath);

	void saveFile(String fsName, String fileName, File file);

	void saveFile(String fsName, String fileName, InputStream input);
	
	boolean existFile(String fsName, String fileName);

	void removeFile(String fsName, String fileName);
	
	void copyFile(String fsName, String sourceName, String targetName);

	InputStream findFile(String fsName, String fileName);
}
