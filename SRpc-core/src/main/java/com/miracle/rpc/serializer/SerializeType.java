package com.miracle.rpc.serializer;

import org.apache.commons.lang3.StringUtils;

public enum SerializeType {

    DEFAULT_SERIALIZER("DefaultSerializer"),
    JACKSON_SERIALIZER("JacksonSerializer"),
    HESSIAN_SERIALIZER("HessianSerializer"),
    FASTJSON_SERIALIZER("FastJsonSerializer"),
    XML_STREAM_SERIALIZER("XmlStreamSerializer");

    private String type;

    public static SerializeType queryByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }
        SerializeType[] serializeTypes = values();
        for (SerializeType serialize : serializeTypes) {
            if (StringUtils.equals(type, serialize.getType())) {
                return serialize;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    SerializeType(String type) {
        this.type = type;
    }
}
