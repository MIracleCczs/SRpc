package com.miracle.rpc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: SRpc
 * @description: 配置信息
 * @author: miracle
 * @create: 2020-11-15 10:33
 **/
@Component
@PropertySource("classpath:/srpc.properties")
@Data
public class SRpcProperties {

    /**
     * nacos ip:port
     */
    @Value("${nocos.serverList}")
    private String nacosServerList;

    @Value("${nocos.appCode}")
    private String appCode;
}
