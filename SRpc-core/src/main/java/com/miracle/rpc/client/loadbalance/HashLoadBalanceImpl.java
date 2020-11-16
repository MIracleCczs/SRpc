package com.miracle.rpc.client.loadbalance;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.miracle.rpc.common.support.IpHelper;

import java.util.List;

/**
 * @program: SRpc
 * @description: IP hash 算法
 * @author: miracle
 * @create: 2020-11-16 21:10
 **/
public class HashLoadBalanceImpl implements LoadBalance {

    @Override
    public Instance select(List<Instance> instances) {
        // 获取IP的hash值
        int hashCode = IpHelper.getLocalIP().hashCode();
        int size = instances.size();
        return instances.get(hashCode % size);
    }
}
