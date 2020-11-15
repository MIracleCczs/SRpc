package com.miracle.rpc.common.constants;

import io.netty.util.CharsetUtil;

/**
 * @program: SRpc
 * @description: 常量信息
 * @author: miracle
 * @create: 2020-11-15 10:16
 **/
public class SRpcConstants {
    public static final String START = "##";

    public static final byte[] START_BYTE = "##".getBytes(CharsetUtil.UTF_8);

    public static final String COLON = ":";

    public static final String AND = "&";

    public static final String LINE = "_";

    public static final String PREFIX = "providers";

    public static final int PORT = 8888;
}
