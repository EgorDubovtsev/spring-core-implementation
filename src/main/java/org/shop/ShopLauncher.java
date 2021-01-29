package org.shop;


import org.shop.api.ItemService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.configuration.MainConfiguration;
import org.shop.configuration.RepositoryConfiguration;
import org.shop.configuration.ServiceConfiguration;
import org.shop.data.Item;
import org.shop.repository.ItemRepository;
import org.shop.repository.SellerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */

public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        System.out.println(applicationContext.getBean(SellerRepository.class).getSellerById(1L));
        System.out.println(applicationContext.getBean(UserService.class).getUserById(1L));
    }
}
