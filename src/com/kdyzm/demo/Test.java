package com.kdyzm.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ��ProxyForAllClassHasInterface����в��ԣ�
 */
public class Test {
	public static void main(String[] args) {
		List<String>list=new ArrayList<String>();
		list=(List<String>) ProxyForAllClassHasInterface.factory(list);
		list.add("��ã�Сǿ��");
		System.out.println(list);
		
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String, String>) ProxyForAllClassHasInterface.factory(map);
		map.put("12110501001", "Сǿ");
		System.out.println(map);
	}
}
