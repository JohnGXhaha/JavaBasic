package com.Thread.ThreadLocalTest;

public class test {
	public static void main(String[] args) {
		Account at=new Account("��ʼ��");
		new MyThread(at,"�̼߳�").start();
		new MyThread(at,"�߳���").start();
	}
}
