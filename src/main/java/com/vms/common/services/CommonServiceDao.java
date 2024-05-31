package com.vms.common.services;

import java.util.HashMap;

public interface CommonServiceDao {

	boolean validateUnique(String tableName, String columnName, String columnValue);

	HashMap<String, Object> forgotPassword(String emailId, String otpForForgotPassword) throws Exception;

}
