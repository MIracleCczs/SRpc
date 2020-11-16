package com.miracle.rpc.client.loadbalance;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: SRpc
 * @description: 负载均衡引擎
 * @author: miracle
 * @create: 2020-11-16 21:18
 **/
public class LoadBalanceEngine {

    private static final Map<LoadBalanceEnum, LoadBalance> LOAD_BALANCE_MAP = Maps.newConcurrentMap();

    static {
        LOAD_BALANCE_MAP.put(LoadBalanceEnum.RANDOM, new RandomLoadBalanceImpl());
        LOAD_BALANCE_MAP.put(LoadBalanceEnum.POLLING, new PollingLoadBalanceImpl());
        LOAD_BALANCE_MAP.put(LoadBalanceEnum.HASH, new HashLoadBalanceImpl());
    }

    /**
     * 根据负载均衡策略获取实现
     * 默认使用随机策略
     * @param loadBalanceStrategy 负载策略
     * @return
     */
    public static LoadBalance queryLoadBalance(String loadBalanceStrategy) {
        LoadBalanceEnum loadBalanceEnum = LoadBalanceEnum.queryByCode(loadBalanceStrategy);
        if (loadBalanceEnum == null) {
            return new RandomLoadBalanceImpl();
        }
        return LOAD_BALANCE_MAP.get(loadBalanceEnum);
    }
}
