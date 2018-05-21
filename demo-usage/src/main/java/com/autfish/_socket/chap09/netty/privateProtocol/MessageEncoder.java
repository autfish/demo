package com.autfish._socket.chap09.netty.privateProtocol;

import com.autfish._socket.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf sendBuf)
			throws Exception {
		sendBuf.writeBytes(msg.toSend());
	}

}
