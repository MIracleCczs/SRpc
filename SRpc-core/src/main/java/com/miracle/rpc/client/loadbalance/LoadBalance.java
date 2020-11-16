package com.miracle.rpc.client.loadbalance;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @program: SRpc
 * @description: 负载均衡策略接口
 * @author: miracle
 * @create: 2020-11-15 10:13
 **/
public interface LoadBalance {

    /**
     * 负载均衡算法
     * @param instances 注册信息
     * @return
     */
    Instance select(List<Instance> instances);
}
