package com.kdyzm.dbutils;
/**
 * ���ݿ����ӳع����ࡣ
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils_c3p0 {
	private static ThreadLocal<Connection>tl=new ThreadLocal<Connection>();
	private static DataSource ds=null;
	static{
		ds=new ComboPooledDataSource("namedconfig");//ʹ�����������������ݿ⡣
	}
	public static Connection getConnection(){
		Connection conn=tl.get();
		if(conn==null)
		{
			try {
				conn=ds.getConnection();
				tl.set(conn);//������ʮ����Ҫ��ǧ������������ǰ�̺߳������Connection����󶨣�
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static DataSource getDataSource(){
		return ds;
	}
	public static void remove(){
		tl.remove();//������Ҳʮ����Ҫ��ǧ����������������TransactionFilter�е���
	}
}	
