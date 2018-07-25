package com.newIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
//��io
public class ChannelTest {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			File f=new File("g:/1.txt");
			FileChannel inChannel=new FileInputStream(f).getChannel();
			ByteBuffer bbin=inChannel.map(FileChannel.MapMode.READ_ONLY, 0,f.length());
			
			
			FileChannel outChannel=new FileOutputStream("g:/a.txt").getChannel();
			outChannel.write(bbin);
			
			bbin.clear();
			
			Charset charset=Charset.forName("GBK");
			//����������
			CharsetDecoder charsetDecoder=charset.newDecoder();
			//ʹ�ý�������butebufferת����charbuffer
			CharBuffer charBuffer=charsetDecoder.decode(bbin);
			System.out.println(charBuffer);
			//��ǰ����ϵͳʹ�õı��뷽ʽ
			System.out.println(System.getProperty("file.encoding"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
