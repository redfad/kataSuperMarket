package dao;

import java.util.List;
import java.util.logging.Logger;

import model.Order;
import repository.OrderRepository;

public class OrderDAO {

	private final Logger log = Logger.getLogger("OrderDAO");
	private final List<Order> orders = OrderRepository.getOrders();

	/**
	 * Save a order
	 * 
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		log.info("Request to save Order : " + order);
		orders.add(order);
		return order;
	}

	/**
	 * Delete a order
	 * 
	 * @param order
	 */
	public void delete(Order order) {
		log.info("Request to delete Order : " + order);
		orders.removeIf(val -> val.getOrderId().equals(order.getOrderId()));
	}

	/**
	 * Search for a order by its id
	 * 
	 * @param id
	 */
	public Order findOne(Integer id) {
		log.info("Request to finde Order : " + id);
		return orders.stream().filter(order -> order.getOrderId().equals(id)).findFirst().get();
	}

	/**
	 * find all orders
	 */
	public List<Order> findAll() {
		log.info("Request to find all orders : ");
		return orders;
	}
}
