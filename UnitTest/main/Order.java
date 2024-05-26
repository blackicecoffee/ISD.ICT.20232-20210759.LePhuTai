package org.example;

import java.util.List;
import java.util.Random;

public class Order {

	int shippingFee;
	DeliveryAddress deliveryAddress;
	List<OrderMedia> mediaList;

	public void setLstOrderMedia(List<OrderMedia> lstOrderMedia) {
		this.mediaList = lstOrderMedia;
	}

	public Order(int shippingFee, DeliveryAddress deliveryAddress) {
		this.shippingFee = shippingFee;
		this.deliveryAddress = deliveryAddress;
	}

	public Order() {

	}

	public List<OrderMedia> getMediaList() {
		return mediaList;
	}

	public int getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public static Order createOrder(Cart cart) {
		Order order = new Order();

		for (int i = 0; i < cart.getCartMediaList().size(); ++ i) {
			CartMedia cartMedia = cart.getCartMediaList().get(i);
			OrderMedia orderMedia = new OrderMedia(cartMedia.getproduct(), cartMedia.getQuantity(), cartMedia.getPrice(), order);
			order.mediaList.add(orderMedia);
			System.out.println(orderMedia);
		}

		return order;
	}

	public void addOrderMedia(OrderMedia ordermedia) {
		this.mediaList.add(ordermedia);
	}

	public int getAmount() {
		int amount = 0;
		for(OrderMedia orderMedia : mediaList) {
			amount += orderMedia.getPrice();
		}
		return amount;
	}

	public void saveOrder() {

	}

	public boolean checkRushProductAndAddress() {
		System.out.println(this.deliveryAddress.getProvince());
		if (this.deliveryAddress.getAddress().equals("Hà Nội")) {
			return true;
		}
		return false;
	}

	public void updateDeliveryFee() {
		Random rand = new Random();
		int fees = (int) ((rand.nextFloat()) * this.getAmount());
		this.shippingFee = fees;
	}

}
