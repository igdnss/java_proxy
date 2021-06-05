package com.research.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这是一个代理，通过这个代理可以与目标类取得联系
 */
public class EstateHandler implements InvocationHandler {
	
	//目标对象
	private Object target;
	
	
	
	/**
	 * obj:目标对象通过构造方法传进来
	 */
	public EstateHandler(Object obj) {
		super();
		this.target = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//扩展的业务1
		doSomeThingBefore();
		//目标方法，使用代理对象调用方法时，会通过反射生成method,从而保证能调用到目标函数
		Object result = method.invoke(target, args);
		//扩展的业务2 
		doSomeThingAfter();
		return result;
	}

	private void doSomeThingBefore() {
		System.out.println("收点中介费");
	}
	private void doSomeThingAfter() {
		System.out.println("办理产证");
	}

}
