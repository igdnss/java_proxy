package com.research;

public class CoupleAgent implements Owner {
	
	//这里必须要包含被真正访问的对象
	HouseOwner houseOwner;
	

	public CoupleAgent(HouseOwner houseOwner) {
		super();
		this.houseOwner = houseOwner;
	}


	@Override
	public void exchangeOldHouse(String str) {
		//扩展原有的业务1
		doSomeThingBefore();
		houseOwner.exchangeOldHouse(str);
		//扩展原有的业务2
		doSomeThingAfter();
	}
	private void doSomeThingBefore() {
		System.out.println("收点中介费");
	}
	private void doSomeThingAfter() {
		System.out.println("办理产证");
	}

}
