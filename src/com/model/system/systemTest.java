package com.model.system;

import java.io.IOException;
import java.util.Map;

public class systemTest {

	public static void main(String[] args) throws IOException {
		Map<String,String> map=System.getenv();
		for(String key:map.keySet()){
			System.out.println(key+"---------->"+map.get(key));
		}
		
		System.out.println(System.getProperty("os.name"));
		
		//����Ϊ��λ
		System.out.println(System.currentTimeMillis());
		//΢��Ϊ��λ
		System.out.println(System.nanoTime());
		
		Runtime rt=Runtime.getRuntime();
		System.out.println("����������:"+rt.availableProcessors());
		System.out.println("�����ڴ�:"+rt.freeMemory());
		System.out.println("���ڴ���:"+rt.totalMemory());
		System.out.println("��������ڴ���:"+rt.maxMemory());
		
		//���в���ϵͳ����
		  
		rt.exec("notepad.exe");
		
	}
	
}
