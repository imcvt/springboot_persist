package com.imc.portconfig;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author luoly
 * @date 2018/11/10 17:24
 * @description 自定义服务器配置修改启动端口
 */
@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(9010);
    }
}
