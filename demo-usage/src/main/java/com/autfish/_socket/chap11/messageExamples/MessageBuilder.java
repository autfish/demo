package com.autfish._socket.chap11.messageExamples;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Created by wujingchun on 2017/3/9.
 */
public class MessageBuilder {

    public static String generateSn() {
        return String.valueOf(System.currentTimeMillis()).substring(0, 12) + RandomStringUtils.randomAlphanumeric(8).toUpperCase();
    }

    public static void writeShort(ByteBuffer buffer, short value)  throws ArrayIndexOutOfBoundsException {
        if(buffer.remaining() >= 2) {
            buffer.putShort(value);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void writeInt(ByteBuffer buffer, int value)  throws ArrayIndexOutOfBoundsException {
        if(buffer.remaining() >= 4) {
            buffer.putInt(value);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void writeString(ByteBuffer buffer, String value)  throws ArrayIndexOutOfBoundsException {
        byte[] temp = new byte[0];
        try {
            temp = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) { }
        if(temp.length > buffer.remaining() - 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        writeShort(buffer, (short)temp.length);
        if(temp.length > 0) {
            buffer.put(temp);
        }
    }

    public static void writeDelimiter(ByteBuffer buffer) {
        if(buffer.remaining() < 2)
            throw new ArrayIndexOutOfBoundsException();
        try {
            byte[] temp = "$$".getBytes("UTF-8");
            buffer.put(temp);
        } catch (UnsupportedEncodingException e) { }
    }

    public static short readShort(ByteBuffer buffer) throws ArrayIndexOutOfBoundsException {
        if(buffer.remaining() >= 2) {
            short value = buffer.asShortBuffer().get();
            buffer.position(buffer.position() + 2);
            return value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static int readInt(ByteBuffer buffer) throws ArrayIndexOutOfBoundsException {
        if(buffer.remaining() >= 4) {
            int value = buffer.asIntBuffer().get();
            buffer.position(buffer.position() + 4);
            return value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static String readString(ByteBuffer buffer) throws ArrayIndexOutOfBoundsException {
        int length = readShort(buffer);
        if(length == 0) {
            return "";
        } else if(buffer.remaining() >= length) {
            byte[] buff = new byte[length];
            buffer.get(buff, 0, buff.length);
            return new String(buff);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
