package com.research.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.research.HouseOwner;
import com.research.Owner;

public class Client2 {

	public static void main(String[] args) {
		// ����Ŀ�����
		Owner officeOwner = new OfficeOwner();
		// ����һ��InvocationHandler����
		InvocationHandler estateHandler = new EstateHandler(officeOwner);
		// ����һ���������,֪����ô�þ����ˣ�����һ����ʽ�ã������о��ܸ��ӣ��Ȳ�����
		Owner officeProxyInstance = (Owner) Proxy.newProxyInstance(officeOwner.getClass().getClassLoader(),
				officeOwner.getClass().getInterfaces(), estateHandler);
		// ʹ�ô���������Ŀ�귽������Ŀ�귽���ᱻ�����invoke�����е�method
		officeProxyInstance.exchangeOldHouse("I am a rich client");

		System.out.println("====================================================");
		// ֮ǰ�ľ�̬�����ö�̬����������
		Owner houseOwner = new HouseOwner();
		InvocationHandler houseHandler = new EstateHandler(houseOwner);
		Owner houseProxyInstance = (Owner) Proxy.newProxyInstance(houseOwner.getClass().getClassLoader(),
				houseOwner.getClass().getInterfaces(), houseHandler);
		// ʹ�ô���������Ŀ�귽������Ŀ�귽���ᱻ�����invoke�����е�method
		houseProxyInstance.exchangeOldHouse("I am a poor client");

		System.out.println("====================================================");
		// ����������ͻ���Ҫ�򷿳�������ֻ��Ҫ����ʵ��һ��Owner�ӿڣ������޸�Owner�ӿ��ˣ����Ͽ���ԭ��
		Owner houseVanOwner = new HouseVanOwner();
		InvocationHandler houseVanHandler = new EstateHandler(houseVanOwner);
		Owner houseVanProxyInstance = (Owner) Proxy.newProxyInstance(houseVanOwner.getClass().getClassLoader(),
				houseVanOwner.getClass().getInterfaces(), houseVanHandler);
		// ʹ�ô���������Ŀ�귽������Ŀ�귽���ᱻ�����invoke�����е�method
		houseVanProxyInstance.exchangeOldHouse("I am a car house client");
	}

}
