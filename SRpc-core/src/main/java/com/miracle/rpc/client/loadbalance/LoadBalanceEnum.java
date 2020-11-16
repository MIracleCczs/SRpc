package com.miracle.rpc.client.loadbalance;

import org.apache.commons.lang3.StringUtils;

/**
 * 负载均衡实现枚举
 * @author miracle
 */
public enum LoadBalanceEnum {

    RANDOM("random"),
    POLLING("polling"),
    HASH("hash");

    private String code;

    LoadBalanceEnum(String code) {
        this.code = code;
    }

    public static LoadBalanceEnum queryByCode(String code) {
        for (LoadBalanceEnum value : values()) {
            if (StringUtils.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }
}
