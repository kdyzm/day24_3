package com.kdyzm.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示对List进行代理，只能对List进行代理。
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
						System.out.println(method.getName()+"方法被调用！");
						return method.invoke(list, args);
					}
				});
		@SuppressWarnings("unchecked")
		List<String>l=(List<String>) proxy;
		l.add("小强！");
		System.out.println(l);
	}
}
