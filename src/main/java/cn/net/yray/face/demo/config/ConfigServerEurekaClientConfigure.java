package cn.net.yray.face.demo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableEurekaClient
@EnableApolloConfig
@EnableFeignClients(basePackages = {"cn.net.cfss.fgbp.api.demo.inte"})
@ConditionalOnProperty(name = "fgbp.eureka.client.enabled", havingValue = "true", matchIfMissing = false)
public class ConfigServerEurekaClientConfigure {
}
