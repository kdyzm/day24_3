package com.kdyzm.interfaces;

import com.kdyzm.myannotation.Transactionflag;

public interface TransactionInterface {
	@Transactionflag//��ʾ�÷�����Ҫʹ������
	public void save();//����save������������
	//����ע���ʾ�÷�������Ҫʹ������
	public void query();
}
