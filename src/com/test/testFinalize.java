package com.test;

public class testFinalize {
	private static testFinalize tf=null;
	
	public void info(){
		System.out.println("������������finalze����ʱЧ");
	}
	public static void main(String[] args) throws Throwable {
		new testFinalize();
		//��������������(ʲôʱ�����finalize��֪��)
		System.gc();
		Runtime.getRuntime().gc();
//		Thread.sleep(1000);
		//��������������(��������finalize����)
		System.runFinalization();
		Runtime.getRuntime().runFinalization();
		tf.info();
	}
	
	public void finalize(){
		tf=this;
	}
}
