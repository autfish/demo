package com.autfish._socket.chap11.messageExamples;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * 平台发送给游戏服务器的TCP封装包
 --------------------------------------------------------------------------
 cmd	        整数，2字节
 length	        整数，2字节，消息长度(version、sn、data、sign四项内容总长度)
 version	    整数，2字节
 sn	            字符串
 data	        字符串，json格式
 sign	        字符串
 delimeter      $$, 2字节
 --------------------------------------------------------------------------
 * Created by wujingchun on 2017/3/9.
 */
public class RequestMessage {

    final int MAX_LENGTH = 2048;
    protected ByteBuffer buffer;

    protected short cmd;
    protected short messageLen;
    protected short version;
    protected String sn;
    protected String data;
    protected String sign;

    private RequestMessage() {
        buffer = ByteBuffer.allocate(MAX_LENGTH);
    }

    public static RequestMessage build(short cmd, short version, String data, String sign) {
        RequestMessage msg = new RequestMessage();
        msg.cmd = cmd;
        msg.version = version;
        msg.sn = MessageBuilder.generateSn();
        msg.data = data;
        msg.sign = sign;
        try {
            msg.messageLen = (short)(8 + msg.sn.getBytes("UTF-8").length + data.getBytes("UTF-8").length + sign.getBytes("UTF-8").length);
        } catch (UnsupportedEncodingException e) {}
        return msg;
    }

    public static RequestMessage build(int cmd, int version, String data, String sign) {
        return build((short)cmd, (short)version, data, sign);
    }

    public byte[] toSendBytes() {
        MessageBuilder.writeShort(buffer, this.cmd);
        MessageBuilder.writeShort(buffer, this.messageLen);
        MessageBuilder.writeShort(buffer, this.version);
        MessageBuilder.writeString(buffer, sn);
        MessageBuilder.writeString(buffer, data);
        MessageBuilder.writeString(buffer, sign);
        MessageBuilder.writeDelimiter(buffer);

        byte[] send = new byte[buffer.position()];
        buffer.rewind();
        buffer.get(send, 0, send.length);
        return send;
    }

    public short getCmd() {
        return cmd;
    }

    public short getMessageLen() {
        return messageLen;
    }

    public short getVersion() {
        return version;
    }

    public String getSn() {
        return sn;
    }

    public String getData() {
        return data;
    }

    public String getSign() {
        return sign;
    }
}
