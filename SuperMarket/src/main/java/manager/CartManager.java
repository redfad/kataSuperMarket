package manager;

import java.util.logging.Logger;

import dao.CartDAO;
import dao.OrderDAO;
import exception.SuperMarketException;
import model.Cart;
import model.Order;
import pricing.Offre;

public class CartManager {
	private final Logger LOG = Logger.getLogger("CartManager");
	private final CartDAO cartDAO = new CartDAO();
	private final OrderDAO orderDAO = new OrderDAO();

	/**
	 * Add a Product
	 * 
	 * @param product
	 * @return
	 * @throws BankCartException
	 */
	public Cart add(Cart cart, Order order) throws SuperMarketException {
		LOG.info("Request to add a product : " + order + " to cart : " + cart);

		if (order != null && order.getProduct() != null && cart != null) {

			order.setOrderPrice(order.getQuantity().multiply(order.getProduct().getPrice()));
			order.setOrderPriceReduced(order.getOrderPrice());
			Offre offre = order.getProduct().getOffre();

			if (offre != null) {
				offre.calculReducedPrice(order);
			}

			orderDAO.save(order);

			cart.addOrder(order);
			cart.setTotalCost(cart.getTotalCost().add(order.getOrderPrice()));
			cart.setTotalReduced(cart.getTotalReduced().add(order.getOrderPriceReduced()));
			cartDAO.save(cart);

		} else {
			throw new SuperMarketException("Please provide a valid order or cart!");
		}
		return cart;
	}
}
