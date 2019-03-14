package repository;

import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderRepository {
	private static ArrayList<Order> orders;

	private OrderRepository() {

	}

	public static List<Order> getOrders() {
		if(orders == null) {
			orders = new ArrayList<Order>();
		}
		return orders;
	}
}
