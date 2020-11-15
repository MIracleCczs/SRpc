package com.miracle.rpc.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SRpc
 * @description:
 * @author: miracle
 * @create: 2020-11-15 10:41
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MethodConfig {

    private String methodName;

    private int retryTimes;

    /* 关于方法的配置， 重试次数，超时时间，是否幂等 ... 暂时先实现一个重试次数*/
}
