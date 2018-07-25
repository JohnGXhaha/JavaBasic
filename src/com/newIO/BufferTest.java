package com.newIO;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		CharBuffer cb=CharBuffer.allocate(8);
		System.out.println("capacity:"+cb.capacity());
		System.out.println("limit:"+cb.limit());
		System.out.println("position:"+cb.position());
		
		cb.put('a');
		cb.put('b');
		cb.put('c');
		
		System.out.println("�������Ԫ�غ��position:"+cb.position());
		System.out.println("�������Ԫ�غ��limit:"+cb.limit());
		System.out.println(cb.get());
		
		cb.flip();//position��λ0,limit��Ϊ ԭposition����λ��,Ϊ���������׼��
		System.out.println("flip���position:"+cb.position());
		System.out.println("flip���limit:"+cb.limit());
		System.out.println("flip��ȡ����һ��Ԫ��:"+cb.get());
		System.out.println("flip��ȡ����һ��Ԫ��positionλ��:"+cb.position());
		
		cb.clear();//position��λ0,limit��Ϊcapacity
		System.out.println("clear���position:"+cb.position());
		System.out.println("clear���limit:"+cb.limit());
		//����ȡֵ
		System.out.println("clear��ȡ���ڶ���Ԫ��:"+cb.get(1));
		//����ȡֵ��Ӱ��positionλ��
		System.out.println("clear�����ȡ���ڶ���Ԫ��positionλ��:"+cb.position());
	}
}
