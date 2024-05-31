package com.vms.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationProps {

	public static String exportFilesPath;

	
	@Value("${export.files.absolutePath}")
	public void setExportFilesPath(String exportFilesPath) {
		ConfigurationProps.exportFilesPath = exportFilesPath;
	}
	
}
