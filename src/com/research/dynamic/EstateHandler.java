package com.research.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ����һ������ͨ��������������Ŀ����ȡ����ϵ
 */
public class EstateHandler implements InvocationHandler {
	
	//Ŀ�����
	private Object target;
	
	
	
	/**
	 * obj:Ŀ�����ͨ�����췽��������
	 */
	public EstateHandler(Object obj) {
		super();
		this.target = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//��չ��ҵ��1
		doSomeThingBefore();
		//Ŀ�귽����ʹ�ô��������÷���ʱ����ͨ����������method,�Ӷ���֤�ܵ��õ�Ŀ�꺯��
		Object result = method.invoke(target, args);
		//��չ��ҵ��2 
		doSomeThingAfter();
		return result;
	}

	private void doSomeThingBefore() {
		System.out.println("�յ��н��");
	}
	private void doSomeThingAfter() {
		System.out.println("�����֤");
	}

}
