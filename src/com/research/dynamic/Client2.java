package com.research.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.research.HouseOwner;
import com.research.Owner;

public class Client2 {

	public static void main(String[] args) {
		// 创建目标对象
		Owner officeOwner = new OfficeOwner();
		// 创建一个InvocationHandler对象
		InvocationHandler estateHandler = new EstateHandler(officeOwner);
		// 创建一个代理对象,知道这么用就行了，当作一个公式用，往下研究很复杂，先不考虑
		Owner officeProxyInstance = (Owner) Proxy.newProxyInstance(officeOwner.getClass().getClassLoader(),
				officeOwner.getClass().getInterfaces(), estateHandler);
		// 使用代理对象调用目标方法，此目标方法会被反射成invoke方法中的method
		officeProxyInstance.exchangeOldHouse("I am a rich client");

		System.out.println("====================================================");
		// 之前的静态代理用动态代理处理试试
		Owner houseOwner = new HouseOwner();
		InvocationHandler houseHandler = new EstateHandler(houseOwner);
		Owner houseProxyInstance = (Owner) Proxy.newProxyInstance(houseOwner.getClass().getClassLoader(),
				houseOwner.getClass().getInterfaces(), houseHandler);
		// 使用代理对象调用目标方法，此目标方法会被反射成invoke方法中的method
		houseProxyInstance.exchangeOldHouse("I am a poor client");

		System.out.println("====================================================");
		// 如果又来个客户需要买房车，这里只需要重新实现一下Owner接口，无需修改Owner接口了，符合开闭原则
		Owner houseVanOwner = new HouseVanOwner();
		InvocationHandler houseVanHandler = new EstateHandler(houseVanOwner);
		Owner houseVanProxyInstance = (Owner) Proxy.newProxyInstance(houseVanOwner.getClass().getClassLoader(),
				houseVanOwner.getClass().getInterfaces(), houseVanHandler);
		// 使用代理对象调用目标方法，此目标方法会被反射成invoke方法中的method
		houseVanProxyInstance.exchangeOldHouse("I am a car house client");
	}

}
