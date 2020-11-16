package com.miracle.rpc.serializer;

import com.miracle.rpc.exception.SRpcException;

import java.io.*;

/**
 * @program: SRpc
 * @description: 默认序列化方式
 * @author: miracle
 * @create: 2020-11-16 21:26
 **/
public class DefaultSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new SRpcException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (T)objectInputStream.readObject();
        } catch (IOException|ClassNotFoundException e) {
            throw new SRpcException(e);
        }
    }
}
