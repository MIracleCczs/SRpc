package com.miracle.rpc.serializer;

import com.miracle.rpc.exception.SRpcException;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @program: SRpc
 * @description: xml
 * @author: miracle
 * @create: 2020-11-16 21:34
 **/
public class XmlStreamSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(byteArrayOutputStream, "utf-8", true, 0);
            xmlEncoder.writeObject(obj);
        } catch (Exception e) {
            throw new SRpcException(e);
        } finally {
            byteArrayOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        XMLDecoder xmlDecoder = new XMLDecoder(byteArrayInputStream);
        T t = (T)xmlDecoder.readObject();
        xmlDecoder.close();
        return t;
    }
}
