package com.kdyzm.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.kdyzm.dbutils.DataSourceUtils_c3p0;

public class Dao1 {
	
	public void save()
	{
		String sql="insert into user values(?,?,?)";
		QueryRunner run=new QueryRunner();
		Connection conn=DataSourceUtils_c3p0.getConnection();
		try {
			run.update(conn,sql,"0001","Сǿ",12);
		} catch (SQLException e) {
			throw new RuntimeException("Dao1����ʧ�ܣ�");
		}
	}

	public void query() {
		System.out.println("������query������");
	}
}
