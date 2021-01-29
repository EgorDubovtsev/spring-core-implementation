package org.shop.configuration;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.bpp.InjectRandomIntBeanPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;
@ComponentScan("org.shop")
@EnableAspectJAutoProxy
@Configuration
@Import({RepositoryConfiguration.class, ServiceConfiguration.class})
public class MainConfiguration {
    @Bean
    public ProductInitializer productInitializer(ProductService productService) {
        return new ProductInitializer(productService);
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public Map<Long, String> sellerNames() {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "amazon");
        map.put(2L, "samsung");
        return map;
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }
    @Bean
    public Logger logger(){
        return LoggerFactory.getLogger("AOP LOGGER");
    }


}
