package com.research;

public class CoupleAgent implements Owner {
	
	//�������Ҫ�������������ʵĶ���
	HouseOwner houseOwner;
	

	public CoupleAgent(HouseOwner houseOwner) {
		super();
		this.houseOwner = houseOwner;
	}


	@Override
	public void exchangeOldHouse(String str) {
		//��չԭ�е�ҵ��1
		doSomeThingBefore();
		houseOwner.exchangeOldHouse(str);
		//��չԭ�е�ҵ��2
		doSomeThingAfter();
	}
	private void doSomeThingBefore() {
		System.out.println("�յ��н��");
	}
	private void doSomeThingAfter() {
		System.out.println("�����֤");
	}

}
