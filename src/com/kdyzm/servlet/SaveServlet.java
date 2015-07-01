package com.kdyzm.servlet;
/*
 * 响应请求并调用事务保存数据。
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdyzm.dbutils.ProxyForTransactionService;
import com.kdyzm.interfaces.TransactionInterface;
import com.kdyzm.service.SaveService;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 6195963898071317331L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 这里出现了转换异常，该怎么解决
		 * 这里不能写SaveService，而应当写TransactionInterface，因为代理之后的对象是接口在内存中生成的子类对象
		 */
		TransactionInterface service=(TransactionInterface) ProxyForTransactionService.factory(new SaveService());
		service.save();
//		service.query();
	}
}
