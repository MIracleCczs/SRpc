package com.miracle.rpc.serializer;

import java.io.IOException;

/**
 * @program: SRpc
 * @description: 自定义序列化接口
 * @author: miracle
 * @create: 2020-11-15 10:11
 **/
public interface Serializer {

    <T> byte[] serialize(T paramT) throws IOException;

    <T> T deserialize(byte[] paramArrayOfbyte, Class<T> paramClass);
}
