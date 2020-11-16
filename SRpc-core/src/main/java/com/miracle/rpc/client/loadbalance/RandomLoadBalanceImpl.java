package com.miracle.rpc.client.loadbalance;

import com.alibaba.nacos.api.naming.pojo.Instance;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @program: SRpc
 * @description: 随机算法
 * @author: miracle
 * @create: 2020-11-16 21:11
 **/
public class RandomLoadBalanceImpl implements LoadBalance {

    @Override
    public Instance select(List<Instance> instances) {
        int size = instances.size();
        int index = RandomUtils.nextInt(0, size - 1);
        return instances.get(index);
    }
}
