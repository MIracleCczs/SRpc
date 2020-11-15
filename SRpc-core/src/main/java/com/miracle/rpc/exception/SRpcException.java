package com.miracle.rpc.exception;

/**
 * @program: SRpc
 * @description: 自定义异常处理类
 * @author: miracle
 * @create: 2020-11-15 10:14
 **/
public class SRpcException extends RuntimeException {

    public SRpcException() {
        super();
    }

    public SRpcException(String message) {
        super(message);
    }

    public SRpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public SRpcException(Throwable cause) {
        super(cause);
    }

    protected SRpcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
