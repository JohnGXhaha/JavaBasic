package com.model;

public class DataWrap {
	private int a;
	private int b;
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void swap(DataWrap dw){
		int tmp=dw.a;
		dw.a=dw.b;
		dw.b=tmp;
		System.out.println("ջ�ڴ��и��Ƶ�dw���� swap1 "+dw.a+","+dw.b);
		dw=null;
		System.out.println("ջ�ڴ��и��Ƶ�dw����ָ���ж� swap2 "+dw);
	}
	
	public static void main(String[] args) {
		DataWrap dw=new DataWrap();
		dw.a=6;
		dw.b=9;
		//��������ķ�����ʱ��,���Ƶ���dw����,��������ͬһ��DataWrap����,��a��b�����ݻ������ı�
		dw.swap(dw);
		System.out.println("main ջ�ڴ���ԭʼdw������Ȼָ����ڴ��DataWrap���� "+dw.a+","+dw.b);
		
		
		
	}
	
	
}
