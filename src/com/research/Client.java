package com.research;

public class Client {
	public static void main(String[] args) {
		//真正提供服务的对象
		HouseOwner owner = new HouseOwner();
		//由代理来接触真正的对象
		CoupleAgent agent = new CoupleAgent(owner);
		agent.exchangeOldHouse("房子交易成功");
	}

}
