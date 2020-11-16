package com.miracle.rpc.codec;

import com.miracle.rpc.serializer.SerializeType;
import com.miracle.rpc.serializer.SerializerEngine;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @program: SRpc
 * @description: 编码器
 * @author: miracle
 * @create: 2020-11-16 20:55
 **/
public class NettyEncoderHandler extends MessageToByteEncoder {

    private SerializeType serializeType;

    public NettyEncoderHandler(SerializeType serializeType) {
        this.serializeType = serializeType;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, ByteBuf out) throws Exception {
        byte[] bytes = SerializerEngine.serialize(msg, this.serializeType.getType());
        out.writeInt(bytes.length);
        out.writeBytes(bytes);
    }
}
