package com.URL;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class URLTest {
	public static void main(String[] args) throws Exception {
		InetAddress ip=InetAddress.getByName("www.baidu.com");
		System.out.println(ip.getHostAddress());//IP��ַ
		System.out.println(ip.getHostName());//����
//		System.out.println(ip.getCanonicalHostName());//ȫ�޶�����
		System.out.println(ip.getLocalHost());//����ip��ַ��Ӧ��inetaddressʵ��
//		System.out.println(ip.isReachable(7000));
		
		InetAddress local=InetAddress.getByName("127.0.0.1");
//		System.out.println(local.isReachable(1000));
		
		//3eafhJ1PMmNWUd3A1I2fTr8SOLmHwXn5xLqEiqgq4llcH4Wjg2t5HBdS5DE
		System.out.println(URLDecoder.decode("switch%E4%B8%AD%E6%96%87%E6%B8%B8%E6%88%8F", "UTF-8"));
		System.out.println(URLEncoder.encode("switch������Ϸ","UTF-8"));
		
	}
}
