package org.example;

import java.util.List;

public class Cart {
	private List<CartMedia> CartMediaList;

	public Cart() {

	}

	public int getAmount() {
		int total = 0;
		for (CartMedia item : CartMediaList) {
			total += item.getPrice();
		}
		return total;
	}

	public Cart(List<CartMedia> CartMediaList) {
		this.CartMediaList = CartMediaList;
	}

	public List<CartMedia> getCartMediaList() {
		return CartMediaList;
	}

	public void setCartMediaList(List<CartMedia> CartMediaList) {
		this.CartMediaList = CartMediaList;
	}

	public boolean checkCartMediaAvailability() {
		return true;
	}

	public void emptyCart() {

	}

	public static Cart createNewCart() {

		Product product0 = new Product(0, "Critical thinking", 400000, "Book", 5, "https://m.media-amazon.com/images/I/61HPS4EC6VL._SL1499_.jpg");
		Product product1 = new Product(0, "The House Maid", 350000, "Book", 7, "https://m.media-amazon.com/images/I/51+UxIo+YNL.jpg");

		CartMedia cartMedia1 = new CartMedia(product0, 2 );
		CartMedia cartMedia2 = new CartMedia(product1, 1 );

		Cart cart = new Cart();
		cart.setCartMediaList(List.of(cartMedia1, cartMedia2));
		return cart;
	}

}
