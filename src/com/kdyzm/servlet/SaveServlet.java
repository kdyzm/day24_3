package com.kdyzm.servlet;
/*
 * ��Ӧ���󲢵������񱣴����ݡ�
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
		 * ���������ת���쳣������ô���
		 * ���ﲻ��дSaveService����Ӧ��дTransactionInterface����Ϊ����֮��Ķ����ǽӿ����ڴ������ɵ��������
		 */
		TransactionInterface service=(TransactionInterface) ProxyForTransactionService.factory(new SaveService());
		service.save();
//		service.query();
	}
}
