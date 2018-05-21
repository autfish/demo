package com.autfish._socket.chap11.messageExamples;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Administrator on 2017/3/10.
 */
public class SocketMessage {
    final int MAX_LENGTH = 1024;

    public SocketMessage(short messageNum, ByteOrder order) {
        this.messageNum = messageNum;
        data = ByteBuffer.allocate(MAX_LENGTH);
        data.order(order);
        data.putShort(messageNum);
        data.putShort((short)0);
    }

    public SocketMessage(short messageNum) {
        this(messageNum, ByteOrder.BIG_ENDIAN);
    }

    private SocketMessage() {
        this((short)0);
    }

    public static SocketMessage parse(ByteBuffer data, ByteOrder byteOrder) {
        if(data == null) return null;
        SocketMessage msg = new SocketMessage();
        msg.data = data;
        msg.data.order(byteOrder);
        try {
            msg.readHeader();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
        if(msg.data.limit() >= msg.messageLen + 4) {
            msg.data.limit(msg.messageLen + 4);
            return msg;
        }
        return null;
    }

    public static SocketMessage parse(byte[] data, ByteOrder byteOrder) {
        return parse(ByteBuffer.wrap(data), byteOrder);
    }

    public void readHeader() throws ArrayIndexOutOfBoundsException {
        if(data.limit() >= 4) {
            messageNum = data.asShortBuffer().get();
            data.position(data.position() + 2);
            messageLen = data.asShortBuffer().get();
            data.position(data.position() + 2);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public short readShort() throws ArrayIndexOutOfBoundsException {
        if(data.remaining() >= 2) {
            short value = data.asShortBuffer().get();
            data.position(data.position() + 2);
            return value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int readInt() throws ArrayIndexOutOfBoundsException {
        if(data.remaining() >= 4) {
            int value = data.asIntBuffer().get();
            data.position(data.position() + 4);
            return value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String readString() throws ArrayIndexOutOfBoundsException {
        int length = readShort();
        if(length == 0) {
            return "";
        } else if(data.remaining() >= length) {
            byte[] buff = new byte[length];
            data.get(buff, 0, buff.length);
            return new String(buff);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void writeShort(short value)  throws ArrayIndexOutOfBoundsException {
        if(data.remaining() >= 2) {
            data.putShort(value);
            messageLen += 2;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void writeInt(int value)  throws ArrayIndexOutOfBoundsException {
        if(data.remaining() >= 4) {
            data.putInt(value);
            messageLen += 4;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void writeString(String value)  throws ArrayIndexOutOfBoundsException {
        byte[] buff = new byte[0];
        try {
            buff = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) { }
        if(buff.length > data.remaining()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        writeShort((short)buff.length);
        if(buff.length > 0) {
            data.put(buff);
            messageLen += buff.length;
        }
    }

    public byte[] toSend() {

        byte[] buff = new byte[data.position()];
        data.position(2);
        data.putShort(messageLen);
        data.rewind();
        data.get(buff, 0, buff.length);
        return buff;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(short messageNum) {
        this.messageNum = messageNum;
    }

    public int getMessageLen() {
        return messageLen;
    }

    public void setMessageLen(short messageLen) {
        this.messageLen = messageLen;
    }

    private ByteBuffer data;
    private short messageNum = 0;
    private short messageLen = 0;
}
