package com.kdyzm.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 对ProxyForAllClassHasInterface类进行测试！
 */
public class Test {
	public static void main(String[] args) {
		List<String>list=new ArrayList<String>();
		list=(List<String>) ProxyForAllClassHasInterface.factory(list);
		list.add("你好，小强！");
		System.out.println(list);
		
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String, String>) ProxyForAllClassHasInterface.factory(map);
		map.put("12110501001", "小强");
		System.out.println(map);
	}
}
