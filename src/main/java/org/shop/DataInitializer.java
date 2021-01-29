package org.shop;

import org.shop.annotations.InjectRandomInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * The main Data Initializer util class.
 */

@Component
public class DataInitializer {
    @InjectRandomInt(min = 1,max = 10)
    private int randomNumber;


    /** The seller initializer. */
    @Autowired
    private SellerInitializer sellerInitializer;

    /**
     * The product initializer.
     */
    @Autowired
    private ProductInitializer productInitializer;

    /**
     * The proposal initializer.
     */
    @Autowired
    private ProposalInitializer proposalInitializer;

    /**
     * The user initializer.
     */
    @Autowired
    private UserInitializer userInitializer;

    /**
     * Inits the data.
     */
    @PostConstruct
    public void initData() {
        System.out.println("RANDOM INT IS "+randomNumber);
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }
}
