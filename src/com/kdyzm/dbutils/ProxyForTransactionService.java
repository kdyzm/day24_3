package com.kdyzm.dbutils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import com.kdyzm.demo.ProxyForAllClassHasInterface;
import com.kdyzm.myannotation.Transactionflag;

/*
 * ��Service����д��������ض��ķ����������޸ģ�ʵ��InvocationHandler�ӿ��Ǿ����������
 * ������Է��ڹ������С�
 */
public class ProxyForTransactionService implements InvocationHandler{
	private Object src;
	private ProxyForTransactionService(Object src)
	{
		this.src=src;
	}
	public static Object factory(Object src)
	{
		Object aim=Proxy.newProxyInstance(ProxyForAllClassHasInterface.class.getClassLoader(),
				src.getClass().getInterfaces(), 
				new ProxyForTransactionService(src));
		return aim;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Connection connection=null;
		Object returnValue=null;
		if(!method.isAnnotationPresent(Transactionflag.class))
		{
			System.out.println("����Ҫ��������ķ�����"+method.getName());
			return method.invoke(src, args);
		}
		System.out.println("��Ҫ��������ķ�����"+method.getName());
		try
		{
			//��ȡ����
			connection=DataSourceUtils_c3p0.getConnection();
			//��������Ŀ�ʼ
			connection.setAutoCommit(false);
			System.out.println("�Ѿ���������");
			//���÷���
			method.invoke(src, args);
			connection.commit();
			System.out.println("�ύ����������");
		}
		catch(Exception e)
		{
			connection.rollback();
			System.out.println("�ع�����������");
			throw e;//Ϊʲô���ף���ΪThrowable��Exception�ĸ��ࡣ
		}
		finally
		{
			connection.close();
			DataSourceUtils_c3p0.remove();
		}
		return returnValue;
	}
	
}
