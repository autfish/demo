package com.autfish._socket.chap05.netty.fixedLength;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {

	public static void main(String[] args) throws Exception {
		int port = 18080;
		new EchoClient().connect(port, "127.0.0.1");
	}

	public void connect(int port, String host) throws Exception {
		//配置客户端NIO线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>(){
					@Override
					protected void initChannel(SocketChannel channel)
							throws Exception {
						channel.pipeline().addLast(new FixedLengthFrameDecoder(20));
						channel.pipeline().addLast(new StringDecoder());
						channel.pipeline().addLast(new EchoClientHandler());
					}
				});
			//发起异步连接操作
			ChannelFuture f = b.connect(host, port).sync();
			//等待客户端链路关闭
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully();
		}
	}
}

