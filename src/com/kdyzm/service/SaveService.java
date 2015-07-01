package com.kdyzm.service;

import com.kdyzm.dao.Dao1;
import com.kdyzm.dao.Dao2;
import com.kdyzm.interfaces.TransactionInterface;

public class SaveService implements TransactionInterface{
	Dao1 dao1=new Dao1();
	Dao2 dao2=new Dao2();
	@Override
	public void save()
	{
		dao1.save();
		dao2.save();
	}
	@Override
	public void query() {
		dao1.query();
	}
}
