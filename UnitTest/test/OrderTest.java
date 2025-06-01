package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order = new Order();
    List<Product> product = new ArrayList<Product>();
    List<CartMedia> crt = new ArrayList<CartMedia>();
    //List<OrderMedia> orderMedia = new ArrayList<OrderMedia>();
    DeliveryAddress deliveryAddress;
    int shippingFee;
    List<OrderMedia> mediaList = new ArrayList<OrderMedia>();

    @BeforeEach
    void setUp() {
        product.add(new Product(1, "Harry Potter", 100000, "Book", 15, "https://m.media-amazon.com/images/I/818FB6bF4aL._SL1500_.jpg"));
        product.add(new Product(0, "Critical thinking", 400000, "Book", 5, "https://m.media-amazon.com/images/I/61HPS4EC6VL._SL1499_.jpg"));
        product.add(new Product(0, "The House Maid", 350000, "Book", 7, "https://m.media-amazon.com/images/I/51+UxIo+YNL.jpg"));
        crt.add(new CartMedia(product.getFirst(), 1));
        crt.add(new CartMedia(product.get(1), 1));
        crt.add(new CartMedia(product.get(2), 1));
        Cart cart = new Cart(crt);
        for (int i = 0; i < cart.getCartMediaList().size(); ++ i) {
            CartMedia cartMedia = cart.getCartMediaList().get(i);
            OrderMedia orderMedia = new OrderMedia(cartMedia.getproduct(), cartMedia.getQuantity(), cartMedia.getPrice(), order);
            mediaList.add(orderMedia);
            //System.out.println(orderMedia);
        }
        shippingFee = 20000;
        deliveryAddress = new DeliveryAddress("LMPhuc", "0123456789", "Nghệ An", "Số 23 Nguyễn Đức Cảnh", "");
        order.setShippingFee(shippingFee);
        order.setDeliveryAddress(deliveryAddress);
        order.setLstOrderMedia(mediaList);
        //System.out.println("This Order: " + order);
    }

    @Test
    void testSetQuantity() {
        //System.out.println(product.size());
        for (int i = 0; i < product.size(); ++ i) {
            int min = 20;
            int max = 30;
            int randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;
            product.get(i).setQuantity(randomNumber);
            assertEquals(randomNumber, product.get(i).getQuantity());
            boolean result = (product.get(i).getQuantity() >= 0);
            assertTrue(result);
            boolean checkavai = ((product.get(i).getQuantity() - crt.get(i).getQuantity() >= 0));
            assertTrue(checkavai);
        }
    }

    @Test
    void testSetPrice() {
        for (int i = 0; i < product.size(); ++i) {
            int min = 2000000;
            int max = 3000000;
            int randomNumber = (int) (Math.random() * ((max - min) + 1)) + min;
            product.get(i).setPrice(randomNumber);
            System.out.println(randomNumber + '\n');
            assertEquals(randomNumber, product.get(i).getPrice());
            boolean result = (product.get(i).getPrice() >= 0);
            assertTrue(result);
        }
    }

    @Test
    void testAmount() {
        int total = 0;
        for (int i = 0; i < product.size(); ++ i)
        {
            int prc = product.get(i).getPrice();
            total += prc;
        }
        System.out.println("total amount: " + total + '\n');
        assertEquals(order.getAmount(), total);
    }
}