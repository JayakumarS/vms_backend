package com.vms.common.services;

import java.util.HashMap;
import java.util.List;

public interface CommonServiceDao {

	boolean validateUnique(String tableName, String columnName, String columnValue);

	HashMap<String, Object> forgotPassword(String emailId, String otpForForgotPassword) throws Exception;

	public List<CommonServiceBean> getFleetList();

	public List<CommonServiceBean> getClassList();

	public List<CommonServiceBean> getVesselType();

	public List<CommonServiceBean> getVesselInsurance();

	public List<CommonServiceBean> getWageScale();

	public List<CommonServiceBean> getPort();

	public List<CommonServiceBean> getCountry();

	public List<CommonServiceBean> getCurrency();

	public List<CommonServiceBean> getphoneCode();
	
	public List<CommonServiceBean> getVesselOwner();

	public List<CommonServiceBean> getOfficialManagers();

	public List<CommonServiceBean> getShipManagers();

}
