package com.model.exceptionTest;

import java.io.IOException;

/**
 * �Զ����쳣��
 * */

public class exceptionTest extends Exception{
	
	public exceptionTest(){
	}
	
	//�Զ����쳣��ʾ��Ϣ
	public exceptionTest(String msg){
		super(msg);
	}
	
	//����׷�ٵ���ԭʼ��Ϣ
	public exceptionTest(Throwable t){
		super(t);
	}
	
	public void test(String numStr) throws exceptionTest{
		try {
			int num=Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
//			throw new exceptionTest(e);
			throw new exceptionTest("����ת���쳣���쳣��!");
		}catch (Exception e) {
			throw new exceptionTest(e);
		}
		
	}
	
	public static void main(String[] args) throws exceptionTest {
//		if(true){
//			throw new exceptionTest("�쳣���쳣��!");
//		}
		
		try {
			new exceptionTest().test("dd");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
}
