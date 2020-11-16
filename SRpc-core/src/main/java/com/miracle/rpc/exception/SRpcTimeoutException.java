package com.miracle.rpc.exception;

/**
 * @program: SRpc
 * @description: 超时异常
 * @author: miracle
 * @create: 2020-11-16 20:48
 **/
public class SRpcTimeoutException extends RuntimeException {

    public SRpcTimeoutException() {
        super();
    }

    public SRpcTimeoutException(String message) {
        super(message);
    }

    public SRpcTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public SRpcTimeoutException(Throwable cause) {
        super(cause);
    }

    protected SRpcTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
