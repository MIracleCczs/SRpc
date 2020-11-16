package com.miracle.rpc.serializer;

import java.io.IOException;

/**
 * @program: SRpc
 * @description: 自定义序列化接口
 * @author: miracle
 * @create: 2020-11-15 10:11
 **/
public interface Serializer {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T obj) throws IOException;

    /**
     * 反序列化
     *
     * @param data
     * @param clazz 目标类
     * @param <T>
     * @return
     */
    <T> T deserialize(byte[] data, Class<T> clazz);
}
