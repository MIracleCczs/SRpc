package com.miracle.rpc.serializer;

import com.google.common.collect.Maps;
import com.miracle.rpc.exception.SRpcException;

import java.io.IOException;
import java.util.Map;

/**
 * @program: SRpc
 * @description: 序列化引擎
 * @author: miracle
 * @create: 2020-11-16 21:33
 **/
public class SerializerEngine {

    public static final Map<SerializeType, Serializer> SERIALIZER_MAP = Maps.newConcurrentMap();

    static {
        SERIALIZER_MAP.put(SerializeType.DEFAULT_SERIALIZER, new DefaultSerializer());
        SERIALIZER_MAP.put(SerializeType.JACKSON_SERIALIZER, new JacksonSerializer());
        SERIALIZER_MAP.put(SerializeType.HESSIAN_SERIALIZER, new HessianSerializer());
        SERIALIZER_MAP.put(SerializeType.FASTJSON_SERIALIZER, new FastJsonSerializer());
        SERIALIZER_MAP.put(SerializeType.XML_STREAM_SERIALIZER, new XmlStreamSerializer());
    }

    public static <T> byte[] serialize(T obj, String serialType) {
        SerializeType serializeType = SerializeType.queryByType(serialType);
        if (serializeType == null) {
            throw new SRpcException("don't find serializer");
        }
        Serializer iSerializer = SERIALIZER_MAP.get(serializeType);
        if (iSerializer == null) {
            throw new SRpcException("serialize error");
        }
        try {
            return iSerializer.serialize(obj);
        } catch (IOException e) {
            throw new SRpcException(e);
        }
    }

    public static <T> T deserialize(byte[] data, Class<T> clazz, String serialType) {
        SerializeType serializeType = SerializeType.queryByType(serialType);
        if (serializeType == null) {
            throw new SRpcException("don't find serializer");
        }
        Serializer iSerializer = SERIALIZER_MAP.get(serializeType);
        if (iSerializer == null) {
            throw new SRpcException("serialize error");
        }
        try {
            return iSerializer.deserialize(data, clazz);
        } catch (Exception var) {
            throw new SRpcException(var);
        }
    }
}
