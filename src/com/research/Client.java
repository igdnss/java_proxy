package com.research;

public class Client {
	public static void main(String[] args) {
		//�����ṩ����Ķ���
		HouseOwner owner = new HouseOwner();
		//�ɴ������Ӵ������Ķ���
		CoupleAgent agent = new CoupleAgent(owner);
		agent.exchangeOldHouse("���ӽ��׳ɹ�");
	}

}
