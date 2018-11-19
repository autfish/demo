package com.autfish._socket.chap05.netty.fixedLength;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

class EchoClientHandler extends ChannelInboundHandlerAdapter {
	private int counter;

	private byte[] req;

	public EchoClientHandler() {
		req = ("QUERY TIME ORDER").getBytes();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ByteBuf message = null;
		for(int i = 0; i < 100; i++) {
			message = Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String)msg;
		System.out.println("body: " + body + "; counter: " + ++counter);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
