package com.vms.crew.multiSeamenSignOff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MultiSeamenSignOffDaoImpl implements MultiSeamenSignOffDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public  List<MultiSeamenSignOffBean> multiSemanlist(String date,String vessel ,Integer port) {
		 List<MultiSeamenSignOffBean> list = new ArrayList<>();

		try {

			list = jdbcTemplate.query(MultiSeamenSignOffQueryUtil.GET_LIST, new Object[] {vessel,date,port},
					new BeanPropertyRowMapper<>(MultiSeamenSignOffBean.class));

		} catch (DataAccessException e) {
		}
		return list;
	}

}
