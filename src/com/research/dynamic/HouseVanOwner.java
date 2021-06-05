package com.research.dynamic;

import com.research.Owner;

public class HouseVanOwner implements Owner {

	@Override
	public void exchangeOldHouse(String str) {
		System.out.println("Here is a house van");
		System.out.println(str);
	}

}
