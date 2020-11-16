package com.miracle.rpc.serializer;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.miracle.rpc.exception.SRpcException;

import java.io.IOException;

/**
 * @program: SRpc
 * @description: jackson
 * @author: miracle
 * @create: 2020-11-16 21:31
 **/
public class JacksonSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            return new byte[0];
        }
        try {
            return JacksonUtils.toJsonBytes(obj);
        } catch (Exception var) {
            throw new SRpcException(var);
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String json = new String(data);
        try {
            return JacksonUtils.toObj(json, clazz);
        } catch (Exception var) {
            throw new SRpcException(var);
        }
    }
}
