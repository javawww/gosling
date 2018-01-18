package com.git;

import java.util.UUID;


public class Random {

	public static void main(String[] args) {
		String pre = "A";
		for (int i = 1; i <= 500; i++) {
			System.out.println(pre+ UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10));
		}
		
	}
}
