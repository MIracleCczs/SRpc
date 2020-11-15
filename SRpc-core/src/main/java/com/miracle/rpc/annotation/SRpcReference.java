package com.miracle.rpc.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface SRpcReference {

    String appCode();

    String implCode() default "default";

    String loadBalanceStrategy() default "random";
}
