package com.process;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		int data1 = 0;
		int data2 = 0;
		for(int i=0; i<=10; i++) {
			data1 += i;
			System.out.println("data1: "+data1);
			Thread.sleep(300);
		}
		for(int i=0; i<=10; i++) {
			data1 += i;
			System.out.println("data2:"+data1);
			Thread.sleep(300);
		}
	}

}
