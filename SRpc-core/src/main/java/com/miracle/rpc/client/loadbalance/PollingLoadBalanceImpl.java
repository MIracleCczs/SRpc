package com.miracle.rpc.client.loadbalance;

import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: SRpc
 * @description:
 * @author: miracle
 * @create: 2020-11-16 21:16
 **/
@Slf4j
public class PollingLoadBalanceImpl implements LoadBalance {

    private int index = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public Instance select(List<Instance> instances) {
        Instance instance = null;
        try {
            this.lock.tryLock(10L, TimeUnit.MILLISECONDS);
            if (this.index >= instances.size()) {
                this.index = 0;
            }
            instance = instances.get(this.index);
            this.index++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("PollingLoadBalanceImpl select error", e);
        } finally {
            this.lock.unlock();
        }
        if (instance == null) {
            instance = instances.get(0);
        }
        return instance;
    }
}
