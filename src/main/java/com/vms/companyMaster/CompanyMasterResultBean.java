package com.vms.companyMaster;

import java.io.Serializable;
import java.util.List;

import com.vms.core.util.BasicResultBean;

public class CompanyMasterResultBean extends BasicResultBean implements Serializable {
   private static final long serialVersionUID = 1L;
	
   public boolean success;
   private String fileName;
   private String filePath;
   private String companyLogo;
   private String backGroundImg;
   
   
	public boolean isSuccess() {
	return success;
}

public void setSuccess(boolean success) {
	this.success = success;
}

	public String getBackGroundImg() {
	return backGroundImg;
}

public void setBackGroundImg(String backGroundImg) {
	this.backGroundImg = backGroundImg;
}

	public static long getSerialversionuid() {
	return serialVersionUID;
}

	public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFilePath() {
	return filePath;
}

public void setFilePath(String filePath) {
	this.filePath = filePath;
}

	

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}



	

}
