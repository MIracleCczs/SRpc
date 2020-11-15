package com.miracle.rpc.common.support;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

/**
 * @program: SRpc
 * @description: 获取IP工具类
 * @author: miracle
 * @create: 2020-11-15 10:17
 **/
@Slf4j
public class IpHelper {

    /**
     * 获取本地IP
     * @return
     */
    public static String getLocalIP() {
        StringBuilder sb = new StringBuilder();
        try {
            InetAddress addr = InetAddress.getLocalHost();
            byte[] ipAddr = addr.getAddress();
            for (int i = 0; i < ipAddr.length; i++) {
                if (i > 0) {
                    sb.append(".");
                }
                sb.append(ipAddr[i] & 0xFF);
            }
        } catch (Exception var) {
            log.error("IpHelper get local ip error", var);
        }
        return sb.toString();
    }
}
