package com.kdyzm.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.kdyzm.dbutils.DataSourceUtils_c3p0;

public class Dao2 {
	
	public void save()
	{
		String sql="insert into user values(?,?,?)";
		QueryRunner run=new QueryRunner();
		Connection conn=DataSourceUtils_c3p0.getConnection();
		try {
			run.update(conn,sql,"0002","Ð¡Ã÷",13);
		} catch (SQLException e) {
			throw new RuntimeException("Dao2²Ù×÷Ê§°Ü£¡");
		}
	}

}
