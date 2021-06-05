package com.research.dynamic;

import com.research.Owner;

public class OfficeOwner implements Owner {

	@Override
	public void exchangeOldHouse(String str) {
		System.out.println("Here has kinds of office");
		System.out.println(str);
	}

}
