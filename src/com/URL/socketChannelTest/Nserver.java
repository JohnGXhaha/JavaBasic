package com.URL.socketChannelTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Nserver {
	private Selector selector;
	private Charset charset=Charset.forName("UTF-8");
	
	public void init() throws IOException{
		selector=Selector.open();
		ServerSocketChannel server=ServerSocketChannel.open();
		InetSocketAddress isa=new InetSocketAddress("127.0.0.1", 30001);
		//����ServerSocketChannel�󶨵�ָ��ip
		server.socket().bind(isa);
		//����Ϊ������ͨѶ
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		
		while(selector.select()>0){
			for(SelectionKey sk:selector.selectedKeys()){
				//sk��Ӧ��ͨ�������ͻ��˵���������
				if(sk.isAcceptable()){
					//��������,���ɷ������˶�Ӧ��SocketChannel
					SocketChannel sc=server.accept();
					sc.configureBlocking(false);
					//��SocketChannelע�ᵽSelector
					sc.register(selector, SelectionKey.OP_READ);
					//ע����sc֮��,��sk���ó�׼���������������״̬
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				//�Ƿ������ݶ�ȡ
				if(sk.isReadable()){
					//��ȡ��SelectionKey��Ӧ��Channel
					//(ע����ϱߴ���30�е�SocketChannel���������,�ϱߵ�SocketChannel�����ɺʹ�SocketChannel��Ӧ����˵�SocketChannel)
					SocketChannel sc=(SocketChannel) sk.channel();
					
					ByteBuffer bb=ByteBuffer.allocate(1024);
					String content="";
					
					try {
						while(sc.read(bb)>0){
							//׼���������
							bb.flip();
							content+=charset.decode(bb);
						}
						//��ȡ��channel������֮��,��sk���ó�׼����һ�ζ�ȡ
						sk.interestOps(SelectionKey.OP_READ);
					} catch (Exception e) {
						//��Selector��ɾ��ָ����SelectionKey
						sk.cancel();
						if(sk.channel()!=null){
							sk.channel().close();
						}
					}
					
					//������д��������Selector��ע���channel
					if(content.length()>0){
						//����selector����SelectionKey
						for(SelectionKey key:selector.keys()){
							Channel channel=key.channel();
							//�жϴ�channel�ǲ��ǿͻ���channel
							if(channel instanceof SocketChannel){
								SocketChannel dest=(SocketChannel) channel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Nserver().init();
	}
}
