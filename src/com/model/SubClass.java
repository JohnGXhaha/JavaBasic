package com.model;

import java.io.IOException;

//��ͨ��ֻ�ܼ̳�һ����
public class SubClass extends BaseClass {
	//��������·���ǩ����������,��Ϊ���෽���������쳣�����Ǹ��෽���������쳣���������ͬ
	//public void test() throws Exception{
	public void test() throws IOException{
		System.out.println("���า�ǵ�test����!");
	}
	
	public String toString(){
		return "����SubClass����,����Object��toString����";
	}

	public static void main(String[] args) throws IOException  {
		BaseClass bc=new SubClass();
		bc.test();
		System.out.println("�ָ�1");
		SubClass sc=new SubClass();
		sc.test();
		System.out.println("�ָ�2");
		System.out.println(sc);
	}
}
