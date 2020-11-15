package com.miracle.rpc.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @program: SRpc
 * @description:
 * @author: miracle
 * @create: 2020-11-15 10:15
 **/
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SRpcImportSelector.class})
public @interface EnableSRpc {
}
