package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;
    @BeforeEach
    void setUp() {
        cart = Cart.createNewCart();
    }

    @Test
    void testCart() {
        for (CartMedia item : cart.getCartMediaList()) {
            int num_in_cart = item.getQuantity();
            int num_in_store = item.getproduct().getQuantity();
            boolean result = (num_in_cart <= num_in_store);
            assertTrue(result);
        }
    }
}