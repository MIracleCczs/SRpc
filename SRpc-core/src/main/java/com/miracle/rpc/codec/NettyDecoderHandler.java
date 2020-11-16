package com.miracle.rpc.codec;

import com.miracle.rpc.serializer.SerializeType;
import com.miracle.rpc.serializer.SerializerEngine;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @program: SRpc
 * @description: 解码器
 * @author: miracle
 * @create: 2020-11-16 20:54
 **/
public class NettyDecoderHandler extends ByteToMessageDecoder {

    private Class<?> genericClass;

    private SerializeType serializeType;

    public NettyDecoderHandler(Class<?> genericClass, SerializeType serializeType) {
        this.genericClass = genericClass;
        this.serializeType = serializeType;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int readableLength = in.readableBytes();
        if (readableLength < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            ctx.close();
        }
        if (readableLength < dataLength) {
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        Object obj = SerializerEngine.deserialize(data, this.genericClass, this.serializeType.getType());
        out.add(obj);
    }
}
