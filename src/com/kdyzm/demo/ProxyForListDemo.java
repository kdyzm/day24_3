package com.kdyzm.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ʾ��List���д���ֻ�ܶ�List���д���
 * @author kdyzm
 *
 */
public class ProxyForListDemo {
	public static void main(String[] args) {
		final List<String>list=new ArrayList<String>();
		Object proxy=Proxy.newProxyInstance(ProxyForListDemo.class.getClassLoader(),
				new Class[]{List.class}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println(method.getName()+"���������ã�");
						return method.invoke(list, args);
					}
				});
		@SuppressWarnings("unchecked")
		List<String>l=(List<String>) proxy;
		l.add("Сǿ��");
		System.out.println(l);
	}
}
