package com.kdyzm.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * ��ʾ������ӵ�нӿڵ�����д���,���Ҹ���ʵ����InvocationHandler�ӿڡ�
 * ���ַ�ʽ���Ƽ��Ĵ���ʽ��
 */
public class ProxyForAllClassHasInterface implements InvocationHandler{
	private Object src;
	private ProxyForAllClassHasInterface(Object src)
	{
		this.src=src;
	}
	public static Object factory(Object src)
	{
		Object aim=Proxy.newProxyInstance(ProxyForAllClassHasInterface.class.getClassLoader(),
				src.getClass().getInterfaces(), 
				new ProxyForAllClassHasInterface(src));
		return aim;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getName()+"����������ProxyForAllClassHasInterface��");
		return method.invoke(src, args);//����src�ķ�����
	}
}
