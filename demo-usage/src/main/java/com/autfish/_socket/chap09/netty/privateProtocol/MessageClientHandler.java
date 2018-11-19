package com.autfish._socket.chap09.netty.privateProtocol;

import com.autfish._socket.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

class MessageClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object in)
			throws Exception {
		Message msg = (Message) in;
		System.out.println("msg: " + msg.getMessageNum());
		System.out.println("message: " + msg.readString());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
