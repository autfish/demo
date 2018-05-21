package com.autfish._socket.chap11.messageExamples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.ByteBuffer;

/**
 * 游戏服务器返回给平台的TCP封装包
 --------------------------------------------------------------------------
 cmd	        整数，2字节
 length	        整数，2字节，消息长度(sn、code、message、data四项内容总长度)
 sn	            字符串
 code           整数，2字节
 message        字符串
 data	        字符串，json格式
 delimeter      $$, 2字节
 --------------------------------------------------------------------------
 * Created by wujingchun on 2017/3/9.
 */
public class ResponseMessage {

    static Logger logger = LogManager.getLogger(ResponseMessage.class);

    protected ByteBuffer buffer;

    protected short cmd;
    protected short messageLen;
    protected String sn;
    protected short code;
    protected String message;
    protected String data;

    private ResponseMessage() {}

    public static ResponseMessage parse(byte[] receive) {
        if(receive == null || receive.length == 0) return null;
        ResponseMessage msg = new ResponseMessage();
        msg.buffer = ByteBuffer.wrap(receive);
        try {
            msg.cmd = MessageBuilder.readShort(msg.buffer);
            msg.messageLen = MessageBuilder.readShort(msg.buffer);
            msg.sn = MessageBuilder.readString(msg.buffer);
            msg.code = MessageBuilder.readShort(msg.buffer);
            msg.message = MessageBuilder.readString(msg.buffer);
            msg.data = MessageBuilder.readString(msg.buffer);
            return msg;
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error(e);
            return null;
        }
    }

    public short getCmd() {
        return cmd;
    }

    public short getMessageLen() {
        return messageLen;
    }

    public String getSn() {
        return sn;
    }

    public short getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}
