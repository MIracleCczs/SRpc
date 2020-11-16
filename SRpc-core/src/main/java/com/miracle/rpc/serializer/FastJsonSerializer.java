package com.miracle.rpc.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;

/**
 * @program: SRpc
 * @description: fastjson
 * @author: miracle
 * @create: 2020-11-16 21:27
 **/
public class FastJsonSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        return JSON.toJSONBytes(obj, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat});
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T) JSON.parseObject(data, clazz, new Feature[0]);
    }
}
