package com.URL.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
//�ͻ���
public class SocketTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		Socket socket = null;
		try {
			InetAddress ip=InetAddress.getByName("127.0.0.1");
			socket=new Socket(ip,30002);
			//���ó�ʱʱ��
			socket.setSoTimeout(3000);
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("��ַ"+socket.getInetAddress().getHostName()+":"+socket.getPort()+"����Ϣ  "+br.readLine());
		}
		catch (SocketTimeoutException stex) {
			System.out.println(1);
			stex.printStackTrace();
			stex.getMessage();
			stex.getStackTrace();
		} 
		catch (SocketException e) {
			System.out.println(2);
			e.printStackTrace();
		
		}
		catch (Exception e) {
			System.out.println(3);
			e.printStackTrace();
		
		}
		finally{
			br.close();
			socket.close();
		}
		
	}
}
