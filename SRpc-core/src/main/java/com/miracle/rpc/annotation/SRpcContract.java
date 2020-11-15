package com.miracle.rpc.annotation;

import java.lang.annotation.*;

/**
 * @program: SRpc
 * @description: RPC 协议
 * @author: miracle
 * @create: 2020-11-15 10:15
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SRpcContract {
    String contractName();
}
