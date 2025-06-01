package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest{
    private Product product;
    @BeforeEach
    void setUp() {
        product = new Product(1, "Harry Potter", 100000, "Book",15, "https://m.media-amazon.com/images/I/818FB6bF4aL._SL1500_.jpg");
    }

    @Test
    void testSetName() {
        product.setTitle("Harvey");
        assertEquals("Harvey", product.getTitle());
    }

    @Test
    void testSetQuantity() {
        product.setQuantity(15);
        assertEquals(15, product.getQuantity());
        boolean result = (product.getQuantity() >= 0);
        assertTrue(result);
    }

    @Test
    void testSetPrice() {
        product.setPrice(200000);
        assertEquals(200000, product.getPrice());
        boolean result = (product.getPrice() >= 0);
        assertTrue(result);
    }
    @Test
    void testSetCategory() {
        product.setCategory("CD");
        assertEquals("CD", product.getCategory());
    }
}