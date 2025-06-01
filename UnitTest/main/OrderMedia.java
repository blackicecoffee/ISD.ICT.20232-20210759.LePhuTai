package org.example;

public class OrderMedia {
    Product product;
    int price;
    int quantity;
    Order order;
    public OrderMedia(Product product, int quantity, int price, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public OrderMedia() {

    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
