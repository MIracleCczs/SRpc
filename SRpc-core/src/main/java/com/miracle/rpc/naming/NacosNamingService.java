package com.miracle.rpc.naming;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.miracle.rpc.client.MethodConfig;
import com.miracle.rpc.common.constants.SRpcConstants;
import com.miracle.rpc.common.support.IpHelper;
import com.miracle.rpc.config.SRpcProperties;
import com.miracle.rpc.exception.SRpcException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @program: SRpc
 * @description: nacos 注册中心
 * @author: miracle
 * @create: 2020-11-15 10:13
 **/
@Slf4j
public class NacosNamingService implements InitializingBean {

    private NamingService naming;

    @Autowired
    private SRpcProperties sRpcProperties;

    /**
     * 将服务注册到nacos
     * @param serviceName contractName_implCode
     * @param methodConfig
     * @throws NacosException
     */
    public void registerService(String serviceName, Map<String, MethodConfig> methodConfig) throws NacosException {
        Instance instance = new Instance();
        instance.setIp(IpHelper.getLocalIP());
        instance.setPort(SRpcConstants.PORT);
        instance.addMetadata("methodsConfig", JSON.toJSONString(methodConfig));
        this.naming.registerInstance("providers:" + sRpcProperties.getAppCode() + ":" + serviceName, instance);
    }

    /**
     * 初始化nacos
     */
    @Override
    public void afterPropertiesSet() {
        try {
            this.naming = NamingFactory.createNamingService(sRpcProperties.getNacosServerList());
        } catch (NacosException e) {
            throw new SRpcException("nacos service init failed");
        }
    }
}
