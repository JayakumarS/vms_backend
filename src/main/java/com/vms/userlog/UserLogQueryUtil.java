package com.vms.userlog;

public class UserLogQueryUtil {
	
	
	public static final String INSERT_USER_LOG = "insert into user_log (user_name ,status,date_time,date) VALUES (?,?,?,to_date(?,'DD/MM/YYYY'))";
	
	public static final String getAllUserLogList = "select user_name as userName, status as status, date_time as dateTime from user_log order by date_time desc";
	
	public static final String Get_UserName_List = "select emp_id as id, emp_name as text from employee order by emp_name asc";
	
	public static final String getUserLogList = "select user_name as userName, status as status, date_time as dateTime from user_log where 1=1  ";

	public static String get_Employeepunches_list="SELECT bc1.checktime::date AS check_date,bc1.user_id AS userId, bc1.sensor_id,  bu1.name AS name,TO_CHAR(bc1.checktime, 'DD/MM/YYYY HH:MI AM') AS checkIntime,\r\n"
			+ " TO_CHAR(bc2.checktime, 'DD/MM/YYYY HH:MI AM') AS checkOuttime FROM bio_checkout bc1\r\n"
			+ "LEFT JOIN bio_checkout bc2 ON bc1.user_id = bc2.user_id  AND bc1.checktime::date = bc2.checktime::date\r\n"
			+ " AND bc1.checktype = 'I'AND bc2.checktype = 'O'\r\n"
			+ "LEFT JOIN bio_userinfo bu1 ON bc1.user_id = bu1.user_id WHERE\r\n"
			+ " bc1.checktype = 'I' AND 1=1";
	
	public static final String get_employee_list = "select emp_id as id, emp_name as text from employee WHERE emp_id IN ('E0009', 'E0011','E0001') order by emp_name asc";

			
}

